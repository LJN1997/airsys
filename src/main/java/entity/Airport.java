package entity;

public class Airport {
	private String airportNumber;
	private String airportName;
	private String airportCity;
	public Airport() {
		super();
	}
	public Airport(String airportNumber, String airportName, String airportCity) {
		super();
		this.airportNumber = airportNumber;
		this.airportName = airportName;
		this.airportCity = airportCity;
	}
	public String getAirportNumber() {
		return airportNumber;
	}
	public void setAirportNumber(String airportNumber) {
		this.airportNumber = airportNumber;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCity() {
		return airportCity;
	}
	public void setAirportCity(String airportCity) {
		this.airportCity = airportCity;
	}
	@Override
	public String toString() {
		return "Airport [airportNumber=" + airportNumber + ", airportName=" + airportName + ", airportCity="
				+ airportCity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportCity == null) ? 0 : airportCity.hashCode());
		result = prime * result + ((airportName == null) ? 0 : airportName.hashCode());
		result = prime * result + ((airportNumber == null) ? 0 : airportNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (airportCity == null) {
			if (other.airportCity != null)
				return false;
		} else if (!airportCity.equals(other.airportCity))
			return false;
		if (airportName == null) {
			if (other.airportName != null)
				return false;
		} else if (!airportName.equals(other.airportName))
			return false;
		if (airportNumber == null) {
			if (other.airportNumber != null)
				return false;
		} else if (!airportNumber.equals(other.airportNumber))
			return false;
		return true;
	}
	
}
