package com.action;

import java.util.ArrayList;
import java.util.List;

import com.dao.CarDao;
import com.dao.OrderDao;
import com.dao.OwnerDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Car;
import com.po.Orders;
import com.po.Owners;

public class OrderAction {
	private int oid;
	private String carorder;
	private String memberid;
	
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
	
	//添加订单的信息
	public String addInformation() {
		//验证数据
		if(this.getCarorder()==null || this.getCarorder().equals("") ||  this.getMemberid()==null || this.getMemberid().equals("")) {
			ActionContext.getContext().put("mess", "请将信息填完整！");
			return "addError";
		}
//		//验证数据（验证车牌号是否存在，不存在先要添加车辆信息）
//		Car car = new Car();
//		CarDao cardao = new CarDao();
//		List<Car> listcar = new ArrayList<Car>();
//		//定义sql语句
//		String sql ="from Car where carnumber='"+this.getCarnumber()+"'";
//		listcar = cardao.getData(sql);
//		if(listcar.size()<=0) {
//			ActionContext.getContext().put("mess", "车辆信息不存在，请添加车辆信息！");
//			return "addError";
//		}
		//验证数据（验证会员号是否存在，不存在先添加会员信息）
		Owners onwers = new Owners();
		OwnerDao ownerdao = new OwnerDao();
		List<Owners> listowners = new ArrayList<Owners>();
		//定义sql语句
		String sql1 = "from Owners where memberid='"+this.getMemberid()+"'";
		listowners = ownerdao.getOwnersData(sql1);
		if(listowners.size()<=0) {
			ActionContext.getContext().put("mess", "会员号不存在，请添加车主信息！");
			return "addError";
		}
		
		//验证数据（验证数据库中是否已经存在该订单号，存在着不能添加，更新只能进行修改）
		Orders order = new Orders();
		OrderDao orderdao = new OrderDao();
		List<Orders> listorder = new ArrayList<Orders>();
		//定义sql语句
		String sql2 = "from Orders where carorder='"+this.getCarorder()+"'";
		listorder = orderdao.getData(sql2);
		if(listorder.size()>0) {
			ActionContext.getContext().put("mess", "订单信息已经存在，要修改请将点击修改信息！");
			return "addError";
		}
		
		//添加信息
		order.setCarorder(this.getCarorder());
		order.setMemberid(this.getMemberid());
		if(!orderdao.addOrders(order)) {
			ActionContext.getContext().put("mess", "添加信息失败！");
			return "addError";
		}
		
		//存入session
		ActionContext.getContext().getSession().put("orders",order);
		ActionContext.getContext().put("mess", "添加成功");
		return "addSuccess";
		
	}
	
	//查询全部订单信息
	public String searchAll() {
		//创建orderdao
		Orders order = new Orders();
		OrderDao orderdao = new OrderDao();
		//定义sql语句
		String sql = "select new Orders(carorder,memberid) from Orders";
		//存储信息
		List<Orders> orderlist = orderdao.getData(sql);
		//jsp页面用iterator
		ActionContext.getContext().put("orderlist", orderlist);
		return "searchSuccess";
	}
	
	//修改或者删除订单信息
	public String Updateordelete() {
		//验证数据
		if(this.getCarorder()==null || this.getCarorder().equals("") ||  this.getMemberid()==null || this.getMemberid().equals("")) {
			ActionContext.getContext().put("mess", "请将信息填完整！");
			return "updateError";
		}
		
		//验证数据（验证会员号是否存在，不存在先添加会员信息）
			Owners onwers = new Owners();
			OwnerDao ownerdao = new OwnerDao();
			List<Owners> listowners = new ArrayList<Owners>();
			//定义sql语句
			String sql1 = "from Owners where memberid='"+this.getMemberid()+"'";
			listowners = ownerdao.getOwnersData(sql1);
			if(listowners.size()<=0) {
				ActionContext.getContext().put("mess", "会员号不存在，请添加车主信息！");
				return "updateError";
			}
			
			//验证数据（验证数据库中是否已经存在该订单号，不存在则不能进行修改，要先进行添加）
			Orders order = new Orders();
			OrderDao orderdao = new OrderDao();
			List<Orders> listorder = new ArrayList<Orders>();
			//定义sql语句
			String sql2 = "from Orders where carorder='"+this.getCarorder()+"'";
			listorder = orderdao.getData(sql2);
			if(listorder.size()<=0) {
				ActionContext.getContext().put("mess", "订单信息不存在，请先进行添加！");
				return "updateError";
			}
			
			//定义sql语句（通过订单号来修改会员号）
			String sql="update Orders SET memberid='"+this.getMemberid()+"' where carorder='"+this.getCarorder()+"'";
			//执行语句
			orderdao.Updateordelete(sql);
			ActionContext.getContext().put("mess", "修改成功！");
			return "updateSuccess";	
	}
	
	//模糊查询订单信息
	public String vaguequery() {
		//创建orderdao对象
		OrderDao orderdao = new OrderDao();
		//定义sql语句
		String sql ="from Orders where carorder like '%"+this.getCarorder()+"%'";
		//定义一个list集合
		List<Orders> orderlist = orderdao.getData(sql);
		ActionContext.getContext().put("orderlist", orderlist);
		
		return "querySuccess";
		
		
	}
	
	//删除订单
	public String Deleteorder() {
		//创建OrderDao对象
		OrderDao orderdao = new OrderDao();
		//定义sql语句
		String sql ="delete from Orders where carorder='"+this.getCarorder()+"'";
		orderdao.Updateordelete(sql);
		//添加数据
		ActionContext.getContext().put("mess", "删除成功！");
		return "DeleteSuccess";
	}
}
