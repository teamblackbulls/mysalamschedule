package orderDetail.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orderDetail.dao.OrderDetailDAO;

@WebServlet("/ListOrderDetailCashierController")
public class ListOrderDetailCashierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDetailDAO dao;
       
    public ListOrderDetailCashierController() {
        super();
        dao = new OrderDetailDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("orderdetail", OrderDetailDAO.getAllOrderdetail());
		RequestDispatcher view = request.getRequestDispatcher("listOrderCashier.jsp");
		view.forward(request, response);
	}

}
