package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Customer;

public interface CustomerDao {

	Customer findByEmail(String email);
	int save(Customer c);
	List<Customer> findallUsers();
	Customer findById(int id);
	int deleteById(int id);
	int updateById(int id, Customer cust);
}
