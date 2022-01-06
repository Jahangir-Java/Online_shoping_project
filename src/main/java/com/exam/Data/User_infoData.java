package com.exam.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.exam.User_info;

public class User_infoData {
	Connection con;
	PreparedStatement pst;
	
	
// insert into user information table
	public void doInsert(User_info ui) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("insert into userinformation (name,email,phone,password) values(?,?,?,?)");

			pst.setString(1, ui.getName());
			pst.setString(2, ui.getEmail());
			pst.setString(3, ui.getPhone());
			pst.setString(4, ui.getPassword());
			pst.executeUpdate();
		} catch (Exception e) {

		}

	}
	
	// update
	public void updatePassword(User_info user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("update userinformation set email=?, password=? where email=?");

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}



}
