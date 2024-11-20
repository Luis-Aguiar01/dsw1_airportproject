//package br.edu.ifsp.dsw1.model.observer;
//
//import br.edu.ifsp.dsw1.model.entity.FlightData;
//import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
//
//public class TookOffTotem extends Totem {
//
//	public TookOffTotem(Long flightNumber, String company, String time) {
//		super(flightNumber, company, time);
//	}
//
//	@Override
//	public void update(FlightData flight) {
//		if (flight.getState() instanceof TakingOff) {
//			Totem totem = new ArrivingTotem(
//					flight.getFlightNumber(), flight.getCompany(), flight.getTime());
//			addTotem(totem);
//		}
//	}
//}
