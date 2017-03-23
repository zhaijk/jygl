package com.derun.jms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSClient {

	public static void main(String[] args) throws JMSException{
		
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new Runnable(){
			@Override
			public void run() {
				//activeMQ服务器地址
				String jmsProviderAddress="tcp://localhost:61616";
				//创建连接工厂
				ConnectionFactory cf=new ActiveMQConnectionFactory(jmsProviderAddress);
				//创建连接
				Connection conn = null;
				try {
					conn = cf.createConnection();
				} catch (JMSException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//创建会话
				Session session = null;
				try {
					session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
				} catch (JMSException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//队列目标
				String destName="demoQueue";		
				Destination dest = null;
				try {
					dest = session.createQueue(destName);
				} catch (JMSException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//消费者
				MessageConsumer consumer = null;
				try {
					consumer = session.createConsumer(dest);
				} catch (JMSException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//连接消息队列
				try {
					conn.start();
				} catch (JMSException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}		
				while(true){					
					try {
						Message message = consumer.receive(2000);
						if(message==null) break;
						System.out.println("取回一条消息:"+((TextMessage)message).getText());
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						try {
							consumer.close();
						} catch (JMSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							session.close();
						} catch (JMSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							conn.close();
						} catch (JMSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}					
				}
			}
		});
		
	}
}
