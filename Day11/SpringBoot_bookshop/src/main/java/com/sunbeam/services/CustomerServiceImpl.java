package com.sunbeam.services;

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

}
