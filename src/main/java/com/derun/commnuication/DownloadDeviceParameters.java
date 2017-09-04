package com.derun.commnuication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.derun.dao.BlacklistDAO;
//import com.derun.dao.CardPutoutDAO;
import com.derun.dao.CheerinfoDAO;
import com.derun.dao.SysTemParameterDAO;
//import com.derun.entity.Blacklist;
//import com.derun.entity.CardPutout;
import com.derun.entity.SysPara;
import com.derun.entity.cheerMachine;

@Service
public class DownloadDeviceParameters {

	@Autowired
	private  CheerinfoDAO 			deviceDao;	
	@Autowired
	private  SysTemParameterDAO 	sysDao;	
	//@Autowired
	//private  BlacklistDAO    		blacklistDao;
	//@Autowired
	//private  CardPutoutDAO 			quotaDao;
//	@Autowired
//	private SysTemParameterDAO  	stpDAO;
	@Autowired 
	private CommController 			controller;	
	
	private volatile int gunid;
	private volatile int status;	
	private volatile int total;
	private volatile int counter;	
		
	public int getTotal() {
		return total;
	}
	public int getCounter() {
		return counter;
	}
	public int getStatus() {
		return status;
	}
//	public void setCounter(int counter) {
//		this.counter=counter;
//	}
//	public void setGunid(int status) {						
//		this.gunid = controller.getLstMachines().get(status-1).getGunId();
//		//System.out.println(gunid);
//	}
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
//		List<Blacklist> blacks=blacklistDao.findALL();
		List<cheerMachine> objs=deviceDao.findALL();
//		List<CardPutout>   quotas= quotaDao.findALL();
//		//for()
//		FiniteStateMahine fsm=controller.getLstMachine(gunid);
//		SetBlackList command=fsm.getSetBlackList();
//		counter=0;
//		total=objs.size();
		status=0;
		int retry=4;
		for(cheerMachine obj:objs){
			//int channelid=Integer.parseInt(obj.getAlleywayMark());
			//gunid=Integer.parseInt(obj.getGunCode());
			status=1;
			//FiniteStateMahine fsm=new FiniteStateMahine(channelid,gunid,stpDAO,deviceDao);//controller.getLstMachine(status);
			FiniteStateMahine fsm=controller.getLstMachine(Integer.parseInt(obj.getGunCode()));
			fsm.getSetDateTime().setStrValue(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			int result=fsm.getSetDateTime().queryretry(retry);//下传时钟
			if(result!=0) continue;
			fsm.getSetOilType().setStrValue(deviceDao.findOilTypeCode(obj.getGunCode()));
			status=2;
			result=fsm.getSetOilType().queryretry(retry);//设置油品
			if(result!=0) continue;
			status=3;
			SysPara paras=sysDao.findOne();			
			fsm.getSetHQAuthID().setStrValue(paras.getHeadQuartersCortrolCode());//联勤码	
			result=fsm.getSetHQAuthID().queryretry(retry);
			if(result!=0) continue;			
			fsm.getSetHTAuthID().setStrValue(paras.getAmountCortrolCode());
			result=fsm.getSetHTAuthID().queryretry(retry);
			if(result!=0) continue;	
			fsm.getSetStationID().setStrValue(paras.getStationCode());
			result=fsm.getSetStationID().queryretry(retry);
			if(result!=0) continue;
			status=5;
//			SendQuotas sendQComm=fsm.getSetQuotaList();//指标
//			int counter=1;
//			for (CardPutout quota:quotas){		 
//				sendQComm.setQuota(counter, quota);
//				result=sendQComm.queryretry(4);
//				if(result!=0) break;
// 			}		
//			if(result!=0) continue;
//			status=6;
//			SetBlackList blcomm=fsm.getSetBlackList();
//			counter=1;
//			for (Blacklist blacklist:blacks){		 //黑名单
//				blcomm.setCardCode12(counter, blacklist.getCardcode());
//				result=blcomm.queryretry(4);
//				if(result!=0) break;
// 			}
		}
	}
	public void download(int gunid){	
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
		//List<Blacklist> blacks=blacklistDao.findALL();
		List<cheerMachine> objs=deviceDao.findALL();
		//List<CardPutout>   quotas= quotaDao.findALL();
//		//for()
//		FiniteStateMahine fsm=controller.getLstMachine(gunid);
//		SetBlackList command=fsm.getSetBlackList();
//		counter=0;
//		total=objs.size();
		status=0;
		int retry=4;
		for(cheerMachine obj:objs){
			int code=Integer.parseInt(obj.getGunCode());
			if(code!=gunid) continue;
			//int channelid=Integer.parseInt(obj.getAlleywayMark());
			//gunid=Integer.parseInt(obj.getGunCode());
			status=1;
			//FiniteStateMahine fsm=new FiniteStateMahine(channelid,gunid,stpDAO,deviceDao);//controller.getLstMachine(status);
			FiniteStateMahine fsm=controller.getLstMachine(gunid);
			fsm.getSetDateTime().setStrValue(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			int result=fsm.getSetDateTime().queryretry(retry);//下传时钟
			if(result!=0) continue;
			fsm.getSetOilType().setStrValue(deviceDao.findOilTypeCode(obj.getGunCode()));
			status=2;
			result=fsm.getSetOilType().queryretry(retry);//设置油品
			if(result!=0) continue;
			status=3;
			SysPara paras=sysDao.findOne();			
			fsm.getSetHQAuthID().setStrValue(paras.getHeadQuartersCortrolCode());//联勤码	
			result=fsm.getSetHQAuthID().queryretry(retry);
			if(result!=0) continue;			
			fsm.getSetHTAuthID().setStrValue(paras.getAmountCortrolCode());
			result=fsm.getSetHTAuthID().queryretry(retry);
			if(result!=0) continue;	
			fsm.getSetStationID().setStrValue(paras.getStationCode());
			result=fsm.getSetStationID().queryretry(retry);
			if(result!=0) continue;
			status=5;
//			SendQuotas sendQComm=fsm.getSetQuotaList();//指标
//			int counter=1;
//			for (CardPutout quota:quotas){		 
//				sendQComm.setQuota(counter, quota);
//				result=sendQComm.queryretry(4);
//				if(result!=0) break;
// 			}		
//			if(result!=0) continue;
//			status=6;
//			SetBlackList blcomm=fsm.getSetBlackList();
//			counter=1;
//			for (Blacklist blacklist:blacks){		 //黑名单
//				blcomm.setCardCode12(counter, blacklist.getCardcode());
//				result=blcomm.queryretry(4);
//				if(result!=0) break;
// 			}
			break;
		}
	}
}
