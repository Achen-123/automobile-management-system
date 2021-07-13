package com.po;

public class CarState {
	
	private int sid;
	private String located;
	private String carcond;//Î¬ÐÞ×´Ì¬
	private String carnumber;
	
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getLocated() {
		return located;
	}
	public void setLocated(String located) {
		this.located = located;
	}
	public String getCarcond() {
		return carcond;
	}
	public void setCarcond(String carcond) {
		this.carcond = carcond;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public CarState(int sid, String located, String carcond, String carnumber) {
		this.sid = sid;
		this.located = located;
		this.carcond = carcond;
		this.carnumber = carnumber;
	}
	
	public CarState() {
		
	}
	public CarState(String located, String carcond, String carnumber) {
		this.located = located;
		this.carcond = carcond;
		this.carnumber = carnumber;
	}
	
	
	
}
