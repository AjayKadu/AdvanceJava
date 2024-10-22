package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.BookDaoImpl;
import com.sunbeam.entities.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDaoImpl bookDao;

	@Override
	public List<String> getSubjects() {
	     
		List<String> list = bookDao.findAllSubject();
		return list;
	}

	@Override
	public List<Book> getBooks(String subject) {
	     List<Book> list = bookDao.findBySubject(subject);
	     return list;
	}

	@Override
	public Book getBookById(int id) {
		Book book = bookDao.findById(id);
	     return book;
	}
	
	
	
	

}
