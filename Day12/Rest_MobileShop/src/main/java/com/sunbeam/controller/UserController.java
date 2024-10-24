package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.model.Result;
import com.sunbeam.pojos.User;
import com.sunbeam.services.UserServices;

@RestController
public class UserController {

	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/users")
	public Result getAllUsers() {
		List<User> list = userServices.showAllUsers();
		return Result.success(list);
}
}
