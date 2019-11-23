package entity;

import java.io.Serializable;

/**
 * 用户
 * @author Administrator
 */
public class User implements Serializable  {
	private int uid;
	private String uname;
	private String upwd;
	private String idcard;
	private String uphone;
	private String uhead;
	public  User() {}
	public User(int uid, String uname, String upwd, String idcard, String uphone, String uhead) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.idcard = idcard;
		this.uphone = uphone;
		this.uhead = uhead;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUhead() {
		return uhead;
	}
	public void setUhead(String uhead) {
		this.uhead = uhead;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", idcard=" + idcard + ", uphone=" + uphone
				+ ", uhead=" + uhead + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcard == null) ? 0 : idcard.hashCode());
		result = prime * result + ((uhead == null) ? 0 : uhead.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((uphone == null) ? 0 : uphone.hashCode());
		result = prime * result + ((upwd == null) ? 0 : upwd.hashCode());
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
		User other = (User) obj;
		if (idcard == null) {
			if (other.idcard != null)
				return false;
		} else if (!idcard.equals(other.idcard))
			return false;
		if (uhead == null) {
			if (other.uhead != null)
				return false;
		} else if (!uhead.equals(other.uhead))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (uphone == null) {
			if (other.uphone != null)
				return false;
		} else if (!uphone.equals(other.uphone))
			return false;
		if (upwd == null) {
			if (other.upwd != null)
				return false;
		} else if (!upwd.equals(other.upwd))
			return false;
		return true;
	}
	
	

}
