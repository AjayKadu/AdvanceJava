package com.sunbeam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Jpa02Relation2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Jpa02Relation2Application.class, args);
	}
  
	@Autowired
	private EmpDao eDao;
	
	@Autowired
	private MeetingDao mDao;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		Optional<Emp> oe = eDao.findById(7934);
		if(oe.isPresent()) {
			Emp emp = oe.get();
			System.out.println("Employee is: "+emp);
      for (Meeting ep : emp.getMeetList()) {
		System.out.println(ep);
	}		

		}
		else {
			System.out.println("Employee Not Found");
		}
		
		System.out.println("----------------------------------------------------------------");
		
		
		Optional<Meeting> om = mDao.findById(2);
		if(om.isPresent()) {
			Meeting m = om.get();
			System.out.println(m);
			for (Emp e : m.getEmpList())
				System.out.println(e);
		}
		else
			System.out.println("Meeting Not Found");
		
	}
}
