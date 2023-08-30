package com.amdoc.DAO;

public class DAO {
	private int pid;
	private String pname;
	private String Area;
	private float price;
	private String oName;
	private String bName;
	private String Sell;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}
	
	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbName() {
		return bName;
	}

	public void setSell(String Sell) {
		this.Sell = Sell;
	}
	
	public String getSell() {
		return Sell;
	}

}
/*
 * Pid int, PName varchar(10), PArea varchar(10), Price float, OwnerName
 * varchar(10), BuyerName varchar(10)
 */
