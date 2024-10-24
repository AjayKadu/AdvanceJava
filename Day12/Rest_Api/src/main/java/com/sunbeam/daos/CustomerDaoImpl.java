package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Customer;

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

	@Override
	public List<Customer> findallUsers() {
	   
		String sql="select * from customers";
		List<Customer>list=jdbcTemplate.query(sql, custMapper);
		return list;
	}

	@Override
	public Customer findById(int id) {
		String sql = "select * from customers where id=?";
		List<Customer> list = jdbcTemplate.query(sql,custMapper, id);
		return list == null ? null : list.get(0);
		
	}
	
	@Override
	public int deleteById(int id) {
		String sql = "delete from customers where id=?";
		int count = jdbcTemplate.update(sql, id);
		return count;
	}
	
	@Override
	public int updateById(int id, Customer cust) {
		String sql="update customers set name=?,email=?,mobile=?,address=?,password=?,birth=? where id=?";
		int count = jdbcTemplate.update(sql,cust.getName(),cust.getEmail(),cust.getMobile(),cust.getAddress(),cust.getPassword(),cust.getBirth(), cust.getId());
		return count;
	}
	
	
}
