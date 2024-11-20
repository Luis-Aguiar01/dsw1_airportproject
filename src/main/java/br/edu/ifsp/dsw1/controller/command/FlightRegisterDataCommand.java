package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FlightRegisterDataCommand implements Command {
	
	private FlightDataCollection repository;
	
	public FlightRegisterDataCommand(FlightDataCollection repository) {
		this.repository = repository;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var flightNumber = Long.parseLong(request.getParameter("flight_number"));
		var companyName = request.getParameter("company_name");
		var arrivingTime = request.getParameter("arriving_time");
		
		if (!isFlightNumberAvailable(flightNumber)) {
			request.setAttribute("unavailable-number", true);
		} 
		else if (!isArrivingTimeValid(arrivingTime)) {
			request.setAttribute("invalid-date", true);
		} 
		else {
			var formatedDate = LocalDateTime.parse(arrivingTime)
					.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			var flight = new FlightData(flightNumber, companyName, formatedDate);
			flight.setState(Arriving.getIntance());

			repository.insertFlight(flight);
			request.setAttribute("sucessful", true);
		}
		
		return "flight_register.jsp";
	}
	
	private boolean isFlightNumberAvailable(long flightNumber) {
		return repository.getAllFligthts().stream()
				.noneMatch(f -> f.getFlightNumber().equals(flightNumber));
	}
	
	private boolean isArrivingTimeValid(String arrivingTime) {
		var arrivingDateTime = LocalDateTime.parse(arrivingTime);
		return arrivingDateTime.isAfter(LocalDateTime.now());
	}
}
