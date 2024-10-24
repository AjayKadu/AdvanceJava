package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Customer;
import com.sunbeam.model.Credential;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao custDao;

	public Customer authenticate(Credential cr) {

		Customer dbCust = custDao.findByEmail(cr.getEmail());
		if (dbCust != null && dbCust.getPassword().equals(cr.getPassword()))
			return dbCust;
		return null;
	}

	@Override
	public int addCustomer(Customer cust) {
		
		int count = custDao.save(cust);
		return count;
	}

	@Override
	public List<Customer> AllUsers() {
		List<Customer> list = custDao.findallUsers();
		return list;
	}

	@Override
	public Customer custByEmail(String email) {
		Customer cust = custDao.findByEmail(email);
		return cust;
		
	}

	@Override
	public Customer custById(int id) {
	Customer cust =	custDao.findById(id);
	return cust;
	}
	
	@Override
	public int removeById(int id) {
		int count = custDao.deleteById(id);
		return count;
	}

	@Override
	public int updateTheCustomer(int id,Customer cust) {
	 int count = custDao.updateById(id, cust);
	 return count;
	}

	@Override
	public int saveNewCustomer(Customer cr) {
		int count = custDao.save(cr);
		return count;
	}
	
}
