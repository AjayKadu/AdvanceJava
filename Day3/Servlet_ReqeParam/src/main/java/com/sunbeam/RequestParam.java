package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/addbook")
public class RequestParam extends HttpServlet {

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
          
          out.println("<h1>Adding a Book</h1>");
          
          try(BookDao b1 = new BookDao()){
        	  
        	 String name = req.getParameter("name");
        	 String author = req.getParameter("author");
        	 String subject = req.getParameter("subject");
        	 double price = Double.parseDouble(req.getParameter("price"));
        	 
        	 Book b = new Book(0,name,author,subject,price);
        	  int count = b1.save(b);
        	  
        	  if(count == 1) {
        		  out.println("<h1>Record Added succesfully</h1>");
        	  }
        	  else {
        		  out.println("<h1>Something Wrong</h1>");
        	  }
          }
          catch(Exception e) {
        	  e.printStackTrace();
          }
          
	}
	
}
