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
 * Servlet implementation class DeleteRescheduleController
 */
@WebServlet("/DeleteRescheduleController")
public class DeleteRescheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RescheduleDAO dao;
    /**
     * Default constructor. 
     */
    public DeleteRescheduleController() {
    	super();
        dao = new RescheduleDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rescheduleid = Integer.parseInt(request.getParameter("rescheduleid"));
		dao.deleteReschedule(rescheduleid);
		request.setAttribute("reschedules", RescheduleDAO.getAllReschedules());
		RequestDispatcher view = request.getRequestDispatcher("listReschedule.jsp");
		view.forward(request, response);
	}
}