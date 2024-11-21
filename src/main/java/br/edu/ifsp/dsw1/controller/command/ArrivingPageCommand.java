package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.ArrivingTotem;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.Totem;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 	Como o banco de dados não é um singleton, eu tive que passar a instância
 	dele para as minhas classes commands relacionadas aos totens. Dessa forma,
 	eu consigo inicializar o meu repositório de totens e já cadastrá-lo como 
 	um observer do banco. A operação simplesmente retorna os dados do tipo do
 	totem como um parâmetro da request e a sua página. Fiz o mesmo para os outros
 	commands relacionados ao totens, como o BoardingPageCommand, o TakingOffPageCommand
 	e o TookOffPageCommand.
*/

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
