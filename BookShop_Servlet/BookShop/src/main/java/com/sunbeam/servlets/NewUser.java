package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.Daos.CustomerDao;
import com.sunbeam.entities.Customer;

@WebServlet("/newuser")
public class NewUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req,resp);
	}
	
	
protected void reqProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    resp.setContentType("text/html");
	    PrintWriter out=resp.getWriter();
	   
	   try(CustomerDao c1 = new CustomerDao()){
		   
		  String name = req.getParameter("name");
		  String password = req.getParameter("password");
		  String mobile = req.getParameter("mobile");
		  String address = req.getParameter("address");
		  String email = req.getParameter("email");
		  String birth = req.getParameter("birth");
		  Date birth1 = Date.valueOf(birth);
		  
		  Customer c = new Customer(0,name,password,mobile,address,email,birth1);
		
		   int count=c1.addCustomer(c);
		   
		   if(count == 1) {
			   out.println("Added Successfuly");
		   }
		   else {
			   out.println("Something Wrong");
		   }
		   
	   }
	   catch (Exception e) {
		   e.printStackTrace();
	   }
	
	}

}
