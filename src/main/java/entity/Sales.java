package entity;

public class Sales {
	private int sid;
	private String snumber;
	private String sname;
	private String spwd;
	private String shead;
	private int pid;
	public Sales() {
		super();
	}
	
	public Sales(int sid) {
		super();
		this.sid = sid;
	}

	public Sales(String snumber) {
		super();
		this.snumber = snumber;
	}
	
	public Sales(String snumber, String sname, String spwd, int pid) {
		super();
		this.snumber = snumber;
		this.sname = sname;
		this.spwd = spwd;

		this.pid = pid;
	}

	public Sales(int sid, String snumber, String sname, String spwd, String shead, int pid) {
		super();
		this.sid = sid;
		this.snumber = snumber;
		this.sname = sname;
		this.spwd = spwd;
		this.shead = shead;
		this.pid = pid;
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
	@Override
	public String toString() {
		return "Sales [sid=" + sid + ", snumber=" + snumber + ", sname=" + sname + ", spwd=" + spwd + ", shead=" + shead
				+ ", pid=" + pid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pid;
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
