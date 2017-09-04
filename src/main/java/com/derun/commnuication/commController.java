package com.derun.commnuication;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import javax.annotation.Resource;

//import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;

import com.derun.dao.CheerinfoDAO;
import com.derun.dao.SysTemParameterDAO;
import com.derun.dao.TradeDAO;
import com.derun.entity.cardtrade;
import com.derun.entity.cheerMachine;

@Service
public class CommController {

	//@Autowired
	//private serialPort serialPort;
	//@Resource
	private List<FiniteStateMahine> lstMachines=new ArrayList<FiniteStateMahine>(); 
	
	private ExecutorService execMachines;
	
	private ExecutorService execTrades=Executors.newSingleThreadExecutor();
	
	private String username;
		
	public void setUsername(String username) {
		this.username = username;
	}
	//@Resource
	//private finiteStateMahine machine;
	//@Resource
	//private ApplicationContext context;
	@Autowired
	private TradeDAO tradeDAO;	
//	@Autowired
//	private SysTemParameterDAO  stpDAO;
	//@Resource
//	@Autowired
//	private CheerinfoDAO cheerDAO;
	
//	@Autowired
//	private CheerinfoDAO cheerDAO;
//	@Autowired
//	private SerialPortLocal sp;
//	@Autowired
//	private ;
	@Autowired
	public CommController(CheerinfoDAO cheerDAO,SerialPortLocal sp,SysTemParameterDAO  stpDAO ) {
		//serialPort=arg3;
		//machine=arg2;
		//System.out.println(arg2.size());
		//initController();
		//lstMachines=new ArrayList<finiteStateMahine>();
		//finiteStateMahine machine;
		//Map<String,String> machineInfo=new HashMap<String,String>();
		//this.cheerDAO=cheerDAO;
	//public CommController(){
		int status =sp.getStatus();		
		List<cheerMachine> lstObjs=cheerDAO.findALL();
		if(lstObjs.size()==0) return;
		//System.out.println(lstObjs.size());
		for(cheerMachine object:lstObjs){
			FiniteStateMahine machine=new FiniteStateMahine(Integer.parseInt(object.getAlleywayMark().trim()), Integer.parseInt(object.getGunCode()),stpDAO,cheerDAO);
			//WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();初始化的时候不行....
			//System.out.println(wac);
			//machine=wac.getBean(finiteStateMahine.class);//context.getBean(finiteStateMahine.class);
			//machine.setParams(Integer.parseInt(object.getAlleywayMark().trim()), Integer.parseInt(object.getGunCode()));			
			machine.setOiltype(cheerDAO.findOilTypeCode(object.getGunCode()));
			lstMachines.add(machine);
		}		
		execMachines=Executors.newFixedThreadPool(lstObjs.size());
//		if(status==1)
//		for(finiteStateMahine obj:lstMachines){
//			//if(obj.getGunId()==3)
//			new Thread(obj).start();
//		}
//		if(status==1)
//		new Thread(new Runnable(){
//			@Override
//			public void run() {
//			while(true){	
//				try {
//					List<cardtrade> objs=finiteStateMahine.getLstObjs();
//					//logger.debugLog("数据队列："+objs.size());
//					for(cardtrade obj:objs){
//						tradeDAO.insertOnlineOne(obj);
//						objs.remove(obj);
//					}				
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {					
//					e.printStackTrace();
//				}
//			}}
//		}).start();
		//System.out.println(lstMachines.size()+".......................................................................");
		//if(status==1) ddps.download();//下传参数
		//if(status==1) ddps.initial();//初始化设备   
		if(status==1) initMachines(0);
		if(status==1) initTrades();
	}
//	private void initController(){
//		lstMachines=new ArrayList<finiteStateMahine>();
//		finiteStateMahine machine;
//		Map<String,String> machineInfo=new HashMap<String,String>();
////		List<cheerMachine> lstObjs=cheers.findALL();		
////		for(cheerMachine object:lstObjs){
////			machine=new finiteStateMahine();
////			machine.setParams																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			(Integer.parseInt(object.getAlleywayMark()), Integer.parseInt(object.getGunCode()));
////			new Thread(machine).start();
////			lstMachines.add(machine);
////		}
//	}
	public synchronized List<FiniteStateMahine> getLstMachines() {
		return lstMachines;
	}
	public synchronized FiniteStateMahine getLstMachine(int gunid) {		
		for(FiniteStateMahine obj:lstMachines){
			if(obj.getGunId()==gunid) return obj;
		}	
		return null;
	}
	public   void initMachines(int id){		
		if(id==0){
			for(FiniteStateMahine obj:lstMachines){			
				obj.setRunflag(true);
				execMachines.execute(obj);
			}
		}else{
			for(FiniteStateMahine obj:lstMachines){
				if(obj.getGunId()==id){
					obj.setRunflag(true);
					execMachines.execute(obj);
				}	
			}
		}
	}
	public void stopMachines(int id){
		if(id==0){
			for(FiniteStateMahine obj:lstMachines){
			//obj.setCommStatus(0);
				obj.setRunflag(false);
			//obj.set
			}
		}else{
			for(FiniteStateMahine obj:lstMachines){
				//obj.setCommStatus(0);
				if(obj.getGunId()==id)
					obj.setRunflag(false);
				//obj.set
			}
		}
		//initMachines();
//		if(execMachines.isShutdown()==false){
//			execMachines.shutdownNow();
//		}
	}
	private   void initTrades(){		
		execTrades.execute(dataQueue);		
	}
	Runnable dataQueue=new Runnable(){
		@Override
		public void run() {
		final long interval=1000;
		while(true){	
			try {
				List<cardtrade> objs=FiniteStateMahine.getLstObjs();
				//logger.debugLog("数据队列："+objs.size());
				for(cardtrade obj:objs){
					tradeDAO.insertOnlineOne(obj,username);
					objs.remove(obj);
				}
				Thread.sleep(interval);
			} catch (InterruptedException e) {					
				logger.debugLog("数据队列异常"+e.getMessage());
			}catch(Exception e ){
				logger.debugLog("数据队列异常"+e.getMessage());
			}
		}}
	};
	
}
