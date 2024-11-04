package com.sunbeam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunbeam.entity.Cred;
import com.sunbeam.entity.Dir;
import com.sunbeam.entity.User;

@Service
public interface UserServ {

	User authenticate(Cred cr);

	List<User> getAll();

	User addDir(Dir dir);

	void deletedU(int id);

}
