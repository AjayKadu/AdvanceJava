package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.BookDaoImpl;
import com.sunbeam.entities.Book;
import com.sunbeam.model.BookPrice;

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

	@Override
	public List<Book> getAllBooks() {

		List<Book> list = bookDao.findAllBook();
		return list;
	}

	@Override
	public Book editThisBook(int id) {
	   
	Book book = bookDao.findById(id);
	return book;
	}

	@Override
	public int updateTheBook(Book b) {
		
	int count = bookDao.update(b);
	return count;
		
	}

	@Override
	public int deleteBook(int id) {
		int count = bookDao.deleteById(id);
		return count;
	}

	@Override
	public int addToBooks(Book b) {
		int count = bookDao.save(b);
		return count;
		
	}

	@Override
	public int changePrice(int id, double price) {
		int count = bookDao.changePrice(id, price);
		return count;
	}

}
