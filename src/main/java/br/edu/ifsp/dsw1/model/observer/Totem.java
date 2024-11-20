package br.edu.ifsp.dsw1.model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Totem implements FlightDataObserver {
	private List<Totem> totemList;
	private final Long flightNumber;
	private final String company;
	private final String time;
	
	public Totem(Long flightNumber, String company, String time) {
		this.flightNumber = flightNumber;
		this.company = company;
		this.time = time;
		totemList = new ArrayList<>();
	}
	
	public void addTotem(Totem totem) {
		if (totem != null) {
			totemList.add(totem);
		}
	}
	
	public void removeTotem(Totem totem) {
		totemList.remove(totem);
	}
	
	public List<Totem> getAllTotens() {
		return new ArrayList<>(totemList);
	}
	
	public Totem findTotemByFlightNumber(Long flightNumber) {
		return getAllTotens().stream()
				.filter(t -> t.getFlightNumber().equals(flightNumber))
				.findFirst()
				.orElse(null);
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public String getCompany() {
		return company;
	}

	public String getTime() {
		return time;
	}
}
