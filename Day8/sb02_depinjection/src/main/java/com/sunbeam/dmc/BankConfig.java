package com.sunbeam.dmc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Account;
import com.example.demo.AccountImpl;
import com.example.demo.Person;
import com.example.demo.PersonImpl;

@Configuration
public class BankConfig {
      
	@Bean
	public Person p2() {
		
		Person p = new PersonImpl();
		p.setId(404);
		p.setName("Rohit");
		p.setAge(39);
		return p;
	}
	
	@Bean
	public Account a3() {
		
		Account a3 = new AccountImpl();
		a3.setId(1111);
		a3.setType("Saving");
		a3.setBalance(30000.00);
		a3.setAccHolder(p2());
		return a3;
	}
	
	@Bean
	public Account a4() {
		Account a4 = new AccountImpl(2222,"Current",700000.00,p2());
		return a4;
	}
	
	@Bean
	public Account a5(@Qualifier("p1")Person p) {
		Account a = new AccountImpl(3333,"Fixed Deposite", 900000.00, p);
		return a;
	}
	
}
