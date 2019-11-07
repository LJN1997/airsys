package entity;

import java.util.Date;

public class Plan {
	private String from_city;
	private String to_city;
	private Date departure_time;
	private Date arrival_time;
	private int sail_length;
	private String type;
	public Plan() {
		super();
	}
	public Plan(String from_city, String to_city, Date departure_time, Date arrival_time, int sail_length,
			String type) {
		super();
		this.from_city = from_city;
		this.to_city = to_city;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.sail_length = sail_length;
		this.type = type;
	}
	public String getFrom_city() {
		return from_city;
	}
	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}
	public String getTo_city() {
		return to_city;
	}
	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}
	public Date getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Date departure_time) {
		this.departure_time = departure_time;
	}
	public Date getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(Date arrival_time) {
		this.arrival_time = arrival_time;
	}
	public int getSail_length() {
		return sail_length;
	}
	public void setSail_length(int sail_length) {
		this.sail_length = sail_length;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Plan [from_city=" + from_city + ", to_city=" + to_city + ", departure_time=" + departure_time
				+ ", arrival_time=" + arrival_time + ", sail_length=" + sail_length + ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
		result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
		result = prime * result + ((from_city == null) ? 0 : from_city.hashCode());
		result = prime * result + sail_length;
		result = prime * result + ((to_city == null) ? 0 : to_city.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Plan other = (Plan) obj;
		if (arrival_time == null) {
			if (other.arrival_time != null)
				return false;
		} else if (!arrival_time.equals(other.arrival_time))
			return false;
		if (departure_time == null) {
			if (other.departure_time != null)
				return false;
		} else if (!departure_time.equals(other.departure_time))
			return false;
		if (from_city == null) {
			if (other.from_city != null)
				return false;
		} else if (!from_city.equals(other.from_city))
			return false;
		if (sail_length != other.sail_length)
			return false;
		if (to_city == null) {
			if (other.to_city != null)
				return false;
		} else if (!to_city.equals(other.to_city))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
