package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.po.Car;

public class CarDao {
	
	//�������ݿ��ȡά�޳�������Ϣ
	public List<Car> getData(String sql){
		//����һ��list����
		List<Car> list = new ArrayList<Car>();
		
		try {
			//����session����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ʹ��SessionFactory���󴴽�session����
			Session session1 = sf.openSession();
			//ִ��hql���(����ת������list����)
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//���ά��������Ϣ
	public boolean carAdd(Car car) {
		//�տ�ʼ���ɹ�
		boolean isSuccess=false;
		
		try {
			//����session����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ͨ��sessionfactory����������session����
			Session session1 = sf.openSession();
			//��������ͨ��session����
			Transaction tx = session1.beginTransaction();
			//ִ������
			session1.save(car);
			//�ύ����
			tx.commit();
			//����Ϊִ�гɹ�(���ɹ�ִ�в����������)
			isSuccess=true;
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���سɹ�
		return isSuccess;
		
	}
	
	//���»���ɾ��ά�޳�����Ϣ
	
	public boolean deleteorUpdateCar(String sql) {
		boolean isSuccess=false;
		
		try {
			//����session����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//ͨ��sessionfactory����������session����
			Session session1 = sf.openSession();
			//ͨ��session����������
			Transaction tx = session1.beginTransaction();
			//ִ�����ȼ��� session1.createQuery(sql).executeUpdate();
			Query query = session1.createQuery(sql);
			//ִ������ddl���
			query.executeUpdate();
			//�ύ����
			tx.commit();
			//����Ϊ��ȷ
			isSuccess=true;
			//����͹ر���Դ
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	
}
