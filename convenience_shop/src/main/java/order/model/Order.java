package order.model;

import java.sql.Date;

import emp.model.Employee;
import product.model.Product;

public class Order {

		private int orderID;
		
		private Date orderdate;
		
		private Product product;
		private int productID;
		
		private int quantity;
		
		private Employee employee;
		private int employeeID;
		
		private double totalamount;
		
		
		public Order() {
			
		}


		public int getOrderID() {
			return orderID;
		}


		public void setOrderID(int orderID) {
			this.orderID = orderID;
		}



		public Date getOrderdate() {
			return orderdate;
		}


		public void setOrderdate(Date orderdate) {
			this.orderdate = orderdate;
		}


		public Product getProduct() {
			return product;
		}


		public void setProduct(Product product) {
			this.product = product;
		}


		public int getProductID() {
			return productID;
		}


		public void setProductID(int productID) {
			this.productID = productID;
		}


		public int getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		

		public Employee getEmployee() {
			return employee;
		}


		public void setEmployee(Employee employee) {
			this.employee = employee;
		}


		public int getEmployeeID() {
			return employeeID;
		}


		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}


		public double getTotalamount() {
			return totalamount;
		}


		public void setTotalamount(double totalamount) {
			this.totalamount = totalamount;
		}
		
		
		
		
		
}

