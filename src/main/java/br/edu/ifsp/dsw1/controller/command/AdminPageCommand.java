package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminPageCommand implements Command {
	
	private FlightDataCollection repository;
	
	public AdminPageCommand(FlightDataCollection repository) {
		this.repository = repository;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("flights", repository.getAllFligthts());
		return "manager.jsp";
	}	
}
