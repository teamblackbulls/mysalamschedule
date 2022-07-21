package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.ProductDAO;
import product.model.Product;

/**
 * Servlet implementation class UpdateProductStorekeeperController
 */
@WebServlet("/UpdateProductStorekeeperController")
public class UpdateProductStorekeeperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductStorekeeperController() {
        super();
        dao = new ProductDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productID = Integer.parseInt(request.getParameter("productID"));
		request.setAttribute("p", ProductDAO.getProductById(productID));
		RequestDispatcher view = request.getRequestDispatcher("updateProductStorekeeper.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product p = new Product();
		
		p.setProductID(Integer.parseInt(request.getParameter("productID")));	
		p.setProductname(request.getParameter("productname"));
		p.setProductdescription(request.getParameter("productdescription"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		p.setProductcategory(request.getParameter("productcategory"));
		
		dao.updateProduct(p);
		
		request.setAttribute("products", ProductDAO.getAllProducts());
		RequestDispatcher view = request.getRequestDispatcher("listProductStorekeeper.jsp");
		view.forward(request, response);
	}

}