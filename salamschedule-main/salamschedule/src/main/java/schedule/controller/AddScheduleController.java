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
 * Servlet implementation class AddScheduleController
 */
@WebServlet("/AddScheduleController")
public class AddScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScheduleController() {
        super();
        dao = new ScheduleDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Schedule sc = new Schedule();		
		sc.setScheduledate(request.getParameter("scheduledate"));
		sc.setPrayerid(Integer.parseInt(request.getParameter("prayerid")));
		sc.setImamid(Integer.parseInt(request.getParameter("imamid")));
		sc.setBilalid(Integer.parseInt(request.getParameter("bilalid")));
		
		dao.addSchedule(sc); //invoke method addSchedule() in ScheduleDAO
		
		request.setAttribute("schedules",ScheduleDAO.getAllSchedules());
		RequestDispatcher view = request.getRequestDispatcher("listSchedule.jsp");
		view.forward(request, response);
	}

}

