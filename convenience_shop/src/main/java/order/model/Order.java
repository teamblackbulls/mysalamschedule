package order.model;
import java.sql.*;

public class Order {
	private int orderID ;
	private int employeeID ;
	private Date orderdate ;
	double grandtotal;
	int products;
	
	
	public Order() {

	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderid) {
		this.orderID = orderid;
	}


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public Date getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}


	public double getGrandtotal() {
		return grandtotal;
	}


	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}


	public int getProducts() {
		return products;
	}


	public void setProducts(int products) {
		this.products = products;
	}



}
