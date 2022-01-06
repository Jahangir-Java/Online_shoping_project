package com.exam;

public class OrdersRecord {
	int sl;
	String customerName;
	String email;
	String phone;
	String address;
	String id;
	String productName;
	String category;
	double price;
	int quantity;
	double subtotal;
	String orderdate;
	String placementdate;
	public OrdersRecord() {
		super();

	}
	public OrdersRecord(int sl) {
		super();
		this.sl = sl;
	}
	public OrdersRecord(int sl, String email, String customerName, String phone, String address, String id, String productName,
			String category, double price, int quantity, double subtotal, String orderdate, String placementdate) {
		super();
		this.sl = sl;
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.orderdate = orderdate;
		this.placementdate = placementdate;
	}

	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getPlacementdate() {
		return placementdate;
	}
	public void setPlacementdate(String placementdate) {
		this.placementdate = placementdate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	





	

}
