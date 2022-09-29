package com.jang.biz.listPay;

public class ListPayVO {
	private int lpk;
	private String mid;
	private int ppk;
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getLpk() {
		return lpk;
	}
	public void setLpk(int lpk) {
		this.lpk = lpk;
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
}
