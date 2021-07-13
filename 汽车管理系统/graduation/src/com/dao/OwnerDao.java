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
	//查询全部全部车主的信息
	public List<Owners> getOwnersData(String sql){
		List<Owners> list = new ArrayList<Owners>();
		
		try {
			//创建sessionfactory对象
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//创建session对象
			Session session1 = sf.openSession();
			//执行sql语句（保存到list集合）
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//添加车主信息
	public boolean addOwners(Owners owners) {
		boolean isSuccess = false;//不成功
		
		try {
			//创建sessionfactory
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//创建session对象
			Session session1 = sf.openSession();
			//开启事务
			Transaction tx = session1.beginTransaction();
			//执行事务（存储数据）
			session1.save(owners);
			//提交事务
			tx.commit();
			//设置成功
			isSuccess=true;
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//更新或者删除车主信息
	public boolean Updateordelete(String sql) {
		boolean isSuccess=false;//不成功
		
		try {
			//创建sessionfactory对象
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//创建session对象
			Session session1 = sf.openSession();
			//开启事务
			Transaction tx = session1.beginTransaction();
			//执行语句
			Query query = session1.createQuery(sql);
			//执行数据库ddl语句
			query.executeUpdate();
			//提交事务
			tx.commit();
			isSuccess=true;//设置正确
			//释放资源
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
	}

}
