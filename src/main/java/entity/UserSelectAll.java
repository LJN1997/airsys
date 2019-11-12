package entity;

import java.util.Date;

public class UserSelectAll {
	private int fid;
	private double discount;
	private int firstClassRemainSeats;
	private int businessClassRemainSeats;
	private int economyClassRemainSeats;
	private String fnumber;
	private Date startDate;
	private Date endDate;
	private String fromCity;
	private String toCity;
	private Date departureTime;
	private Date arrivalTime;
	private int sailLength;
	private String tprice;
	public UserSelectAll() {
	}
	public UserSelectAll(int fid, double discount, int firstClassRemainSeats, int businessClassRemainSeats,
			int economyClassRemainSeats, String fnumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, int sailLength, String tprice) {
		super();
		this.fid = fid;
		this.discount = discount;
		this.firstClassRemainSeats = firstClassRemainSeats;
		this.businessClassRemainSeats = businessClassRemainSeats;
		this.economyClassRemainSeats = economyClassRemainSeats;
		this.fnumber = fnumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.sailLength = sailLength;
		this.tprice = tprice;
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
	public int getFirstClassRemainSeats() {
		return firstClassRemainSeats;
	}
	public void setFirstClassRemainSeats(int firstClassRemainSeats) {
		this.firstClassRemainSeats = firstClassRemainSeats;
	}
	public int getBusinessClassRemainSeats() {
		return businessClassRemainSeats;
	}
	public void setBusinessClassRemainSeats(int businessClassRemainSeats) {
		this.businessClassRemainSeats = businessClassRemainSeats;
	}
	public int getEconomyClassRemainSeats() {
		return economyClassRemainSeats;
	}
	public void setEconomyClassRemainSeats(int economyClassRemainSeats) {
		this.economyClassRemainSeats = economyClassRemainSeats;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getSailLength() {
		return sailLength;
	}
	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
	}
	public String getTprice() {
		return tprice;
	}
	public void setTprice(String tprice) {
		this.tprice = tprice;
	}
	@Override
	public String toString() {
		return "UserSelectAll [fid=" + fid + ", discount=" + discount + ", firstClassRemainSeats="
				+ firstClassRemainSeats + ", businessClassRemainSeats=" + businessClassRemainSeats
				+ ", economyClassRemainSeats=" + economyClassRemainSeats + ", fnumber=" + fnumber + ", startDate="
				+ startDate + ", endDate=" + endDate + ", fromCity=" + fromCity + ", toCity=" + toCity
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", sailLength=" + sailLength
				+ ", tprice=" + tprice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + businessClassRemainSeats;
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + economyClassRemainSeats;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + fid;
		result = prime * result + firstClassRemainSeats;
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + sailLength;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
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
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (businessClassRemainSeats != other.businessClassRemainSeats)
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (economyClassRemainSeats != other.economyClassRemainSeats)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (fid != other.fid)
			return false;
		if (firstClassRemainSeats != other.firstClassRemainSeats)
			return false;
		if (fnumber == null) {
			if (other.fnumber != null)
				return false;
		} else if (!fnumber.equals(other.fnumber))
			return false;
		if (fromCity == null) {
			if (other.fromCity != null)
				return false;
		} else if (!fromCity.equals(other.fromCity))
			return false;
		if (sailLength != other.sailLength)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (toCity == null) {
			if (other.toCity != null)
				return false;
		} else if (!toCity.equals(other.toCity))
			return false;
		if (tprice == null) {
			if (other.tprice != null)
				return false;
		} else if (!tprice.equals(other.tprice))
			return false;
		return true;
	}
	
	
	
}
