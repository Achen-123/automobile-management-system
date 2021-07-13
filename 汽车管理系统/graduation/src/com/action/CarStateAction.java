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
	
	//�������ά��״̬
	public String addCarState() {
		
		//��֤����
		if(this.getCarnumber()==null || this.getCarnumber().equals("") || this.getCarcond()==null || this.getCarcond()==null || this.getCarcond().equals("") || this.getLocated()==null || this.getLocated().equals("")) {
			ActionContext.getContext().put("mess", "�뽫��Ϣ��������");
			return "carstateError";
		}
		CarState carstate = new CarState();
		CarStateDao carstatedao = new CarStateDao();
		//��֤������Ϣ�Ƿ��Ѿ�����
		String sql = "from CarState where carnumber='"+this.getCarnumber()+"'";
		List<CarState> carstatelist = carstatedao.getData(sql);
		if(carstatelist.size()>0) {
			ActionContext.getContext().put("mess", "����ά��״̬�Ѿ����ڣ���Ҫ���£�������޸�״̬");
			return "carstateError";
		}
		//�����Ϣ
		carstate.setCarnumber(this.getCarnumber());
		carstate.setCarcond(this.getCarcond());
		carstate.setLocated(this.getLocated());
		
		if(!carstatedao.addState(carstate)) {
			ActionContext.getContext().put("mess", "��Ӳ��ɹ���");
			
			return "carstateError";
		}
		//����Ϣ����session
		ActionContext.getContext().getSession().put("carstate", carstate);
		ActionContext.getContext().put("mess", "��Ϣ��ӳɹ���");
		return "carstateSuccess";
	}
	
	//��ѯȫ��ά��״̬�ķ���
	public String searchCarstate() {
		//����List�ļ���,�洢��Ϣ
		List<CarState> carstatelist = new ArrayList<CarState>();
		//����dao����
		CarStateDao carstatedao = new CarStateDao();
		//����sql���
		String sql = "select new CarState(located,carcond,carnumber) from CarState";
		//�洢����
		carstatelist = carstatedao.getData(sql);
		ActionContext.getContext().put("carstatelist", carstatelist);
		return "searchSuccess";
		
	}
	
	//�޸�����ά��״̬
	public String changeCarstate() {
		//��֤���ݣ�����Ҫ��������������ѡ�
		if(this.getCarnumber()==null || this.getCarnumber().equals("") || this.getCarcond()==null || this.getCarcond().equals("") || this.getLocated()==null || this.getLocated().equals("")) {
			//������Ϣ
			ActionContext.getContext().put("mess", "���ƺ�,λ��,����ά��״̬����Ϊ�գ�");
			return "CarstateError";
		}
		//��֤���ݣ����ƺ��Ƿ������ά��״̬�����ά��״̬����ſ��Խ����޸ģ�
		CarStateDao carstatedao = new CarStateDao();
		//����sql���
		String sql = "from CarState where carnumber='"+this.getCarnumber()+"'";
		List<CarState> carstatelist = carstatedao.getData(sql);
		
		if(carstatelist.size()<=0) {
			//������Ϣ
			ActionContext.getContext().put("mess", "������������ά����Ϣ�����Ƚ�����ӣ�");
			return "CarstateError";
		}
		
		//���и���ά��״̬��Ϣ(ͨ�����ƺŽ��и���)
		//����sql���
		String sql1 = "Update CarState SET located='"+this.getLocated()+"',carcond='"+this.getCarcond()+"' where carnumber='"+this.getCarnumber()+"'";
		//ִ�����
		 carstatedao.Updateordelete(sql1);
		 //�����Ϣ
		 ActionContext.getContext().put("mess", "�޸ĳɹ���");
		 return "CarstateSuccess";
	}
	
	//���г��ƺ�ģ����ѯ
	public String searchCarnum() {
		//����dao����
		CarStateDao carstatedao = new CarStateDao();
		//����sql���
		String sql = "from CarState where carnumber like '%"+this.getCarnumber()+"%'";
		//����list���Ͻ��д洢
		List<CarState> carstatelist = carstatedao.getData(sql);
		//�洢
		ActionContext.getContext().put("carstatelist", carstatelist);
		
		return "searchSuccess";
		
		
	}
	
}
