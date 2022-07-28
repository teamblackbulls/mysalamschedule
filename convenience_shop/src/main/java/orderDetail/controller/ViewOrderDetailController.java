package orderDetail.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orderDetail.dao.OrderDetailDAO;

@WebServlet("/ViewOrderDetailController")
public class ViewOrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDetailDAO dao;
       
    public ViewOrderDetailController() {
        super();
        dao = new OrderDetailDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderdetailID = Integer.parseInt(request.getParameter("orderdetailID"));
		request.setAttribute("od",OrderDetailDAO.getOrderdetailById(orderdetailID));
		RequestDispatcher view = request.getRequestDispatcher("viewOrderdetail.jsp");
		view.forward(request, response);
	}


}
