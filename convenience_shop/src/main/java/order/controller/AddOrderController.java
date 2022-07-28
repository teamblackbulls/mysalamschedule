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

@WebServlet("/AddOrderController")
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoOrder dao;
       
    public AddOrderController() {
        super();
        dao = new DaoOrder();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Order or = new Order();
		or.setOrderdate(Date.valueOf(request.getParameter("orderdate")));
		
		int orderid = dao.addOrder(or); //invoke method addOrder() in OrderDAO
		
		request.setAttribute("orderid", orderid);
		RequestDispatcher view = request.getRequestDispatcher("addOrder.jsp");
		view.forward(request, response);
	}
	
	
}
