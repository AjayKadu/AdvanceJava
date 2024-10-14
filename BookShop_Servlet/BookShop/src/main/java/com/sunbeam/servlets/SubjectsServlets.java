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

@WebServlet ("/subjects")
public class SubjectsServlets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		
		try(BookDao b1 = new BookDao()){
		
		   List<String> list = b1.findAllSubject();
		   out.println("<html>");
		   out.println("<head>");
		   out.println("<title>All Subjects</title>");
		   out.println("</head>");
		   out.println("<body>");
		   
		   for (String subject : list) {
               out.printf("<input type='radio' name='subject' value='%s'> %s<br>", subject,subject);
           }
		   
		   out.println("</body>");
		   out.println("</html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
