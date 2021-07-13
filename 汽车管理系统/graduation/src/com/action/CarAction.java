package com.action;

import java.util.List;

import com.dao.CarDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Car;

public class CarAction {
//�������
	private String carname;
	private String carnumber;//���ƺ�
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
	
	
	

	//��ӵ���ά�޳�����Ϣ�ķ���
	public String addCarinformation(){
		//��֤���ݣ�������д����Ϊһ���������ж��������
		if(this.getCarnumber()==null || this.getCarnumber().equals("") ||   this.getCarname()==null || this.getCarname().equals("") || this.getCarcolor()==null || this.getCarcolor().equals("") ) {
			ActionContext.getContext().put("mess", "�뽫��Ϣ��������");
			
			return "addError";
		}	
		//�������ݿ���֤��������Ϣ�Ƿ��Ѿ��������ݿ���
		CarDao cardao = new CarDao();
		//����sql
		String sql = "from Car where carnumber ='"+this.getCarnumber()+"'";
		List<Car> listcar = cardao.getData(sql);
		if(listcar.size()>0) {
			ActionContext.getContext().put("mess", "�ó�������Ϣ�Ѿ����ڣ�");
			return "addError";
		}
		
		//�����ݴ���
		Car car = new Car();
		car.setCarnumber(this.getCarnumber());
		car.setCarname(this.getCarname());
		car.setCarcolor(this.getCarcolor());
		
		
		//��֤�Ƿ����ɹ�
		if(!cardao.carAdd(car)) {
			ActionContext.getContext().put("mess", "��Ϣ��Ӳ��ɹ�");
			
			return "addError";
		}
		
		//����Ϣ����session��
		ActionContext.getContext().getSession().put("car", car);
		return "addSuccess";
	}
	
	
	//��ѯ����ȫ��ά�޳�����Ϣ
	public String searchAllcar() {
		//����cardao����
		CarDao cardao = new CarDao();
		//����sql���
		String sql = " select new Car(carname,carnumber,carcolor,carorder) from Car";
		List<Car> carlist = cardao.getData(sql);
		//���루��jspҳ����struts�ĵ�������ȫ��ȡ����
		ActionContext.getContext().put("carlist", carlist);
		
		return "searchSuccess";
	}
	
	//�޸�ά�޳�����Ϣ
	public String carInformationchange() {
		//��֤���ݣ�����������)
		if(this.getCarnumber()==null || this.getCarnumber().equals("") ||   this.getCarname()==null || this.getCarname().equals("") || this.getCarcolor()==null || this.getCarcolor().equals("") ) {
			ActionContext.getContext().put("mess", "�뽫��Ϣ��������");
			
			return "addinformError";
		}
		CarDao cardao = new CarDao();
		//��֤���ݣ��Ƿ���ڸó�������Ϣ�����ڲſ����޸ģ�
		//����sql��䣨�����int���ֶ�ֵ��"from Car where carnumber="+this.getCarnumber()��
		String sql = "from Car where carnumber='"+this.getCarnumber()+"'";
		List<Car> carlist = cardao.getData(sql);
		if(carlist.size()<=0) {
			ActionContext.getContext().put("mess", "û�иó�����Ϣ��������ӣ�");
			return "addinformError";
		}
		//����sql��䣨ע���Сд��
		String sql1 = "Update Car SET carname='"+this.getCarname()+"',carcolor='"+this.getCarcolor()+"' where carnumber='"+this.getCarnumber()+"'";
		//ִ��sql���
		cardao.deleteorUpdateCar(sql1);
		ActionContext.getContext().put("mess", "�޸ĳɹ�");
		return "addinformSuccess";
		
	}
	
	//���ƺŵ�ģ����ѯ
	public String searchcarnumber() {
		CarDao cardao = new CarDao();
		//����sql���
		String sql = "  from Car where carnumber like '%"+this.getCarnumber()+"%'";
		//���ݴ��뼯����
		List<Car> carlist = cardao.getData(sql);
		//���ݴ���
		ActionContext.getContext().put("carlist", carlist);
		
		return "searchSuccess";
	}
}
