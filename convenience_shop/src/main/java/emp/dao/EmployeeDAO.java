package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import emp.model.Employee;
import product.db.ConnectionManager;

public class EmployeeDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private String firstname, lastname,email, empphonenum, address;
	private int employeeID, jobID;

	//add employee
	public void addEmployee(Employee bean) {
		employeeID = bean.getEmployeeID();
		firstname = bean.getFirstname();
		lastname = bean.getLastname();
		email= bean.getEmail();
		empphonenum = bean.getEmpphonenum();
		address = bean.getAddress();
	
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO EMPLOYEE(employeeID, firstname, lastname, email, empphonenum, address)VALUES(?,?,?,?,?,?)");
			ps.setInt(1,employeeID);
			ps.setString(2,firstname);
			ps.setString(3, lastname);
			ps.setString(4,email);
			ps.setString(5, empphonenum);
			ps.setString(6,address);
	

			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	
	//get all employees
	public static List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM EMPLOYEE ORDER BY employeeID";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Employee em = new Employee();
				em.setEmployeeID(rs.getInt("employeeID"));
				em.setFirstname(rs.getString("firstname"));
				em.setLastname(rs.getString("lastname"));
				em.setEmail(rs.getString("email"));
				em.setEmpphonenum(rs.getString("empphonenum"));
				em.setAddress(rs.getString("address"));
				em.setJobID(rs.getInt("jobID"));
				
				employees.add(em);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return employees;		
	}	
	
	//get Employee by employee id
		public static Employee getEmployeeById(int employeeID) {
			Employee em = new Employee();
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps= con.prepareStatement("SELECT * FROM EMPLOYEE WHERE employeeID=?");
				ps.setInt(1, employeeID);
				
				//execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					
					em.setEmployeeID(rs.getInt("employeeID"));
					em.setFirstname(rs.getString("firstname"));
					em.setLastname(rs.getString("lastname"));
					em.setEmail(rs.getString("email"));
					em.setEmpphonenum(rs.getString("empphonenum"));
					em.setAddress(rs.getString("address"));
					em.setJobID(rs.getInt("jobID"));
					
				}
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return em;
		}
		
		//delete product
		public void deleteEmployee(int employeeID) {
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE employeeID=?");
				ps.setInt(1, employeeID);
				
				//execute query
				ps.executeUpdate();
				
				//close connection
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//update product
		public void updateEmployee(Employee bean) {
			employeeID = bean.getEmployeeID();
			firstname = bean.getFirstname();
			lastname = bean.getLastname();
			email= bean.getEmail();
			empphonenum = bean.getEmpphonenum();
			address = bean.getAddress();
			jobID = bean.getJobID();
			
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("UPDATE EMPLOYEE SET firstname=?, lastname=?, email=?, empphonenum=?, address=?, jobID=? WHERE employeeID=?");
				
				ps.setString(1,firstname);
				ps.setString(2, lastname);
				ps.setString(3,email);
				ps.setString(4, empphonenum);
				ps.setString(5,address);
				ps.setInt(6,jobID);
				ps.setInt(7,employeeID);
				

				//execute query
				ps.executeUpdate();
				
				System.out.println("Successfully updated");
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}
