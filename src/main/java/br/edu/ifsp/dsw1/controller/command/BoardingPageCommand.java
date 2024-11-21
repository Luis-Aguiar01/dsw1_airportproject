package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.BoardingTotem;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.Totem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Comentário feito na classe ArrivingPageCommand.

public final class BoardingPageCommand implements Command {

	private final FlightDataCollection flightRepository;
	private final Totem boardingRepository;
	
	public BoardingPageCommand(FlightDataCollection flightRepository) {
		this.flightRepository = flightRepository;
		this.boardingRepository = BoardingTotem.getInstance();
		flightRepository.register(boardingRepository);
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("boarding-totens", boardingRepository.getAllTotens());
		return "boarding-page.jsp";
	}
}
