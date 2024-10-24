package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.User;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> showAllUsers() {
	    List<User> list = userDao.findAll();
	    return list;
	}

}
