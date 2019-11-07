package entity;

public class Airport {
	private String airport_number;
	private String airport_name;
	private String airport_city;
	public Airport() {
		super();
	}
	public Airport(String airport_number, String airport_name, String airport_city) {
		super();
		this.airport_number = airport_number;
		this.airport_name = airport_name;
		this.airport_city = airport_city;
	}
	public String getAirport_number() {
		return airport_number;
	}
	public void setAirport_number(String airport_number) {
		this.airport_number = airport_number;
	}
	public String getAirport_name() {
		return airport_name;
	}
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
	public String getAirport_city() {
		return airport_city;
	}
	public void setAirport_city(String airport_city) {
		this.airport_city = airport_city;
	}
	@Override
	public String toString() {
		return "Airport [airport_number=" + airport_number + ", airport_name=" + airport_name + ", airport_city="
				+ airport_city + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airport_city == null) ? 0 : airport_city.hashCode());
		result = prime * result + ((airport_name == null) ? 0 : airport_name.hashCode());
		result = prime * result + ((airport_number == null) ? 0 : airport_number.hashCode());
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
		if (airport_city == null) {
			if (other.airport_city != null)
				return false;
		} else if (!airport_city.equals(other.airport_city))
			return false;
		if (airport_name == null) {
			if (other.airport_name != null)
				return false;
		} else if (!airport_name.equals(other.airport_name))
			return false;
		if (airport_number == null) {
			if (other.airport_number != null)
				return false;
		} else if (!airport_number.equals(other.airport_number))
			return false;
		return true;
	}
	
}
