package com.derun.jms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSServer {

	public static void main(String[] args) throws JMSException, InterruptedException{
		String jmsProviderAddress="tcp://localhost:61616";
		//连接器
		ConnectionFactory cf=new ActiveMQConnectionFactory(jmsProviderAddress);
		//连接
		Connection conn=cf.createConnection();
		//会话
		final Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//消息目的地
		Destination dest=session.createQueue("demoQueue");
		//消息产生者
		final MessageProducer mp=session.createProducer(dest);
		ExecutorService  exec=Executors.newFixedThreadPool(10);
		exec.execute(new Runnable(){

			@Override
			public void run() {
				for(int i=1;;i++){
					//一条消息
					Message message;
					try {
						message = session.createTextMessage("Hello 你妈是猴！！！"+i);
						mp.send(message);
						Thread.sleep(1000);
					} catch (JMSException e) {					
						e.printStackTrace();
					}catch (InterruptedException e) {					
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}
			
		});		
//		mp.close();			//关闭消息产生者
//		session.close();	//关闭会话
//		conn.close();		//关闭连接
	}
}
