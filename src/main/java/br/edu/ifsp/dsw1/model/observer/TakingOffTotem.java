package br.edu.ifsp.dsw1.model.observer;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;

public final class TakingOffTotem extends Totem {

	private static Totem instance;
	
	private TakingOffTotem() {
		super();
	}

	@Override
	public void update(FlightData flight) {
		if (flight.getState() instanceof TakingOff) {
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
			instance = new TakingOffTotem();
		}
		return instance;
	}
}
