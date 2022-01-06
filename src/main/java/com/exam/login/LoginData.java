package com.exam.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.Product;
import com.exam.User_info;



public class LoginData {
	Connection con;
	PreparedStatement pst;

	
	

		/*
		 * public User_info findByE_P(String email, String password) { List<User_info>
		 * list = new ArrayList<>(); User_info s; try {
		 * Class.forName("com.mysql.cj.jdbc.Driver"); con =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject",
		 * "root", "idb122292");
		 * 
		 * pst = con.
		 * prepareStatement("select * from userinformation where email=? AND password=?"
		 * ); pst.setString(1, email); pst.setString(2, password);
		 * 
		 * ResultSet rs = pst.executeQuery(); while (rs.next()) { s = new
		 * User_info(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
		 * rs.getString(5)); list.add(s); }
		 * 
		 * } catch (Exception e) {
		 * 
		 * } return list.get(0); }
		 */// showing product information

		public List<Product> productShow() {

			List<Product> list = new ArrayList<Product>();
			Product p;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");

				pst = con.prepareStatement("select * from product");
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));

					list.add(p);
				}

			} catch (Exception e) {

			}
			return list;
		}
// Showing user information
		
		public List<User_info> userShow() {
			
			List<User_info> list = new ArrayList<User_info>();
			User_info ui;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
				
				pst = con.prepareStatement("select * from userinformation");
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					ui = new User_info(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
					
					list.add(ui);
				}
				
			} catch (Exception e) {
				
			}
			return list;
		}


}
		
