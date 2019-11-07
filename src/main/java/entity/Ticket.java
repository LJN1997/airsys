package entity;

public class Ticket {
		private int tid;
		private int fid;
		private int uid;
		private int sid;
		private String tdate;
		private String tclass;
		private String passenger_type;
		private double tprice;
		public Ticket() {
			super();
		}
		public Ticket(int tid, int fid, int uid, int sid, String tdate, String tclass, String passenger_type,
				double tprice) {
			super();
			this.tid = tid;
			this.fid = fid;
			this.uid = uid;
			this.sid = sid;
			this.tdate = tdate;
			this.tclass = tclass;
			this.passenger_type = passenger_type;
			this.tprice = tprice;
		}
		public int getTid() {
			return tid;
		}
		public void setTid(int tid) {
			this.tid = tid;
		}
		public int getFid() {
			return fid;
		}
		public void setFid(int fid) {
			this.fid = fid;
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
		public String getPassenger_type() {
			return passenger_type;
		}
		public void setPassenger_type(String passenger_type) {
			this.passenger_type = passenger_type;
		}
		public double getTprice() {
			return tprice;
		}
		public void setTprice(double tprice) {
			this.tprice = tprice;
		}
		@Override
		public String toString() {
			return "Ticket [tid=" + tid + ", fid=" + fid + ", uid=" + uid + ", sid=" + sid + ", tdate=" + tdate
					+ ", tclass=" + tclass + ", passenger_type=" + passenger_type + ", tprice=" + tprice + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + fid;
			result = prime * result + ((passenger_type == null) ? 0 : passenger_type.hashCode());
			result = prime * result + sid;
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
			if (fid != other.fid)
				return false;
			if (passenger_type == null) {
				if (other.passenger_type != null)
					return false;
			} else if (!passenger_type.equals(other.passenger_type))
				return false;
			if (sid != other.sid)
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
