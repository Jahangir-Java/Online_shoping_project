package com.exam;

public class CurrentAddress {
	int id;
	String name;
	String email;
	String phone;
	String address;
	String date;
	public CurrentAddress() {
		super();
	}
	
	public CurrentAddress(int id) {
		super();
		this.id = id;
	}
	
	public CurrentAddress(int id, String name, String email, String phone, String address, String date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CurrentAddress [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", date=" + date + "]";
	}
	
	

}
