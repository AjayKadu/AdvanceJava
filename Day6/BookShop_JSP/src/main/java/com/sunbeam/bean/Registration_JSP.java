package com.sunbeam.bean;

import java.sql.Date;

import com.sunbeam.daos.BookDao;
import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Customer;

public class Registration_JSP {
	
	public Registration_JSP() {

	}

	private String id;
	private String name;
	private String password;
	private String mobile;
	private String address;
	private String email;
	private String birth;

	@Override
	public String toString() {
		return "Registration_JSP [id=" + id + ", name=" + name + ", password=" + password + ", mobile=" + mobile
				+ ", address=" + address + ", email=" + email + ", birth=" + birth + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Registration_JSP(String id, String name, String password, String mobile, String address, String email,
			String birth) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.birth = birth;
	}

	public String registration() {

		try (CustomerDao dao = new CustomerDao()) {
			int id = Integer.parseInt(this.getId());
			String name = this.getName();
			String pass = this.getPassword();
			String mobile = this.getMobile();
			String address = this.getAddress();
			String email = this.getEmail();
			Date birth1 = Date.valueOf(this.getBirth());

			Customer c1 = new Customer(id, name, pass, mobile, address, email, birth1);

			int count = dao.addCustomer(c1);
			
			if(count ==1) {
				return "Registration Successful";
			}
			else {
				return "Registration Failed";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	     return "An error occurred during registration.";
	}

}
