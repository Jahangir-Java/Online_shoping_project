package com.exam.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.exam.CurrentAddress;

public class CurrentAdderssData {
	Connection con;
	PreparedStatement pst;

	public void doInsert(CurrentAddress ca) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String date = dtf.format(localDate);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement(
					"insert into currentaddress" + " (name,email, phone, address,orderdate)" + "values(?,?,?,?,?)");

			pst.setString(1, ca.getName());
			pst.setString(2, ca.getEmail());
			pst.setString(3, ca.getPhone());
			pst.setString(4, ca.getAddress());
			pst.setString(5, date);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
