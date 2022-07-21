package order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.dao.*;
import order.model.*;

/**
 * Servlet implementation class UpdateOrderController
 */
@WebServlet("/UpdateOrderController")
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderController() {
        super();
        dao = new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("od", OrderDAO.getOrderById(id));
		RequestDispatcher view = request.getRequestDispatcher("updateOrder.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order od = new Order ();
		
		od.setOrderId(Integer.parseInt(request.getParameter("orderID")));
		od.setEmpId(Integer.parseInt(request.getParameter("employeeID")));
		od.setOrderDate(request.getParameter("orderdate"));
		od.setProdId(Integer.parseInt(request.getParameter("productID")));
		od.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		od.setTotalamount(Double.parseDouble(request.getParameter("totalamount")));
		
		dao.updateOrder(od);
		
		request.setAttribute("orders", OrderDAO.getAllOrders());
		RequestDispatcher view = request.getRequestDispatcher("listOrder.jsp");
		view.forward(request, response);
	}
}

