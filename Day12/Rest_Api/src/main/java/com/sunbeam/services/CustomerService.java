package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Customer;
import com.sunbeam.model.Credential;

public interface CustomerService {

	Customer authenticate(Credential cr);

	int addCustomer(Customer cust);

	List<Customer> AllUsers();

	Customer custByEmail(String email);

	Customer custById(int id);

	int removeById(int id);

	int updateTheCustomer(int id, Customer cust);

	int saveNewCustomer(Customer cr);
}
