package entity;
/**
* 
*
* @author DanyangLi
*/
public class aa {
		private int id;
		private String name;
		private String price;
		public aa(String name, String price) {
			super();
			this.name = name;
			this.price = price;
		}
		public aa() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "aa [id=" + id + ", name=" + name + ", price=" + price + "]";
		}
		
}
