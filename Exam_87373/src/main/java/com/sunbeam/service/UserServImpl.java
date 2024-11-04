package com.sunbeam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entity.Cred;
import com.sunbeam.entity.Dir;
import com.sunbeam.entity.User;

@Service
public class UserServImpl implements UserServ {

	@Autowired
	private UserDao uDao;

	@Override
	public User authenticate(Cred cr) {

		User user = uDao.findByEmail(cr.getUname());
		if (user != null && user.getPassword().equals(cr.getPassword()))
			return user;
		return null;

	}

	@Override
	public List<User> getAll() {
		List<User> list = uDao.findAll();
		return list;
	}

	@Override
	public User addDir(Dir dir) {
		User d = new User(0, dir.getName(), dir.getEmail(), dir.getDate(), dir.getPassword(), null);

		User user = uDao.save(d);
		return user;
	}

	@Override
	public void deletedU(int id) {
	
		uDao.deleteById(id);
	}


	
}
