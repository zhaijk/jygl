package com.derun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derun.commnuication.finiteStateMahine;
import com.derun.entity.cardtrade;

@Service
public class scanTradeThread implements Runnable{
	@Autowired
	private TradeDAO trades;
	
	public scanTradeThread(){
		new Thread(this,"数据插入线程");
	}
	public void run() {
		List<cardtrade> lstObjs=finiteStateMahine.getLstObjs();
		while(true){
			try {
				int counter=lstObjs.size();
				System.out.println("列表长度 :  "+counter);
				if(counter>0){
					lstObjs.get(0).setOilType("23");
					lstObjs.get(0).setTFlag(false);
					lstObjs.get(0).setOperatorName("王师傅");
					String buff=lstObjs.get(0).getTradeDate();					
					lstObjs.get(0).setTradeDate(buff.substring(0,4)+"-"+buff.substring(4,6)+"-"+buff.substring(6,8));
					buff=lstObjs.get(0).getTradeTime();
					lstObjs.get(0).setTradeTime(buff.substring(0,2)+":"+buff.substring(2,4)+":"+buff.substring(4,6));
					lstObjs.get(0).setBalance(lstObjs.get(0).getBalance()/100);
					lstObjs.get(0).setCardMoney(lstObjs.get(0).getCardMoney()/100);
					lstObjs.get(0).setVolumn(lstObjs.get(0).getVolumn()/100);
					trades.insertOne(lstObjs.get(0));
					lstObjs.remove(0);
				}
				else					
					Thread.sleep(2000);				
			} catch (InterruptedException e) {
				
			}
		}
	}
}
