package com.derun.aopTEST;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class test {

	public static void  main(String[] args){
				
		ApplicationContext ac=new XmlWebApplicationContext();//new ClassPathXmlApplicationContext("spring-context.xml");		
		//haha test=  (haha) ac.getBean("hei");//"haha");//.class);
		//test.add();
		((haha) ac.getBean(haha.class)).add();
		((haha) ac.getBean("hei")).add();
	}
}
