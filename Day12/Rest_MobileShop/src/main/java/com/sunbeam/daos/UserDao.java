/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 21, 2024
 */

package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.User;

public interface UserDao {
	User findByEmail(String email);
	int save(User c);
	User findById(int id);
	List<User> findAll();
	int update(User c);
}
