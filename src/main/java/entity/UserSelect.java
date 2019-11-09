package entity;

import java.util.Date;

public class UserSelect {
	private String fnumber;
	private String tprice;
	private Date departure_time;
	private Date arrival_time;
	public UserSelect(String fnumber, String tprice, Date departure_time, Date arrival_time) {
		super();
		this.fnumber = fnumber;
		this.tprice = tprice;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
	}
	public UserSelect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public String getTprice() {
		return tprice;
	}
	public void setTprice(String tprice) {
		this.tprice = tprice;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
		result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
		result = prime * result + ((tprice == null) ? 0 : tprice.hashCode());
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
		UserSelect other = (UserSelect) obj;
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
		if (fnumber == null) {
			if (other.fnumber != null)
				return false;
		} else if (!fnumber.equals(other.fnumber))
			return false;
		if (tprice == null) {
			if (other.tprice != null)
				return false;
		} else if (!tprice.equals(other.tprice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserSelect [fnumber=" + fnumber + ", tprice=" + tprice + ", departure_time=" + departure_time
				+ ", arrival_time=" + arrival_time + "]";
	}
	
}
