package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.entities.Customer;
import com.sunbeam.model.Credential;
import com.sunbeam.services.CustomerService;

@Controller
public class LoginController {
     
	@Autowired
	private CustomerService custService;
	
	@RequestMapping("/login")
	
	public String authentication(Credential cr) {
		   
	Customer cust = custService.authenticate(cr);
	if(cust == null) {
		return "failed";
	}
	return "welcome";
		
	}
	
}
