package com.derun.commnuication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.derun.dao.CardPutoutDAO;
import com.derun.entity.CardPutout;

@Service
public class DownloadQuotaList {

	@Autowired
	private  CardPutoutDAO dao;	
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
	
	public void download(){	
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
		//System.out.println(String.format("%02d", gunid));
		
		List<CardPutout> objs=dao.findByGuncode(String.format("%02d", gunid));
		FiniteStateMahine fsm=controller.getLstMachine(gunid);
		SendQuotas command=fsm.getSetQuotaList();
		counter=1;
		total=objs.size();
		//System.out.println(total);
		for(CardPutout obj:objs){
			command.setQuota(counter, obj); 
			command.query();
			counter++;			
		}
	}
}
