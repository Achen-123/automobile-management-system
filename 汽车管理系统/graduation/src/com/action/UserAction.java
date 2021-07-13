package com.action;

import java.util.List;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.State;
import com.po.Userinfo;

public class UserAction {
	private String username;
	private String number;
	private String pwd;
	private String pwd1;
	private String sex;
	private String department;
	private int snum;
	private String scondition;
	
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
	//	注册方法
	public String reg() {
	//验证数据
	if(this.getUsername()==null || this.getUsername().equals("") || this.getNumber()==null || this.getNumber().equals("")
		|| this.getPwd()==null || this.getPwd().equals("") || this.getPwd1()==null || this.getPwd1().equals("")
		|| this.getSex()==null || this.getSex().equals("") || this.getDepartment()==null ||this.getDepartment().equals("")) {
		ActionContext.getContext().put("mess", "不能为空！");
		return "regError";
	}
	if(!this.pwd.equals(this.pwd1)) {
		ActionContext.getContext().put("mess", "密码不一致！");
		return "regError";
	}
	
	//连接数据库，验证该数据是否已经存在
	String sql = "from Userinfo where number='"+this.number+"'";
	UserDao userDao = new UserDao();
	if(userDao.getData(sql).size()>0) {
		ActionContext.getContext().put("mess","该工号已经存在！");
		return "regError";
	}
	
	Userinfo userinfo = new Userinfo();
	userinfo.setNumber(this.getNumber());
	userinfo.setUsername(this.getUsername());
	userinfo.setPwd(this.getPwd());
	userinfo.setDepartment(this.getDepartment());
	userinfo.setSex(this.getSex());
	if(!userDao.applyUser(userinfo)) {
		ActionContext.getContext().put("mess","注册失败！，请联系管理人员");
		return "regError";
	}
	//将注册成功的用户信息存储到userinfo中
	ActionContext.getContext().put("userinfo", userinfo);
	ActionContext.getContext().put("mess", "注册成功");
	return "regSuccess";
	}
	
	//登录方法
	public String login() {
		//验证数据（姓名和工号不能为空）
		if(this.getUsername()==null || this.getUsername().equals("") || this.getNumber()==null || this.getNumber().equals("")) {
			
			ActionContext.getContext().put("mess","姓名和工号不能为空！");
			return "loginError";
		}
		//登录
		String sql = "from Userinfo where username='"+this.username+"' and number='"+this.number+"' and pwd='"+this.pwd+"'";
		UserDao userdao = new UserDao();
		//获取数据库中全部的值
		List<Userinfo> list = userdao.getData(sql);
		if(list.size()==0) {
			ActionContext.getContext().put("mess", "姓名或工号或密码不正确！");
			
			return "loginError";
		}
//		//查询部门(对工号设置唯一索引)（不实现）
//		String sql1 = "select department from Userinfo where department='"+this.number+"'";
//		//list集合Userinfo泛型
//		List<Userinfo> list = userdao.getData(sql1);
//		System.out.println(list);
		//将数据存入po层
//		Userinfo userinfo = new Userinfo(this.getUsername(),this.getNumber(),this.getPwd());
		
		//将值全部存入session中
		ActionContext.getContext().getSession().put("userinfo",list.get(0));
		return "loginSuccess";
	}
	
	//注销方法
	public String logout() {
		ActionContext.getContext().getSession().clear();
		return "logoutSuccess";
	}
	
	//显示员工信息
	public String showWorker() {
		//连接数据库查询员工信息
		String sql = "select new Userinfo(id,username,number,sex,department) from Userinfo";
		UserDao userdao = new UserDao();
		List<Userinfo> listuserinfo = userdao.getData(sql);
		ActionContext.getContext().put("listuserinfo",listuserinfo);
		
		return "showSuccess";
	
	}
	//管理员有权限添加新员工（通过部门要判断）
	public String addWorker() {
		//连接数据库获取部门
//		String sql = "select new Userinfo(id,username,number,sex,department) from Userinfo";
//		UserDao userdao = new UserDao();
//		List<Userinfo> listuser = userdao.getData(sql);
//		ActionContext.getContext().put("userinfo", listuser);
//		Userinfo userinfo = new Userinfo();
//		System.out.println(ActionContext.getContext().get("userinfo"));
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		
		if(!userinfo.getDepartment().equals("management")) {
			
			ActionContext.getContext().put("mess", "你没有权限进行添加");
		return "addError";
		};
				
				
		return "addSuccess";
	}
	
	//管理员有权限添加工作状态（通过部门要判断）	
			public String addifState() {
			Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
			
			
			if(!userinfo.getDepartment().equals("management")) {
				
			ActionContext.getContext().put("mess", "你没有权限进行添加");
			return "addStateError";
			};
			
			return "addStateSuccess";
				
			}
	
