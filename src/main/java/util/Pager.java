package util;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> extends ArrayList<T>{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<T> data;//数据
	private int pageNum;//总页数
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
