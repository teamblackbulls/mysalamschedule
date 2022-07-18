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
 * Servlet implementation class ViewScheduleController
 */
@WebServlet("/ViewScheduleController")
public class ViewScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewScheduleController() {
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
		request.setAttribute("sc",ScheduleDAO.getScheduleById(scheduleid));
		RequestDispatcher view = request.getRequestDispatcher("viewSchedule.jsp");
		view.forward(request, response);
	}

}
