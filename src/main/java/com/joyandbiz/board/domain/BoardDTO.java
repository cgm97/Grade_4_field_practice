package com.joyandbiz.board.domain;

import java.util.Date;

public class BoardDTO {
	private String con_div;
	private String con_no;
	private String con_title;
	private String con_txt;
	private String con_id;
	private String password;
	private int read_count;
	private String del_yn;
	private String reg_ip;
	private String reg_date;
	private String upd_date;
	
	public String getCon_div() {
		return con_div;
	}
	public void setCon_div(String con_div) {
		this.con_div = con_div;
	}
	public String getCon_no() {
		return con_no;
	}
	public void setCon_no(String con_no) {
		this.con_no = con_no;
	}
	public String getCon_title() {
		return con_title;
	}
	public void setCon_title(String con_title) {
		this.con_title = con_title;
	}
	public String getCon_txt() {
		return con_txt;
	}
	public void setCon_txt(String con_txt) {
		this.con_txt = con_txt;
	}
	public String getCon_id() {
		return con_id;
	}
	public void setCon_id(String con_id) {
		this.con_id = con_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getReg_ip() {
		return reg_ip;
	}
	public void setReg_ip(String reg_ip) {
		this.reg_ip = reg_ip;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}
}
