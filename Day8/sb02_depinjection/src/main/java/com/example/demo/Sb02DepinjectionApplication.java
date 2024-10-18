package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan ("com.sunbeam")
@ImportResource ({"classpath:beans.xml"})
@SpringBootApplication
public class Sb02DepinjectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb02DepinjectionApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		Person p = (Person) ctx.getBean("p1");
		System.out.println("p1" + p);
		
		Account a1 = (Account) ctx.getBean("a1");
		System.out.println("a1" + a1);
		
		Account a2 = (Account) ctx.getBean("a2");
		System.out.println("a2" + a2);
		
		Person p2 = (Person) ctx.getBean("p2");
		System.out.println("p1" + p2);
		
		Account a3 = (Account) ctx.getBean("a3");
		System.out.println("a1" + a3);
		
		Account a4 = (Account) ctx.getBean("a4");
		System.out.println("a2" + a4);
		
		Account a5 = (Account) ctx.getBean("a5");
		System.out.println("a5" + a5);
	}

}
