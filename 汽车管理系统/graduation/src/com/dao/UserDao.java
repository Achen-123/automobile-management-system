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
	
//	连接数据库获取登录用户的信息
	public List<Userinfo> getData(String sql){
		List<Userinfo> list = new ArrayList<Userinfo>();
		//创建SessionFactory（Session工厂）对象
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//使用SessionFactory对象创建Session对象
			Session session1 = sf.openSession();
			//session1.createQuery(sql).list()转化成线性表
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
//	连接数据库获取登录用户的信息
	public List<State> getStateData(String sql){
		List<State> list = new ArrayList<State>();
		//创建SessionFactory（Session工厂）对象
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//使用SessionFactory创建Session对象
			Session session1 = sf.openSession();
			//session1.createQuery(sql).list()转化成线性表
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

//	用户注册
	public boolean applyUser(Userinfo userinfo) {
		boolean isSuccess=false;//不成功
try { 
//		创建session工厂
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//		使用sessionFactory创建session对象
		Session session1 = sf.openSession();
//		开启事务
		Transaction tx = session1.beginTransaction();
		//执行的事务
		session1.save(userinfo);
//		提交事务
		tx.commit();
		isSuccess=true;
		session1.clear();
		session1.close();
} catch (HibernateException e) { 
	   e.printStackTrace(); 
	  }
		
		
		return isSuccess;
	}
	
	//删除或更新的员工工作状态的方法
	public boolean deleteorUpdate(String sql) {
		boolean isSuccess=false;//不成功
		
		try {
			//创建session工厂
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//通过工厂创建session对象
			Session session1 = sf.openSession();
			//开启事务
			Transaction tx = session1.beginTransaction();
			//执行语句
			Query query = session1.createQuery(sql);
			//执行ddl数据库语句
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
	
	
	//添加工作状态
	public boolean stateAdd(State state) {
		//要放在try catch后面
		boolean isSuccess=false;//不成功
		
		try {	
			//创建session工厂
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//使用session工厂创建session对象
			Session session1 = sf.openSession();
			//开启事务
			Transaction tx = session1.beginTransaction();
			//执行的事务（插入或者更新）
			session1.saveOrUpdate(state);
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
	
	//更新或删除员工的信息
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
