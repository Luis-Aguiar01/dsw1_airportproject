package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.observer.ArrivingTotem;
import br.edu.ifsp.dsw1.model.observer.Totem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class ArrivingPageCommand implements Command {
	
	private final FlightDataCollection flightRepository;
	private final Totem arrivingRepository;
	
	public ArrivingPageCommand(FlightDataCollection flightRepository) {
		this.flightRepository = flightRepository;
		this.arrivingRepository = ArrivingTotem.getInstance();
		flightRepository.register(arrivingRepository);
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("arriving-totens", arrivingRepository.getAllTotens());
		return "arriving-page.jsp";
	}
}
