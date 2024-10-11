package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements AutoCloseable {

	private Connection con;

	public BookDao() throws SQLException {
		con = Dbutil.getConnection();
	}

	public List<Book> allBook() throws SQLException {
		
		List<Book> list = new ArrayList<>();
		String sql = "select * from books";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");
					
					Book b = new Book(id, name, author, subject, price);
				    list.add(b);
				}
			}
		}
		return list;

	}

	public int save() {
		return 0;
	}

	public Book findbyId(int id) throws SQLException {
		
		String sql = "select * from books where id=?";
		
		try(PreparedStatement stmt=con.prepareStatement(sql)){
           
			stmt.setInt(1, id);
			
			try(ResultSet rs = stmt.executeQuery()){
			
				if(rs.next()) {
				int idx = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String subject = rs.getString("subject");
				double price = rs.getDouble("price");
				
				Book bk = new Book(idx, name, author,subject,price);
			    return bk;
				}	
				
			}

		}
		
		return null;
	
		
	}

	public List<Book> findbySubject(String sub) throws SQLException {
		
		List<Book> list = new ArrayList<>();
		
String sql = "select * from books where subject=?";
		
		try(PreparedStatement stmt=con.prepareStatement(sql)){
           
			stmt.setString(1, sub);
			
			try(ResultSet rs = stmt.executeQuery()){
			
				while(rs.next()) {
				int idx = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String subject = rs.getString("subject");
				double price = rs.getDouble("price");
				
				Book bk = new Book(idx, name, author,subject,price);
			    list.add(bk);
				}	
				
			}

		}
		
		  return list;
		
		
	}

	public int update() {
		return 0;
	}

	public int deletebyId(int id) throws SQLException {
	
		String sql = "Delete from books where id =?";
		
		try( PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1,id);
			int count = stmt.executeUpdate();
			return count;
			
		}
		
		
	}

	@Override
	public void close() throws Exception {
		if (con != null) {
			con.close();
		}

	}

}
