package com.sunbeam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	

	List<Employee> findByJob(String string);


	List<Employee> findByEnameContaining(String string);


	List<Employee> findByDeptnoAndSalBetween(int i, double d, double e);


	List<Employee> findBySalBetween(double d, double e);


	List<Employee> findByJobOrderBySalDesc(String string);

}
