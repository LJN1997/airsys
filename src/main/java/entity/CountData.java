package entity;

public class CountData {
	private String allPrice;
	private String count;
	private String province;
	public CountData() {
		super();
	}
	public CountData(String allPrice, String count, String province) {
		super();
		this.allPrice = allPrice;
		this.count = count;
		this.province = province;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "CountData [allPrice=" + allPrice + ", count=" + count + ", province=" + province + "]";
	}

	
}
