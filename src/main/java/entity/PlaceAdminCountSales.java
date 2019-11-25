package entity;

public class PlaceAdminCountSales {
	private String sname;
	private double tprice;
	public PlaceAdminCountSales(String sname, double tprice) {
		super();
		this.sname = sname;
		this.tprice = tprice;
	}
	public PlaceAdminCountSales() {
		super();
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	@Override
	public String toString() {
		return "PlaceAdminCountSales [sname=" + sname + ", tprice=" + tprice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
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
		PlaceAdminCountSales other = (PlaceAdminCountSales) obj;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
			return false;
		return true;
	}
	
}
