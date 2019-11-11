package entity;

public class Sales {
	private int sid;
	private String snumber;
	private String sname;
	private String spwd;
	private String shead;
	private int pid;
	private String pname;
	private String pphone;
	private String psite;
	private String province;
	public Sales() {
		super();
	}
	public Sales(int sid, String snumber, String sname, String spwd, String shead, int pid, String pname, String pphone,
			String psite, String province) {
		super();
		this.sid = sid;
		this.snumber = snumber;
		this.sname = sname;
		this.spwd = spwd;
		this.shead = shead;
		this.pid = pid;
		this.pname = pname;
		this.pphone = pphone;
		this.psite = psite;
		this.province = province;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getShead() {
		return shead;
	}
	public void setShead(String shead) {
		this.shead = shead;
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
		return "Sales [sid=" + sid + ", snumber=" + snumber + ", sname=" + sname + ", spwd=" + spwd + ", shead=" + shead
				+ ", pid=" + pid + ", pname=" + pname + ", pphone=" + pphone + ", psite=" + psite + ", province="
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
		result = prime * result + ((shead == null) ? 0 : shead.hashCode());
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((snumber == null) ? 0 : snumber.hashCode());
		result = prime * result + ((spwd == null) ? 0 : spwd.hashCode());
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
		Sales other = (Sales) obj;
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
		if (shead == null) {
			if (other.shead != null)
				return false;
		} else if (!shead.equals(other.shead))
			return false;
		if (sid != other.sid)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (snumber == null) {
			if (other.snumber != null)
				return false;
		} else if (!snumber.equals(other.snumber))
			return false;
		if (spwd == null) {
			if (other.spwd != null)
				return false;
		} else if (!spwd.equals(other.spwd))
			return false;
		return true;
	}
	
	
	
}
