package com.po;

public class Car {
	private int cid;
	private String carname;
	private String carnumber;//³µÅÆºÅ
	private String carcolor;
	private String carorder;
	

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getCarorder() {
		return carorder;
	}
	public void setCarorder(String carorder) {
		this.carorder = carorder;
	}
	
	public Car() {
	}
	
	
	public Car(int cid, String carname, String carnumber,  String carcolor, String carorder) {
		this.cid = cid;
		this.carname = carname;
		this.carnumber = carnumber;
		this.carcolor = carcolor;
		this.carorder = carorder;
	}
	
	public Car(String carname, String carnumber,  String carcolor, String carorder) {
		this.carname = carname;
		this.carnumber = carnumber;
		this.carcolor = carcolor;
		this.carorder = carorder;
	}
	
	
	
	
}
