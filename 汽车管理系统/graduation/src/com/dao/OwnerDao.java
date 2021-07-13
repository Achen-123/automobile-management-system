package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.po.Owners;

public class OwnerDao {
	//��ѯȫ��ȫ����������Ϣ
	public List<Owners> getOwnersData(String sql){
		List<Owners> list = new ArrayList<Owners>();
		
		try {
			//����sessionfactory����
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//����session����
			Session session1 = sf.openSession();
			//ִ��sql��䣨���浽list���ϣ�
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//��ӳ�����Ϣ
	public boolean addOwners(Owners owners) {
		boolean isSuccess = false;//���ɹ�
		
		try {
			//����sessionfactory
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//����session����
			Session session1 = sf.openSession();
			//��������
			Transaction tx = session1.beginTransaction();
			//ִ�����񣨴洢���ݣ�
			session1.save(owners);
			//�ύ����
			tx.commit();
			//���óɹ�
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
			isSuccess=true;//������ȷ
			//�ͷ���Դ
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
	}

}
