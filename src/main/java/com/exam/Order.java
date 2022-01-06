package com.exam;

public class Order {
	
	String customerName;
	String email;
	String phone;
	String address;
	String productName;
	int quantity;
	double price;
	String orderDate;
	
	public Order(String customerName, String email, String phone, String address, String productName, int quantity,
			double price, String orderDate) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + ", orderDate="
				+ orderDate + "]";
	}
	
	


	
	

}
