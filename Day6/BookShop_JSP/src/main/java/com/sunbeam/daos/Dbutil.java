package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {

	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/advancejava";
	public static final String user = "W3_87373_Ajay";
	public static final String pass= "manager";
	
	static {
		try {
			Class.forName(Driver);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(url,user,pass);
		return con;
	}
}
