package br.edu.ifsp.dsw1.controller.command;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;

/*
	Criei essa classe para inicializar e armazenar os meus Commands relacionados
	aos totens. Como achei que ficaria muito poluído criar todas essas classes
	diretamente no Servlet, preferi criá-los dentro de uma classe separada.
*/

public final class ControlTotens {
	private final List<Command> commands;
	private final FlightDataCollection flightRepository;
	
	public ControlTotens(FlightDataCollection flightRepository) {
		this.commands = new ArrayList<>();
		this.flightRepository = flightRepository;
		
		setTotemCommands();
	}
	
	private void setTotemCommands() {
		commands.add(new ArrivingPageCommand(flightRepository));
		commands.add(new BoardingPageCommand(flightRepository));
		commands.add(new TakingOffPageCommand(flightRepository));
		commands.add(new TookOffPageCommand(flightRepository));
	}
	
	public List<Command> getCommands() {
		return commands;
	}
}
