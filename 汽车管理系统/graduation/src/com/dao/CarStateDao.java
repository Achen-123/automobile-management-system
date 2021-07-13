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
		//创建list存储信息（泛型）
		List<CarState> list = new ArrayList<CarState>();
		
		try {
			//连接数据库获取汽车维修状态信息
			//创建sessionfactory对象
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//通过sessionfactory对象来创建session对象
			Session session1 = sf.openSession();
			//（查询不用开启事务）执行sql存储信息（用list（）转换成list表）
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//添加车辆维修状态
	public boolean addState(CarState carstate) {
	boolean isSuccess=false;//不成功	
	
	try {
		//创建sessionfactory对象
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//创建session对象
		Session session1 = sf.openSession();
		//开启事务
		Transaction tx = session1.beginTransaction();
		//存储信息（执行）
		session1.save(carstate);
		//提交事务
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
	
	//修改汽车维修状态
	public boolean Updateordelete(String sql) {
		boolean isSuccess=false;//不成功
		
		try {
			//创建sessionfactory 对象
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//创建session对象
			Session session1 = sf.openSession();
			//开启事务
			Transaction tx = session1.beginTransaction();
			//执行
			Query query = session1.createQuery(sql);
			//执行ddl数据库语句
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
