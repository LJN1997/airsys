package entity;

import java.io.Serializable;

public class Place implements Serializable  {
	private int pid;
	private String pname;
	private String pphone;
	private String psite;
	private String province;
	public Place() {
		super();
	}
	public Place(int pid, String pname, String pphone, String psite, String province) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pphone = pphone;
		this.psite = psite;
		this.province = province;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPphone() {
		return pphone;
	}
	public void setPphone(String pphone) {
		this.pphone = pphone;
	}
	public String getPsite() {
		return psite;
	}
	public void setPsite(String psite) {
		this.psite = psite;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Place [pid=" + pid + ", pname=" + pname + ", pphone=" + pphone + ", psite=" + psite + ", province="
				+ province + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pid;
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + ((pphone == null) ? 0 : pphone.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((psite == null) ? 0 : psite.hashCode());
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
		Place other = (Place) obj;
		if (pid != other.pid)
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (pphone == null) {
			if (other.pphone != null)
				return false;
		} else if (!pphone.equals(other.pphone))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (psite == null) {
			if (other.psite != null)
				return false;
		} else if (!psite.equals(other.psite))
			return false;
		return true;
	}
	
	
	
}
