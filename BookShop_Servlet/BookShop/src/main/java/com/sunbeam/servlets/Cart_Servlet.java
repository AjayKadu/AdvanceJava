package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/cart")
public class Cart_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req, resp);
	}

	protected void reqProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h1>Cart Items</h1>");
		
	 	String[] bookid = req.getParameterValues("book");
	 	
	 	
	 	HttpSession session = req.getSession();
	 	
		List<Integer>cart = (List<Integer>) session.getAttribute("cart");
	 	
	 	for (String st : bookid) {
			int id = Integer.parseInt(st);
		     cart.add(id);	
		}
		
		resp.sendRedirect("subjects");
	}

}
