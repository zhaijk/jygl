package com.derun.db;

import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derun.dao.TradeDAO;
import com.derun.entity.cardtrade;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("applicationContext.xml")
//@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@ContextConfiguration(value  = "classpath:applicationContext.xml")
//@ContextConfiguration(locations={"classpath:spring-context.xml"})
@ContextConfiguration(locations={"file:src/main/resources/spring-context.xml"})   

public class DAOTest {
	
	//@Autowired
	//private CarColorDAO dao;
	
	@Autowired  
	private TradeDAO dao;
	//private ApplicationContext context;
	@Before
	public void init(){
		//ServletContext sc = null;
		//context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//context=WebApplicationContextUtils.getWebApplicationContext(sc);
		//context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//dao=context.getBean(CarColorDAO.class);
		System.out.println("init...........");
	}
	
	@Test
	public void test(){
		//CarColorDAO dao=context.getBean(CarColorDAO.class);
		List<cardtrade> lstObjs=dao.findALL();
		for(cardtrade obj:lstObjs){
			//System.out.println(obj.getCode()+"-"+obj.getName()+"-"+obj.getTmemo());
			System.out.println(obj.getCardCode());
		}
	}
	@After
	public void destory(){
		//context.
		System.out.println("destory...........");
	}
	
}
