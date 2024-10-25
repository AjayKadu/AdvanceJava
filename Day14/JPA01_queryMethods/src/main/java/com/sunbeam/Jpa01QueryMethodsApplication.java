package com.sunbeam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class Jpa01QueryMethodsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Jpa01QueryMethodsApplication.class, args);
	}

	@Autowired
	private EmployeeDao dao;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * List<Employee> list = dao.findAll(); list.forEach(e ->
		 * System.out.println(e));
		 */

		/*
		 * int id = 7839; Optional<Employee> oe = dao.findById(id); Employee emp =
		 * oe.orElse(null); System.out.println(emp);
		 */

//		 Employee emp = new Employee(0, "Smith", "Manager", 1, 3000.00, 200.00, 20,
//		 null ,78988.0); Employee em = dao.save(emp); System.out.println(em);

//		int id = 789;
//		if (dao.existsById(id)) {
//			System.out.println("Result: "+dao.existsById(id));
//			dao.deleteById(id);
//			System.out.println("Deleted");
//		} else {
//			System.out.println("Not Found");
//		}

//	    List<Employee> list = dao.findByJob("Manager");
//	    list.forEach(e->System.out.println(e));

//		List<Employee> list = dao.findByEnameContaining("U");
//		list.forEach(e -> System.out.println(e));

//		List<Employee> list = dao.findByDeptnoAndSalBetween(20,1000.00, 3000.01);
//		list.forEach(e-> System.out.println(e));
		
//		List<Employee> list = dao.findBySalBetween(1500.00, 2500.0);
//		list.forEach(e->System.out.println(e));
		
//		List<Employee> list = dao.findByJobOrderBySalDesc("salesman");
//		list.forEach(e->System.out.println(e));
		
		List<Employee> list = dao.findAll(Sort.by("ename"));
		list.forEach(e->System.out.println(e));
	}

}
