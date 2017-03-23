package com.derun.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class sqlhelper {//拒绝继承
	private static SqlSessionFactory sessionFactory ;
	static{
		try{
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			Reader reader=Resources.getResourceAsReader("configuration.xml");
			sessionFactory=ssfb.build(reader);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private sqlhelper(){} //拒绝实例化
	private static sqlhelper instance=null;
	
	public static synchronized sqlhelper   getInstance(){//避免创建多个实例 延迟加载
		if(instance==null)
			instance=new sqlhelper();
		return instance;
	}
	public static SqlSession getSession(){
		return sessionFactory.openSession();
	}
	public static void freeSession(SqlSession session){
		session.close();
		
	}
}
