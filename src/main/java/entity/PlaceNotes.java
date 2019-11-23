package entity;

import java.util.Date;

public class PlaceNotes {
	private int oid;
	private String oname;
	private String ophone;
	private String tdate;
	private String tclass;
	private String passengerType;
	private String fnumber;
	private Date startDate;
	private Date endDate;
	private String fromCity;
	private String toCity;
	private double tprice;
	public PlaceNotes(int oid,String oname, String ophone, String tdate, String tclass, String passengerType, String fnumber,
			Date startDate, Date endDate, String fromCity, String toCity, double tprice) {
		super();
		this.oid=oid;
		this.oname = oname;
		this.ophone = ophone;
		this.tdate = tdate;
		this.tclass = tclass;
		this.passengerType = passengerType;
		this.fnumber = fnumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.tprice = tprice;
	}
	public PlaceNotes() {
	}
	public String getOname() {
		return oname;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
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
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	@Override
	public String toString() {
		return "PlaceNotes [oid=" + oid + ", oname=" + oname + ", ophone=" + ophone + ", tdate=" + tdate + ", tclass="
				+ tclass + ", passengerType=" + passengerType + ", fnumber=" + fnumber + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fromCity=" + fromCity + ", toCity=" + toCity + ", tprice=" + tprice + "]";
	}

	
}
