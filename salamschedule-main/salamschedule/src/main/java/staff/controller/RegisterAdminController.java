package staff.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import staff.model.*;
import staff.dao.*;



/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterAdminController")
public class RegisterAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAdminController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin ad = new Admin();
		//retrieve input and set
		ad.setAdminname(request.getParameter("adminname"));	
		ad.setAdminphone(request.getParameter("adminphone"));
		ad.setAdminemail(request.getParameter("adminemail"));	
		ad.setAdminpass(request.getParameter("adminpass"));
		
		ad = AdminDAO.getAdmin(ad);
		//check if user exists
		if(!ad.isValid()){
        	try {
        		//if user not exist, add/register the user
				dao.add(ad);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//redirect to login page
        	response.sendRedirect("loginAdmin.html");
        }     
		else {
			response.sendRedirect("index.html");
		}
	}

}

