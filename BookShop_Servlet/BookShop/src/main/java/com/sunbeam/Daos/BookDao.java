package com.sunbeam.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.Book;

public class BookDao implements AutoCloseable {

	private Connection con;

	public BookDao() throws SQLException {
		con = Dbutil.getConnection();
	}

	@Override
	public void close() throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public List<Book> findAllBook() throws SQLException {

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

	public int save(Book b) throws SQLException {

		String sql = "Insert into books(name,author,subject,price) values(?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, b.getName());
			stmt.setString(2, b.getAuthor());
			stmt.setString(3, b.getSubject());
			stmt.setDouble(4, b.getPrice());
			int count = stmt.executeUpdate();
			return count;
		}

	}

	public Book findbyId(int id) throws SQLException {

		String sql = "select * from books where id=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					int idx = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");

					Book bk = new Book(idx, name, author, subject, price);
					return bk;
				}
			}
		}
		return null;
	}

	public List<String> findAllSubject() throws SQLException {

		List<String> list = new ArrayList<>();

		String sql = "select distinct subject from books";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					String subject = rs.getString("subject");
					list.add(subject);
				}
			}
		}
		return list;
	}

	public int update(Book b) throws SQLException {

		String sql = "Update books set name=?, author=?, subject=?, price=? where id=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, b.getName());
			stmt.setString(2, b.getAuthor());
			stmt.setString(3, b.getSubject());
			stmt.setDouble(4, b.getPrice());
			stmt.setInt(5, b.getId());
			int count = stmt.executeUpdate();
			return count;

		}

	}

	public int deletebyId(int id) throws SQLException {

		String sql = "Delete from books where id =?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int count = stmt.executeUpdate();
			return count;
		}
	}

	public List<Book> findbySubject(String sub) throws SQLException {
        
		List<Book> list = new ArrayList<>();
		
		String sql = "select * from books where subject=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, sub);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					int idx = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");

					Book bk = new Book(idx, name, author, subject, price);
					list.add(bk);
				}
			}
		}
		return list;
	}
}
