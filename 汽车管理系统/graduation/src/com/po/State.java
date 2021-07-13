package com.po;

public class State {
	private int  snum;
	private String scondition;
	private String number;
	
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getScondition() {
		return scondition;
	}
	public void setScondition(String scondition) {
		this.scondition = scondition;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public State() {
	}
	
	
	public State(int snum, String scondition,String number) {
		this.snum = snum;
		this.scondition = scondition;
		
		this.number = number;
	}
	
	public State(String scondition, String number) {
		this.scondition = scondition;
		this.number = number;
	}
	
	public State(String number) {
		this.number = number;
	}
	
	
	
}
