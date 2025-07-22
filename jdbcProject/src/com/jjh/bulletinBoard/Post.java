package com.jjh.bulletinBoard;

import java.sql.Date;

public class Post {
	// 필드
	private int pnum;
	private String title;
	private String name;
	private Date pdate;
	private int pgood;
	private int pview;
	
	// 생성자
	// 메소드
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getPgood() {
		return pgood;
	}
	public void setPgood(int pgood) {
		this.pgood = pgood;
	}
	public int getPview() {
		return pview;
	}
	public void setPview(int pview) {
		this.pview = pview;
	}
	
}// end class
