package entity;

import java.util.Date;

public class UserSelectAll {
	private int fid;
	private double discount;
	private int first_class_remain_seats;
	private int business_class_remain_seats;
	private int economy_class_remain_seats;
	private String fnumber;
	private Date start_date;
	private Date end_date;
	private String from_city;
	private String to_city;
	private Date departure_time;
	private Date arrival_time;
	private int sail_length;
	private String tprice;
	public UserSelectAll(int fid, double discount, int first_class_remain_seats, int business_class_remain_seats,
			int economy_class_remain_seats, String fnumber, Date start_date, Date end_date, String from_city,
			String to_city, Date departure_time, Date arrival_time, int sail_length, String tprice) {
		super();
		this.fid = fid;
		this.discount = discount;
		this.first_class_remain_seats = first_class_remain_seats;
		this.business_class_remain_seats = business_class_remain_seats;
		this.economy_class_remain_seats = economy_class_remain_seats;
		this.fnumber = fnumber;
		this.start_date = start_date;
		this.end_date = end_date;
		this.from_city = from_city;
		this.to_city = to_city;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.sail_length = sail_length;
		this.tprice = tprice;
	}
	public UserSelectAll() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserSelectAll [fid=" + fid + ", discount=" + discount + ", first_class_remain_seats="
				+ first_class_remain_seats + ", business_class_remain_seats=" + business_class_remain_seats
				+ ", economy_class_remain_seats=" + economy_class_remain_seats + ", fnumber=" + fnumber
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", from_city=" + from_city + ", to_city="
				+ to_city + ", departure_time=" + departure_time + ", arrival_time=" + arrival_time + ", sail_length="
				+ sail_length + ", tprice=" + tprice + "]";
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getFirst_class_remain_seats() {
		return first_class_remain_seats;
	}
	public void setFirst_class_remain_seats(int first_class_remain_seats) {
		this.first_class_remain_seats = first_class_remain_seats;
	}
	public int getBusiness_class_remain_seats() {
		return business_class_remain_seats;
	}
	public void setBusiness_class_remain_seats(int business_class_remain_seats) {
		this.business_class_remain_seats = business_class_remain_seats;
	}
	public int getEconomy_class_remain_seats() {
		return economy_class_remain_seats;
	}
	public void setEconomy_class_remain_seats(int economy_class_remain_seats) {
		this.economy_class_remain_seats = economy_class_remain_seats;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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
	public String getTprice() {
		return tprice;
	}
	public void setTprice(String tprice) {
		this.tprice = tprice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
		result = prime * result + business_class_remain_seats;
		result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + economy_class_remain_seats;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + fid;
		result = prime * result + first_class_remain_seats;
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
		result = prime * result + ((from_city == null) ? 0 : from_city.hashCode());
		result = prime * result + sail_length;
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((to_city == null) ? 0 : to_city.hashCode());
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
		UserSelectAll other = (UserSelectAll) obj;
		if (arrival_time == null) {
			if (other.arrival_time != null)
				return false;
		} else if (!arrival_time.equals(other.arrival_time))
			return false;
		if (business_class_remain_seats != other.business_class_remain_seats)
			return false;
		if (departure_time == null) {
			if (other.departure_time != null)
				return false;
		} else if (!departure_time.equals(other.departure_time))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (economy_class_remain_seats != other.economy_class_remain_seats)
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (fid != other.fid)
			return false;
		if (first_class_remain_seats != other.first_class_remain_seats)
			return false;
		if (fnumber == null) {
			if (other.fnumber != null)
				return false;
		} else if (!fnumber.equals(other.fnumber))
			return false;
		if (from_city == null) {
			if (other.from_city != null)
				return false;
		} else if (!from_city.equals(other.from_city))
			return false;
		if (sail_length != other.sail_length)
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (to_city == null) {
			if (other.to_city != null)
				return false;
		} else if (!to_city.equals(other.to_city))
			return false;
		if (tprice == null) {
			if (other.tprice != null)
				return false;
		} else if (!tprice.equals(other.tprice))
			return false;
		return true;
	}
	
	
	
}
