package orderDetail.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import orderDetail.dao.OrderDetailDAO;

@WebServlet("/DeleteOrderDetailController")
public class DeleteOrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDetailDAO dao;
       
    public DeleteOrderDetailController() {
        super();
        dao = new OrderDetailDAO();
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int orderdetailID = Integer.parseInt(request.getParameter("orderdetailID"));
		dao.deleteOrderDetail(orderdetailID);
		int orderid = Integer.parseInt(request.getParameter("orderID"));
		
		request.setAttribute("orderid", orderid);
		RequestDispatcher view = request.getRequestDispatcher("addOrder.jsp");
		view.forward(request, response);
	}

}
