package com.derun.commnuication;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springTest {

	private ApplicationContext   context;
	@Before
	public void init(){
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void main(){
		context.getBean(finiteStateMahine.class);
		
	}
}
