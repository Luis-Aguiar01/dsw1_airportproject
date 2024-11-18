package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/application.do")
public class ManagerApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		var action = request.getParameter("action");
		var view = "";
		
		if ("login".equals(action)) {
			view = handleLogin(request, response);
		} else if ("logout".equals(action)) {
			view = handleLogout(request, response);
		} else if ("login-page".equals(action)) {
			view = handleLoginPage(request, response);
		}
		
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String handleLoginPage(HttpServletRequest request, HttpServletResponse response) {
		return "login.jsp";
	}
	
	private String handleLogin(HttpServletRequest request, HttpServletResponse response) {
		var username = request.getParameter("username");
		var password = request.getParameter("password");
		
		if (validateAdminCredentials(username, password)) {
			var session = request.getSession();
			session.setAttribute("logged", true);
			return "manager.jsp";
		} else {
			request.setAttribute("error", true);
			return "login.jsp";
		}		
	}
	
	private boolean validateAdminCredentials(String username, String password) {
		return username.equals("admin") && password.equals("admin");
	}
	
	private String handleLogout(HttpServletRequest request, HttpServletResponse response) {
		var session = request.getSession(false);
		session.invalidate();
		return "index.jsp";
	}
}
