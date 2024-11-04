package com.sunbeam.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {



	User findByEmail(String uname);





}
