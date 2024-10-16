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

@WebServlet ("/delbook")
public class DelBook_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req, resp);
	}

	protected void reqProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		
	  int id = Integer.parseInt(req.getParameter("id"));
		
	     
	  
		try(BookDao dao = new BookDao()){
			
		int count = dao.deletebyId(id);
		
		if(count == 1) {
			
			String mess = "Delete Sucessfully";
			
			req.setAttribute("msg", mess);
			RequestDispatcher rd = req.getRequestDispatcher("booklist");
			rd.forward(req, resp);
		}
		else {
			String mess = "Delete Failed";
			req.setAttribute("msg", mess);
			RequestDispatcher rd = req.getRequestDispatcher("booklist");
			rd.forward(req, resp);
		}
			 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
