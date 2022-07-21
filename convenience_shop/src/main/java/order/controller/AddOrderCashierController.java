package order.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.dao.OrderDAO;
import order.model.Order;

/**
 * Servlet implementation class AddOrderCashierController
 */
@WebServlet("/AddOrderCashierController")
public class AddOrderCashierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderCashierController() {
        super();
        dao = new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order od = new Order();

		od.setOrderID(Integer.parseInt(request.getParameter("orderID")));
		od.setOrderdate(Date.valueOf(request.getParameter("orderdate")));
		od.setProductID(Integer.parseInt(request.getParameter("productID")));
		od.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		od.setTotalamount(Double.parseDouble(request.getParameter("totalamount")));
		
		dao.addOrder(od); //invoke method addOrder() in OrderDAO
		
		request.setAttribute("orders", OrderDAO.getAllOrders());
		RequestDispatcher view = request.getRequestDispatcher("listOrderCashier.jsp");
		view.forward(request,  response);
	}

}
