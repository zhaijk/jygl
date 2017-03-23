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
		//������
		ConnectionFactory cf=new ActiveMQConnectionFactory(jmsProviderAddress);
		//����
		Connection conn=cf.createConnection();
		//�Ự
		final Session session=conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//��ϢĿ�ĵ�
		Destination dest=session.createQueue("demoQueue");
		//��Ϣ������
		final MessageProducer mp=session.createProducer(dest);
		ExecutorService  exec=Executors.newFixedThreadPool(10);
		exec.execute(new Runnable(){

			@Override
			public void run() {
				for(int i=1;;i++){
					//һ����Ϣ
					Message message;
					try {
						message = session.createTextMessage("Hello �����Ǻ����"+i);
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
//		mp.close();			//�ر���Ϣ������
//		session.close();	//�رջỰ
//		conn.close();		//�ر�����
	}
}
