package com.sunbeam.bean;

import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Customer;

public class LoginJsp {

	private String uname;
	private String passwd;
	private Customer cust;

	public LoginJsp() {

	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public void compare() {

		try (CustomerDao dao = new CustomerDao()) {

			Customer dbcust = dao.findByEmail(uname);
			if(dbcust != null && this.passwd.equals(dbcust.getPassword())) {
				this.cust = dbcust;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
