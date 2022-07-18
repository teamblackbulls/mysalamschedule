package staff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import staff.dao.AdminDAO;
import staff.model.Admin;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginLogoutController")
public class LoginLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO dao;
	HttpSession session;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginLogoutController() {
		super();
		dao = new AdminDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//get the current session
			HttpSession session = request.getSession(true);
			//set current session to null.
			session.setAttribute("sessionEmail", null);
			//destroy session
			session.invalidate();
			//redirect to login page
			response.sendRedirect("loginAdmin.html");
		}catch (Throwable ex) {
			System.out.println(ex);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Admin ad = new Admin();
			//retrieve and set email and password
			ad.setAdminemail(request.getParameter("adminemail"));
			ad.setAdminpass(request.getParameter("adminpass"));

			ad = AdminDAO.login(ad);
			//set user session if user is valid
			if(ad.isValid()){
				session = request.getSession(true);
				session.setAttribute("sessionId", ad.getAdminid());
				System.out.println(ad.getAdminid());
				session.setAttribute("sessionEmail", ad.getAdminemail());  //set current session based on email
				
					request.setAttribute("ad", AdminDAO.getAdminByEmail(ad.getAdminemail()));   					
			
					RequestDispatcher view = request.getRequestDispatcher("adminHome.jsp"); // staff page
					view.forward(request, response);	
				
							
			}
			//redirect to invalidLoggin.jsp if user is not valid
			else{
				response.sendRedirect("errorLoginAdmin.html");
			}		
		}

		catch (Throwable ex) {
			System.out.println(ex);
		}
	}

}
