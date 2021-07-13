package com.action;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Userinfo;
//可以在没有登录的情况下进入管理主页面，但是接下去就需要登录，本类就是解决该类问题，需登录然后才能到达相应的功能模块
public class MainAction {
	private String username;
	private String number;
	private String pwd;
	private String pwd1;
	private String sex;
	private String department;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	//验证员工信息管理模块是否登录
	public String ifemployee() {
		
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		//利用是否有工号验证是否登录
		if(userinfo.getNumber()==null) {
			return "loginError";
		}
		return "employeeSuccess";
	}
	//验证维修车辆出入店信息管理模块是否登录
	public String ifcar() {
		Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
		
		if(userinfo.getNumber()==null) {
			return "loginError";
		}
		return "carSuccess";
	}
	
	//验证维修汽车状态信息模块是否登录
		public String ifcondition() {
			Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
			
			if(userinfo.getNumber()==null) {
				return "loginError";
			}
			return "conditionSuccess";
		}
	
		
		//验证维汽车车主信息管理模块是否登录
				public String ifowner() {
					Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
					
					if(userinfo.getNumber()==null) {
						return "loginError";
					}
					return "ownerSuccess";
				}
				
				
				
				
			//验证订单信息管理模块是否登录
				public String iforder() {
					Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
					
					if(userinfo.getNumber()==null) {
						return "loginError";
					}
					return "orderSuccess";
				}
	
	
	
	

}
