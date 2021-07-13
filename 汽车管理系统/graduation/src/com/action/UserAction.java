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
	//	ע�᷽��
	public String reg() {
	//��֤����
	if(this.getUsername()==null || this.getUsername().equals("") || this.getNumber()==null || this.getNumber().equals("")
		|| this.getPwd()==null || this.getPwd().equals("") || this.getPwd1()==null || this.getPwd1().equals("")
		|| this.getSex()==null || this.getSex().equals("") || this.getDepartment()==null ||this.getDepartment().equals("")) {
		ActionContext.getContext().put("mess", "����Ϊ�գ�");
		return "regError";
	}
	if(!this.pwd.equals(this.pwd1)) {
		ActionContext.getContext().put("mess", "���벻һ�£�");
		return "regError";
	}
	
	//�������ݿ⣬��֤�������Ƿ��Ѿ�����
	String sql = "from Userinfo where number='"+this.number+"'";
	UserDao userDao = new UserDao();
	if(userDao.getData(sql).size()>0) {
		ActionContext.getContext().put("mess","�ù����Ѿ����ڣ�");
		return "regError";
	}
	
	Userinfo userinfo = new Userinfo();
	userinfo.setNumber(this.getNumber());
	userinfo.setUsername(this.getUsername());
	userinfo.setPwd(this.getPwd());
	userinfo.setDepartment(this.getDepartment());
	userinfo.setSex(this.getSex());
	if(!userDao.applyUser(userinfo)) {
		ActionContext.getContext().put("mess","ע��ʧ�ܣ�������ϵ������Ա");
		return "regError";
	}
	//��ע��ɹ����û���Ϣ�洢��userinfo��
	ActionContext.getContext().put("userinfo", userinfo);
	ActionContext.getContext().put("mess", "ע��ɹ�");
	return "regSuccess";
	}
	
	//��¼����
	public String login() {
		//��֤���ݣ������͹��Ų���Ϊ�գ�
		if(this.getUsername()==null || this.getUsername().equals("") || this.getNumber()==null || this.getNumber().equals("")) {
			
			ActionContext.getContext().put("mess","�����͹��Ų���Ϊ�գ�");
			return "loginError";
		}
		//��¼
		String sql = "from Userinfo where username='"+this.username+"' and number='"+this.number+"' and pwd='"+this.pwd+"'";
		UserDao userdao = new UserDao();
		//��ȡ���ݿ���ȫ����ֵ
		List<Userinfo> list = userdao.getData(sql);
		if(list.size()==0) {
			ActionContext.getContext().put("mess", "�����򹤺Ż����벻��ȷ��");
			
			return "loginError";
		}
//		//��ѯ����(�Թ�������Ψһ����)����ʵ�֣�
//		String sql1 = "select department from Userinfo where department='"+this.number+"'";
//		//list����Userinfo����
//		List<Userinfo> list = userdao.getData(sql1);
//		System.out.println(list);
		//�����ݴ���po��
//		Userinfo userinfo = new Userinfo(this.getUsername(),this.getNumber(),this.getPwd());
		
		//��ֵȫ������session��
		ActionContext.getContext().getSession().put("userinfo",list.get(0));
		return "loginSuccess";
	}
	
	//ע������
	public String logout() {
		ActionContext.getContext().getSession().clear();
		return "logoutSuccess";
	}
	
	//��ʾԱ����Ϣ
	public String showWorker() {
		//�������ݿ��ѯԱ����Ϣ
		String sql = "select new Userinfo(id,username,number,sex,department) from Userinfo";
		UserDao userdao = new UserDao();
		List<Userinfo> listuserinfo = userdao.getData(sql);
		ActionContext.getContext().put("listuserinfo",listuserinfo);
		
		return "showSuccess";
	
	}
	//����Ա��Ȩ�������Ա����ͨ������Ҫ�жϣ�
	public String addWorker() {
		//�������ݿ��ȡ����
//		String sql = "select new Userinfo(id,username,number,sex,department) from Userinfo";
//		UserDao userdao = new UserDao();
//		List<Userinfo> listuser = userdao.getData(sql);
//		ActionContext.getContext().put("userinfo", listuser);
//		Userinfo userinfo = new Userinfo();
//		System.out.println(ActionContext.getContext().get("userinfo"));
		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
		
		if(!userinfo.getDepartment().equals("management")) {
			
			ActionContext.getContext().put("mess", "��û��Ȩ�޽������");
		return "addError";
		};
				
				
		return "addSuccess";
	}
	
	//����Ա��Ȩ����ӹ���״̬��ͨ������Ҫ�жϣ�	
			public String addifState() {
			Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("userinfo");
			
			
			if(!userinfo.getDepartment().equals("management")) {
				
			ActionContext.getContext().put("mess", "��û��Ȩ�޽������");
			return "addStateError";
			};
			
			return "addStateSuccess";
				
			}
	
	//���Ա������״̬������Ա����Ȩ�ޣ�
	public String addState() {
		
		//��֤���ݣ�����Ϊ�գ�
		if(this.getNumber()==null || this.getNumber().equals("") || this.getScondition()==null || this.getScondition().equals("")) {
			ActionContext.getContext().put("mess", "���Ż��߹���״̬����Ϊ�գ�");
			
			return "StateError";
		}
		
		UserDao userdao = new UserDao();
		State state = new State();
		//��֤���ݣ�����״̬�����Ƿ���ڸù��ţ�����������ӣ�ֻ���޸ģ�
		String sql0 = "from State where number='"+this.number+"'";
		List<State> liststate = userdao.getStateData(sql0);
		if(liststate.size()>0) {
			//����������Ϣ
			ActionContext.getContext().put("mess", "������ӹ��ˣ�Ҫ�޸Ĺ���״̬�����޸�״̬");
			return "StateError";
		}
		
		//��֤���ݣ�Ա�����Ƿ���ڸù��ţ����������������Ϊ�Ǹ�״̬�������º�ɾ���ģ�
		String sql = "select new Userinfo(number) from Userinfo";
		
		//��ȡ���ݿ���ȫ����ֵ
		List<Userinfo> list = userdao.getData(sql);
		
		
		for(Userinfo userinfo: list) {
			//�����й��Ž��жԱ�
			if(this.getNumber().equals(userinfo.getNumber())) {
				//��ֵ����state���棬
				state.setScondition(this.getScondition());
				state.setNumber(this.getNumber());
				if(!userdao.stateAdd(state)) {
					ActionContext.getContext().put("mess", "����״̬��Ӳ��ɹ���");
					return "StateError";
				}
				//��ӳɹ���ʾ��Ϣ
				ActionContext.getContext().put("mess", "��ӳɹ���");
//				//�����е�ֵ����session
//				ActionContext.getContext().put("state",state);
				return "StateSuccess";
					
			}		
		}	
		//�����ݴ������
//		UserDao userdao = new UserDao();
		
		ActionContext.getContext().put("mess", "�ù��Ų�����");
		
		return "StateError";
		
	}
	
	
	//�޸�Ա������״̬
	public String workstateUpdate() {
		//��֤����
		if(this.getNumber()==null || this.getNumber().equals("") || this.getScondition()==null || this.getScondition().equals("")) {
			ActionContext.getContext().put("mess", "���Ż��߹���״̬����Ϊ�գ�");
			
			return "updateError";
		}
		//��֤�����Ƿ���ڹ���״̬����
		//����sql���
		String sql = "from State where number='"+this.getNumber()+"'";
		UserDao userdao = new UserDao();
		List<State> liststate = userdao.getStateData(sql);
		if(liststate.size()<=0) {
			//������ʾ��Ϣ
			ActionContext.getContext().put("mess", "�ù��Ų����ڣ�����ӻ���ע�ᣡ");
			return "updateError";
		}
		//���¹���״̬��Ϣ
		//����sql���
		String sql1 = "Update State SET scondition='"+this.getScondition()+"' where number='"+this.getNumber()+"'";
		userdao.deleteorUpdate(sql1);
		ActionContext.getContext().put("mess", "�޸ĳɹ���");
		return "updateSuccess";
	}
	
	//�鿴ȫ��Ա������Ϣ
	public String showWorkstate() {
		UserDao userdao = new UserDao();
		//ע�����sql�������po��ʵ��������ģ��������ִ�Сд
		String sql = "select new State(scondition,number) from State ";
		//ִ��sql��䣬Ȼ�󽫲�ѯ�����ʾ��������
		List<State> showstatelist = userdao.getStateData(sql);
		//���뻺����
		ActionContext.getContext().put("showstatelist", showstatelist);
		
		return "showWorkstateSuccess";
	}
	
	
	//�鿴����ְԱ������Ϣ
	public String lookquitWorker() {
		
		UserDao userdao = new UserDao();
		
		//sql����ѯ��ְԱ�������������
		String sql = "select new Userinfo(u.username,s.number,u.sex,u.department) from Userinfo u,State s  where u.number=s.number and s.scondition='��ְ'";
		//���д���list���ϣ���userdaoִ����䣩
		List<Userinfo> quitlist = userdao.getData(sql); 
		//ȡ��ֵ��Ҫ����hibernate������(��jspҳ������õ�����һ��һ��ȡ��)
		ActionContext.getContext().put("quitlist",quitlist);
		
		return "Successlook";
	}
	
	
	//ģ����ѯ����
	public String vaguequery() {
		//����userdao����
		UserDao userdao = new UserDao();
		//����sql��䣨��
		String sql = "select new Userinfo(username,number,sex,department) from Userinfo u where  u.username  like '%"+this.username+"%'";
		//���浽���ϵ���
		List<Userinfo> listuserinfo = userdao.getData(sql);
		ActionContext.getContext().put("listuserinfo", listuserinfo);
		
		return "querySuccess";
	}
	
	//ɾ����ְԱ������Ϣ
	public String deleteWorker() {
		//����userdao����
		UserDao userdao =  new UserDao();
		//����sql���
		String sql = "delete from Userinfo where number='"+this.getNumber()+"'";
		//ִ�����
		userdao.Updateordelete(sql);
		//������
		ActionContext.getContext().put("mess", "ɾ���ɹ���");
		return "deleteworkerSuccess";
	}
}