	//添加员工工作状态（管理员才有权限）
	public String addState() {
		
		//验证数据（不能为空）
		if(this.getNumber()==null || this.getNumber().equals("") || this.getScondition()==null || this.getScondition().equals("")) {
			ActionContext.getContext().put("mess", "工号或者工作状态不能为空！");
			
			return "StateError";
		}
		
		UserDao userdao = new UserDao();
		State state = new State();
		//验证数据（工作状态表中是否存在该工号，存在则不能添加，只能修改）
		String sql0 = "from State where number='"+this.number+"'";
		List<State> liststate = userdao.getStateData(sql0);
		if(liststate.size()>0) {
			//存入提醒信息
			ActionContext.getContext().put("mess", "工号添加过了，要修改工作状态请点击修改状态");
			return "StateError";
		}
		
		//验证数据（员工表是否存在该工号，不存在则不能添加因为是跟状态表级联更新和删除的）
		String sql = "select new Userinfo(number) from Userinfo";
		
		//获取数据库中全部的值
		List<Userinfo> list = userdao.getData(sql);
		
		
		for(Userinfo userinfo: list) {
			//将所有工号进行对比
			if(this.getNumber().equals(userinfo.getNumber())) {
				//将值传入state里面，
				state.setScondition(this.getScondition());
				state.setNumber(this.getNumber());
				if(!userdao.stateAdd(state)) {
					ActionContext.getContext().put("mess", "工作状态添加不成功！");
					return "StateError";
				}
				//添加成功提示信息
				ActionContext.getContext().put("mess", "添加成功！");
//				//将所有的值存入session
//				ActionContext.getContext().put("state",state);
				return "StateSuccess";
					
			}		
		}	
		//将数据存入表中
//		UserDao userdao = new UserDao();
		
		ActionContext.getContext().put("mess", "该工号不存在");
		
		return "StateError";
		
	}
	
	
	//修改员工工作状态
	public String workstateUpdate() {
		//验证数据
		if(this.getNumber()==null || this.getNumber().equals("") || this.getScondition()==null || this.getScondition().equals("")) {
			ActionContext.getContext().put("mess", "工号或者工作状态不能为空！");
			
			return "updateError";
		}
		//验证工号是否存在工作状态表中
		//定义sql语句
		String sql = "from State where number='"+this.getNumber()+"'";
		UserDao userdao = new UserDao();
		List<State> liststate = userdao.getStateData(sql);
		if(liststate.size()<=0) {
			//存入提示信息
			ActionContext.getContext().put("mess", "该工号不存在，请添加或者注册！");
			return "updateError";
		}
		//更新工作状态信息
		//定义sql语句
		String sql1 = "Update State SET scondition='"+this.getScondition()+"' where number='"+this.getNumber()+"'";
		userdao.deleteorUpdate(sql1);
		ActionContext.getContext().put("mess", "修改成功！");
		return "updateSuccess";
	}
	
	//查看全部员工的信息
	public String showWorkstate() {
		UserDao userdao = new UserDao();
		//注意这个sql语句是在po层实体类里面的，所以区分大小写
		String sql = "select new State(scondition,number) from State ";
		//执行sql语句，然后将查询结果显示到集合中
		List<State> showstatelist = userdao.getStateData(sql);
		//存入缓存中
		ActionContext.getContext().put("showstatelist", showstatelist);
		
		return "showWorkstateSuccess";
	}
	
	
	//查看已离职员工的信息
	public String lookquitWorker() {
		
		UserDao userdao = new UserDao();
		
		//sql语句查询离职员工（连表操作）
		String sql = "select new Userinfo(u.username,s.number,u.sex,u.department) from Userinfo u,State s  where u.number=s.number and s.scondition='离职'";
		//进行存入list集合（用userdao执行语句）
		List<Userinfo> quitlist = userdao.getData(sql); 
		//取出值就要存入hibernate缓存中(在jsp页面可以用迭代器一个一个取出)
		ActionContext.getContext().put("quitlist",quitlist);
		
		return "Successlook";
	}
	
	
	//模糊查询功能
	public String vaguequery() {
		//创建userdao对象
		UserDao userdao = new UserDao();
		//定义sql语句（）
		String sql = "select new Userinfo(username,number,sex,department) from Userinfo u where  u.username  like '%"+this.username+"%'";
		//保存到集合当中
		List<Userinfo> listuserinfo = userdao.getData(sql);
		ActionContext.getContext().put("listuserinfo", listuserinfo);
		
		return "querySuccess";
	}
	
	//删除离职员工的信息
	public String deleteWorker() {
		//创建userdao对象
		UserDao userdao =  new UserDao();
		//定义sql语句
		String sql = "delete from Userinfo where number='"+this.getNumber()+"'";
		//执行语句
		userdao.Updateordelete(sql);
		//添加语句
		ActionContext.getContext().put("mess", "删除成功！");
		return "deleteworkerSuccess";
	}
}
