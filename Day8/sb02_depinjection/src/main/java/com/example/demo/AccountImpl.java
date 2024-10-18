package com.example.demo;

public class AccountImpl implements Account {

	private int id;
	private String Type;
	private double balance;
	private Person accHolder;
	
	public AccountImpl() {
		
	}


	public Person getAccHolder() {
		return accHolder;
	}


	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}


	public AccountImpl(int id, String type, double balance, Person accHolder) {
		this.id = id;
		Type = type;
		this.balance = balance;
		this.accHolder = accHolder;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", Type=" + Type + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	}


	public double deposite(double amount) {
		return this.balance + amount;
	}
	
	public double withdraw(double amount) {
		return this.balance - amount;
	}
	
	
}
