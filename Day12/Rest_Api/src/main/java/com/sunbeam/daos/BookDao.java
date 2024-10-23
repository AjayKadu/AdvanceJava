package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Book;

public interface BookDao {
  
	int save(Book b);
	
	List<Book> findBySubject(String subject);
	
	Book findById(int id);
	
	int deleteById(int id);
	
	List<String> findAllSubject();
	
	int update(Book b);
	
}
