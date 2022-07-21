package order.model;

import product.model.Product;

public class Order {
		private int orderId;
		private String orderDate;
		private Product prod;
		private int prodId;
		private int quantity;
		private int empId;
		private double totalamount;
		
		
		public Order() {
			
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public String getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}
		
		
		
		
		public Product getProd() {
			return prod;
		}
		public void setProd(Product prod) {
			this.prod = prod;
		}
		
		
		
		public int getProdId() {
			return prodId;
		}
		public void setProdId(int ProdId) {
			this.prodId = prodId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int Quantity) {
			this.quantity = quantity;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public double getTotalamount() {
			// TODO Auto-generated method stub
			return 0;
		}
		public void setTotalamount(double totalamount) {
			this.totalamount = totalamount;
		}
}

