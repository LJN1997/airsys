package entity;

import java.util.Date;

import util.DateUtil;

public class Fplan {
	private int planId;
	private String fnumber;
	private String startDate;
	private String endDate;
	private String fromCity;
	private String toCity;
	private Date departureTime;
	private Date arrivalTime;
	private Date ExpStartTime;
	private Date ExpEndTime;
	private int sailLength;
	private String type;
	private double tprice;
	public Fplan() {
		super();
	}
	public Fplan(int planId, String fnumber, String startDate, String endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, Date expStartTime, Date expEndTime, int sailLength, String type,
			double tprice) {
		super();
		this.planId = planId;
		this.fnumber = fnumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		ExpStartTime = expStartTime;
		ExpEndTime = expEndTime;
		this.sailLength = sailLength;
		this.type = type;
		this.tprice = tprice;   
	}
	
	public Fplan(String fnumber, String startDate, String endDate, String fromCity, String toCity, String type,
			double tprice) {
		super();
		this.fnumber = fnumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.type = type;
		this.tprice = tprice;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate =DateUtil.dateToString("yyyy-MM-dd", startDate);
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = DateUtil.dateToString("yyyy-MM-dd", endDate);
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
	public Date getExpStartTime() {
		return ExpStartTime;
	}
	public void setExpStartTime(Date expStartTime) {
		ExpStartTime = expStartTime;
	}
	public Date getExpEndTime() {
		return ExpEndTime;
	}
	public void setExpEndTime(Date expEndTime) {
		ExpEndTime = expEndTime;
	}
	public int getSailLength() {
		return sailLength;
	}
	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", fnumber=" + fnumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", ExpStartTime=" + ExpStartTime + ", ExpEndTime=" + ExpEndTime
				+ ", sailLength=" + sailLength + ", type=" + type + ", tprice=" + tprice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ExpEndTime == null) ? 0 : ExpEndTime.hashCode());
		result = prime * result + ((ExpStartTime == null) ? 0 : ExpStartTime.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + planId;
		result = prime * result + sailLength;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Fplan other = (Fplan) obj;
		if (ExpEndTime == null) {
			if (other.ExpEndTime != null)
				return false;
		} else if (!ExpEndTime.equals(other.ExpEndTime))
			return false;
		if (ExpStartTime == null) {
			if (other.ExpStartTime != null)
				return false;
		} else if (!ExpStartTime.equals(other.ExpStartTime))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
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
		if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
