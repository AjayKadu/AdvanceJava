package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookshopJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookshopJdbcApplication.class, args);
	}

	@Autowired
	private BookDaoImpl bookDao;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * List<Book> list = bookDao.findBySubject("c"); for (Book book : list) {
		 * System.out.println(book); }
		 */
		
		
		  List<Book> list = bookDao.findAllBook();
		  for (Book book : list) {
		  System.out.println(book); 
		  }
		 

		
		/*
		 * Book b = new Book(66, "Atomic Habit", "James Clear", "General",340.78); int
		 * count = bookDao.update(b); System.out.println(count);
		 */
		 

		/*
		 * Book bkk =bookDao.findById(65); System.out.println(bkk);
		 */

		/*
		 * int count =bookDao.deleteById(64); System.out.println(count);
		 */

		/*
		 * List<String> list = bookDao.findAllSubject(); for (String st : list) {
		 * System.out.println(st); }
		 */

	}

}
