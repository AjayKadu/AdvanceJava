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

@WebServlet("/showcart")
public class ShowCart_Servlet extends HttpServlet {

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

		Cookie[] c = req.getCookies();

		String userName = "";
		if (c != null) {
			for (Cookie cook : c) {
				if (cook.getName().equals("uname")) {

					userName = cook.getValue();
					break;
				}

			}

			HttpSession session = req.getSession();
			Customer cust = (Customer) session.getAttribute("User");

			out.println("<html>");
			out.println("<body>");

			out.printf("Hello, %s - %s - %s<hr/>\n", userName, cust.getEmail(), cust.getMobile());
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<tr>");
			out.printf("<th>Id</th>");
			out.printf("<th>Name</th>");
			out.printf("<th>Author</th>");
			out.printf("<th>Subject</th>");
			out.printf("<th>Price</th>");
			out.println("</tr>");
			out.println("</thead>");

			List<Integer> cart = (List<Integer>) session.getAttribute("cart");

			try (BookDao bookDao = new BookDao()) {
				for (Integer id : cart) {
					Book b = bookDao.findbyId(id);
					
					out.println("<tr>");
					out.printf("<td>%d</td>", id);
					out.printf("<td>%s</td>", b.getName());
					out.printf("<td>%s</td>", b.getAuthor());
					out.printf("<td>%s</td>", b.getSubject());
					out.printf("<td>%f</td>", b.getPrice());
					out.println("</tr>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			out.println("</table>");
			out.println("<p><a href='logout'>Sign Out</a></p>\r\n");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
