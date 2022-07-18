package staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import staff.db.*;
import staff.model.*;

public class StaffDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private String staffid1, name, address, phone, email, role, pass;
	private int id;
	
	//add Staff
		public void addStaff(Staff bean) {
			staffid1 = bean.getStaffid1();
			name = bean.getName();
			address = bean.getAddress();
			phone = bean.getPhone();
			email= bean.getEmail();
			role = bean.getRole();
			pass = bean.getPass();
			
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("INSERT INTO staff(staffid1, name, address, phone, email, role, pass)VALUES(?,?,?,?,?,?,?)");
				ps.setString(1,staffid1);
				ps.setString(2,name);
				ps.setString(3, address);
				ps.setString(4,phone);
				ps.setString(5,email);
				ps.setString(6,role);
				ps.setString(7,pass);

				//execute query
				ps.executeUpdate();
				System.out.println("Successfully inserted");
				
				//close connection
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//get all Staffs
		public static List<Staff> getAllStaffs() {
			List<Staff> staffs = new ArrayList<Staff>();
			
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//create statement
				st = con.createStatement();
				String sql = "SELECT * FROM staff ORDER BY id";
				
				//execute query
				rs = st.executeQuery(sql);
				
				while(rs.next()) {		//process result
					Staff s = new Staff();
					s.setId(rs.getInt("id"));
					s.setStaffid1(rs.getString("staffid1"));
					s.setName(rs.getString("name"));
					s.setAddress(rs.getString("address"));
					s.setPhone(rs.getString("phone"));
					s.setEmail(rs.getString("email"));
					s.setRole(rs.getString("role"));
					s.setPass(rs.getString("pass"));
				
					staffs.add(s);
				}
				
				//close connection
				con.close();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return staffs;
		}
		
		//get Staff by id
		public static Staff getStaffById(int id) {
			Staff s = new Staff();
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps= con.prepareStatement("SELECT * FROM staff WHERE id=?");
				ps.setInt(1, id);
				
				//execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					
					s.setId(rs.getInt("id"));
					s.setStaffid1(rs.getString("staffid1"));
					s.setName(rs.getString("name"));
					s.setAddress(rs.getString("address"));
					s.setPhone(rs.getString("phone"));
					s.setEmail(rs.getString("email"));
					s.setRole(rs.getString("role"));
					s.setPass(rs.getString("pass"));
				}
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return s;
		}
		
		//delete Staff
		public void deleteStaff(int id) {
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("DELETE FROM staff WHERE id=?");
				ps.setInt(1, id);
				
				//execute query
				ps.executeUpdate();
				
				//close connection
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//update Staff
		public void updateStaff(Staff bean) {
			id = bean.getId();
			staffid1 = bean.getStaffid1();
			name = bean.getName();
			address = bean.getAddress();
			phone = bean.getPhone();
			email= bean.getEmail();
			role = bean.getRole();
			pass = bean.getPass();
			
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("UPDATE staff SET staffid1=?,name=?, address=?, phone=?, email=?,role=?,pass=? WHERE id=?");
				ps.setString(1, staffid1);
				ps.setString(2,name);
				ps.setString(3, address);
				ps.setString(4,phone);
				ps.setString(5,email);
				ps.setString(6,role);
				ps.setString(7,pass);
				
				ps.setInt(8, id);
				
				//execute query
				ps.executeUpdate();
				
				System.out.println("Successfully updated");
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//get StaffLogin
		public Staff getStaffLogin(String staffid, String pass) {
			Staff s = new Staff();
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps= con.prepareStatement("SELECT * FROM staff WHERE staffid1=? and pass=?");
				ps.setString(1, staffid);
				ps.setString(2, pass);
				
				//execute query
				rs = ps.executeQuery();
				while(rs.next()) {
					s.setStaffid1(rs.getString("staffid1"));
					s.setPass(rs.getString("pass"));
					s.setName(rs.getString("name"));
				}
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return s;
		}				
		
		//get StaffLogin
				public Staff getStaffID(String staffid) {
					Staff s = new Staff();
					try {
						//call getConnection method
						con = ConnectionManager.getConnection();
						
						//create statement
						ps= con.prepareStatement("SELECT * FROM staff WHERE staffid1=?");
						ps.setString(1, staffid);
				
						
						//execute query
						rs = ps.executeQuery();
						while(rs.next()) {
							s.setStaffid1(rs.getString("staffid1"));
			
						}
						
						//close connection
						con.close();
						
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					return s;
				}				
				
}
