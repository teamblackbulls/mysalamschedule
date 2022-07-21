package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.ProductDAO;

/**
 * Servlet implementation class ListProductController
 */
@WebServlet("/ListProductController")
public class ListProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductController() {
        super();
        dao = new ProductDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("products", ProductDAO.getAllProducts());
		RequestDispatcher view = request.getRequestDispatcher("listProduct.jsp");
		view.forward(request, response);
	}


}
