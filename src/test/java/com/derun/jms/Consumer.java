package com.derun.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] args) throws JMSException{
		String brokerUrl="tcp://127.0.0.1:61616";
		ConnectionFactory cf=new ActiveMQConnectionFactory(brokerUrl);
		Connection conn=cf.createConnection();
		conn.start();
		Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest=session.createTopic("dancing and killing");
		MessageConsumer consumer=session.createConsumer(dest);
		consumer.setMessageListener(new MessListener());
	}
}
