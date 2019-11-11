package entity;

public class PlaneType {
	private String type;
	private int maxSailLength;
	private int firstClassSeats;
	private int businessClassSeats;
	private int economyClassSeats;
	public PlaneType() {
		super();
	}
	public PlaneType(String type, int maxSailLength, int firstClassSeats, int businessClassSeats,
			int economyClassSeats) {
		super();
		this.type = type;
		this.maxSailLength = maxSailLength;
		this.firstClassSeats = firstClassSeats;
		this.businessClassSeats = businessClassSeats;
		this.economyClassSeats = economyClassSeats;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMaxSailLength() {
		return maxSailLength;
	}
	public void setMaxSailLength(int maxSailLength) {
		this.maxSailLength = maxSailLength;
	}
	public int getFirstClassSeats() {
		return firstClassSeats;
	}
	public void setFirstClassSeats(int firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}
	public int getBusinessClassSeats() {
		return businessClassSeats;
	}
	public void setBusinessClassSeats(int businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}
	public int getEconomyClassSeats() {
		return economyClassSeats;
	}
	public void setEconomyClassSeats(int economyClassSeats) {
		this.economyClassSeats = economyClassSeats;
	}
	@Override
	public String toString() {
		return "PlaneType [type=" + type + ", maxSailLength=" + maxSailLength + ", firstClassSeats=" + firstClassSeats
				+ ", businessClassSeats=" + businessClassSeats + ", economyClassSeats=" + economyClassSeats + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + businessClassSeats;
		result = prime * result + economyClassSeats;
		result = prime * result + firstClassSeats;
		result = prime * result + maxSailLength;
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
		PlaneType other = (PlaneType) obj;
		if (businessClassSeats != other.businessClassSeats)
			return false;
		if (economyClassSeats != other.economyClassSeats)
			return false;
		if (firstClassSeats != other.firstClassSeats)
			return false;
		if (maxSailLength != other.maxSailLength)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	
}
