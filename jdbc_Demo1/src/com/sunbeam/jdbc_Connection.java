package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc_Connection {
 
	 //Load and Register the Driver
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
        
		//Establish the Connection
		
		String url = "jdbc:mysql://localhost:3306/advancejava";
		String user = "W3_87373_Ajay";
		String password = "manager";

		try (Connection con = DriverManager.getConnection(url, user, password)) {
            
			//prepare the statement
			
			String sql = "select * from books";

			try (PreparedStatement stmt = con.prepareStatement(sql)) {
                
				//Execute the Query
				
				try (ResultSet rs = stmt.executeQuery(sql)) {

					while (rs.next()) {

						int id = rs.getInt("id");
						String name = rs.getString("name");
						String author = rs.getString("author");
						String subject = rs.getString("subject");
						double price = rs.getDouble("price");

						System.out.printf("%d,%s,%s,%S,%f \n", id, name, author, subject, price);

					}
				}

			} // stmt.close();

		} // con.close();
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
