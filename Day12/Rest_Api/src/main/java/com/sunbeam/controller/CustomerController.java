package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Customer;
import com.sunbeam.model.CustResult;
import com.sunbeam.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService custServices;

	@GetMapping("/customer")
	public CustResult allCustomers() {
		List<Customer> list = custServices.AllUsers();
		return CustResult.success(list);
	}
	
	@GetMapping("/customer/byEmail/{email}")
	public CustResult getByEmail(@PathVariable("email") String email) {
		
		Customer cust = custServices.custByEmail(email);
		return CustResult.success(cust);
	}
	
	@GetMapping("/customer/byId/{id}")
	public CustResult getByEmail(@PathVariable("id") int id) {
		
		Customer cust = custServices.custById(id);
		return CustResult.success(cust);
	}
	
	@DeleteMapping("/customer/{id}")
	public CustResult removeCustomer(@PathVariable ("id") int id) {
		int count = custServices.removeById(id);
		return CustResult.success("Book Deleted");
	}
	
	@PutMapping("/customer/{id}")
	public CustResult updateCustomer(@PathVariable("id")int id, @RequestBody Customer cust) {
		
		cust.setId(id);
		int count = custServices.updateTheCustomer(id,cust);
		return CustResult.success("Customer Updated");
	}
	
	@PostMapping("/customer")
	public CustResult addNewUser(@RequestBody Customer cr) {
		int count = custServices.saveNewCustomer(cr);
		return CustResult.success("Customer Added");
	}
}
