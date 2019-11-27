package entity;

public class CountData {
	private String allPrice;
	private String count;
	private String pname;
	public CountData(String allPrice, String count, String pname) {
		super();
		this.allPrice = allPrice;
		this.count = count;
		this.pname = pname;
	}
	public CountData() {
		super();
	}
	public String getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(String allPrice) {
		this.allPrice = allPrice;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "CountData [allPrice=" + allPrice + ", count=" + count + ", pname=" + pname + "]";
	}
	
	
}
