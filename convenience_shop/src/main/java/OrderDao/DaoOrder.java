package OrderDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import product.db.ConnectionManager;
import order.model.Order;


public class DaoOrder {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private int orderID, employeeID;
	private Date orderdate;
	double grandtotal;
	
//add order
	public int addOrder(Order bean) {
		int orderid = 0;
		
		orderdate = bean.getOrderdate();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO orders(orderid, orderdate) VALUES (order_sequence.nextval,?)");
			ps.setDate(1,orderdate);
	
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			// Get orderid
			PreparedStatement getidSQL = con.prepareStatement("SELECT orderid FROM orders ORDER BY orderid");
			
			// Execute
			ResultSet result = getidSQL.executeQuery();
			
			// Get latest orderid
			while(result.next()) {
				orderid = result.getInt("orderid");
			}
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderid;
	}
	
/*	//get all order
	public static List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			
			char quote ='"';
			String sql = "SELECT o.orderid, o.orderdate, o.employeeid, o.grandtotal, COUNT(d.orderdetailid) AS "+quote+"PRODUCTS"+quote+" FROM orders o JOIN orderdetail d ON (o.orderid = d.orderid) GROUP BY o.orderid, o.orderdate, o.employeeid, o.grandtotal ORDER BY o.orderid";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Order or = new Order();
				or.setOrderid(rs.getInt("orderid"));
				or.setEmployeeID(rs.getInt("employeeID"));
				or.setOrderdate(rs.getDate("orderdate"));
				or.setGrandtotal(rs.getDouble("grandtotal"));
				or.setProducts(rs.getInt("products"));
				orders.add(or);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return orders;
	}	
*/	
/*	//get Order by order id
		public static Order getOrderById(int orderid) {
			Order or = new Order();
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps= con.prepareStatement("SELECT * FROM orders WHERE orderID=?");
				ps.setInt(1, orderid);
				
				//execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					
					or.setOrderid(rs.getInt("orderid"));
					or.setEmployeeID(rs.getInt("employeeID"));
					or.setOrderdate(rs.getDate("orderdate"));
					or.setGrandtotal(rs.getDouble("grandtotal"));
						
				}
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return or;
		}
*/		
		//delete order
		public void deleteOrder(int orderid) {
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("DELETE FROM orders WHERE orderid=?");
				ps.setInt(1, orderid);
				
				//execute query
				ps.executeUpdate();
				
				//close connection
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//update order
		public void updateOrder(Order bean) {
			orderID = bean.getOrderID();
			grandtotal= bean.getGrandtotal();
			
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("UPDATE orders SET grandtotal=? WHERE orderid=?");
				
				ps.setDouble(1,grandtotal);
				ps.setInt(2, orderID);
				
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
