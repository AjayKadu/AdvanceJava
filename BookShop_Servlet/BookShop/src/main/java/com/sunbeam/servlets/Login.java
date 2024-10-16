package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.Daos.CustomerDao;
import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProcess(req, resp);
	}

	protected void requestProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try (CustomerDao c1 = new CustomerDao()) {

			Customer b = c1.findByEmail(email);
			if (b != null && password.equals(b.getPassword())) {
				System.out.println("Login Successfuly");
				out.println("<h1>Login successfully</h1>");

				Cookie c = new Cookie("uname", b.getName());
				resp.addCookie(c);

				HttpSession session = req.getSession();
				session.setAttribute("User", b);
				
				List<Integer> cart = new ArrayList<>();
			    
				session.setAttribute("cart", cart);

				resp.sendRedirect("subjects");

			} else {
				System.out.println("Login Fail");
				out.println("<h1>Login Failed</h1>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}
}
