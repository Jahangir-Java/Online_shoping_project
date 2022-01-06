package com.exam.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.Product;

public class ProductData {
	Connection con;
	PreparedStatement pst;
	
	public void doInsert(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("insert into product (name, category, price) values(?,?,?)");
			pst.setString(1, p.getName());
			pst.setString(2, p.getCategory());
			pst.setDouble(3, p.getPrice());
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {
			System.out.println(e);

		}

	}
	public List<Product> doShow(Product p) {
		List<Product> list = new ArrayList<Product>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");

			pst = con.prepareStatement("select * from product");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDouble(4),rs.getString(5));
				list.add(p);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return list;
	}
	//update
	public void doUpdate(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("update product set price=? where Id=?");

			pst.setDouble(1, p.getPrice());
			pst.setInt(2, p.getId());
			pst.executeUpdate();

		
		} catch (Exception e) {

		}

	}
// Delete code
	public void doDelete(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("delete from product where Id=?");
			pst.setInt(1, p.getId());
			pst.executeUpdate();

		
		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
