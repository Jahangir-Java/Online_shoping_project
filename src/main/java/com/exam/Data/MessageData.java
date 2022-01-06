package com.exam.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exam.Message;

public class MessageData {
	Connection con;
	PreparedStatement pst;
	
	// Insert into message
	public void doInsert(Message m) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");
			pst = con.prepareStatement("insert into message(name, email, message) values(?,?,?)");
		
			pst.setString(1, m.getName());
			pst.setString(2, m.getEmail());
			pst.setString(3, m.getMessage());
			pst.executeUpdate();
			
		} catch (Exception e) {

		}

	}
	
	
	//Show from message
	public List<Message> doShow() {
		List<Message> list = new ArrayList<Message>();
		Message m;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoping", "root", "idb122292");

			pst = con.prepareStatement("select * from message");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				m = new Message(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
				list.add(m);
			}

		} catch (Exception e) {

		}
		return list;
	}

}
