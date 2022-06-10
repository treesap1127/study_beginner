package kr.ac.kopo.assignment.util;

public class Search {
	private float total;//토탈값은 특수하게 합계로 계산하는 값!
	private int search=0; // 찾는 값
	private String keyword; //특수하게 받아주는 값

	public int getSearch() {
		return search;
	}
	public void setSearch(int search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getQuery() {
		if(search<1)
			return null;
		return "&search="+search+"&keyword="+keyword;
	}
}
