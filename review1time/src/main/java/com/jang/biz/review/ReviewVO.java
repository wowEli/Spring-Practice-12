package com.jang.biz.review;

public class ReviewVO {
	private int rpk;
	private String title;
	private String content;
	private String mid;
	private int ppk;
	
	public int getRpk() {
		return rpk;
	}
	public void setRpk(int rpk) {
		this.rpk = rpk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getPpk() {
		return ppk;
	}
	public void setPpk(int ppk) {
		this.ppk = ppk;
	}
	@Override
	public String toString() {
		return "ReviewVO [rpk=" + rpk + ", title=" + title + ", content=" + content + ", mid=" + mid + ", ppk=" + ppk
				+ "]";
	}
	
}
