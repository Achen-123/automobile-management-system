package com.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.dao.CarStateDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.CarState;

public class CarStateAction {
	private String sid;
	private String located;
	public String carcond;
	public String carnumber;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
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
	
	//添加汽车维修状态
	public String addCarState() {
		
		//验证数据
		if(this.getCarnumber()==null || this.getCarnumber().equals("") || this.getCarcond()==null || this.getCarcond()==null || this.getCarcond().equals("") || this.getLocated()==null || this.getLocated().equals("")) {
			ActionContext.getContext().put("mess", "请将信息填完整！");
			return "carstateError";
		}
		CarState carstate = new CarState();
		CarStateDao carstatedao = new CarStateDao();
		//验证汽车信息是否已经存在
		String sql = "from CarState where carnumber='"+this.getCarnumber()+"'";
		List<CarState> carstatelist = carstatedao.getData(sql);
		if(carstatelist.size()>0) {
			ActionContext.getContext().put("mess", "汽车维修状态已经存在，如要更新，请进行修改状态");
			return "carstateError";
		}
		//添加信息
		carstate.setCarnumber(this.getCarnumber());
		carstate.setCarcond(this.getCarcond());
		carstate.setLocated(this.getLocated());
		
		if(!carstatedao.addState(carstate)) {
			ActionContext.getContext().put("mess", "添加不成功！");
			
			return "carstateError";
		}
		//将信息存入session
		ActionContext.getContext().getSession().put("carstate", carstate);
		ActionContext.getContext().put("mess", "信息添加成功！");
		return "carstateSuccess";
	}
	
	//查询全部维修状态的方法
	public String searchCarstate() {
		//创建List的集合,存储信息
		List<CarState> carstatelist = new ArrayList<CarState>();
		//创建dao对象
		CarStateDao carstatedao = new CarStateDao();
		//定义sql语句
		String sql = "select new CarState(located,carcond,carnumber) from CarState";
		//存储数据
		carstatelist = carstatedao.getData(sql);
		ActionContext.getContext().put("carstatelist", carstatelist);
		return "searchSuccess";
		
	}
	
	//修改汽车维修状态
	public String changeCarstate() {
		//验证数据（数据要填完整，订单号选填）
		if(this.getCarnumber()==null || this.getCarnumber().equals("") || this.getCarcond()==null || this.getCarcond().equals("") || this.getLocated()==null || this.getLocated().equals("")) {
			//存入信息
			ActionContext.getContext().put("mess", "车牌号,位置,汽车维修状态不能为空！");
			return "CarstateError";
		}
		//验证数据（车牌号是否存在于维修状态表里，在维修状态表里才可以进行修改）
		CarStateDao carstatedao = new CarStateDao();
		//定义sql语句
		String sql = "from CarState where carnumber='"+this.getCarnumber()+"'";
		List<CarState> carstatelist = carstatedao.getData(sql);
		
		if(carstatelist.size()<=0) {
			//存入信息
			ActionContext.getContext().put("mess", "该汽车不存在维修信息，请先进行添加！");
			return "CarstateError";
		}
		
		//进行更改维修状态信息(通过车牌号进行更新)
		//定义sql语句
		String sql1 = "Update CarState SET located='"+this.getLocated()+"',carcond='"+this.getCarcond()+"' where carnumber='"+this.getCarnumber()+"'";
		//执行语句
		 carstatedao.Updateordelete(sql1);
		 //添加信息
		 ActionContext.getContext().put("mess", "修改成功！");
		 return "CarstateSuccess";
	}
	
	//进行车牌号模糊查询
	public String searchCarnum() {
		//定义dao对象
		CarStateDao carstatedao = new CarStateDao();
		//定义sql语句
		String sql = "from CarState where carnumber like '%"+this.getCarnumber()+"%'";
		//定义list集合进行存储
		List<CarState> carstatelist = carstatedao.getData(sql);
		//存储
		ActionContext.getContext().put("carstatelist", carstatelist);
		
		return "searchSuccess";
		
		
	}
	
}
