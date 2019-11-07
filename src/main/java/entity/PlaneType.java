package entity;

public class PlaneType {
	private String type;
	private int max_sail_length;
	private int first_class_seats;
	private int business_class_seats;
	private int economy_class_seats;
	public PlaneType() {
		super();
	}
	public PlaneType(String type, int max_sail_length, int first_class_seats, int business_class_seats,
			int economy_class_seats) {
		super();
		this.type = type;
		this.max_sail_length = max_sail_length;
		this.first_class_seats = first_class_seats;
		this.business_class_seats = business_class_seats;
		this.economy_class_seats = economy_class_seats;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMax_sail_length() {
		return max_sail_length;
	}
	public void setMax_sail_length(int max_sail_length) {
		this.max_sail_length = max_sail_length;
	}
	public int getFirst_class_seats() {
		return first_class_seats;
	}
	public void setFirst_class_seats(int first_class_seats) {
		this.first_class_seats = first_class_seats;
	}
	public int getBusiness_class_seats() {
		return business_class_seats;
	}
	public void setBusiness_class_seats(int business_class_seats) {
		this.business_class_seats = business_class_seats;
	}
	public int getEconomy_class_seats() {
		return economy_class_seats;
	}
	public void setEconomy_class_seats(int economy_class_seats) {
		this.economy_class_seats = economy_class_seats;
	}
	@Override
	public String toString() {
		return "Planetype [type=" + type + ", max_sail_length=" + max_sail_length + ", first_class_seats="
				+ first_class_seats + ", business_class_seats=" + business_class_seats + ", economy_class_seats="
				+ economy_class_seats + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + business_class_seats;
		result = prime * result + economy_class_seats;
		result = prime * result + first_class_seats;
		result = prime * result + max_sail_length;
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
		if (business_class_seats != other.business_class_seats)
			return false;
		if (economy_class_seats != other.economy_class_seats)
			return false;
		if (first_class_seats != other.first_class_seats)
			return false;
		if (max_sail_length != other.max_sail_length)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
}
