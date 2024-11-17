package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		var username = request.getParameter("username");
		var password = request.getParameter("password");
		
		if (username.equals("admin") && password.equals("admin")) {
			var session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("manager.jsp");
		} else {
			
		}		
	}
}
