package com.sunbeam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Book;
import com.sunbeam.services.BookService;
import com.sunbeam.services.BookServiceImpl;

@Controller
public class BookshopController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping ("/subjects")
	public String showSubject(Model model) {
		
		List<String> list = bookService.getSubjects();
		model.addAttribute("subjectList", list);
		return "subjects";
	}
	
	@RequestMapping("/books")
	public String showBooks(@RequestParam("subject") String subject, Model model) {
		
	List<Book> list	= bookService.getBooks(subject);
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
	

	
}
