package com.sunbeam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Autowired
	private EmpDao eDao;
	
	@Autowired
	private AddressDao addDao;

	@Override
	public void run(String... args) throws Exception {
	    
      Optional<Address> oe = addDao.findById(7782);
		if(oe.isPresent()) {
			Address addr = oe.get();
			System.out.println(addr);
		}
	}
}
