package com.sunbeam.services;

import com.sunbeam.entities.Customer;
import com.sunbeam.model.Credential;

public interface CustomerService {

	Customer authenticate(Credential cr);
}
