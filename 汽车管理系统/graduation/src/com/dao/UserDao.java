package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.po.State;
import com.po.Userinfo;

public class UserDao {
	
//	�������ݿ��ȡ��¼�û�����Ϣ
	public List<Userinfo> getData(String sql){
		List<Userinfo> list = new ArrayList<Userinfo>();
		//����SessionFactory��Session����������
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ʹ��SessionFactory���󴴽�Session����
			Session session1 = sf.openSession();
			//session1.createQuery(sql).list()ת�������Ա�
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
//	�������ݿ��ȡ��¼�û�����Ϣ
	public List<State> getStateData(String sql){
		List<State> list = new ArrayList<State>();
		//����SessionFactory��Session����������
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ʹ��SessionFactory����Session����
			Session session1 = sf.openSession();
			//session1.createQuery(sql).list()ת�������Ա�
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

//	�û�ע��
	public boolean applyUser(Userinfo userinfo) {
		boolean isSuccess=false;//���ɹ�
try { 
//		����session����
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//		ʹ��sessionFactory����session����
		Session session1 = sf.openSession();
//		��������
		Transaction tx = session1.beginTransaction();
		//ִ�е�����
		session1.save(userinfo);
//		�ύ����
		tx.commit();
		isSuccess=true;
		session1.clear();
		session1.close();
} catch (HibernateException e) { 
	   e.printStackTrace(); 
	  }
		
		
		return isSuccess;
	}
	
	//ɾ������µ�Ա������״̬�ķ���
	public boolean deleteorUpdate(String sql) {
		boolean isSuccess=false;//���ɹ�
		
		try {
			//����session����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ͨ����������session����
			Session session1 = sf.openSession();
			//��������
			Transaction tx = session1.beginTransaction();
			//ִ�����
			Query query = session1.createQuery(sql);
			//ִ��ddl���ݿ����
			query.executeUpdate();
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
	
	
	//��ӹ���״̬
	public boolean stateAdd(State state) {
		//Ҫ����try catch����
		boolean isSuccess=false;//���ɹ�
		
		try {	
			//����session����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ʹ��session��������session����
			Session session1 = sf.openSession();
			//��������
			Transaction tx = session1.beginTransaction();
			//ִ�е����񣨲�����߸��£�
			session1.saveOrUpdate(state);
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
	
	//���»�ɾ��Ա������Ϣ
	public boolean Updateordelete(String sql) {
		boolean isSuccess=false;//���ɹ�
		
		try {
			//����sessionfactory����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//����session����
			Session session1 = sf.openSession();
			//��������
			Transaction tx = session1.beginTransaction();
			//ִ�����
			Query query = session1.createQuery(sql);
			//ִ�����ݿ�ddl���
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
