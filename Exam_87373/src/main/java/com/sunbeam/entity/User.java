package com.sunbeam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User_tb")
public class User {

	@Id
	private int u_id;
	private String username;
	private String email;
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date date;
	private String password;
	@Column(name = "role", columnDefinition = "VARCHAR(255) DEFAULT 'user'")
	private String role;


	public User() {

	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(int u_id, String username, String email, Date date, String password, String role) {
		this.u_id = u_id;
		this.username = username;
		this.email = email;
		this.date = date;
		this.password = password;
	    this.role = (role != null) ? role : "user";
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", username=" + username + ", email=" + email + ", date=" + date + ", password="
				+ password + ", role=" + role + "]";
	}

}
