package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.po.Orders;

public class OrderDao {
	//��ѯ������Ϣ
	public List<Orders> getData(String sql){
		List<Orders> list = new ArrayList<Orders>();
		try {
			//����sessionfactory����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//����session����
			Session session1 = sf.openSession();
			//ִ����䣨ת����list��
			list = session1.createQuery(sql).list();
			//���ؼ�������
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//��Ӷ�����Ϣ
	public boolean addOrders(Orders order) {
		boolean isSuccess=false;//���ɹ�
		try {
			//����sessionfactory����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//����session����
			Session session1 = sf.openSession();
			//��������
			Transaction tx = session1.beginTransaction();
			//������ݣ�ִ�У�
			session1.save(order);
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
	
	
	//���»���ɾ��������Ϣ
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
			isSuccess=true;//����ɹ�
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
}
