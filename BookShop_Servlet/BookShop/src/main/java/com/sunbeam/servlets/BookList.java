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

@WebServlet("/booklist")
public class BookList extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>BookList</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>List all the Books</h1>");
		out.println("<table border='1'>");
		out.println("<thead>");

		out.printf("<th>Id</th>");
		out.printf("<th>Name</th>");
		out.printf("<th>Author</th>");
		out.printf("<th>Subject</th>");
		out.printf("<th>Price</th>");
		out.printf("<th>Action</th>");

		out.println("</thead>");
		
		
		try (BookDao bk = new BookDao()) {
			List<Book> list = bk.findAllBook();
			for (Book b : list) {
				out.println("<tr>");
				out.printf("<td>%d</td>", b.getId());
				out.printf("<td>%s</td>", b.getName());
				out.printf("<td>%s</td>", b.getAuthor());
				out.printf("<td>%s</td>", b.getSubject());
				out.printf("<td>%.2f</td>", b.getPrice());
				out.printf(
						"<td><a href='delbook?id=%d'><img src='images/delete.png' alt='Del' height='24' weigth='24'></a> &nbsp <a href='editbook?id=%d'><img src='images/edit.png' alt='Edit' height='24' weigth='24'></a></td>",
						b.getId(), b.getId());
				out.println("<tr>");
			}

			String mess = (String) req.getAttribute("msg");
			if (mess != null) {
				out.printf("<p>%s</p>", mess);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		out.println("</table>");
		
		out.printf(" <a href=\"addbook\">Add Book</a>");
		
		out.println("</body>");
		out.println("</html>");

	}

}
