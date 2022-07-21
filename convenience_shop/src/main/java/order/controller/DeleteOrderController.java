package order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.dao.OrderDAO;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteOrderController")
public class DeleteOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderController() {
        super();
        dao = new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		dao.deleteOrder(orderID);
		request.setAttribute("orders", OrderDAO.getAllOrders());
		RequestDispatcher view = request.getRequestDispatcher("listOrder.jsp");
		view.forward(request, response);
	}

}
