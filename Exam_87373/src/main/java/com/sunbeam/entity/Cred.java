package com.sunbeam.entity;



public class Cred {
     
	private String uname;
	private String password;
	
	public Cred() {
		// TODO Auto-generated constructor stub
	}

	public Cred(String uname, String password) {
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Cred [uname=" + uname + ", password=" + password + "]";
	}
	
	
	
}
