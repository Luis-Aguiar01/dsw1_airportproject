package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
	Atualiza o status de um voo e envia a lista de voos para a página do admin.
*/

public class UpdateFlightCommand implements Command {
	
	private FlightDataCollection repository;
	
	public UpdateFlightCommand(FlightDataCollection repository) {
		this.repository = repository;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			var flightNumber = Long.parseLong(request.getParameter("flight_number"));
			repository.updateFlight(flightNumber);
			request.setAttribute("flights", repository.getAllFligthts());
		} catch (NumberFormatException e) {
			return "manager.jsp";
		}
		
		return "manager.jsp";
	}
}
