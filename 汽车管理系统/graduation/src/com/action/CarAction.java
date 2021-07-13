package com.action;

import java.util.List;

import com.dao.CarDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Car;

public class CarAction {
//添加属性
	private String carname;
	private String carnumber;//车牌号
	private String carcolor;
	private String carorder;
	
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getCarorder() {
		return carorder;
	}
	public void setCarorder(String carorder) {
		this.carorder = carorder;
	}
	
	
	

	//添加店内维修车辆信息的方法
	public String addCarinformation(){
		//验证数据（订单不写，因为一辆车可以有多个订单）
		if(this.getCarnumber()==null || this.getCarnumber().equals("") ||   this.getCarname()==null || this.getCarname().equals("") || this.getCarcolor()==null || this.getCarcolor().equals("") ) {
			ActionContext.getContext().put("mess", "请将信息填完整！");
			
			return "addError";
		}	
		//连接数据库验证这辆车信息是否已经存在数据库中
		CarDao cardao = new CarDao();
		//定义sql
		String sql = "from Car where carnumber ='"+this.getCarnumber()+"'";
		List<Car> listcar = cardao.getData(sql);
		if(listcar.size()>0) {
			ActionContext.getContext().put("mess", "该车辆的信息已经存在！");
			return "addError";
		}
		
		//将数据存入
		Car car = new Car();
		car.setCarnumber(this.getCarnumber());
		car.setCarname(this.getCarname());
		car.setCarcolor(this.getCarcolor());
		
		
		//验证是否插入成功
		if(!cardao.carAdd(car)) {
			ActionContext.getContext().put("mess", "信息添加不成功");
			
			return "addError";
		}
		
		//将信息存入session中
		ActionContext.getContext().getSession().put("car", car);
		return "addSuccess";
	}
	
	
	//查询店内全部维修车辆信息
	public String searchAllcar() {
		//创建cardao对象
		CarDao cardao = new CarDao();
		//定义sql语句
		String sql = " select new Car(carname,carnumber,carcolor,carorder) from Car";
		List<Car> carlist = cardao.getData(sql);
		//存入（在jsp页面用struts的迭代器来全部取出）
		ActionContext.getContext().put("carlist", carlist);
		
		return "searchSuccess";
	}
	
	//修改维修车辆信息
	public String carInformationchange() {
		//验证数据（数据填完整)
		if(this.getCarnumber()==null || this.getCarnumber().equals("") ||   this.getCarname()==null || this.getCarname().equals("") || this.getCarcolor()==null || this.getCarcolor().equals("") ) {
			ActionContext.getContext().put("mess", "请将信息填完整！");
			
			return "addinformError";
		}
		CarDao cardao = new CarDao();
		//验证数据（是否存在该车辆的信息，存在才可以修改）
		//定义sql语句（如果是int的字段值是"from Car where carnumber="+this.getCarnumber()）
		String sql = "from Car where carnumber='"+this.getCarnumber()+"'";
		List<Car> carlist = cardao.getData(sql);
		if(carlist.size()<=0) {
			ActionContext.getContext().put("mess", "没有该车的信息，请先添加！");
			return "addinformError";
		}
		//定义sql语句（注意大小写）
		String sql1 = "Update Car SET carname='"+this.getCarname()+"',carcolor='"+this.getCarcolor()+"' where carnumber='"+this.getCarnumber()+"'";
		//执行sql语句
		cardao.deleteorUpdateCar(sql1);
		ActionContext.getContext().put("mess", "修改成功");
		return "addinformSuccess";
		
	}
	
	//车牌号的模糊查询
	public String searchcarnumber() {
		CarDao cardao = new CarDao();
		//定义sql语句
		String sql = "  from Car where carnumber like '%"+this.getCarnumber()+"%'";
		//数据存入集合中
		List<Car> carlist = cardao.getData(sql);
		//数据存入
		ActionContext.getContext().put("carlist", carlist);
		
		return "searchSuccess";
	}
}
