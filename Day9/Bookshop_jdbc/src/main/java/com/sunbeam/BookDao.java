package com.sunbeam;

import java.util.List;

public interface BookDao {
  
	int save(Book b);
	
	List<Book> findBySubject(String subject);
	
	Book findById(int id);
	
	int deleteById(int id);
	
	List<String> findAllSubject();
	
	int update(Book b);
	
}
