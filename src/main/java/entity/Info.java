package entity;

import java.util.Date;

import util.DateUtil;

/**
* 
*  查到的航班信息
* @author DanyangLi
*/
public class Info {
	
		private String fnumber;
		private String from_city;
		private String to_city;
		private Date start_date;
		private String departure_time;
		private String arrival_time;
		private int first_class_remain_seats;
		private int business_class_remain_seats;
		private int economy_class_remain_seats;
		private double tprice;
		private double season_discount;
		public Info() {
			super();
		}
		public Info(String fnumber, String from_city, String to_city, Date start_date, String departure_time,
				String arrival_time, int first_class_remain_seats, int business_class_remain_seats,
				int economy_class_remain_seats, double tprice, double season_discount) {
			super();
			this.fnumber = fnumber;
			this.from_city = from_city;
			this.to_city = to_city;
			this.start_date = start_date;
			this.departure_time = departure_time;
			this.arrival_time = arrival_time;
			this.first_class_remain_seats = first_class_remain_seats;
			this.business_class_remain_seats = business_class_remain_seats;
			this.economy_class_remain_seats = economy_class_remain_seats;
			this.tprice = tprice;
			this.season_discount = season_discount;
		}
		public String getFnumber() {
			return fnumber;
		}
		public void setFnumber(String fnumber) {
			this.fnumber = fnumber;
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
		public Date getStart_date() {
			return start_date;
		}
		public void setStart_date(String start_date) {
			this.start_date=DateUtil.toDate("yyyy-MM-dd", start_date);
		}
		public String getDeparture_time() {
			return departure_time;
		}
		public void setDeparture_time(String departure_time) {
			this.departure_time = departure_time;
		}
		public String getArrival_time() {
			return arrival_time;
		}
		public void setArrival_time(String arrival_time) {
			this.arrival_time = arrival_time;
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
		public double getTprice() {
			return tprice;
		}
		public void setTprice(double tprice) {
			this.tprice = tprice;
		}
		public double getSeason_discount() {
			return season_discount;
		}
		public void setSeason_discount(double season_discount) {
			this.season_discount = season_discount;
		}
		@Override
		public String toString() {
			return "info [fnumber=" + fnumber + ", from_city=" + from_city + ", to_city=" + to_city + ", start_date="
					+ start_date + ", departure_time=" + departure_time + ", arrival_time=" + arrival_time
					+ ", first_class_remain_seats=" + first_class_remain_seats + ", business_class_remain_seats="
					+ business_class_remain_seats + ", economy_class_remain_seats=" + economy_class_remain_seats
					+ ", tprice=" + tprice + ", season_discount=" + season_discount + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
			result = prime * result + business_class_remain_seats;
			result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
			result = prime * result + economy_class_remain_seats;
			result = prime * result + first_class_remain_seats;
			result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
			result = prime * result + ((from_city == null) ? 0 : from_city.hashCode());
			long temp;
			temp = Double.doubleToLongBits(season_discount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
			result = prime * result + ((to_city == null) ? 0 : to_city.hashCode());
			temp = Double.doubleToLongBits(tprice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			if (economy_class_remain_seats != other.economy_class_remain_seats)
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
			if (Double.doubleToLongBits(season_discount) != Double.doubleToLongBits(other.season_discount))
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
			if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
				return false;
			return true;
		}
		
		
		
		
}
