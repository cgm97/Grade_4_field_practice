package com.joyandbiz.board.domain;

public class SearchDTO { ////////////////////////////// 현재 사용 X -> SearchCriteria로 전환 사용중
	private String search_option;
	private String keyword;
	private String con_div;
	
	public String getSearch_option() {
		return search_option;
	}
	public void setSearch_option(String search_option) {
		this.search_option = search_option;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCon_div() {
		return con_div;
	}
	public void setCon_div(String con_div) {
		this.con_div = con_div;
	}
	@Override
	public String toString() {
		return "SearchDTO [search_option=" + search_option + ", keyword=" + keyword + ", con_div=" + con_div + "]";
	}
}
