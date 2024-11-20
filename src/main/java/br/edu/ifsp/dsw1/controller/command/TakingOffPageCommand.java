package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.observer.TakingOffTotem;
import br.edu.ifsp.dsw1.model.observer.Totem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class TakingOffPageCommand implements Command {
	
	private final FlightDataCollection flightRepository;
	private final Totem takingOffRepository;
	
	public TakingOffPageCommand(FlightDataCollection flightRepository) {
		this.flightRepository = flightRepository;
		this.takingOffRepository = TakingOffTotem.getInstance();
		flightRepository.register(takingOffRepository);
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("taking-off-totens", takingOffRepository.getAllTotens());
		return "taking-off-page.jsp";
	}
}
