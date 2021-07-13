package com.po;

public class Owners{
	
	private int ownerid;
	private String carowner;
	private String carnumber;
	private String phonenum;
	private String ownersex;
	private String memberid;//会员号 不重复
	

	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public String getCarowner() {
		return carowner;
	}
	public void setCarowner(String carowner) {
		this.carowner = carowner;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getOwnersex() {
		return ownersex;
	}
	public void setOwnersex(String ownersex) {
		this.ownersex = ownersex;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	
	
	public Owners(int ownerid, String carowner, String carnumber, String phonenum, String ownersex, String memberid) {
		this.ownerid = ownerid;
		this.carowner = carowner;
		this.carnumber = carnumber;
		this.phonenum = phonenum;
		this.ownersex = ownersex;
		this.memberid = memberid;
	}
	
	
	public Owners(String carowner, String carnumber, String phonenum, String ownersex, String memberid) {
		this.carowner = carowner;
		this.carnumber = carnumber;
		this.phonenum = phonenum;
		this.ownersex = ownersex;
		this.memberid = memberid;
	}
	
	public Owners() {
	}
	
	
}
