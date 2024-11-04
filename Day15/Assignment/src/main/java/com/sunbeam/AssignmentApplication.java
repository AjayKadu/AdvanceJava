package com.sunbeam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.daos.CatDao;
import com.sunbeam.daos.ProDao;
import com.sunbeam.entities.Products;

@SpringBootApplication
public class AssignmentApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
 
//	@Autowired
//	private ProDao Dao;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		Optional<Products> oe = Dao.findById(1);
//		if(oe.isPresent()) {
//		Products p = oe.get();
//		System.out.println(p);
//		}
//	}
//	
}
