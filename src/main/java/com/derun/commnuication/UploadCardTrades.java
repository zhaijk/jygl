package com.derun.commnuication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.derun.dao.TradeDAO;

@Service
public class UploadCardTrades {

	@Autowired
	private  TradeDAO dao;	
	@Autowired
	private CommController controller;	
	
	private volatile int gunid;
	private volatile int total;
	private volatile int counter;	
		
	public int getTotal() {
		return total;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter=counter;
	}
	public void setGunid(int index) {						
		this.gunid = controller.getLstMachines().get(index-1).getGunId();
		//System.out.println(gunid);
	}
	public int getGunid() {
		return gunid;
	}
	
	public void upload(){	
		//counter=0;
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//				List<Blacklist> objs=dao.findALL();
//				FiniteStateMahine fsm=controller.getLstMachine(gunid);
//				SetBlackList command=fsm.getSetBlackList();
//				counter=0;
//				total=objs.size();
//				for(Blacklist obj:objs){
//					command.setCardCode12(counter++, obj.getCardcode()); 
//					command.query();	
//					System.out.println(counter+" "+total);
//				}
//			}
//		}).start();
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//				List<CardPutout> objs=dao.findALL();
//				FiniteStateMahine fsm=controller.getLstMachine(gunid);
//				SendQuotas command=fsm.getSetQuotaList();
//				counter=1;
//				total=objs.size();
//				for(CardPutout obj:objs){
//					command.setQuota(counter, obj); 
//					command.query();
//					counter++;
//					//System.out.println(counter+" "+total);
//				}
//			}
//		}).start();	
		FiniteStateMahine fsm=controller.getLstMachine(gunid);
		QueryTradeNumber getNumber=fsm.getGetTradeNumber();
		QueryTradComm getTrade=fsm.getGetTrade();
		
		counter=1;
		total=0;
		for(int i=0;i<4;i++){
			int result=getNumber.query();
			if(result==0){
				total=getNumber.getIntValue();
				break;
			}
		}
//		while(counter<=total){
//		//for(int counter=1;;counter++){
//		//	System.out.println(counter);
//			getTrade.setCounter(counter);
//			for(int i=0;i<4;i++){
//				int result=getTrade.query();
//				if(result==0){
////					try{
////						//dao.insertOne(getTrade.getTradeinfo());
////					}catch(Exception e){
////						//e.printStackTrace();
////					}
//					break;
//				}
//			}
//			counter++;
//		}
		
		//for(int counter=1;counter<=total;counter++){
		while(counter<=total){
			getTrade.setCounter(counter);
			for(int i=0;i<4;i++){
				int result=getTrade.query();
				if(result==0){
					try{				
						getTrade.getTradeinfo().setOilType(fsm.getOiltype());
						dao.insertOne(getTrade.getTradeinfo());
					}catch(Exception e){
						e.printStackTrace();
						//System.out.println(counter);
					}
					break;
				}
			}
			counter++;
		}	
	}
}
