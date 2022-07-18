package schedule.controller;

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
 * Servlet implementation class UpdateScheduleController
 */
@WebServlet("/UpdateScheduleController")
public class UpdateScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScheduleController() {
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
		request.setAttribute("sc", ScheduleDAO.getScheduleById(scheduleid));
		RequestDispatcher view = request.getRequestDispatcher("updateSchedule.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Schedule sc = new Schedule();	
		sc.setScheduleid(Integer.parseInt(request.getParameter("scheduleid")));
		sc.setScheduledate(request.getParameter("scheduledate"));
		sc.setPrayerid(Integer.parseInt(request.getParameter("prayerid")));
		sc.setImamid(Integer.parseInt(request.getParameter("imamid")));
		sc.setBilalid(Integer.parseInt(request.getParameter("bilalid")));
	
		
		dao.updateSchedule(sc);
		
		request.setAttribute("schedules", ScheduleDAO.getAllSchedules());
		RequestDispatcher view = request.getRequestDispatcher("listSchedule.jsp");
		view.forward(request, response);
	}

}