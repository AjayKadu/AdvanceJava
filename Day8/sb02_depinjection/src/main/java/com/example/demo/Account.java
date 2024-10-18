package com.example.demo;

public interface Account {

	void setId(int id);
	void setType(String type);
	void setBalance(double balance);
	void setAccHolder(Person accHolder);
	int getId();
	String getType();
	double getBalance();
	Person getAccHolder();

}
