package entity;

public class Ticket {
		private int tid;
		private int planId;
		private int uid;
		private int sid;
	
       private String snumber;
	
       private int oid;
		private String oname;
		private String ophone;
		private String idcard;
		private String tdate;
		private String tclass;
		private String passengerType;
		private double tprice;
		private int status;
		
       public Ticket() {
			super();
		}
		
       
       
		public Ticket(int tid, int planId, int uid, int sid, int status, String snumber, int oid, String oname,
			String ophone, String idcard, String tdate, String tclass, String passengerType, double tprice) {
		super();
		this.tid = tid;
		this.planId = planId;
		this.uid = uid;
		this.sid = sid;
		this.status = status;
		this.snumber = snumber;
		this.oid = oid;
		this.oname = oname;
		this.ophone = ophone;
		this.idcard = idcard;
		this.tdate = tdate;
		this.tclass = tclass;
		this.passengerType = passengerType;
		this.tprice = tprice;
	}



	

		public Ticket(int planId, int uid, int sid,String tclass, String passengerType,
				double tprice, int status, String idcard) {
			super();
			this.planId = planId;
			this.uid = uid;
			this.sid = sid;
			this.tclass = tclass;
			this.passengerType = passengerType;
			this.tprice = tprice;
			this.status = status;
			this.idcard = idcard;
		}

		public Ticket(int tid, int planId, int uid, int sid, String tdate, String tclass, String passengerType,
				double tprice, int status, String idcard, String snumber) {
			super();
			this.tid = tid;
			this.planId = planId;
			this.uid = uid;
			this.sid = sid;
			this.tdate = tdate;
			this.tclass = tclass;
			this.passengerType = passengerType;
			this.tprice = tprice;
			this.status = status;
			this.idcard = idcard;
			this.snumber = snumber;
		}

		public int getTid() {
			return tid;
		}

		public void setTid(int tid) {
			this.tid = tid;
		}

		public int getPlanId() {
			return planId;
		}

		public void setPlanId(int planId) {
			this.planId = planId;
		}

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

		public int getSid() {
			return sid;
		}

		public void setSid(int sid) {
			this.sid = sid;
		}

		public String getTdate() {
			return tdate;
		}

		public void setTdate(String tdate) {
			this.tdate = tdate;
		}

		public String getTclass() {
			return tclass;
		}

		public void setTclass(String tclass) {
			this.tclass = tclass;
		}

		public String getPassengerType() {
			return passengerType;
		}

		public void setPassengerType(String passengerType) {
			this.passengerType = passengerType;
		}

		public double getTprice() {
			return tprice;
		}

		public void setTprice(double tprice) {
			this.tprice = tprice;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getIdcard() {
			return idcard;
		}

		public void setIdcard(String idcard) {
			this.idcard = idcard;
		}

		public String getSnumber() {
			return snumber;
		}

		public void setSnumber(String snumber) {
			this.snumber = snumber;
		}

		public int getOid() {
			return oid;
		}



		public void setOid(int oid) {
			this.oid = oid;
		}



		public String getOname() {
			return oname;
		}



		public void setOname(String oname) {
			this.oname = oname;
		}



		public String getOphone() {
			return ophone;
		}



		public void setOphone(String ophone) {
			this.ophone = ophone;
		}



		@Override
		public String toString() {
			return "Ticket [tid=" + tid + ", planId=" + planId + ", uid=" + uid + ", sid=" + sid + ", status=" + status
					+ ", snumber=" + snumber + ", oid=" + oid + ", oname=" + oname + ", ophone=" + ophone + ", idcard="
					+ idcard + ", tdate=" + tdate + ", tclass=" + tclass + ", passengerType=" + passengerType
					+ ", tprice=" + tprice + "]";
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idcard == null) ? 0 : idcard.hashCode());
			result = prime * result + ((passengerType == null) ? 0 : passengerType.hashCode());
			result = prime * result + planId;
			result = prime * result + sid;
			result = prime * result + ((snumber == null) ? 0 : snumber.hashCode());
			result = prime * result + status;
			result = prime * result + ((tclass == null) ? 0 : tclass.hashCode());
			result = prime * result + ((tdate == null) ? 0 : tdate.hashCode());
			result = prime * result + tid;
			long temp;
			temp = Double.doubleToLongBits(tprice);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			Ticket other = (Ticket) obj;
			if (idcard == null) {
				if (other.idcard != null)
					return false;
			} else if (!idcard.equals(other.idcard))
				return false;
			if (passengerType == null) {
				if (other.passengerType != null)
					return false;
			} else if (!passengerType.equals(other.passengerType))
				return false;
			if (planId != other.planId)
				return false;
			if (sid != other.sid)
				return false;
			if (snumber == null) {
				if (other.snumber != null)
					return false;
			} else if (!snumber.equals(other.snumber))
				return false;
			if (status != other.status)
				return false;
			if (tclass == null) {
				if (other.tclass != null)
					return false;
			} else if (!tclass.equals(other.tclass))
				return false;
			if (tdate == null) {
				if (other.tdate != null)
					return false;
			} else if (!tdate.equals(other.tdate))
				return false;
			if (tid != other.tid)
				return false;
			if (Double.doubleToLongBits(tprice) != Double.doubleToLongBits(other.tprice))
				return false;
			if (uid != other.uid)
				return false;
			return true;
		}

	
		
		
}
