package com.student.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	// this static method will return the Statement Object
		public static Statement getStatement() throws ClassNotFoundException, SQLException {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/mydata";
			String username="root";
			String password="root";
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stm = conn.createStatement();
			return stm;
		}
}
