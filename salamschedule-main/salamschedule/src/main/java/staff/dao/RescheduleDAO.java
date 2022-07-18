package staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import staff.db.*;
import staff.model.*;

public class RescheduleDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private int scheduleid, rescheduleid,rescheduleprayerid,staffid;
	private String rescheduledate;
	
	
	//add Reschedule
	public void addReschedule(Reschedule bean) {
		rescheduleid = bean.getRescheduleid();
		scheduleid=bean.getScheduleid();
		rescheduledate = bean.getRescheduledate();
		rescheduleprayerid = bean.getRescheduleprayerid();
		staffid = bean.getStaffID();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO reschedule(scheduleid, rescheduledate,rescheduleprayerid,staffid) VALUES(?,?,?,?)");
			
			ps.setInt(1,scheduleid);
			ps.setString(2, rescheduledate);
			ps.setInt(3,rescheduleprayerid);
			ps.setInt(4,staffid);
			
		

			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
					
	//get all Reschedules
	public static List<Reschedule> getAllReschedules() {
		List<Reschedule> reschedules = new ArrayList<Reschedule>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM reschedule ORDER BY rescheduleid";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Reschedule rc = new Reschedule();
				rc.setRescheduleid(rs.getInt("rescheduleid"));
				rc.setScheduleid(rs.getInt("scheduleid"));
				rc.setRescheduledate(rs.getString("rescheduledate"));
				rc.setRescheduleprayerid(rs.getInt("rescheduleprayerid"));
				rc.setStaffID(rs.getInt("staffid"));
			
				reschedules.add(rc);
			}
			System.out.println("Successfully getAllReschedules");
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return reschedules;
	}
	
	
			
	//get Reschedule by Rescheduleid
	public static Reschedule getRescheduleById(int rescheduleid) {
		Reschedule rc = new Reschedule();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM reschedule WHERE rescheduleid=?");
			ps.setInt(1, rescheduleid);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				rc.setRescheduleid(rs.getInt("rescheduleid"));
				rc.setScheduleid(rs.getInt("scheduleid"));
				rc.setRescheduledate(rs.getString("rescheduledate"));
				rc.setRescheduleprayerid(rs.getInt("rescheduleprayerid"));
				rc.setStaffID(rs.getInt("staffid"));
			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rc;
	}		
	

	
	//get Reschedule by staffid1
	public static Reschedule getRescheduleId(int staffid) {
		Reschedule rc = new Reschedule();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM Reschedule WHERE imamid=?");
			ps.setInt(1,staffid);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				rc.setRescheduleid(rs.getInt("rescheduleid"));
				rc.setScheduleid(rs.getInt("scheduleid"));
				rc.setRescheduledate(rs.getString("rescheduledate"));
				rc.setRescheduleprayerid(rs.getInt("rescheduleprayerid"));
				rc.setStaffID(rs.getInt("staffid"));
			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rc;
	}		
	
			
	//delete Reschedule
	public void deleteReschedule(int rescheduleid) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM reschedule WHERE rescheduleid=?");
			ps.setInt(1, rescheduleid);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}			
				
	
}