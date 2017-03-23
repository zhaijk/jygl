package com.derun.jms;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MessListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try{
			MapMessage map=(MapMessage)message;
			System.out.println(map.getString("String")+map.getDouble("北京房价")+map.getBoolean("ToBeORNotToBe"));
			System.out.println(map.getInt("salary"));
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}
