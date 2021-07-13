package com.action;

import java.util.List;

import com.dao.CarDao;
import com.dao.OwnerDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Car;
import com.po.Owners;

public class OwnerAction {
	
	private int ownerid;
	private String carowner;
	private String carnumber;
	private String phonenum;
	private String ownersex;
	private String memberid;
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
	
	//添加车主信息
	
	public String Addinformation() {
		//验证数据
		if(this.getCarowner()==null || this.getCarowner().equals("") || this.getCarnumber()==null || this.getCarnumber().equals("") || this.getOwnersex()==null || this.getOwnersex().equals("") || this.getPhonenum()==null || this.getPhonenum().equals("")) {
			ActionContext.getContext().put("mess", "请将信息填完整！");
			return "addownerError";
		}
		//验证数据（车主信息是否存在，存在着不能添加）
		Owners owners = new Owners(); 
		OwnerDao ownerdao = new OwnerDao();
		//定义sql语句
		String sql = "from Owners where memberid='"+this.getMemberid()+"'";
		//执行存储数据
		List<Owners> ownerslist = ownerdao.getOwnersData(sql);
		
		if(ownerslist.size()>0) {
			ActionContext.getContext().put("mess", "车主信息已经存在，如要修改，请点击修改信息！");
			return "addownerError";
		}
		//验证数据（车辆信息是否存在，不存在则无法添加车主信息）
		CarDao cardao = new CarDao();
		//定义sql语句
		String sql1 = "from Car where carnumber='"+this.getCarnumber()+"'";
		List<Car> carlist = cardao.getData(sql1);
		if(carlist.size()<=0) {
			ActionContext.getContext().put("mess", "车牌号不存在！请先添加车辆信息");
			return "addownerError";
		}
		
		owners.setMemberid(this.getMemberid());
		owners.setCarnumber(this.getCarnumber());
		owners.setCarowner(this.getCarowner());
		owners.setOwnersex(this.getOwnersex());
		owners.setPhonenum(this.getPhonenum());
		
		//验证是否添加成功
		if(!ownerdao.addOwners(owners)) {
			ActionContext.getContext().put("mess", "添加不成功！");
			return "addownerError";
		}
		
		ActionContext.getContext().getSession().put("owners", owners);
		ActionContext.getContext().put("mess", "添加成功");
		return "addownerSuccess";
		
	}
	
	
	//查询全部车主的信息
	public String searchInformation() {
		//创建ownerdao
		OwnerDao ownerdao = new OwnerDao();
		//定义sql语句
		String sql = "select new Owners(carowner,carnumber,phonenum,ownersex,memberid) from Owners";
		//存储信息
		List<Owners> ownerlist = ownerdao.getOwnersData(sql);
		//jsp页面用iterator
		ActionContext.getContext().put("ownerlist", ownerlist);
		return "searchSuccess";
	}
	
	//更新或者删除车主信息
	public String Updateordelete() {
		//验证数据（不能为空）
		if(this.getCarnumber()==null || this.getCarnumber().equals("") || this.getMemberid()==null || this.getMemberid().equals("") || this.getCarowner()==null || this.getCarowner().equals("") || this.getOwnersex()==null || this.getOwnersex().equals("") || this.getPhonenum()==null || this.getPhonenum().equals("")) {
			ActionContext.getContext().put("mess", "请将信息填完整！");
			return "updateError";
		}
		//验证数据（会员号信息是否存在，不存在则要先进行添加）
		OwnerDao ownerdao = new OwnerDao();
		//定义sql语句
		String sql = "from Owners where memberid='"+this.getMemberid()+"'";
		//执行语句
		List<Owners> list = ownerdao.getOwnersData(sql);
		if(list.size()<=0) {
			ActionContext.getContext().put("mess", "请先添加该车主信息！");
			return "updateError";
		}
		//验证数据（车牌号是否存在，不存在先添加车辆信息）
		String sql1 = "from Car where carnumber='"+this.getCarnumber()+"'";
		CarDao cardao = new CarDao();
		List<Car> carlist = cardao.getData(sql1);
		if(carlist.size()<=0) {
			ActionContext.getContext().put("mess", "车牌号不存在！请先添加车辆信息");
			return "updateError";
		}
		//定义sql语句（会员号不变，修改更新其他的）
		String sql2 = "Update Owners SET carowner='"+this.getCarowner()+"',carnumber='"+this.getCarnumber()+"',phonenum='"+this.getPhonenum()+"',ownersex='"+this.getOwnersex()+"' where memberid='"+this.getMemberid()+"'";
		//执行语句
		ownerdao.Updateordelete(sql2);
		ActionContext.getContext().put("mess", "修改成功！");
		return "updateSuccess";
	}
	
	//按名字来查询车主信息
	public String searchOwner() {
		//创建对象
		Owners owners = new Owners();
		OwnerDao ownerdao = new OwnerDao();
		//定义sql语句
		String sql = "from Owners where carowner like '%"+this.getCarowner()+"%'";
		List<Owners> ownerlist = ownerdao.getOwnersData(sql);
		ActionContext.getContext().put("ownerlist", ownerlist);
		return "searchSuccess";
	}
}
