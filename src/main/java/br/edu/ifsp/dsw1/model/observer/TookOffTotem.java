package br.edu.ifsp.dsw1.model.observer;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;

public final class TookOffTotem extends Totem {
	
	private static Totem instance;
	
	private TookOffTotem() {
		super();
	}

	@Override
	public void update(FlightData flight) {
		if (flight.getState() instanceof TookOff) {
			var totem = new TotemData(
					flight.getFlightNumber(), flight.getCompany(), flight.getTime());
			addTotem(totem);
		}
	}
	
	public static Totem getInstance() {
		if (instance == null) {
			instance = new TookOffTotem();
		}
		return instance;
	}
}