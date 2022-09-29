package com.jang.biz.product;

public class ProductVO {
	private int ppk;
	private String pname;
	private int price;
	public int getPpk() {
		return ppk;
	}
	public void setPpk(int ppk) {
		this.ppk = ppk;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductVO [ppk=" + ppk + ", pname=" + pname + ", price=" + price + "]";
	}
	
}
