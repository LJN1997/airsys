package entity;

import java.util.Date;

public class PlanNew {
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
	
	public PlanNew() {
	}
	public PlanNew(int planId, String fnumber, String startDate, String endDate, String fromCity, String toCity,
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
	
	
	public PlanNew(String fnumber, String startDate, String endDate, String fromCity, String toCity, String type,
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
	public PlanNew(int planId,String fnumber, String startDate, String endDate, String fromCity, String toCity, String type,
			double tprice) {
		super();
		this.planId=planId;
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
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
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
		return "PlanNew [planId=" + planId + ", fnumber=" + fnumber + ", startDate=" + startDate + ", endDate="
				+ endDate + ", fromCity=" + fromCity + ", toCity=" + toCity + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", ExpStartTime=" + ExpStartTime + ", ExpEndTime=" + ExpEndTime
				+ ", sailLength=" + sailLength + ", type=" + type + ", tprice=" + tprice + "]";
	}
	
}
