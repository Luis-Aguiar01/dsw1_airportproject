package br.edu.ifsp.dsw1.model.observer;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;

public class ArrivingTotem extends Totem {
	
	public ArrivingTotem(Long flightNumber, String company, String time) {
		super(flightNumber, company, time);
	}
	
	@Override
	public void update(FlightData flight) {
		if (flight.getState() instanceof Arriving) {
			Totem totem = new ArrivingTotem(
					flight.getFlightNumber(), flight.getCompany(), flight.getTime());
			addTotem(totem);
		}
		else {
			Totem totem = findTotemByFlightNumber(flight.getFlightNumber());
			if (totem != null) {
				getAllTotens().remove(totem);
			}
		}
	}
}
