package entity;

public class Flight {
	private int fid;
	private String fnumber;
	private double discount;
	private int firstClassRemainSeats;
	private int businessClassRemainSeats;
	private int economyClassRemainSeats;
	public Flight() {
		super();
	}
	public Flight(int fid, String fnumber, double discount, int firstClassRemainSeats, int businessClassRemainSeats,
			int economyClassRemainSeats) {
		super();
		this.fid = fid;
		this.fnumber = fnumber;
		this.discount = discount;
		this.firstClassRemainSeats = firstClassRemainSeats;
		this.businessClassRemainSeats = businessClassRemainSeats;
		this.economyClassRemainSeats = economyClassRemainSeats;
	}
	public Flight( String fnumber, double discount, int firstClassRemainSeats, int businessClassRemainSeats,
			int economyClassRemainSeats) {
		super();
		this.fnumber = fnumber;
		this.discount = discount;
		this.firstClassRemainSeats = firstClassRemainSeats;
		this.businessClassRemainSeats = businessClassRemainSeats;
		this.economyClassRemainSeats = economyClassRemainSeats;
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
	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", fnumber=" + fnumber + ", discount=" + discount + ", firstClassRemainSeats="
				+ firstClassRemainSeats + ", businessClassRemainSeats=" + businessClassRemainSeats
				+ ", economyClassRemainSeats=" + economyClassRemainSeats + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + businessClassRemainSeats;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + economyClassRemainSeats;
		result = prime * result + fid;
		result = prime * result + firstClassRemainSeats;
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
		if (businessClassRemainSeats != other.businessClassRemainSeats)
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (economyClassRemainSeats != other.economyClassRemainSeats)
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
		return true;
	}
	
}
