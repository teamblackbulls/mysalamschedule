package product.model;

public class Product {
	private int productID;
	private String productname;
	private String productdescription;
	private double price;
	private String productcategory;
	
	public Product() {

	}
	
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	
	public String getProductdescription() {
		return productdescription;
	}


	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	
}
