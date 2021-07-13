package com.po;

public class Userinfo {
	
	private int id;
	private String username;
	private String number;
	private String pwd;
	private String sex;
	private String department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUsername() {
		return username;
	}
	public String getPwd() {
		return pwd;
	}
	public String getSex() {
		return sex;
	}
	public String getDepartment() {
		return department;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public Userinfo() {//无参构造方法
		
	}
	
	public Userinfo(String username, String number, String pwd) {
		this.username = username;
		this.number = number;
		this.pwd = pwd;
		
	}
	
	public Userinfo(int id, String username, String number, String pwd, String sex, String department) {
		this.id = id;
		this.username = username;
		this.number = number;
		this.pwd = pwd;
		this.sex = sex;
		this.department = department;
	}
	public Userinfo(int id ,String username, String number, String sex, String department) {
		this.id=id;
		this.username = username;
		this.number = number;
		this.sex = sex;
		this.department = department;
	}
	
	public Userinfo(String number) {
		this.number = number;
	}
	
	
	public Userinfo(String username, String number, String sex, String department) {
		this.username = username;
		this.number = number;
		this.sex = sex;
		this.department = department;
	}
	@Override
	public String toString() {
		return "Userinfo [number=" + number + "]";
	}
	
	
	
}
