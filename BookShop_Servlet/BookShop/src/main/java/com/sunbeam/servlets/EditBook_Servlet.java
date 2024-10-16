package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.Daos.BookDao;
import com.sunbeam.entities.Book;

@WebServlet ("/editbook")
public class EditBook_Servlet extends HttpServlet{
     
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id =Integer.parseInt(req.getParameter("id"));
		
		try(BookDao dao = new BookDao()){
			Book bk = dao.findbyId(id);
			
			out.printf("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>New Book</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<h3>New Book</h3>\r\n"
					+ "	<form method=\"post\" action=\"editbook\">\r\n"
					+ "		Id: <input type=\"text\" name=\"id\" value=\"%d\"  /> <br/><br/>\r\n"
					+ "		Name: <input type=\"text\" name=\"name\" value=\"%s\"/> <br/><br/>\r\n"
					+ "		Author: <input type=\"text\" name=\"author\" value=\"%s\" /> <br/><br/>\r\n"
					+ "		Subject: <input type=\"text\" name=\"subject\" value=\"%s\" /> <br/><br/>\r\n"
					+ "		Price: <input type=\"text\" name=\"price\" value=\"%.2f\")/> <br/><br/>\r\n"
					
					+ "		<input type=\"submit\" value=\"Edit Book\"/>\r\n"
					+ "		<a href='booklist'>Go Back</a>"
					
					+ "	</form>\r\n"
					+ "</body>\r\n"
					+ "</html>", bk.getId(),bk.getName(), bk.getAuthor(), bk.getSubject(), bk.getPrice());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String subject = req.getParameter("subject");
		double price = Double.parseDouble(req.getParameter("price"));

		try (BookDao b1 = new BookDao()) {

			Book bk = new Book(id, name, author, subject, price);
			int count = b1.update(bk);

			if (count == 1) {
				
				String msg = "Updated Sucessfully";
				req.setAttribute("msg", msg);
				
				RequestDispatcher rd = req.getRequestDispatcher("booklist");
				rd.forward(req, resp);
			} 
			else {
				String msg = "Added Sucessfully";
				req.setAttribute("msg", msg);
			}
		 } 
	    	catch (Exception e) {
			e.printStackTrace();
		}

	}
	}

