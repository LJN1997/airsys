package entity;

import java.io.Serializable;
import java.util.Date;

import util.DateUtil;

/**
* 
*  查到的航班信息
* @author DanyangLi
*/
public class Info implements Serializable  {
	
		private String fnumber;
		private String fromCity;
		private String toCity;
		private Date startDate;
		private String departureTime;
		private String arrivalTime;
		private int firstClassRemainSeats;
		private int businessClassRemainSeats;
		private int economyClassRemainSeats;
		private double tprice;
		private double seasonDiscount;
		private Date expStartTime;
		private Date expEndTime;
		private int planId;
		private int sid;
		private int uid;
		private int status;
		
		public Info() {
			super();
		}

		public Info(String fnumber, String fromCity, String toCity, Date startDate, String departureTime,
				String arrivalTime, int firstClassRemainSeats, int businessClassRemainSeats,
				int economyClassRemainSeats, double tprice, double seasonDiscount, Date expStartTime, Date expEndTime,
				int planId, int sid, int uid, int status) {
			super();
			this.fnumber = fnumber;
			this.fromCity = fromCity;
			this.toCity = toCity;
			this.startDate = startDate;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			this.firstClassRemainSeats = firstClassRemainSeats;
			this.businessClassRemainSeats = businessClassRemainSeats;
			this.economyClassRemainSeats = economyClassRemainSeats;
			this.tprice = tprice;
			this.seasonDiscount = seasonDiscount;
			this.expStartTime = expStartTime;
			this.expEndTime = expEndTime;
			this.planId = planId;
			this.sid = sid;
			this.uid = uid;
			this.status = status;
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

		public String getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}

		public String getArrivalTime() {
			return arrivalTime;
		}

		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime;
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

		public double getTprice() {
			return tprice;
		}

		public void setTprice(double tprice) {
			this.tprice = tprice;
		}

		public double getSeasonDiscount() {
			return seasonDiscount;
		}

		public void setSeasonDiscount(double seasonDiscount) {
			this.seasonDiscount = seasonDiscount;
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

		public int getPlanId() {
			return planId;
		}

		public void setPlanId(int planId) {
			this.planId = planId;
		}

		public int getSid() {
			return sid;
		}

		public void setSid(int sid) {
			this.sid = sid;
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Info [fnumber=" + fnumber + ", fromCity=" + fromCity + ", toCity=" + toCity + ", startDate="
					+ startDate + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
					+ ", firstClassRemainSeats=" + firstClassRemainSeats + ", businessClassRemainSeats="
					+ businessClassRemainSeats + ", economyClassRemainSeats=" + economyClassRemainSeats + ", tprice="
					+ tprice + ", seasonDiscount=" + seasonDiscount + ", expStartTime=" + expStartTime + ", expEndTime="
					+ expEndTime + ", planId=" + planId + ", sid=" + sid + ", uid=" + uid + ", status=" + status + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
			result = prime * result + businessClassRemainSeats;
			result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
			result = prime * result + economyClassRemainSeats;
			result = prime * result + ((expEndTime == null) ? 0 : expEndTime.hashCode());
			result = prime * result + ((expStartTime == null) ? 0 : expStartTime.hashCode());
			result = prime * result + firstClassRemainSeats;
			result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
			result = prime * result + ((fromCity == null) ? 0 : fromCity.hashCode());
			result = prime * result + planId;
			long temp;
			temp = Double.doubleToLongBits(seasonDiscount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + sid;
			result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
			result = prime * result + status;
			result = prime * result + ((toCity == null) ? 0 : toCity.hashCode());
			temp = Double.doubleToLongBits(tprice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + uid;
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
			Info other = (Info) obj;
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
			if (Double.doubleToLongBits(seasonDiscount) != Double.doubleToLongBits(other.seasonDiscount))
				return false;
			if (sid != other.sid)
				return false;
			if (startDate == null) {
				if (other.startDate != null)
					return false;
			} else if (!startDate.equals(other.startDate))
				return false;
			if (status != other.status)
				return false;
			if (toCity == null) {
				if (other.toCity != null)
					return false;
			} else if (!toCity.equals(other.toCity))
				return false;
			if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
				return false;
			if (uid != other.uid)
				return false;
			return true;
		}


		
		
}
