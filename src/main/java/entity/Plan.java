package entity;

import java.util.Date;

import util.DateUtil;

public class Plan {
	private int planId;
	private String fnumber;
	private Date startDate;
	private Date endDate;
	private String fromCity;
	private String toCity;
	private Date departureTime;
	private Date arrivalTime;
	private int sailLength;
	private String type;
	private double tprice;
	private Date expStartTime;
	private Date expEndTime;
	public Plan() {
		super();
	}
	public Plan(int planId, String fnumber, Date startDate, Date endDate, String fromCity, String toCity,
			Date departureTime, Date arrivalTime, int sailLength, String type, double tprice, Date expStartTime,
			Date expEndTime) {
		super();
		this.planId = planId;
		this.fnumber = fnumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.sailLength = sailLength;
		this.type = type;
		this.tprice = tprice;
		this.expStartTime = expStartTime;
		this.expEndTime = expEndTime;
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
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", fnumber=" + fnumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", sailLength=" + sailLength + ", type=" + type + ", tprice="
				+ tprice + ", expStartTime=" + expStartTime + ", expEndTime=" + expEndTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((expEndTime == null) ? 0 : expEndTime.hashCode());
		result = prime * result + ((expStartTime == null) ? 0 : expStartTime.hashCode());
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
		Plan other = (Plan) obj;
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
