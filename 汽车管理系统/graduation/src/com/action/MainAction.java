package com.action;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Userinfo;
//������û�е�¼������½��������ҳ�棬���ǽ���ȥ����Ҫ��¼��������ǽ���������⣬���¼Ȼ����ܵ�����Ӧ�Ĺ���ģ��
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
	
	//��֤Ա����Ϣ����ģ���Ƿ��¼
	public String ifemployee() {
		
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		//�����Ƿ��й�����֤�Ƿ��¼
		if(userinfo.getNumber()==null) {
			return "loginError";
		}
		return "employeeSuccess";
	}
	//��֤ά�޳����������Ϣ����ģ���Ƿ��¼
	public String ifcar() {
		Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
		
		if(userinfo.getNumber()==null) {
			return "loginError";
		}
		return "carSuccess";
	}
	
	//��֤ά������״̬��Ϣģ���Ƿ��¼
		public String ifcondition() {
			Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
			
			if(userinfo.getNumber()==null) {
				return "loginError";
			}
			return "conditionSuccess";
		}
	
		
		//��֤ά����������Ϣ����ģ���Ƿ��¼
				public String ifowner() {
					Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
					
					if(userinfo.getNumber()==null) {
						return "loginError";
					}
					return "ownerSuccess";
				}
				
				
				
				
			//��֤������Ϣ����ģ���Ƿ��¼
				public String iforder() {
					Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
					
					if(userinfo.getNumber()==null) {
						return "loginError";
					}
					return "orderSuccess";
				}
	
	
	
	

}
