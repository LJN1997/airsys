package entity;

public class PlaceAdmin {
	private int paid;
	private String panumber;
	private String paname;
	private String papwd;
	private String pahead;
	private int pid;
	public PlaceAdmin() {
		super();
	}
	public PlaceAdmin(int paid, String panumber, String paname, String papwd, String pahead, int pid) {
		super();
		this.paid = paid;
		this.panumber = panumber;
		this.paname = paname;
		this.papwd = papwd;
		this.pahead = pahead;
		this.pid = pid;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public String getPanumber() {
		return panumber;
	}
	public void setPanumber(String panumber) {
		this.panumber = panumber;
	}
	public String getPaname() {
		return paname;
	}
	public void setPaname(String paname) {
		this.paname = paname;
	}
	public String getPapwd() {
		return papwd;
	}
	public void setPapwd(String papwd) {
		this.papwd = papwd;
	}
	public String getPahead() {
		return pahead;
	}
	public void setPahead(String pahead) {
		this.pahead = pahead;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "PlaceAdmin [paid=" + paid + ", panumber=" + panumber + ", paname=" + paname + ", papwd=" + papwd
				+ ", pahead=" + pahead + ", pid=" + pid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pahead == null) ? 0 : pahead.hashCode());
		result = prime * result + paid;
		result = prime * result + ((paname == null) ? 0 : paname.hashCode());
		result = prime * result + ((panumber == null) ? 0 : panumber.hashCode());
		result = prime * result + ((papwd == null) ? 0 : papwd.hashCode());
		result = prime * result + pid;
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
		PlaceAdmin other = (PlaceAdmin) obj;
		if (pahead == null) {
			if (other.pahead != null)
				return false;
		} else if (!pahead.equals(other.pahead))
			return false;
		if (paid != other.paid)
			return false;
		if (paname == null) {
			if (other.paname != null)
				return false;
		} else if (!paname.equals(other.paname))
			return false;
		if (panumber == null) {
			if (other.panumber != null)
				return false;
		} else if (!panumber.equals(other.panumber))
			return false;
		if (papwd == null) {
			if (other.papwd != null)
				return false;
		} else if (!papwd.equals(other.papwd))
			return false;
		if (pid != other.pid)
			return false;
		return true;
	}
	
}
