package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var username = request.getParameter("username");
		var password = request.getParameter("password");
		
		if (validateAdminCredentials(username, password)) {
			var session = request.getSession();
			session.setAttribute("authenticate", true);
			return "manager.jsp";
		} else {
			request.setAttribute("error", true);
			return "login.jsp";
		}		
	}
	
	private boolean validateAdminCredentials(String username, String password) {
		return username.equals("admin") && password.equals("admin");
	}
}
