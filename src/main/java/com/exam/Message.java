package com.exam;

public class Message {
int id;
String name;
String email;
String message;
public Message() {
	super();
	
}
public Message(int id) {
	super();
	this.id = id;
}
public Message(int id, String name, String email, String message) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.message = message;
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
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}



}
