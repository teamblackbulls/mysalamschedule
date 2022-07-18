package staff.dao;


import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import staff.db.ConnectionManager;
import staff.model.Admin;



public class AdminDAO {
	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String adminname,adminphone, adminemail, adminpass;
	static int adminid;
	
	
	//method for login
		public static Admin login(Admin bean) throws NoSuchAlgorithmException{
			//get email and password
			adminemail = bean.getAdminemail();
			adminpass = bean.getAdminpass();


			String query = "select * from admin where adminemail='" + adminemail + "'AND adminpass='" + adminpass + "'";

			try {
				//call getConnection() method //3. create statement  //4. execute query
				con = ConnectionManager.getConnection();
				//3. create statement
				stmt = con.createStatement();
			    //4. execute query
				rs = stmt.executeQuery(query);
				boolean more = rs.next();

				// if user exists set the isValid variable to true
				if (more) {
					int adminid = rs.getInt("adminid");
					String adminname = rs.getString("adminname");
					String adminphone = rs.getString("adminphone");
					String adminemail = rs.getString("adminemail");
					String adminpass = rs.getString("adminpass");
					
					bean.setAdminid(adminid);
					bean.setAdminname(adminname);
					bean.setAdminphone(adminphone);
					bean.setAdminemail(adminemail);
					bean.setAdminemail(adminpass);
					
					bean.setValid(true);
				}
				// if user does not exist set the isValid variable to false
				else if (!more) {
					bean.setValid(false);
				}

				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return bean;
		}

		//add new user (register)
		public void add(Admin bean) throws NoSuchAlgorithmException{
			//get email,name and password
			
			adminname = bean.getAdminname();
			adminphone= bean.getAdminphone();
			adminemail = bean.getAdminemail();
			adminpass = bean.getAdminpass();


			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("insert into admin(adminname,adminphone,adminemail,adminpass)values(?,?,?,?)");
				ps.setString(1,adminname);
				ps.setString(2,adminphone);
				ps.setString(3,adminemail);
				ps.setString(4,adminpass);
				
				//4. execute query
				ps.executeUpdate();			
				
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

		}

		//method to get user
		public static Admin getAdmin(Admin bean)  {   
			//get email
			adminemail = bean.getAdminemail();
			String searchQuery = "select * from admin where adminemail='" + adminemail + "'";
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//execute statement
				rs = stmt.executeQuery(searchQuery);

				boolean more = rs.next();

				// if user exists set the isValid variable to true
				if (more) {
					String adminemail = rs.getString("adminemail");
					bean.setAdminemail(adminemail);
					bean.setValid(true);
				}
				// if user does not exist set the isValid variable to false
				else if (!more) {
					bean.setValid(false);
				}
				//5. close connection
				con.close();	
			}catch(Exception e) {
				e.printStackTrace();		
			}
			return bean;
		}

		//get user by email
		public static Admin getAdminByEmail(String adminemail) {
			Admin ad = new Admin();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("select * from admin where adminemail=?");
				ps.setString(1, adminemail);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {	            
					ad.setAdminid(rs.getInt("adminid"));
					ad.setAdminname(rs.getString("adminname"));				
					ad.setAdminphone(rs.getString("adminphone"));
					ad.setAdminemail(rs.getString("adminemail"));				
					ad.setAdminpass(rs.getString("adminpass"));

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return ad;
		}

		//get user by id
		public static Admin getAdminById(int adminid) {
			Admin ad = new Admin();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("select * from admin where adminid=?");
				ps.setInt(1, adminid);
				//4. execute query
				rs = ps.executeQuery();

				if (rs.next()) {
					ad.setAdminid(rs.getInt("adminid"));
					ad.setAdminname(rs.getString("adminname"));				
					ad.setAdminphone(rs.getString("adminphone"));
					ad.setAdminemail(rs.getString("adminemail"));
					ad.setAdminpass(rs.getString("adminpass"));

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return ad;
		}
		

		public static List<Admin> getAdminId() {
			List<Admin> admins = new ArrayList<Admin>();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//4. execute query
				rs = stmt.executeQuery("select adminid, adminemail from admin");

				while (rs.next()) {
					Admin ad = new Admin();
					ad.setAdminid(rs.getInt("adminid"));
					ad.setAdminemail(rs.getString("adminemail"));
					admins.add(ad);

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return admins;
		}
		
		public static List<Admin> getAdminSchedule() {
			List<Admin> admins = new ArrayList<Admin>();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				stmt = con.createStatement();
				//4. execute query
				rs = stmt.executeQuery("SELECT * FROM admin a INNER JOIN schedule sc ON a.adminid = sc.adminid");

				while (rs.next()) {
					Admin ad = new Admin();
					ad.setAdminid(rs.getInt("adminid"));
					ad.setAdminemail(rs.getString("adminemail"));
					ad.setSchedule(ScheduleDAO.getScheduleId(rs.getInt("scheduleid")));
					admins.add(ad);

				}
				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return admins;
		}
		
			
		//delete admin and scheudle from table admin
		public void deleteAdmin(int adminid) {
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				//3. create statement  
				ps=con.prepareStatement("delete from admin where adminid=?");
				ps.setInt(1, adminid);
				//4. execute query
				ps.executeUpdate();

				//5. close connection
				con.close();
			}catch(Exception e) {
				e.printStackTrace();		
			}
		}
	
	
}
