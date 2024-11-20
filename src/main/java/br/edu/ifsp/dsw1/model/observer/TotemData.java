package br.edu.ifsp.dsw1.model.observer;

import java.util.Objects;

public class TotemData {
	private final Long flightNumber;
	private final String company;
	private final String time;
	
	public TotemData(Long flightNumber, String company, String time) {
		super();
		this.flightNumber = flightNumber;
		this.company = company;
		this.time = time;
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
		return "TotemData [flightNumber=" + flightNumber + ", company=" + company + ", time=" + time + "]";
	}
}
