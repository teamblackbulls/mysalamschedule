package emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmployeeDAO;
import emp.model.Employee;

/**
 * Servlet implementation class UpdateEmployeeController
 */
@WebServlet("/UpdateEmployeeController")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeController() {
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
		request.setAttribute("em", EmployeeDAO.getEmployeeById(employeeID));
		RequestDispatcher view = request.getRequestDispatcher("updateEmployee.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Employee em = new Employee();
		
		em.setEmployeeID(Integer.parseInt(request.getParameter("employeeID")));	
		em.setFirstname(request.getParameter("firstname"));
		em.setLastname(request.getParameter("lastname"));
		em.setEmail(request.getParameter("email"));
		em.setEmpphonenum(request.getParameter("empphonenum"));
		em.setAddress(request.getParameter("address"));
		em.setJobID(Integer.parseInt(request.getParameter("jobID")));	
		
		dao.updateEmployee(em); //invoke method updateEmployee() in EmployeeDAO
		
		request.setAttribute("employees", EmployeeDAO.getAllEmployees());
		RequestDispatcher view = request.getRequestDispatcher("listEmployee.jsp");
		view.forward(request, response);
	}

}
