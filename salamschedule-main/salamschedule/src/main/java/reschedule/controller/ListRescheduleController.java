package reschedule.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import staff.dao.*;
import staff.model.*;
/**
 * Servlet implementation class ListRescheduleController
 */
@WebServlet("/ListRescheduleController")
public class ListRescheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RescheduleDAO dao;
    /**
     * Default constructor. 
     */
    public ListRescheduleController() {
    	 super();
         dao = new RescheduleDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("reschedules", RescheduleDAO.getAllReschedules());
		RequestDispatcher view = request.getRequestDispatcher("listReschedule.jsp");
		view.forward(request, response);
	}

}