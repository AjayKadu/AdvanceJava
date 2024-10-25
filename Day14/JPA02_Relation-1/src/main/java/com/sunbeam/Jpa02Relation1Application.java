package com.sunbeam;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Jpa02Relation1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Jpa02Relation1Application.class, args);
	}

	@Autowired
	private DeptDao dao;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
	
	Optional<Dept> dp = dao.findById(10);
		if(dp.isPresent()) {
			Dept dept = dp.get();
			System.out.println("Dept is: "+dept);
			for (Emp list : dept.getList()) {
				System.out.println(list);
			}
		}
		else {
			System.out.println("Dept Not Found");
		}
		
	}
}
