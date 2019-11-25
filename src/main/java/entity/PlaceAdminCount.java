package entity;

public class PlaceAdminCount {

	private double tprice;
	public PlaceAdminCount() {
		super();
	}
	public PlaceAdminCount( double tprice) {
		super();
		this.tprice = tprice;

	}

	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	@Override
	public String toString() {
		return "PlaceAdminCount [tprice=" + tprice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		PlaceAdminCount other = (PlaceAdminCount) obj;
		if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
			return false;
		return true;
	}
	
	

}
