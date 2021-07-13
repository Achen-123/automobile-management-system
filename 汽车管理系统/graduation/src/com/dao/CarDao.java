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
	
	//连接数据库获取维修车辆的信息
	public List<Car> getData(String sql){
		//创建一个list对象
		List<Car> list = new ArrayList<Car>();
		
		try {
			//创建session工厂
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//使用SessionFactory对象创建session对象
			Session session1 = sf.openSession();
			//执行hql语句(并且转换成了list集合)
			list = session1.createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//添加维修汽车信息
	public boolean carAdd(Car car) {
		//刚开始不成功
		boolean isSuccess=false;
		
		try {
			//创建session工厂
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//通过sessionfactory对象来创建session对象
			Session session1 = sf.openSession();
			//开启事务（通过session对象）
			Transaction tx = session1.beginTransaction();
			//执行事务
			session1.save(car);
			//提交事务
			tx.commit();
			//设置为执行成功(不成功执行不到这条语句)
			isSuccess=true;
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回成功
		return isSuccess;
		
	}
	
	//更新或者删除维修车辆信息
	
	public boolean deleteorUpdateCar(String sql) {
		boolean isSuccess=false;
		
		try {
			//创建session工厂
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//通过sessionfactory对象来创建session对象
			Session session1 = sf.openSession();
			//通过session对象开启事务
			Transaction tx = session1.beginTransaction();
			//执行语句等价于 session1.createQuery(sql).executeUpdate();
			Query query = session1.createQuery(sql);
			//执行数据ddl语句
			query.executeUpdate();
			//提交事务
			tx.commit();
			//设置为正确
			isSuccess=true;
			//清除和关闭资源
			session1.clear();
			session1.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	
}
