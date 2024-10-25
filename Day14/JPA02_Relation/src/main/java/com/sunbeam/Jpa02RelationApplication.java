package com.sunbeam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Jpa02RelationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Jpa02RelationApplication.class, args);
	}

	@Autowired
	private EmpDao dao;

	@Transactional
	@Override
	public void run(String... args) throws Exception {

//		List<Employee> list = dao.findAll();
//		list.forEach(e->System.out.println(e));

		//Dept d = new Dept();
		//d.setDeptid(40);
//
//		Employee emp = new Employee(7891, "David", "Manager", 789, 3000.0, 200.00, null, null, null);
//		Employee eo = dao.save(emp);
//		System.out.println(eo);
		
//		int id =7891;
//		Optional<Employee> eo = dao.findById(id);
//		Employee emp = eo.orElse(null);
//		System.out.println(emp);
//		System.out.println(emp.getEname());
//		System.out.println(emp.getSal());
//		System.out.println(emp.getHire());
	}
}
