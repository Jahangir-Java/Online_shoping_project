package com.exam;

public class Product {
	int id;
	String name;
	String category;
	double price;
	String photos;
	public Product() {
		super();
	
	}
	public Product(int id) {
		super();
		this.id = id;
	
	}
	public Product(int id, String name, String category, double price, String photos) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.photos = photos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	

	
	

}
