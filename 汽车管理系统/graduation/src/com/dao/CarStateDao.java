package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.po.CarState;

public class CarStateDao {
	
	public List<CarState> getData(String sql){
		//����list�洢��Ϣ�����ͣ�
		List<CarState> list = new ArrayList<CarState>();
		
		try {
			//�������ݿ��ȡ����ά��״̬��Ϣ
			//����sessionfactory����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ͨ��sessionfactory����������session����
			Session session1 = sf.openSession();
			//����ѯ���ÿ�������ִ��sql�洢��Ϣ����list����ת����list��
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//��ӳ���ά��״̬
	public boolean addState(CarState carstate) {
	boolean isSuccess=false;//���ɹ�	
	
	try {
		//����sessionfactory����
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//����session����
		Session session1 = sf.openSession();
		//��������
		Transaction tx = session1.beginTransaction();
		//�洢��Ϣ��ִ�У�
		session1.save(carstate);
		//�ύ����
		tx.commit();
		isSuccess=true;
		session1.clear();
		session1.close();
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 	isSuccess;
		
	}
	
	//�޸�����ά��״̬
	public boolean Updateordelete(String sql) {
		boolean isSuccess=false;//���ɹ�
		
		try {
			//����sessionfactory ����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//����session����
			Session session1 = sf.openSession();
			//��������
			Transaction tx = session1.beginTransaction();
			//ִ��
			Query query = session1.createQuery(sql);
			//ִ��ddl���ݿ����
			query.executeUpdate();
			//�ύ����
			tx.commit();
			isSuccess=true;
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	}
	
}
