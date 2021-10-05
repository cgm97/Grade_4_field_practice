package com.joyandbiz.board;

public class SearchCriteria extends Criteria{ // ���x
	
	private String searchType = "";
	private String keyword = "";
	/* private String con_div; */
	
	public SearchCriteria(String searchType, String keyword) {
		this.searchType = searchType;
		this.keyword = keyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/*
	 * public String getCon_div() { return con_div; } public void setCon_div(String
	 * con_div) { this.con_div = con_div; }
	 */
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}
