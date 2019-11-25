package entity;

public class PlaceAdminCountPassenger {

	private double tprice;
	private String passengerType;
	public PlaceAdminCountPassenger() {
		super();
	}
	public PlaceAdminCountPassenger(double tprice, String passengerType) {
		super();
		this.tprice = tprice;
		this.passengerType = passengerType;
	}
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	@Override
	public String toString() {
		return "PlaceAdminCountPassenger [tprice=" + tprice + ", passengerType=" + passengerType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passengerType == null) ? 0 : passengerType.hashCode());
		long temp;
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
		PlaceAdminCountPassenger other = (PlaceAdminCountPassenger) obj;
		if (passengerType == null) {
			if (other.passengerType != null)
				return false;
		} else if (!passengerType.equals(other.passengerType))
			return false;
		if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
			return false;
		return true;
	}
	
}
