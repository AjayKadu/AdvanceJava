package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/bookList")
public class BookList extends HttpServlet {
	
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
	  
	  out.println("</thead>");
	  
	  try(BookDao bk = new BookDao()){
		  List<Book> list = bk.allBook(); 
		  for (Book b : list) {
			  out.println("<tr>");
			  out.printf("<td>%d</td>", b.getId());
			  out.printf("<td>%s</td>", b.getName());
			  out.printf("<td>%s</td>", b.getAuthor());
			  out.printf("<td>%s</td>", b.getSubject());
			  out.printf("<td>%.2f</td>", b.getPrice());
			  out.println("<tr>");
		}
	  }
	  catch (Exception e) {
		  e.printStackTrace();
	  }
	  
	  
	  out.println("</table>");
	  out.println("</body>");
	  out.println("</html>");
	  
	  
	}
   
	
}
