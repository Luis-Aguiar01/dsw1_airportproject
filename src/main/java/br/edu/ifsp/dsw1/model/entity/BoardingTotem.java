package br.edu.ifsp.dsw1.model.entity;

import br.edu.ifsp.dsw1.model.flightstates.Boarding;

public final class BoardingTotem extends Totem {
	
	private static Totem instance;
	
	private BoardingTotem() {
		super();
	}
	
	@Override
	public void update(FlightData flight) {
		if (flight.getState() instanceof Boarding) {
			var totem = new TotemData(
					flight.getFlightNumber(), flight.getCompany(), flight.getTime());
			addTotem(totem);
		}
		else {
			var totem = findTotemByFlightNumber(flight.getFlightNumber());
			if (totem != null) {
				removeTotem(totem);
			}
		}
	}
	
	public static Totem getInstance() {
		if (instance == null) {
			instance = new BoardingTotem();
		}
		return instance;
	}
}
