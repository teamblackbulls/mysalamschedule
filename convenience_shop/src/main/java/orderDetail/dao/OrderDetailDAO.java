package orderDetail.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import product.db.ConnectionManager;
import order.model.OrderDetail;

public class OrderDetailDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private int orderdetailID, quantity, productID,orderID;
	double totalamount;

	//add orderdetail
	public void addOrderDetail(OrderDetail bean) {
	
		productID = bean.getProductID();
		quantity= bean.getQuantity();
		orderID = bean.getOrderID();
	
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			// Get total amount for productID
			PreparedStatement amountSQL = con.prepareStatement("SELECT price FROM product WHERE productid ="+productID);
			ResultSet resultAmount = amountSQL.executeQuery();
			
			while(resultAmount.next()) {
			totalamount = resultAmount.getDouble("price") * quantity;
			}
			
			//create statement add order details
			ps = con.prepareStatement("INSERT INTO orderdetail(orderdetailid,productID, quantity, totalamount, orderID)VALUES(orderdetail_sequence.nextval,?,?,?,?)");
			ps.setInt(1,productID);
			ps.setInt(2,quantity);
			ps.setDouble(3,totalamount);
			ps.setInt(4, orderID);
	
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//get all orderdetail
	public static List<OrderDetail> getAllOrderdetail() {
		List<OrderDetail> orderdetail = new ArrayList<OrderDetail>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT orderdtailsid, productid, quantity, totalamount, orderid FROM orderdetail ORDER BY orderID";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				OrderDetail od = new OrderDetail();
				od.setOrderdetailID(rs.getInt("orderdetailID"));
				od.setProductID(rs.getInt("productID"));
				od.setQuantity(rs.getInt("quantity"));
				od.setTotalamount(rs.getInt("totalamount"));
				od.setOrderID(rs.getInt("orderID"));

				orderdetail.add(od);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return orderdetail;
	}	

	//get Order by order id
	public static OrderDetail getOrderdetailById(int orderdetailID) {
		OrderDetail od = new OrderDetail();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM orderdetail WHERE orderdetailID=?");
			ps.setInt(1, orderdetailID);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				od.setOrderdetailID(rs.getInt("orderdetailID"));
				od.setProductID(rs.getInt("productID"));
				od.setQuantity(rs.getInt("quantity"));
				od.setTotalamount(rs.getDouble("totalamount"));
				od.setOrderID(rs.getInt("orderID"));
					
			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return od;
	}
	
	
	//delete orderdetail
	public void deleteOrderDetail(int orderdetailID) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM orderdetail WHERE orderdetailID=?");
			ps.setInt(1, orderdetailID);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update orderdetail
	public void updateOrderDetail(OrderDetail bean) {
		orderdetailID = bean.getOrderdetailID();
		productID = bean.getProductID();
		quantity= bean.getQuantity();
		totalamount = bean.getTotalamount();
		
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE orderdetail SET  productID=?, quantity=?, totalamount=?, orderid=? WHERE orderdetailID=?");
			
			ps.setInt(1,productID);
			ps.setInt(2,quantity);
			ps.setDouble(3,totalamount);
			ps.setInt(4, orderID);
			
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

