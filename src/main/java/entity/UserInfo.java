package entity;

import java.util.Date;

public class UserInfo {
	private String fnumber;
	private Date departureTime;
	private Date arrivalTime;
	private String fromCity;
	private String toCity;
	private String tprice;
	private long temp;
	private String tid;
	private String fid;
	private String tclass;
	private String startDate;
	private String idcard;
	private String oname;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String fnumber, Date departureTime, Date arrivalTime, String fromCity, String toCity, String tprice,
			long temp, String tid, String fid, String tclass, String startDate, String idcard, String oname) {
		super();
		this.fnumber = fnumber;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.tprice = tprice;
		this.temp = temp;
		this.tid = tid;
		this.fid = fid;
		this.tclass = tclass;
		this.startDate = startDate;
		this.idcard = idcard;
		this.oname = oname;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
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
	public String getTprice() {
		return tprice;
	}
	public void setTprice(String tprice) {
		this.tprice = tprice;
	}
	public long getTemp() {
		return temp;
	}
	public void setTemp(long temp) {
		this.temp = temp;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
		result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
		result = prime * result + ((idcard == null) ? 0 : idcard.hashCode());
		result = prime * result + ((oname == null) ? 0 : oname.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((tclass == null) ? 0 : tclass.hashCode());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		UserInfo other = (UserInfo) obj;
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
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
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
		if (idcard == null) {
			if (other.idcard != null)
				return false;
		} else if (!idcard.equals(other.idcard))
			return false;
		if (oname == null) {
			if (other.oname != null)
				return false;
		} else if (!oname.equals(other.oname))
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
		if (temp != other.temp)
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
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
	@Override
	public String toString() {
		return "UserInfo [fnumber=" + fnumber + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", fromCity=" + fromCity + ", toCity=" + toCity + ", tprice=" + tprice + ", temp=" + temp + ", tid="
				+ tid + ", fid=" + fid + ", tclass=" + tclass + ", startDate=" + startDate + ", idcard=" + idcard
				+ ", oname=" + oname + "]";
	}
	
	
}
