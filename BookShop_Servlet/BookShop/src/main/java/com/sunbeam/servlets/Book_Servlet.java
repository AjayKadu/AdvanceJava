package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.Daos.BookDao;
import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;

@WebServlet("/books")
public class Book_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProcess(req, resp);
	}

	protected void requestProcess(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String subject = req.getParameter("subject");

		try (BookDao dao = new BookDao()) {

			List<Book> list = dao.findbySubject(subject);
			
			 Cookie[] c = req.getCookies();
			 
			 String userName = "";
			 if(c != null) {
				 for (Cookie cook : c) {
						if(cook.getName().equals("uname")) {
						   
							userName = cook.getValue();
							break;
						}
					 
					}
			 }
			 
			HttpSession session = req.getSession();
			Customer cust = (Customer) session.getAttribute("User");
			 
			 out.printf("Hello, %s  %s %s<hr/>\n", userName, cust.getEmail(), cust.getMobile());
			out.println("<form method='post' action='cart'>");
			for (Book bk : list) {
				
				out.printf("<input type='checkbox' name='book' value='%d'>%s - %s" , bk.getId(),  bk.getName(), bk.getAuthor());
				out.println("<br>");
			}
			
			out.println("<input type='submit' value='Add Cart'>");
			
			out.println("</form>");
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
