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
	
	//��ӳ�����Ϣ
	
	public String Addinformation() {
		//��֤����
		if(this.getCarowner()==null || this.getCarowner().equals("") || this.getCarnumber()==null || this.getCarnumber().equals("") || this.getOwnersex()==null || this.getOwnersex().equals("") || this.getPhonenum()==null || this.getPhonenum().equals("")) {
			ActionContext.getContext().put("mess", "�뽫��Ϣ��������");
			return "addownerError";
		}
		//��֤���ݣ�������Ϣ�Ƿ���ڣ������Ų�����ӣ�
		Owners owners = new Owners(); 
		OwnerDao ownerdao = new OwnerDao();
		//����sql���
		String sql = "from Owners where memberid='"+this.getMemberid()+"'";
		//ִ�д洢����
		List<Owners> ownerslist = ownerdao.getOwnersData(sql);
		
		if(ownerslist.size()>0) {
			ActionContext.getContext().put("mess", "������Ϣ�Ѿ����ڣ���Ҫ�޸ģ������޸���Ϣ��");
			return "addownerError";
		}
		//��֤���ݣ�������Ϣ�Ƿ���ڣ����������޷���ӳ�����Ϣ��
		CarDao cardao = new CarDao();
		//����sql���
		String sql1 = "from Car where carnumber='"+this.getCarnumber()+"'";
		List<Car> carlist = cardao.getData(sql1);
		if(carlist.size()<=0) {
			ActionContext.getContext().put("mess", "���ƺŲ����ڣ�������ӳ�����Ϣ");
			return "addownerError";
		}
		
		owners.setMemberid(this.getMemberid());
		owners.setCarnumber(this.getCarnumber());
		owners.setCarowner(this.getCarowner());
		owners.setOwnersex(this.getOwnersex());
		owners.setPhonenum(this.getPhonenum());
		
		//��֤�Ƿ���ӳɹ�
		if(!ownerdao.addOwners(owners)) {
			ActionContext.getContext().put("mess", "��Ӳ��ɹ���");
			return "addownerError";
		}
		
		ActionContext.getContext().getSession().put("owners", owners);
		ActionContext.getContext().put("mess", "��ӳɹ�");
		return "addownerSuccess";
		
	}
	
	
	//��ѯȫ����������Ϣ
	public String searchInformation() {
		//����ownerdao
		OwnerDao ownerdao = new OwnerDao();
		//����sql���
		String sql = "select new Owners(carowner,carnumber,phonenum,ownersex,memberid) from Owners";
		//�洢��Ϣ
		List<Owners> ownerlist = ownerdao.getOwnersData(sql);
		//jspҳ����iterator
		ActionContext.getContext().put("ownerlist", ownerlist);
		return "searchSuccess";
	}
	
	//���»���ɾ��������Ϣ
	public String Updateordelete() {
		//��֤���ݣ�����Ϊ�գ�
		if(this.getCarnumber()==null || this.getCarnumber().equals("") || this.getMemberid()==null || this.getMemberid().equals("") || this.getCarowner()==null || this.getCarowner().equals("") || this.getOwnersex()==null || this.getOwnersex().equals("") || this.getPhonenum()==null || this.getPhonenum().equals("")) {
			ActionContext.getContext().put("mess", "�뽫��Ϣ��������");
			return "updateError";
		}
		//��֤���ݣ���Ա����Ϣ�Ƿ���ڣ���������Ҫ�Ƚ�����ӣ�
		OwnerDao ownerdao = new OwnerDao();
		//����sql���
		String sql = "from Owners where memberid='"+this.getMemberid()+"'";
		//ִ�����
		List<Owners> list = ownerdao.getOwnersData(sql);
		if(list.size()<=0) {
			ActionContext.getContext().put("mess", "������Ӹó�����Ϣ��");
			return "updateError";
		}
		//��֤���ݣ����ƺ��Ƿ���ڣ�����������ӳ�����Ϣ��
		String sql1 = "from Car where carnumber='"+this.getCarnumber()+"'";
		CarDao cardao = new CarDao();
		List<Car> carlist = cardao.getData(sql1);
		if(carlist.size()<=0) {
			ActionContext.getContext().put("mess", "���ƺŲ����ڣ�������ӳ�����Ϣ");
			return "updateError";
		}
		//����sql��䣨��Ա�Ų��䣬�޸ĸ��������ģ�
		String sql2 = "Update Owners SET carowner='"+this.getCarowner()+"',carnumber='"+this.getCarnumber()+"',phonenum='"+this.getPhonenum()+"',ownersex='"+this.getOwnersex()+"' where memberid='"+this.getMemberid()+"'";
		//ִ�����
		ownerdao.Updateordelete(sql2);
		ActionContext.getContext().put("mess", "�޸ĳɹ���");
		return "updateSuccess";
	}
	
	//����������ѯ������Ϣ
	public String searchOwner() {
		//��������
		Owners owners = new Owners();
		OwnerDao ownerdao = new OwnerDao();
		//����sql���
		String sql = "from Owners where carowner like '%"+this.getCarowner()+"%'";
		List<Owners> ownerlist = ownerdao.getOwnersData(sql);
		ActionContext.getContext().put("ownerlist", ownerlist);
		return "searchSuccess";
	}
}
