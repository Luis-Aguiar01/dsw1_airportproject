package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.TookOffTotem;
import br.edu.ifsp.dsw1.model.entity.Totem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Comentário na classe ArrivingPageCommand.

public final class TookOffPageCommand implements Command {
	
	private final FlightDataCollection flightRepository;
	private final Totem tookOffRepository;
	
	public TookOffPageCommand(FlightDataCollection flightRepository) {
		this.flightRepository = flightRepository;
		this.tookOffRepository = TookOffTotem.getInstance();
		flightRepository.register(tookOffRepository);
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("took-off-totens", tookOffRepository.getAllTotens());
		return "took-off-page.jsp";
	}	
}
