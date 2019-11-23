package entity;

import java.io.Serializable;

public class Order implements Serializable  {
	private int oid;
	private int sid;
	private int uid;
	private String idcard;
	private String ophone;
	private String oname;
	public Order() {
		super();
	}
	
	public Order( int sid, int uid, String idcard, String ophone, String oname) {
		super();
	
		this.sid = sid;
		this.uid = uid;
		this.idcard = idcard;
		this.ophone = ophone;
		this.oname = oname;
	}
	
	public Order(int oid, int sid, int uid, String idcard, String ophone, String oname) {
		super();
		this.oid = oid;
		this.sid = sid;
		this.uid = uid;
		this.idcard = idcard;
		this.ophone = ophone;
		this.oname = oname;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", sia=" + sid + ", uid=" + uid + ", idcard=" + idcard + ", ophone=" + ophone
				+ ", oname=" + oname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcard == null) ? 0 : idcard.hashCode());
		result = prime * result + oid;
		result = prime * result + ((oname == null) ? 0 : oname.hashCode());
		result = prime * result + ((ophone == null) ? 0 : ophone.hashCode());
		result = prime * result + sid;
		result = prime * result + uid;
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
		Order other = (Order) obj;
		if (idcard == null) {
			if (other.idcard != null)
				return false;
		} else if (!idcard.equals(other.idcard))
			return false;
		if (oid != other.oid)
			return false;
		if (oname == null) {
			if (other.oname != null)
				return false;
		} else if (!oname.equals(other.oname))
			return false;
		if (ophone == null) {
			if (other.ophone != null)
				return false;
		} else if (!ophone.equals(other.ophone))
			return false;
		if (sid != other.sid)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	
	
}
