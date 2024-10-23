package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Book;


public interface BookService {

	List<String> getSubjects();	
	
	List<Book> getBooks(String subject);
	
	Book getBookById(int id);

	List<Book> getAllBooks();

	Book editThisBook(int id);

	int updateTheBook(Book b);

	int deleteBook(int id);

	int addToBooks(Book b);
}
