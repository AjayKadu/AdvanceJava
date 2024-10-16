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
import com.sunbeam.entities.Customer;

@WebServlet("/subjects")
public class SubjectsServlets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		try (BookDao b1 = new BookDao()) {

			List<String> list = b1.findAllSubject();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>All Subjects</title>");
			out.println("</head>");
			out.println("<body>");

			Cookie[] c = req.getCookies();

			String userName = "";
			if (c != null) {
				for (Cookie cook : c) {
					if (cook.getName().equals("uname")) {

						userName = cook.getValue();
						break;
					}

				}
			}

			HttpSession session = req.getSession();
			Customer cust = (Customer) session.getAttribute("User");

			out.printf("Hello, %s  %s %s<hr/>\n", userName, cust.getEmail(), cust.getMobile());
			
			out.println("<form method='post' action='books'>");
			out.println("<h1>List of Subjects</h1>");
			for (String subject : list) {
				out.printf("<input type='radio' name='subject' value='%s'> %s<br>", subject, subject);
			}

			out.println("<input type='submit' value='Show Books'><br><br>");

			out.println("<a href='showcart'>Show Cart</a>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
