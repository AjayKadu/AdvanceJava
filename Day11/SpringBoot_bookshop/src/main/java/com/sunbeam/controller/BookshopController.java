package com.sunbeam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Book;
import com.sunbeam.services.BookService;
import com.sunbeam.services.BookServiceImpl;

@Controller
public class BookshopController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/subjects")
	public String showSubject(Model model) {

		List<String> list = bookService.getSubjects();
		model.addAttribute("subjectList", list);
		return "subjects";
	}

	@RequestMapping("/books")
	public String showBooks(@RequestParam("subject") String subject, Model model) {

		List<Book> list = bookService.getBooks(subject);
		model.addAttribute("bookList", list);
		return "books";
	}

	@RequestMapping("/addcart")
	public String addToCart(@RequestParam("book") String[] bookids, HttpSession session) {

		List<Book> cart = (List<Book>) session.getAttribute("cart");

		for (String bk : bookids) {
			int id = Integer.parseInt(bk);
			Book book = bookService.getBookById(id);
			cart.add(book);
		}

		return "redirect:subjects";
	}

	@RequestMapping("/cart")
	public String showCart() {
		return "cart";
	}

	@RequestMapping("/booklist")
	public String showAllBooks(Model model) {

		List<Book> list = bookService.getAllBooks();
		model.addAttribute("bookList", list);
		return "booklist";

	}
	
	@GetMapping("/editbook")
	public String editTheBook(@RequestParam ("id") int id, Model model) {
	   
	Book book=bookService.editThisBook(id);
	model.addAttribute("book", book);
	
	return "editbook";
		
	}
	
	@PostMapping("/editbook")
	public String updateBook(Book b) {
		int count = bookService.updateTheBook(b);
		return "redirect:booklist";
		
	}
	
	@RequestMapping("/delbook")
	public String delBook(@RequestParam("id")int id) {
		int count = bookService.deleteBook(id);
		return "redirect:booklist";
	}
       
	@GetMapping("/addbook")
	public String addNewBook() {
		return "addbook";
	}
	
	@PostMapping("/addbook")
	public String addNewBook(Book b) {
		int count = bookService.addToBooks(b);
		return "redirect:booklist";
	}
}
