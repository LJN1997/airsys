package entity;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;

public class UserSelectAll implements Serializable  {
	private int fid;
	private double season_discount;
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
	private String type;
	private Date expStartTime;
	private Date expEndTime;
	private String str;
	private long temp;
	private int planId;
	public UserSelectAll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSelectAll(int fid, double season_discount, int firstClassRemainSeats, int businessClassRemainSeats,
			int economyClassRemainSeats, String fnumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, int sailLength, String tprice, String type, Date expStartTime,
			Date expEndTime, String str, long temp, int planId) {
		super();
		this.fid = fid;
		this.season_discount = season_discount;
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
		this.type = type;
		this.expStartTime = expStartTime;
		this.expEndTime = expEndTime;
		this.str = str;
		this.temp = temp;
		this.planId = planId;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public double getSeason_discount() {
		return season_discount;
	}
	public void setSeason_discount(double season_discount) {
		this.season_discount = season_discount;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getExpStartTime() {
		return expStartTime;
	}
	public void setExpStartTime(Date expStartTime) {
		this.expStartTime = expStartTime;
	}
	public Date getExpEndTime() {
		return expEndTime;
	}
	public void setExpEndTime(Date expEndTime) {
		this.expEndTime = expEndTime;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public long getTemp() {
		return temp;
	}
	public void setTemp(long temp) {
		this.temp = temp;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + businessClassRemainSeats;
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + economyClassRemainSeats;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((expEndTime == null) ? 0 : expEndTime.hashCode());
		result = prime * result + ((expStartTime == null) ? 0 : expStartTime.hashCode());
		result = prime * result + fid;
		result = prime * result + firstClassRemainSeats;
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + planId;
		result = prime * result + sailLength;
		long temp;
		temp = Double.doubleToLongBits(season_discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		result = prime * result + (int) (this.temp ^ (this.temp >>> 32));
		result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
		result = prime * result + ((tprice == null) ? 0 : tprice.hashCode());
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
		if (economyClassRemainSeats != other.economyClassRemainSeats)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (expEndTime == null) {
			if (other.expEndTime != null)
				return false;
		} else if (!expEndTime.equals(other.expEndTime))
			return false;
		if (expStartTime == null) {
			if (other.expStartTime != null)
				return false;
		} else if (!expStartTime.equals(other.expStartTime))
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
		if (planId != other.planId)
			return false;
		if (sailLength != other.sailLength)
			return false;
		if (Double.doubleToLongBits(season_discount) != Double.doubleToLongBits(other.season_discount))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		if (temp != other.temp)
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserSelectAll [fid=" + fid + ", season_discount=" + season_discount + ", firstClassRemainSeats="
				+ firstClassRemainSeats + ", businessClassRemainSeats=" + businessClassRemainSeats
				+ ", economyClassRemainSeats=" + economyClassRemainSeats + ", fnumber=" + fnumber + ", startDate="
				+ startDate + ", endDate=" + endDate + ", fromCity=" + fromCity + ", toCity=" + toCity
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", sailLength=" + sailLength
				+ ", tprice=" + tprice + ", type=" + type + ", expStartTime=" + expStartTime + ", expEndTime="
				+ expEndTime + ", str=" + str + ", temp=" + temp + ", planId=" + planId + "]";
	}
	
	
	
	
}
