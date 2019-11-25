package entity;

public class PlaceAdminCountClass {

	private double tprice;
	private String tclass;
	public PlaceAdminCountClass() {
		super();
	}
	public PlaceAdminCountClass(double tprice, String tclass) {
		super();
		this.tprice = tprice;
		this.tclass = tclass;
	}
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	@Override
	public String toString() {
		return "PlaceAdminCountClass [tprice=" + tprice + ", tclass=" + tclass + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tclass == null) ? 0 : tclass.hashCode());
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
		PlaceAdminCountClass other = (PlaceAdminCountClass) obj;
		if (tclass == null) {
			if (other.tclass != null)
				return false;
		} else if (!tclass.equals(other.tclass))
			return false;
		if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
			return false;
		return true;
	}
	
}
