package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunbeam.entities.Customer;



public class CustomerDao implements AutoCloseable {

	private Connection con;

	public CustomerDao() throws SQLException {
		con = Dbutil.getConnection();
	}

	@Override
	public void close() throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public int addCustomer(Customer c) throws SQLException {

		String sql = "Insert into customers(id,name,password,mobile,address,email,birth) values(?,?,?,?,?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3, c.getPassword());
			stmt.setString(4, c.getMobile());
			stmt.setString(5, c.getAddress());
			stmt.setString(6, c.getEmail());
			stmt.setDate(7, c.getBirth());
			int count = stmt.executeUpdate();
			return count;
		}
	}

	public Customer findByEmail(String email) throws SQLException {

		String sql = "Select * from Customers where email = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, email);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					int id = rs.getInt("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					String email2 = rs.getString("email");
					Date birth = rs.getDate("birth");

					Customer c1 = new Customer(id, name, password, mobile, address, email, birth);
					return c1;
				}
			}

		}

		return null;
	}
}
