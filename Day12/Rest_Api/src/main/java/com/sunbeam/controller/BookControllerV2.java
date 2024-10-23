package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Book;
import com.sunbeam.model.BookPrice;
import com.sunbeam.services.BookService;

@RequestMapping("/v2")
@RestController
public class BookControllerV2 {

	@Autowired
	private BookService bookService;

	@GetMapping("/book")
	public List<Book> showAllBooks() {
		List<Book> list = bookService.getAllBooks();
		return list;
	}

	@GetMapping("/book/{id}")

	public ResponseEntity<Book> findBookById(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		return ResponseEntity.created(null).body(book);
	}

	@PostMapping("/book")
	public ResponseEntity<Integer> saveBook(@RequestBody Book b) {

		int count = bookService.addToBooks(b);
		return ResponseEntity.ok(count);

	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
		try {
			int count = bookService.deleteBook(id);
			return ResponseEntity.created(null).body("Deleted Successfully"+count);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Book Deleted Failed");
		}

	}

	@PutMapping("/book/{id}")
	public int updateBook(@PathVariable("id") int id, @RequestBody Book bk) {
		bk.setId(id);
		int count = bookService.updateTheBook(bk);
		return count;
	}

	@PatchMapping("/book/{id}/updateprice")
	public int changePrice(@PathVariable("id") int id, @RequestBody BookPrice bp) {
		int count = bookService.changePrice(id, bp.getPrice());
		return count;

	}
}
