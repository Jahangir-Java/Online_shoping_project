package com.exam.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.exam.Order;

public class OrderData {
	Connection con;
	PreparedStatement pst;
	List<Order> list = new ArrayList<Order>();
	public List<Order> doShow() {
		
		Order or;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");

			pst = con.prepareStatement("SELECT currentaddress.customername, ordersrecord.email, currentaddress.phone, "
					+ "currentaddress.address, ordersrecord.productname, ordersrecord.quantity, ordersrecord.price, ordersrecord.orderdate"
					+ "  FROM shoping.ordersrecord inner join shoping.currentaddress where ordersrecord.email=currentaddress.email");
				
				
				
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				or = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getDouble(7)
						,rs.getString(8));
				list.add(or);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return list;
	}

}
