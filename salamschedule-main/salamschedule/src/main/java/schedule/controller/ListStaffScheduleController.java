package schedule.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import staff.dao.StaffDAO;
import staff.model.Staff;

/**
 * Servlet implementation class ListStaffScheduleController
 */
@WebServlet("/ListStaffScheduleController")
public class ListStaffScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StaffDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStaffScheduleController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StaffDAO sd = new StaffDAO();
		
		String staffid1 = request.getParameter("staffid1");

		
		Staff s = sd.getStaffID(staffid1);
		
		if(s!=null) {
			request.getRequestDispatcher("listStaffSchedule.jsp").forward(request, response);

		} else {
			response.sendRedirect("errorStaffHome.jsp");
		}
	}

}
