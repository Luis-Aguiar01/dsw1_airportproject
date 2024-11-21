package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;

/*
	Essa classe define a lógica básica de todos os totens do sistema. Cada totem novo
	deverá herdar dessa classe.
*/

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
