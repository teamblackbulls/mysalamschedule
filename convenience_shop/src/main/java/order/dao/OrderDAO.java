package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import product.db.ConnectionManager;
import order.model.Order;


public class OrderDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private int orderID, productID, quantity, employeeID;
	private String orderdate;
	double totalamount;

	
	//add order
	public void addOrder(Order bean) {
		employeeID = bean.getEmpId();
		orderdate = bean.getOrderDate();
		productID = bean.getProdId();
		quantity= bean.getQuantity();
		totalamount = bean.getTotalamount();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO orders(employeeID, orderdate, productID, quantity, totalamount)VALUES(?,?,?,?,?)");
			ps.setInt(1,employeeID);
			ps.setString(2, orderdate);
			ps.setInt(3,productID);
			ps.setInt(4,quantity);
			ps.setDouble(5,totalamount);

			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//get all products
	public static List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM orders ORDER BY orderID";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Order od = new Order();
				od.setOrderId(rs.getInt("orderID"));
				od.setEmpId(rs.getInt("employeeID"));
				od.setOrderDate(rs.getString("orderdate"));
				od.setProdId(rs.getInt("productID"));
				od.setQuantity(rs.getInt("quantity"));
				od.setTotalamount(rs.getDouble("totalamount"));
				
			
				orders.add(od);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return orders;
	}	

	//get Order by order id
	public static Order getOrderById(int orderID) {
		Order od = new Order();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM orders WHERE orderID=?");
			ps.setInt(1, orderID);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				od.setOrderId(rs.getInt("orderID"));
				od.setEmpId(rs.getInt("employeeID"));
				od.setOrderDate(rs.getString("orderdate"));
				od.setProdId(rs.getInt("productID"));
				od.setQuantity(rs.getInt("quantity"));
				od.setTotalamount(rs.getDouble("totalamount"));
					
			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return od;
	}
	
	//delete product
	public void deleteOrder(int orderID) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM orders WHERE orderID=?");
			ps.setInt(1, orderID);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update product
	public void updateOrder(Order bean) {
		orderID = bean.getOrderId();
		employeeID = bean.getEmpId();
		orderdate = bean.getOrderDate();
		productID = bean.getProdId();
		quantity= bean.getQuantity();
		totalamount = bean.getTotalamount();
		
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE orders SET  employeeID=?, orderdate=?, productID=?, quantity=?, totalamount=? WHERE orderID=?");
			
			ps.setInt(1,employeeID);
			ps.setString(2, orderdate);
			ps.setInt(3,productID);
			ps.setInt(4,quantity);
			ps.setDouble(5,totalamount);
			
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

