package order.controller;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.model.*;
import OrderDao.*;

@WebServlet("/UpdateOrderController")
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoOrder dao;
    
	   public UpdateOrderController() {
	        super();
	        dao = new DaoOrder();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Order or = new Order ();
			
			or.setOrderID(Integer.parseInt(request.getParameter("orderID")));
			or.setGrandtotal(Double.parseDouble(request.getParameter("grandtotal")));
			
			dao.updateOrder(or);
			
			RequestDispatcher view = request.getRequestDispatcher("listOrder.jsp");
			view.forward(request, response);
		}

}
