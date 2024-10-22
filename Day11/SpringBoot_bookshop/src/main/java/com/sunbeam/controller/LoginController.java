package com.sunbeam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	List<Book> cart = new ArrayList<>();
	session.setAttribute("cart", cart);
	return "redirect:subjects";
		
	}
	
}
