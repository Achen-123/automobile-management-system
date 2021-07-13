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
	//查询订单信息
	public List<Orders> getData(String sql){
		List<Orders> list = new ArrayList<Orders>();
		try {
			//创建sessionfactory对象
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//创建session对象
			Session session1 = sf.openSession();
			//执行语句（转化成list表）
			list = session1.createQuery(sql).list();
			//返回集合数据
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//添加订单信息
	public boolean addOrders(Orders order) {
		boolean isSuccess=false;//不成功
		try {
			//创建sessionfactory对象
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//创建session对象
			Session session1 = sf.openSession();
			//开启事务
			Transaction tx = session1.beginTransaction();
			//添加数据（执行）
			session1.save(order);
			//提交事务
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
	
	
	//更新或者删除订单信息
	public boolean Updateordelete(String sql) {
		
		boolean isSuccess=false;//不成功
		try {
			//定义sessionfactory对象
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//定义session对象
			Session session1 = sf.openSession();
			//开启事务
			Transaction tx = session1.beginTransaction();
			//执行语句
			Query query = session1.createQuery(sql);
			//执行数据库ddl语句
			query.executeUpdate();
			//提交事务
			tx.commit();
			isSuccess=true;//定义成功
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
}
