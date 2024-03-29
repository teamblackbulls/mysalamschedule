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
 * Servlet implementation class AddProductStorekeeperController
 */
@WebServlet("/AddProductStorekeeperController")
public class AddProductStorekeeperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductStorekeeperController() {
        super();
        dao = new ProductDAO();
        // TODO Auto-generated constructor stub
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
		
		dao.addProduct(p); //invoke method addProduct() in ProductDAO
		
		request.setAttribute("products",ProductDAO.getAllProducts());
		RequestDispatcher view = request.getRequestDispatcher("listProductStorekeeper.jsp");
		view.forward(request, response);
	}

}
