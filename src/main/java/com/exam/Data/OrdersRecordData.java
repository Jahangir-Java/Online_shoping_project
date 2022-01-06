package com.exam.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.exam.OrdersRecord;


public class OrdersRecordData {
	Connection con;
	PreparedStatement pst;
	
	//insert into orders record
	public void doInsert(OrdersRecord or) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String date = dtf.format(localDate);
		
		LocalDate localDate_1day = localDate.plusDays(1);
		String date_1day = dtf.format(localDate_1day);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("insert into ordersrecord"
					+ " (customername, email, phone, id, productname, category, price, quantity, subtotal, orderdate, placementdate)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)");

			pst.setString(1, or.getCustomerName());
			pst.setString(2, or.getEmail());
			pst.setString(3, or.getPhone());
			pst.setString(4, or.getId());
			pst.setString(5, or.getProductName());
			pst.setString(6, or.getCategory());
			pst.setDouble(7, or.getPrice());
			pst.setInt(8, or.getQuantity());
			pst.setDouble(9, or.getSubtotal());
			pst.setString(10, date);
			pst.setString(11, date_1day);
			
	
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);

		}

	}
	
	
	//Update code to order record by price
	public void doUpdate(OrdersRecord or) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("update ordersrecord set quantity=? where sl=?");

			pst.setDouble(1, or.getQuantity());
			pst.setInt(2, or.getSl());
			pst.executeUpdate();

		} catch (Exception e) {

		}

	}
	//Update code to order record by email and date
	public void updateEmail_date(OrdersRecord or) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("update ordersrecord set address=? where email=? and orderdate=?");
			
		    pst.setString(1, or.getAddress());
		    pst.setString(2, or.getEmail());
		    pst.setString(3, or.getOrderdate());
			pst.executeUpdate();
			
		} catch (Exception e) {
			
		}
		
	}
	
// Delete from order record
	public void doDelete(OrdersRecord or) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("delete from ordersrecord where sl=?");
			pst.setInt(1, or.getSl());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);

		}

	}
	
	// show from order record
	public List<OrdersRecord> doShow() {
		List<OrdersRecord> list = new ArrayList<OrdersRecord>();
		OrdersRecord or;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");

			pst = con.prepareStatement("select * from ordersrecord");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				or = new OrdersRecord(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getDouble(9),  rs.getInt(10), rs.getDouble(11),
						rs.getString(12),rs.getString(13));
				list.add(or);
			}

		} catch (Exception e) {

		}
		return list;
	}
	
	
	
}
