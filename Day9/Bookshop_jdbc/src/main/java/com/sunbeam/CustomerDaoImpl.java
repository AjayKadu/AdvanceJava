package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustMapper custMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Customer findByEmail(String email) {

		String sql = "Select * from customers where email=?";
		List<Customer> list = jdbcTemplate.query(sql, custMapper, email);
		return list == null ? null : list.get(0);
	}
	
	public int save(Customer c) {
		
		String sql = "Insert into customers (name,password,mobile,address,email,birth) values(?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, c.getName(), c.getPassword(), c.getMobile(), c.getAddress(), c.getEmail(),c.getBirth());
		return count;
	}
	
	
}
