package com.derun.commnuication;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

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
import com.derun.entity.cheerMachine;

@Service
public class commController   {

	//@Autowired
	//private serialPort serialPort;
	//@Resource
	private List<finiteStateMahine> lstMachines=new ArrayList<finiteStateMahine>(); 
		
	//@Resource
	private finiteStateMahine machine;
	//@Resource
	//private ApplicationContext context;
	
	@Autowired
	public commController(CheerinfoDAO arg1,serialPort arg3) throws CloneNotSupportedException{
		//serialPort=arg3;
		//machine=arg2;
		//System.out.println(arg2.size());
		//initController();
		//lstMachines=new ArrayList<finiteStateMahine>();
		//finiteStateMahine machine;
		//Map<String,String> machineInfo=new HashMap<String,String>();
		List<cheerMachine> lstObjs=arg1.findALL();
		//System.out.println(lstObjs.size());
		for(cheerMachine object:lstObjs){
			machine=new finiteStateMahine();
			//WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();初始化的时候不行....
			//System.out.println(wac);
			//machine=wac.getBean(finiteStateMahine.class);//context.getBean(finiteStateMahine.class);
			machine.setParams(Integer.parseInt(object.getAlleywayMark().trim()), Integer.parseInt(object.getGunCode()));			
			lstMachines.add(machine);
		}		
//		for(finiteStateMahine obj:lstMachines){
//			//if(obj.getGunId()==3)
//			new Thread(obj).start();
//		}
		//System.out.println(lstMachines.size()+".......................................................................");
	}
//	private void initController(){
//		lstMachines=new ArrayList<finiteStateMahine>();
//		finiteStateMahine machine;
//		Map<String,String> machineInfo=new HashMap<String,String>();
////		List<cheerMachine> lstObjs=cheers.findALL();		
////		for(cheerMachine object:lstObjs){
////			machine=new finiteStateMahine();
////			machine.setParams(Integer.parseInt(object.getAlleywayMark()), Integer.parseInt(object.getGunCode()));
////			new Thread(machine).start();
////			lstMachines.add(machine);
////		}
//	}
	public List<finiteStateMahine> getLstMachines() {
		return lstMachines;
	}

	
}
