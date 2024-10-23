package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.sunbeam.model.Result;
import com.sunbeam.services.BookService;

@RequestMapping("/v4")
@RestController
public class BookControllerV4 {

	@Autowired
	private BookService bookService;

	@GetMapping("/book")
	public Result showAllBooks() {
		List<Book> list = bookService.getAllBooks();
		return Result.success(list);
	}

	@GetMapping("/book/{id}")
	public Result findBookById(@PathVariable("id") int id) {
			Book book = bookService.getBookById(id);
			return Result.success(book);
		}
	

	@PostMapping("/book")
	public Result saveBook(@RequestBody Book b) {
			int count = bookService.addToBooks(b);
			return Result.success("Book Added: " + count);
	}

	@DeleteMapping("/book/{id}")
	public Result deleteBook(@PathVariable("id") int id) {
			int count = bookService.deleteBook(id);
			return Result.success("Deleted Successfully" + count);
	}

	@PutMapping("/book/{id}")
	public Result updateBook(@PathVariable("id") int id, @RequestBody Book bk) {
			bk.setId(id);
			int count = bookService.updateTheBook(bk);
			return Result.success("Updated Successfully: " + count);
	}

	@PatchMapping("/book/{id}/updateprice")
	public Result changePrice(@PathVariable("id") int id, @RequestBody BookPrice bp) {
			int count = bookService.changePrice(id, bp.getPrice());
			return Result.success("Price is Changed");
	}
	
	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
		return Result.failed(e.getMessage());
	}
}
