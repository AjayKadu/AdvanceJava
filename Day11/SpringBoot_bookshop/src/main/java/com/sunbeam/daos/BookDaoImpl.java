package com.sunbeam.daos;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Rowmapper bookMaper;

	@Override
	public int save(Book b) {

		String sql = "Insert into books (name,author,subject,price) values(?,?,?,?)";
		int count = jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getSubject(), b.getPrice());
		return count;

	}

	public List<Book> findBySubject(String subject) {

		String sql = "Select * from books where subject=?";
		List<Book> list = jdbcTemplate.query(sql, bookMaper, subject);
		return list;
	}

	public Book findById(int id) {

		String sql = "Select * from books where id = ?";
		List<Book> list = jdbcTemplate.query(sql, bookMaper, id);
		return list == null ? null : list.get(0);
	}

	public int deleteById(int id) {

		String sql = "delete from books where id = ?";
		int count = jdbcTemplate.update(sql, id);
		return count;
	}
	
	public List<String> findAllSubject(){
		
		String sql = "Select distinct subject from books";
		 List<String> list = jdbcTemplate.queryForList(sql, String.class);
		return list;
	}
	
	public int update(Book b) {

		String sql = "Update books set name=?, author=?, subject=?, price=? where id=?";
		int count = jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getSubject(), b.getPrice(), b.getId());
		return count;

	}
	
	public List<Book> findAllBook(){
		
		String sql="Select * from books";
		List<Book> list = jdbcTemplate.query(sql, bookMaper);
		return list;
	}

	
}
