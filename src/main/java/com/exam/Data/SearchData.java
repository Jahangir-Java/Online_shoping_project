package com.exam.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.exam.OrdersRecord;
import com.exam.Product;
import com.exam.User_info;

@Controller
public class SearchData {
	Connection con;
	PreparedStatement pst;

	// Search by email from orders record
	public OrdersRecord findByEmailFromOrdersRecord(String email) {
		List<OrdersRecord> list = new ArrayList<>();
		OrdersRecord or;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("select * from ordersrecord where email='" + email + "'");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				or = new OrdersRecord(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getDouble(9),  rs.getInt(10), rs.getDouble(11),
						rs.getString(12),rs.getString(13));
				list.add(or);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return list.get(0);
	}
	
	


	// find by any from products
	public List<Product> getByAnyFromProduct(String pid) {

		List<Product> list = new ArrayList<Product>();
		Product p;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");

			pst = con.prepareStatement("select * from product where id like '%" + pid + "%' or name like '%" + pid
					+ "%' or category like '%" + pid + "%'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));

				list.add(p);
			}

		} catch (Exception e) {

		}
		return list;
	}

	// login Email and password match
	public String LoginEmailPasswordMatch(String email, String password) {
		String ss = "fail";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement(
					"select * from userinformation where email='" + email + "' and password='" + password + "'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ss = "Success";

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ss;
	}
	
	public List<OrdersRecord> searchByEmail_date(String email, String date) {
		List<OrdersRecord> list = new ArrayList<OrdersRecord>();
		OrdersRecord or;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement(
					"select * from ordersrecord where email='" + email + "' and orderdate='" + date + "'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				or = new OrdersRecord(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getDouble(9),  rs.getInt(10), rs.getDouble(11),
						rs.getString(12),rs.getString(13));
				list.add(or);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	// find by email from user info
	public User_info findByEmailFromUser_info(String email) {
		List<User_info> list = new ArrayList<>();
		User_info s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("select * from userinformation where email='" + email + "'");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new User_info(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(s);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return list.get(0);
	}

	// find by email from User info
	public String findByEmailFormUser_info(String email) {
		String ss = "fail";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("select * from userinformation where email='" + email + "'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				ss = "Success";

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ss;
	}
	
	

}
