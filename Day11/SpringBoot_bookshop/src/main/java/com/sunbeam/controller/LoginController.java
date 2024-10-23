package com.sunbeam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;
import com.sunbeam.model.Credential;
import com.sunbeam.services.CustomerService;

@Controller
public class LoginController {
     
	@Autowired
	private CustomerService custService;
	
	@RequestMapping("/login")
	public String authentication(Credential cr, HttpSession session) {
	Customer cust = custService.authenticate(cr);
	
	if(cust == null) {
		return "failed";
	}
	
	if(cust.getName().equalsIgnoreCase("admin"))
		return "redirect:booklist";
				
	List<Book> cart = new ArrayList<>();
	session.setAttribute("cart", cart);
	return "redirect:subjects";
		
	}
	
	@RequestMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	@RequestMapping("/index")
	public String showLogin() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String newUser() { 
		return "signup";
	}
	
	@PostMapping("/signup")
	public String newUser(Customer cust) {
		System.out.println(cust);
		int count = custService.addCustomer(cust);
		return "signup";
		
	}
	
	
	
}
