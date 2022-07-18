package schedule.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import staff.dao.*;

/**
 * Servlet implementation class DeleteScheduleController
 */
@WebServlet("/DeleteScheduleController")
public class DeleteScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteScheduleController() {
        super();
        dao = new ScheduleDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int scheduleid = Integer.parseInt(request.getParameter("scheduleid"));
		dao.deleteSchedule(scheduleid);
		request.setAttribute("schedules", ScheduleDAO.getAllSchedules());
		RequestDispatcher view = request.getRequestDispatcher("listSchedule.jsp");
		view.forward(request, response);
	}

}