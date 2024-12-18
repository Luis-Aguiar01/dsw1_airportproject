package br.edu.ifsp.dsw1.model.entity;

import java.util.Objects;

/*
	Essa classe serve para guardar as informações relevantes de um totem.
*/

public class TotemData {
	private final Long flightNumber;
	private final String company;
	private final String time;
	private final String state;
	
	public TotemData(Long flightNumber, String company, String time, String state) {
		super();
		this.flightNumber = flightNumber;
		this.company = company;
		this.time = time;
		this.state = state;
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
	
	public String getState() {
		return state;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(flightNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TotemData other = (TotemData) obj;
		return Objects.equals(flightNumber, other.flightNumber);
	}

	@Override
	public String toString() {
		return "TotemData [flightNumber=" + flightNumber + 
				", company=" + company + 
				", time=" + time + 
				", state=" + state + "]";
	}
}
