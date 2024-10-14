package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.Daos.BookDao;
import com.sunbeam.entities.Book;

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
			for (Book bk : list) {
				
				out.printf("<input type='checkbox' name='book'>%s - %s" ,bk.getName(), bk.getAuthor());
				out.println("<br>");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
