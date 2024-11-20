package br.edu.ifsp.dsw1.model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Totem implements FlightDataObserver {
	private List<TotemData> totemList;
	
	public Totem() {
		totemList = new ArrayList<>();
	}
	
	public void addTotem(TotemData totem) {
		if (totem != null) {
			totemList.add(totem);
		}
	}
	
	public void removeTotem(TotemData totem) {
		totemList.remove(totem);
	}
	
	public List<TotemData> getAllTotens() {
		return new ArrayList<>(totemList);
	}
	
	public TotemData findTotemByFlightNumber(Long flightNumber) {
		return getAllTotens().stream()
				.filter(t -> t.getFlightNumber().equals(flightNumber))
				.findFirst()
				.orElse(null);
	}
}
