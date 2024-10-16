package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/logout")
public class Logout_Servlet extends HttpServlet{
      
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
		 PrintWriter out =  resp.getWriter();
		 
		HttpSession session = req.getSession();
		session.invalidate();
		 
		 out.println("<h1>Thank You For Visiting :)</h1>");
		 out.println("<a href=\"login.html\">Want to login again</a>");
	}
}
