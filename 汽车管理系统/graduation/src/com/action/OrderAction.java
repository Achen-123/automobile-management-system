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
	
	//��Ӷ�������Ϣ
	public String addInformation() {
		//��֤����
		if(this.getCarorder()==null || this.getCarorder().equals("") ||  this.getMemberid()==null || this.getMemberid().equals("")) {
			ActionContext.getContext().put("mess", "�뽫��Ϣ��������");
			return "addError";
		}
//		//��֤���ݣ���֤���ƺ��Ƿ���ڣ���������Ҫ��ӳ�����Ϣ��
//		Car car = new Car();
//		CarDao cardao = new CarDao();
//		List<Car> listcar = new ArrayList<Car>();
//		//����sql���
//		String sql ="from Car where carnumber='"+this.getCarnumber()+"'";
//		listcar = cardao.getData(sql);
//		if(listcar.size()<=0) {
//			ActionContext.getContext().put("mess", "������Ϣ�����ڣ�����ӳ�����Ϣ��");
//			return "addError";
//		}
		//��֤���ݣ���֤��Ա���Ƿ���ڣ�����������ӻ�Ա��Ϣ��
		Owners onwers = new Owners();
		OwnerDao ownerdao = new OwnerDao();
		List<Owners> listowners = new ArrayList<Owners>();
		//����sql���
		String sql1 = "from Owners where memberid='"+this.getMemberid()+"'";
		listowners = ownerdao.getOwnersData(sql1);
		if(listowners.size()<=0) {
			ActionContext.getContext().put("mess", "��Ա�Ų����ڣ�����ӳ�����Ϣ��");
			return "addError";
		}
		
		//��֤���ݣ���֤���ݿ����Ƿ��Ѿ����ڸö����ţ������Ų�����ӣ�����ֻ�ܽ����޸ģ�
		Orders order = new Orders();
		OrderDao orderdao = new OrderDao();
		List<Orders> listorder = new ArrayList<Orders>();
		//����sql���
		String sql2 = "from Orders where carorder='"+this.getCarorder()+"'";
		listorder = orderdao.getData(sql2);
		if(listorder.size()>0) {
			ActionContext.getContext().put("mess", "������Ϣ�Ѿ����ڣ�Ҫ�޸��뽫����޸���Ϣ��");
			return "addError";
		}
		
		//�����Ϣ
		order.setCarorder(this.getCarorder());
		order.setMemberid(this.getMemberid());
		if(!orderdao.addOrders(order)) {
			ActionContext.getContext().put("mess", "�����Ϣʧ�ܣ�");
			return "addError";
		}
		
		//����session
		ActionContext.getContext().getSession().put("orders",order);
		ActionContext.getContext().put("mess", "��ӳɹ�");
		return "addSuccess";
		
	}
	
	//��ѯȫ��������Ϣ
	public String searchAll() {
		//����orderdao
		Orders order = new Orders();
		OrderDao orderdao = new OrderDao();
		//����sql���
		String sql = "select new Orders(carorder,memberid) from Orders";
		//�洢��Ϣ
		List<Orders> orderlist = orderdao.getData(sql);
		//jspҳ����iterator
		ActionContext.getContext().put("orderlist", orderlist);
		return "searchSuccess";
	}
	
	//�޸Ļ���ɾ��������Ϣ
	public String Updateordelete() {
		//��֤����
		if(this.getCarorder()==null || this.getCarorder().equals("") ||  this.getMemberid()==null || this.getMemberid().equals("")) {
			ActionContext.getContext().put("mess", "�뽫��Ϣ��������");
			return "updateError";
		}
		
		//��֤���ݣ���֤��Ա���Ƿ���ڣ�����������ӻ�Ա��Ϣ��
			Owners onwers = new Owners();
			OwnerDao ownerdao = new OwnerDao();
			List<Owners> listowners = new ArrayList<Owners>();
			//����sql���
			String sql1 = "from Owners where memberid='"+this.getMemberid()+"'";
			listowners = ownerdao.getOwnersData(sql1);
			if(listowners.size()<=0) {
				ActionContext.getContext().put("mess", "��Ա�Ų����ڣ�����ӳ�����Ϣ��");
				return "updateError";
			}
			
			//��֤���ݣ���֤���ݿ����Ƿ��Ѿ����ڸö����ţ����������ܽ����޸ģ�Ҫ�Ƚ�����ӣ�
			Orders order = new Orders();
			OrderDao orderdao = new OrderDao();
			List<Orders> listorder = new ArrayList<Orders>();
			//����sql���
			String sql2 = "from Orders where carorder='"+this.getCarorder()+"'";
			listorder = orderdao.getData(sql2);
			if(listorder.size()<=0) {
				ActionContext.getContext().put("mess", "������Ϣ�����ڣ����Ƚ�����ӣ�");
				return "updateError";
			}
			
			//����sql��䣨ͨ�����������޸Ļ�Ա�ţ�
			String sql="update Orders SET memberid='"+this.getMemberid()+"' where carorder='"+this.getCarorder()+"'";
			//ִ�����
			orderdao.Updateordelete(sql);
			ActionContext.getContext().put("mess", "�޸ĳɹ���");
			return "updateSuccess";	
	}
	
	//ģ����ѯ������Ϣ
	public String vaguequery() {
		//����orderdao����
		OrderDao orderdao = new OrderDao();
		//����sql���
		String sql ="from Orders where carorder like '%"+this.getCarorder()+"%'";
		//����һ��list����
		List<Orders> orderlist = orderdao.getData(sql);
		ActionContext.getContext().put("orderlist", orderlist);
		
		return "querySuccess";
		
		
	}
	
	//ɾ������
	public String Deleteorder() {
		//����OrderDao����
		OrderDao orderdao = new OrderDao();
		//����sql���
		String sql ="delete from Orders where carorder='"+this.getCarorder()+"'";
		orderdao.Updateordelete(sql);
		//�������
		ActionContext.getContext().put("mess", "ɾ���ɹ���");
		return "DeleteSuccess";
	}
}
