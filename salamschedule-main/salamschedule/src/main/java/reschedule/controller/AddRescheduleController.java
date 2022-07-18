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
 * Servlet implementation class AddRescheduleController
 */
@WebServlet("/AddRescheduleController")
public class AddRescheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RescheduleDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRescheduleController() {
        super();
        dao = new RescheduleDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reschedule rc = new Reschedule();	
		rc.setScheduleid(Integer.parseInt(request.getParameter("scheduleid")));
		rc.setRescheduledate(request.getParameter("rescheduledate"));
		rc.setRescheduleprayerid(Integer.parseInt(request.getParameter("prayerid")));
		rc.setStaffID(Integer.parseInt(request.getParameter("staffid")));
		
		dao.addReschedule(rc); //invoke method addSchedule() in ScheduleDAO
		
		request.setAttribute("reschedules",RescheduleDAO.getAllReschedules());
		RequestDispatcher view = request.getRequestDispatcher("liststaffReschedule.jsp");
		view.forward(request, response);
	}


}