package entity;

public class Flight {
	private int fid;
	private String fnumber;
	private double discount;
	private int first_class_remain_seats;
	private int business_class_remain_seats;
	private int economy_class_remain_seats;
	public Flight() {
		super();
	}
	public Flight(int fid, String fnumber, double discount, int first_class_remain_seats,
			int business_class_remain_seats, int economy_class_remain_seats) {
		super();
		this.fid = fid;
		this.fnumber = fnumber;
		this.discount = discount;
		this.first_class_remain_seats = first_class_remain_seats;
		this.business_class_remain_seats = business_class_remain_seats;
		this.economy_class_remain_seats = economy_class_remain_seats;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFnumber() {
		return fnumber;
	}
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + business_class_remain_seats;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + economy_class_remain_seats;
		result = prime * result + fid;
		result = prime * result + first_class_remain_seats;
		result = prime * result + ((fnumber == null) ? 0 : fnumber.hashCode());
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
		Flight other = (Flight) obj;
		if (business_class_remain_seats != other.business_class_remain_seats)
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (economy_class_remain_seats != other.economy_class_remain_seats)
			return false;
		if (fid != other.fid)
			return false;
		if (first_class_remain_seats != other.first_class_remain_seats)
			return false;
		if (fnumber == null) {
			if (other.fnumber != null)
				return false;
		} else if (!fnumber.equals(other.fnumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", fnumber=" + fnumber + ", discount=" + discount + ", first_class_remain_seats="
				+ first_class_remain_seats + ", business_class_remain_seats=" + business_class_remain_seats
				+ ", economy_class_remain_seats=" + economy_class_remain_seats + "]";
	}
	
}
