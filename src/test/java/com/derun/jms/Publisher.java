package com.derun.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {

	public static void main(String[] args) throws JMSException, InterruptedException{
		String jmsProviderAddress="tcp://localhost:61616";
		ConnectionFactory cf=new ActiveMQConnectionFactory(jmsProviderAddress);
		Connection conn=cf.createConnection();
		conn.start();
		Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer=session.createProducer(null);
		Destination dest=session.createTopic("dancing and killing");
		MapMessage message=session.createMapMessage();
		message.setBoolean("ToBeORNotToBe", true);
		message.setString("String", "WhatEver 你喜欢就好");
		message.setDouble("北京房价", 51478.21);
		int salary=20000;
		while(true){
			message.setInt("salary", salary+=1000);
			producer.send(dest, message);
			Thread.sleep(1000);
			System.out.println("send topic"+salary);
		}	
	}
}
