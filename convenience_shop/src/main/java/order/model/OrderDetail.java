package order.model;
public class OrderDetail {

		private int orderdetailID;
		private int quantity;
		private double totalamount;
		private int productID;
		private int orderID;
		
		
		public OrderDetail() {
			
		}


		public int getOrderdetailID() {
			return orderdetailID;
		}


		public void setOrderdetailID(int orderdetailID) {
			this.orderdetailID = orderdetailID;
		}


		public int getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


		public double getTotalamount() {
			return totalamount;
		}


		public void setTotalamount(double totalamount) {
			this.totalamount = totalamount;
		}


		public int getProductID() {
			return productID;
		}


		public void setProductID(int productID) {
			this.productID = productID;
		}


		public int getOrderID() {
			return orderID;
		}


		public void setOrderID(int orderID) {
			this.orderID = orderID;
		}


	

		
		
		
		
}

