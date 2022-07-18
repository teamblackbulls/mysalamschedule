package staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import staff.db.*;
import staff.model.*;


public class ScheduleDAO {

	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private int scheduleid,prayerid,imamid,bilalid;
	private String scheduledate;
	
	
	//add Schedule
	public void addSchedule(Schedule bean) {
		scheduleid = bean.getScheduleid();
		scheduledate = bean.getScheduledate();
		prayerid = bean.getPrayerid();
		imamid = bean.getImamid();
		bilalid = bean.getBilalid();

		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO schedule(scheduledate,prayerid,imamid,bilalid) VALUES(?,?,?,?)");
			
			ps.setString(1,scheduledate);
			ps.setInt(2, prayerid);
			ps.setInt(3,imamid);
			ps.setInt(4,bilalid);

			
		

			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
					
	//get all Schedules
	public static List<Schedule> getAllSchedules() {
		List<Schedule> schedules = new ArrayList<Schedule>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM schedule ORDER BY scheduleid";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Schedule sc = new Schedule();
				sc.setScheduleid(rs.getInt("scheduleid"));
				sc.setScheduledate(rs.getString("scheduledate"));
				sc.setPrayerid(rs.getInt("prayerid"));
				sc.setImamid(rs.getInt("imamid"));
				sc.setBilalid(rs.getInt("bilalid"));
				sc.setAdminid(rs.getInt("adminid"));
			
				schedules.add(sc);
			}

			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return schedules;
	}
	
	
			
	//get Schedule by scheduleid
	public static Schedule getScheduleById(int scheduleid) {
		Schedule sc = new Schedule();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM schedule WHERE scheduleid=?");
			ps.setInt(1, scheduleid);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				sc.setScheduleid(rs.getInt("scheduleid"));
				sc.setScheduledate(rs.getString("scheduledate"));
				sc.setPrayerid(rs.getInt("prayerid"));
				sc.setImamid(rs.getInt("imamid"));
				sc.setBilalid(rs.getInt("bilalid"));

			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sc;
	}		
	

	
	//get Schedule by staffid1
	public static Schedule getScheduleId(int imamid) {
		Schedule sc = new Schedule();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM schedule WHERE imamid=?");
			ps.setInt(1, imamid);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				sc.setScheduleid(rs.getInt("scheduleid"));
				sc.setScheduledate(rs.getString("scheduledate"));
				sc.setPrayerid(rs.getInt("prayerid"));
		
				sc.setImamid(rs.getInt("imamid"));
				sc.setBilalid(rs.getInt("bilalid"));
			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sc;
	}		
	
	//get Schedule by staffid2
		public static Schedule getScheduleId2(int bilalid) {
			Schedule sc = new Schedule();
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps= con.prepareStatement("SELECT * FROM schedule WHERE bilalid=?");
				ps.setInt(1, bilalid);
				
				//execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					
					sc.setScheduleid(rs.getInt("scheduleid"));
					sc.setScheduledate(rs.getString("scheduledate"));
					sc.setPrayerid(rs.getInt("prayerid"));
			
					sc.setImamid(rs.getInt("imamid"));
					sc.setBilalid(rs.getInt("bilalid"));
				}
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return sc;
		}		
	
	
	//get Schedule by prayerid
		public static Schedule getScheduleIds(int prayerid) {
			Schedule sc = new Schedule();
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps= con.prepareStatement("SELECT * FROM schedule WHERE prayerid=?");
				ps.setInt(1, prayerid);
				
				//execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					
					sc.setScheduleid(rs.getInt("scheduleid"));
					sc.setScheduledate(rs.getString("scheduledate"));
					sc.setPrayerid(rs.getInt("prayerid"));
			
					sc.setImamid(rs.getInt("imamid"));
					sc.setBilalid(rs.getInt("bilalid"));
				}
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return sc;
		}		
	
	
			
	//delete Schedule
	public void deleteSchedule(int scheduleid) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM schedule WHERE scheduleid=?");
			ps.setInt(1, scheduleid);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}			
			
	//update Schedule
	public void updateSchedule(Schedule bean) {
		scheduleid = bean.getScheduleid();
		scheduledate = bean.getScheduledate();
		prayerid = bean.getPrayerid();
		imamid = bean.getImamid();
		bilalid = bean.getBilalid();

		
		
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE schedule SET scheduledate=?,prayerid=?,imamid=?,bilalid=? WHERE scheduleid=?");
			ps.setString(1,scheduledate);
			ps.setInt(2, prayerid);
			ps.setInt(3, imamid);
			ps.setInt(4, bilalid);

			ps.setInt(5,scheduleid);
			
			
			//execute query
			ps.executeUpdate();
			
			System.out.println("Successfully updated");
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}			
			
	//get schedule and staff
	public static List<Schedule> getStaffSchedules() { 
		List<Schedule> schedules = new ArrayList<Schedule>(); 
		Staff staffid1 = new Staff();
		
		try { 
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			//3. create statement 
			st = con.createStatement(); 
			//4. execute query
			String sql = "SELECT * FROM staff INNER JOIN schedule ON staff.id =schedule.imamid OR staff.id=schedule.bilalid WHERE staff.staffid1 ='" + staffid1 + "'";
			rs = st.executeQuery(sql);

			while (rs.next()) { 
				Schedule sc = new Schedule();
				sc.setScheduleid(rs.getInt("scheduleid"));	  
				sc.setScheduledate(rs.getString("scheduledate"));
				sc.setPrayerid(rs.getInt("prayerid"));
				sc.setImamid(rs.getInt("imamid"));
				sc.setBilalid(rs.getInt("bilalid"));

				sc.setStaff(StaffDAO.getStaffById(rs.getInt("id")));
				schedules.add(sc);

			} 
			System.out.println("Schedule Staff");
			//5. close connection
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}

		return schedules; 
	}			
		
		//get schedule and prayer
				public static List<Schedule> getPrayerSchedules() { 
					List<Schedule> schedules = new ArrayList<Schedule>(); 
					try { 
						//call getConnection() method 
						con = ConnectionManager.getConnection();
						//3. create statement 
						st = con.createStatement(); 
						//4. execute query
						rs = st.executeQuery("SELECT * FROM schedule sc INNER JOIN prayer p ON sc.prayerid= p.id");

						while (rs.next()) { 
							Schedule sc = new Schedule();
							sc.setScheduleid(rs.getInt("scheduleid"));	  
							sc.setScheduledate(rs.getString("scheduledate"));
							sc.setPrayerid(rs.getInt("prayerid"));
							sc.setImamid(rs.getInt("imamid"));
							sc.setBilalid(rs.getInt("bilalid"));
			
							sc.setPrayer(PrayerDAO.getPrayerById(rs.getInt("id")));
							schedules.add(sc);

						} 
						System.out.println("Schedule Prayer");
						//5. close connection
						con.close();
					
					}catch(Exception e) {
						e.printStackTrace();
					
					}

					return schedules; 
				}	
	
}
