package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Sql_injection_attack {
	
	public static final String Driver ="com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/advancejava";
	public static final String pass = "manager";
	public static final String user = "W3_87373_Ajay";
	
	static {
		try {
			Class.forName(Driver);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Subject : ");
		String subject = sc.nextLine();
		System.out.print("Enter Price : ");
		double price = sc.nextDouble();
		
	try(Connection con = DriverManager.getConnection(url,user,pass)){
		
	//String sql="select * from books where id = ?";
	String sql = "SELECT * FROM books WHERE subject = ? AND price > ?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, subject);
			stmt.setDouble(2, price);
		     
		     try(ResultSet rs = stmt.executeQuery()){
		    	 while(rs.next()) {
		    		    int idx = rs.getInt("id");
						String name = rs.getString("name");
						String author = rs.getString("author");
						String sub = rs.getString("subject");
						double pri = rs.getDouble("price");

						System.out.printf("%d,%s,%s,%S,%f \n", idx, name, author, sub, pri);

		    	 }
		     }
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}

}
