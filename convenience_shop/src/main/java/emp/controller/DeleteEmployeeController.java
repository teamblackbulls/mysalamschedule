package emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmployeeDAO;

/**
 * Servlet implementation class DeleteEmployeeController
 */
@WebServlet("/DeleteEmployeeController")
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeController() {
        super();
        dao = new EmployeeDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
		dao.deleteEmployee(employeeID);
		request.setAttribute("employees", EmployeeDAO.getAllEmployees());
		RequestDispatcher view = request.getRequestDispatcher("listEmployee.jsp");
		view.forward(request, response);
	}

}
