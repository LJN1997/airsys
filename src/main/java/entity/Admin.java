package entity;

import java.io.Serializable;

public class Admin implements Serializable  {
	private int aid;
	private String anumber;
	private String aname;
	private String apwd;
	private String ahead;
	public Admin() {
		super();
	}
	public Admin(int aid, String anumber, String aname, String apwd, String ahead) {
		super();
		this.aid = aid;
		this.anumber = anumber;
		this.aname = aname;
		this.apwd = apwd;
		this.ahead = ahead;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAnumber() {
		return anumber;
	}
	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAhead() {
		return ahead;
	}
	public void setAhead(String ahead) {
		this.ahead = ahead;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", anumber=" + anumber + ", aname=" + aname + ", apwd=" + apwd + ", ahead=" + ahead
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ahead == null) ? 0 : ahead.hashCode());
		result = prime * result + aid;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((anumber == null) ? 0 : anumber.hashCode());
		result = prime * result + ((apwd == null) ? 0 : apwd.hashCode());
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
		Admin other = (Admin) obj;
		if (ahead == null) {
			if (other.ahead != null)
				return false;
		} else if (!ahead.equals(other.ahead))
			return false;
		if (aid != other.aid)
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (anumber == null) {
			if (other.anumber != null)
				return false;
		} else if (!anumber.equals(other.anumber))
			return false;
		if (apwd == null) {
			if (other.apwd != null)
				return false;
		} else if (!apwd.equals(other.apwd))
			return false;
		return true;
	}
	
}
