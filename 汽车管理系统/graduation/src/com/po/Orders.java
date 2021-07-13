package com.po;

public class Orders {
	private int oid;
	private String carorder;//∂©µ•∫≈
	private String memberid;//ª·‘±∫≈
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getCarorder() {
		return carorder;
	}
	public void setCarorder(String carorder) {
		this.carorder = carorder;
	}

	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	public Orders() {
	}
	
	public Orders(int oid, String carorder,  String memberid) {
		this.oid = oid;
		this.carorder = carorder;
		this.memberid = memberid;
	}
	
	public Orders(String carorder, String memberid) {
		this.carorder = carorder;
		this.memberid = memberid;
	}
	
	
}
