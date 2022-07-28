package product.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import product.db.ConnectionManager;
import product.model.Product;
import emp.model.*;


public class ProductDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private String productname, productdescription,productcategory;
	private int productID;
	double price;

	
	//add product
	public void addProduct(Product bean) {
		productID = bean.getProductID();
		productname = bean.getProductname();
		productdescription = bean.getProductdescription();
		price= bean.getPrice();
		productcategory = bean.getProductcategory();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO PRODUCT(productID, productname, productdescription, price, productcategory)VALUES(product_sequence.nextval,?,?,?,?)");
			ps.setString(1,productname);
			ps.setString(2, productdescription);
			ps.setDouble(3,price);
			ps.setString(4,productcategory);

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
	public static List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM PRODUCT ORDER BY productID";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {		//process result
				Product p = new Product();
				p.setProductID(rs.getInt("productID"));
				p.setProductname(rs.getString("productname"));
				p.setProductdescription(rs.getString("productdescription"));
				p.setPrice(rs.getDouble("price"));
				p.setProductcategory(rs.getString("productcategory"));
				
			
				products.add(p);
			}
			
			//close connection
			con.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}	

	//get Product by product id
	public static Product getProductById(int productID) {
		Product p = new Product();
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps= con.prepareStatement("SELECT * FROM PRODUCT WHERE productID=?");
			ps.setInt(1, productID);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				
				p.setProductID(rs.getInt("productID"));
				p.setProductname(rs.getString("productname"));
				p.setProductdescription(rs.getString("productdescription"));
				p.setPrice(rs.getDouble("price"));
				p.setProductcategory(rs.getString("productcategory"));
				
			}
			
			//close connection
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	//delete product
	public void deleteProduct(int productID) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM PRODUCT WHERE productID=?");
			ps.setInt(1, productID);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update product
	public void updateProduct(Product bean) {
		productID = bean.getProductID();
		productname = bean.getProductname();
		productdescription = bean.getProductdescription();
		price= bean.getPrice();
		productcategory = bean.getProductcategory();
		
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("UPDATE PRODUCT SET productname=?, productdescription=?, price=?, productcategory=? WHERE productID=?");
			
			ps.setString(1,productname);
			ps.setString(2,productdescription);
			ps.setDouble(3,price);
			ps.setString(4,productcategory);
			ps.setInt(5,productID);
			
			
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
