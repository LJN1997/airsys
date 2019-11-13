package entity;

import java.sql.Date;

public class SalesTicket {

	private int tid;
	private String snumber;
	private String sname;
	private String tnumber;
	private String fnumber;
	private String fromCity;
	private String toCity;
	private Date startDate;
	private Date endDate;
	private Date expStartTime;
	private Date expEndTime;
	private String type;
	private String tclass;
	private String passengerType;
	private double tprice;
	private int sailLength;
	public SalesTicket() {
		super();
	}
	public SalesTicket(int tid, String snumber, String sname, String tnumber, String fnumber, String fromCity,
			String toCity, Date startDate, Date endDate, Date expSatrtTime, Date expEndTime, String type, String tclass,
			String passengerType, double tprice, int sailLength) {
		super();
		this.tid = tid;
		this.snumber = snumber;
		this.sname = sname;
		this.tnumber = tnumber;
		this.fnumber = fnumber;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.startDate = startDate;
		this.endDate = endDate;
	    this.expStartTime = expStartTime;
	    this.expEndTime = expEndTime;
		this.type = type;
		this.tclass = tclass;
		this.passengerType = passengerType;
		this.tprice = tprice;
		this.sailLength = sailLength;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTnumber() {
		return tnumber;
	}
	public void setTnumber(String tnumber) {
		this.tnumber = tnumber;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	public int getSailLength() {
		return sailLength;
	}
	public void setSailLength(int sailLength) {
		this.sailLength = sailLength;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((expEndTime == null) ? 0 : expEndTime.hashCode());
		result = prime * result + ((expStartTime == null) ? 0 : expStartTime.hashCode());
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + ((passengerType == null) ? 0 : passengerType.hashCode());
		result = prime * result + sailLength;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((snumber == null) ? 0 : snumber.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((tclass == null) ? 0 : tclass.hashCode());
		result = prime * result + tid;
		result = prime * result + ((tnumber == null) ? 0 : tnumber.hashCode());
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
		SalesTicket other = (SalesTicket) obj;
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
		if (passengerType == null) {
			if (other.passengerType != null)
				return false;
		} else if (!passengerType.equals(other.passengerType))
			return false;
		if (sailLength != other.sailLength)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (snumber == null) {
			if (other.snumber != null)
				return false;
		} else if (!snumber.equals(other.snumber))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (tclass == null) {
			if (other.tclass != null)
				return false;
		} else if (!tclass.equals(other.tclass))
			return false;
		if (tid != other.tid)
			return false;
		if (tnumber == null) {
			if (other.tnumber != null)
				return false;
		} else if (!tnumber.equals(other.tnumber))
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
	@Override
	public String toString() {
		return "SalesTicket [tid=" + tid + ", snumber=" + snumber + ", sname=" + sname + ", tnumber=" + tnumber
				+ ", fnumber=" + fnumber + ", fromCity=" + fromCity + ", toCity=" + toCity + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", expSatrtTime=" + expStartTime + ", expEndTime=" + expEndTime + ", type="
				+ type + ", tclass=" + tclass + ", passengerType=" + passengerType + ", tprice=" + tprice
				+ ", sailLength=" + sailLength + "]";
	}
	
	
	
	

}
