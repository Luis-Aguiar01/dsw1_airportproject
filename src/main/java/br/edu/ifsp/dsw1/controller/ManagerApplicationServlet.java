package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.*;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/application.do")
public class ManagerApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FlightDataCollection flightRepository;
	private static ControlTotens totemCommands;
	
	@Override
	public void init() throws ServletException {
		flightRepository = new FlightDataCollection();
		totemCommands = new ControlTotens(flightRepository);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		var action = request.getParameter("action");
		Command command;
		
		if ("login".equals(action)) {
			command = new LoginCommand();
		} else if ("logout".equals(action)) {
			command = new LogoutCommand();
		} else if ("login-page".equals(action)) {
			command = new LoginPageCommand();
		} else if ("admin-page".equals(action)) {
			command = new AdminPageCommand(flightRepository);
		} else if ("flight-register-page".equals(action)) {
			command = new FlightRegisterPageCommand();
		} else if ("flight-register-data".equals(action)) {
			command = new FlightRegisterDataCommand(flightRepository);
		} else if ("update".equals(action)) {
			command = new UpdateFlightCommand(flightRepository);
		} else if ("arriving-page".equals(action)) {
			command = totemCommands.getCommands().get(0);
		} else if ("boarding-page".equals(action)) {
			command = totemCommands.getCommands().get(1);
		} else if ("taking-off-page".equals(action)) {
			command = totemCommands.getCommands().get(2);
		} else if ("took-off-page".equals(action)) {
			command = totemCommands.getCommands().get(3);
		} else {
			command = new ErrorCommand();
		}
		
		var view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
