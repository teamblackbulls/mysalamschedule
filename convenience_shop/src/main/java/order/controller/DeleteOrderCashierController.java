package order.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.model.*;
import OrderDao.*;

@WebServlet("/DeleteOrderCashierController")
public class DeleteOrderCashierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoOrder dao;
	
	  public DeleteOrderCashierController() {
	        super();
	        dao = new DaoOrder();
	        // TODO Auto-generated constructor stub
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			int orderID = Integer.parseInt(request.getParameter("orderID"));
			dao.deleteOrder(orderID);

			RequestDispatcher view = request.getRequestDispatcher("listOrderCashier.jsp");
			view.forward(request, response);
		}

}
