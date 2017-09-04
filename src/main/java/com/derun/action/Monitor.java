package com.derun.action;


import java.util.List;
import java.util.ArrayList;


import javax.annotation.Resource;

import com.derun.commnuication.CommController;
import com.derun.commnuication.SerialPortLocal;
import com.derun.commnuication.FiniteStateMahine;
//import com.derun.commnuication.logger;
import com.derun.dao.CheerinfoDAO;
import com.derun.dao.UsersDAO;
import com.derun.entity.cheerMachine;
import com.derun.model.machineStatus;
import com.derun.model.refueler;

import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Monitor {
		
//	@Autowired
//	private  HttpServletRequest req;
	
	@Resource
	private  CheerinfoDAO cheers;	
	@Autowired
	private UsersDAO users;	
	@Autowired
	private CommController  controller;
	@Autowired
	private SerialPortLocal sp;
	
	@RequestMapping(value="setonoff/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String setOnOff(@PathVariable int id){
		List<FiniteStateMahine> lstObjs=controller.getLstMachines();//当前IC卡机应用对象
		for(FiniteStateMahine object:lstObjs){			
			if(object.getGunId()==id){
				switch(object.getCommStatus()){
				case 2://插卡 开机命令
					object.setOn_Off(true);
					return "success";
				case 3://加油中 停止加油命令
					object.setOn_Off(false);
					return "success";
				default://其他的
					break;
				}
			}
		}
		return "failure";
	}
	@RequestMapping(value="closedevice/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String closedevice(@PathVariable int id) throws InterruptedException{
		controller.stopMachines(id);
		//Thread.sleep(1000);
		//sp.reOpen();
		//controller.initMachines();
		return "success";
	}		
	@RequestMapping(value="opendevice/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String reopendevice(@PathVariable int id) throws InterruptedException{		
		//sp.reOpen();
		//controller.initMachines();
		//return "success";
		//sp.reOpen();
		controller.initMachines(id);		
		return "success";
	}
	@RequestMapping(value="reopen/port",method=RequestMethod.GET)
	@ResponseBody
	public String reopenport() throws InterruptedException{		
		sp.reopen();
		//controller.initMachines();
		//return "success";
		//sp.reOpen();
		//controller.initMachines(id);		
		return "success";
	}
	@RequestMapping(value="open/port",method=RequestMethod.GET)
	@ResponseBody
	public String openport() throws InterruptedException{		
		sp.open();
		//controller.initMachines();
		//return "success";
		//sp.reOpen();
		//controller.initMachines(id);		
		return "success";
	}
	@RequestMapping(value="close/port",method=RequestMethod.GET)
	@ResponseBody
	public String closeport() throws InterruptedException{		
		sp.close();
		//controller.initMachines();
		//return "success";
		//sp.reOpen();
		//controller.initMachines(id);		
		return "success";
	}
	List<machineStatus> infos=new ArrayList<machineStatus>();//返回数据
	
	@RequestMapping(value="getdevinfo/{id}",method=RequestMethod.GET)	
	@ResponseBody
	public Object  getOilgunInfo(@PathVariable int id){
		
//		machineStatus info=new machineStatus();
//		List<machineStatus> infos=new ArrayList<machineStatus>();
//		
//		if((id%2)==0){
//			info.setCommStatus("通讯正常");
//			info.setStatus("等待插卡");
//		}
//		else{
//			info.setCommStatus("通讯失败");
//			info.setStatus("开机....");
//		}
//			
//		info.setItem1("上次加油");
//		info.setItem2("上次日期");
//		info.setItem3("卡号");
//		info.setItem4("车辆类型");
//		info.setValue1((12.34+100*id)+"");
//		info.setValue2("2015-01-"+id);
//		info.setValue3("720001890001");
//		info.setValue4("images/truck.gif");
//		if(id==1)
//			info.setValue4("images/bigbus.gif");
//		if(id==2)
//			info.setValue4("images/bus.gif");
//		if(id==3)
//			info.setValue4("images/car.gif");
//		if(id==4)
//			info.setValue4("images/jeep.gif");
//		if(id==5)
//			info.setValue4("images/truck.gif");
//		
//		
//		for(int i=0;i<16;i++)
//			infos.add(info);
//		List<finiteStateMahine> lstMachines=controller.getLstMachines();
//		for(finiteStateMahine object:lstMachines){
//			System.out.println(object.getGunId()+"号枪  状态"+object.getCommStatus()+" "+object.getQueryStatus().query());
//			System.out.println(object.getQueryCardInfos());
//			System.out.println(object.getQueryOilNumber());
//			//object.setOn_Off(false);
//			//object.setOn_Off(true);
//			if(object.getCommStatus()==0)
//				new Thread(object).start();
//		}
		infos.clear();
		machineStatus info;
		List<FiniteStateMahine> lstObjs=controller.getLstMachines();//当前IC卡机应用对象
		for(FiniteStateMahine object:lstObjs){
			if(id==0){				
				info=new machineStatus();
				info.setCommStatus("发送:"+object.getSendCounter()+" 接收:"+(object.getRecvCounter())+" 通道:"+(object.getChannelId()+1));
				switch(object.getCommStatus()){
				case 0:				
					info.setCommStatus("通讯失败"+" 通道:"+(object.getChannelId()+1));
					info.setStatus("通讯失败");
					info.setItem1("上次加油");
					info.setItem2("上次日期");
					info.setItem3("加油卡号");
					info.setItem4("车辆类型");
					info.setValue1("????.??");
					info.setValue2("????-??-??");
					info.setValue3("??????????");
					info.setValue4("images/car.gif");		
				break;
				case 1:
					info.setStatus("等待插卡....");
					info.setItem1("上次加油");
					info.setItem2("上次日期");
					info.setItem3("加油卡号");
					info.setItem4("车辆号牌");
					String value=object.getQueryCardInfos().getCardinfo().getLastOilValue();
					if((value!=null)&&(value.length()==6))
						info.setValue1(value.substring(0,4)+"."+value.substring(4,6));
					else
						info.setValue1(object.getQueryCardInfos().getCardinfo().getLastOilValue());
					value=object.getQueryCardInfos().getCardinfo().getLastOilDateTime();
					if((value!=null)&&(value.length()==8))
						info.setValue2(value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8));
					else
						info.setValue2(object.getQueryCardInfos().getCardinfo().getLastOilValue());
					//info.setValue2();
					info.setValue3(object.getQueryCardInfos().getCardinfo().getCardID());
					info.setValue4(object.getQueryCardInfos().getCardinfo().getCarNumber());
				break;
				case 2:
					info.setStatus("(开机)");
					info.setItem1("加油卡号");
					info.setItem2("卡上余额");
					info.setItem3("车辆牌号");
					info.setItem4("消费次数");
					info.setValue1(object.getQueryCardInfos().getCardinfo().getCardID());
					String strValue=object.getQueryCardInfos().getCardinfo().getCardBanlance();
					//logger.debugLog("卡上余额"+strValue);
					//Integer intValue=Integer.parseInt();
					//value=intValue.toString();
					//value=value.substring(0,value.length()-2)+"."+value.substring(value.length()-2,value.length());
					info.setValue2(strValue);
					info.setValue3(object.getQueryCardInfos().getCardinfo().getCarNumber());
					info.setValue4(object.getQueryCardInfos().getCardinfo().getTradeCounter());
				break;
				case 3:
					info.setStatus("加油中 (停止加油)");
					info.setItem1("加油卡号");
					info.setItem2("卡上余额");
					info.setItem3("车辆牌号");
					info.setItem4("车辆类型");
					info.setValue1(object.getQueryCardInfos().getCardinfo().getCardID());
					info.setValue5(object.getQueryCardInfos().getCardinfo().getCarNumber());
					strValue=object.getQueryCardInfos().getCardinfo().getCardBanlance();
					info.setValue2(String.format("%.2f",(Double.parseDouble(strValue)/100)));
					//intValue=Integer.parseInt(object.getQueryCardInfos().getCardinfo().getCardBanlance());
					//value=intValue.toString();
					//value=value.substring(0,value.length()-2)+"."+value.substring(value.length()-2,value.length());
					//info.setValue2(value);
					//info.setValue3(object.getQueryCardInfos().getCardinfo().getCarNumber());
					info.setValue3(object.getQueryOilNumber().getStrOilValue());
					int carType=Integer.parseInt(object.getQueryCardInfos().getCardinfo().getCarType());
					switch(carType){
					case 1://小客车
						info.setValue4("images/car.gif");
					break;
					case 2://面包车
						info.setValue4("images/bus.gif");
					break;
					case 3://大客车
					info.setValue4("images/bigbus.gif");
					break;
					case 4://卡车
						info.setValue4("images/truck.gif");
						break;
					case 5://越野车
						info.setValue4("images/jeep.gif");
						break;
					default:
						info.setValue4("images/car.gif");
					}				
					break;
				default:
					info.setCommStatus("通讯失败"+" 通道:"+(object.getChannelId()+1));
					info.setStatus("等待插卡....");
					info.setItem1("上次加油");
					info.setItem2("上次日期");
					info.setItem3("加油卡号");
					info.setItem4("车辆类型");
					info.setValue1("????.??");
					info.setValue2("????-??-??");
					info.setValue3("??????????");
					info.setValue4("images/car.gif");		
					break;
				}
				infos.add(info);				
			}else if(id!=object.getGunId()){
				continue;
			}else if(id==object.getGunId()){
				info=new machineStatus();
				info.setCommStatus("发送:"+object.getSendCounter()+" 接收:"+(object.getRecvCounter())+" 通道:"+(object.getChannelId()+1));
				switch(object.getCommStatus()){
				case 0:				
					info.setCommStatus("通讯失败"+" 通道:"+(object.getChannelId()+1));
					info.setStatus("通讯失败");
					info.setItem1("上次加油");
					info.setItem2("上次日期");
					info.setItem3("加油卡号");
					info.setItem4("车辆类型");
					info.setValue1("????.??");
					info.setValue2("????-??-??");
					info.setValue3("??????????");
					info.setValue4("images/car.gif");		
				break;
				case 1:
					info.setStatus("等待插卡....");
					info.setItem1("上次加油");
					info.setItem2("上次日期");
					info.setItem3("加油卡号");
					info.setItem4("车辆号牌");
					String value=object.getQueryCardInfos().getCardinfo().getLastOilValue();
					if((value!=null)&&(value.length()==6))
						info.setValue1(value.substring(0,4)+"."+value.substring(4,6));
					else
						info.setValue1(object.getQueryCardInfos().getCardinfo().getLastOilValue());
					value=object.getQueryCardInfos().getCardinfo().getLastOilDateTime();
					if((value!=null)&&(value.length()==8))
						info.setValue2(value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8));
					else
						info.setValue2(object.getQueryCardInfos().getCardinfo().getLastOilValue());
					//info.setValue2();
					info.setValue3(object.getQueryCardInfos().getCardinfo().getCardID());
					info.setValue4(object.getQueryCardInfos().getCardinfo().getCarNumber());
				break;
				case 2:
					info.setStatus("(开机)");
					info.setItem1("加油卡号");
					info.setItem2("卡上余额");
					info.setItem3("车辆牌号");
					info.setItem4("消费次数");
					info.setValue1(object.getQueryCardInfos().getCardinfo().getCardID());
					String strValue=object.getQueryCardInfos().getCardinfo().getCardBanlance();
					//logger.debugLog("卡上余额"+strValue);
					//Integer intValue=Integer.parseInt();
					//value=intValue.toString();
					//value=value.substring(0,value.length()-2)+"."+value.substring(value.length()-2,value.length());
					info.setValue2(strValue);
					info.setValue3(object.getQueryCardInfos().getCardinfo().getCarNumber());
					info.setValue4(object.getQueryCardInfos().getCardinfo().getTradeCounter());
				break;
				case 3:
					info.setStatus("加油中 (停止加油)");
					info.setItem1("加油卡号");
					info.setItem2("卡上余额");
					info.setItem3("车辆牌号");
					info.setItem4("车辆类型");
					info.setValue1(object.getQueryCardInfos().getCardinfo().getCardID());
					strValue=object.getQueryCardInfos().getCardinfo().getCardBanlance();
					info.setValue2(strValue);
					//intValue=Integer.parseInt(object.getQueryCardInfos().getCardinfo().getCardBanlance());
					//value=intValue.toString();
					//value=value.substring(0,value.length()-2)+"."+value.substring(value.length()-2,value.length());
					//info.setValue2(value);
					//info.setValue3(object.getQueryCardInfos().getCardinfo().getCarNumber());
					info.setValue3(object.getQueryOilNumber().getStrOilValue());
					int carType=Integer.parseInt(object.getQueryCardInfos().getCardinfo().getCarType());
					switch(carType){
					case 1://小客车
						info.setValue4("images/car.gif");
					break;
					case 2://面包车
						info.setValue4("images/bus.gif");
					break;
					case 3://大客车
					info.setValue4("images/bigbus.gif");
					break;
					case 4://卡车
						info.setValue4("images/truck.gif");
						break;
					case 5://越野车
						info.setValue4("images/jeep.gif");
						break;
					default:
						info.setValue4("images/car.gif");
					}				
					break;
				default:
					info.setCommStatus("通讯失败"+" 通道:"+(object.getChannelId()+1));
					info.setStatus("等待插卡....");
					info.setItem1("上次加油");
					info.setItem2("上次日期");
					info.setItem3("加油卡号");
					info.setItem4("车辆类型");
					info.setValue1("????.??");
					info.setValue2("????-??-??");
					info.setValue3("??????????");
					info.setValue4("images/car.gif");		
					break;
				}
				infos.add(info);
				break;
			}			
		}
		return infos;
	}	
	@RequestMapping("monitor.htm")//加载页面信息 控制器数量 参数 通讯状态 当前工作状态	
	public String monitors(HttpServletRequest request,ModelMap cheersMap){
		
		//Map<String,String> info=new HashMap<String,String>();
		List<refueler> info =new ArrayList<refueler>();
		
		List<cheerMachine>  lstObjs=cheers.findALL();
		for(cheerMachine obj:lstObjs){
			//info.put(obj.getGunCode(),cheers.findOilType(obj.getGunCode()));
			refueler object=new refueler();
			object.setGunID(obj.getGunCode());
			object.setOilType(cheers.findOilType(obj.getGunCode()));
			object.setChannelID(obj.getAlleywayMark());
			info.add(object);
		}
		cheersMap.addAttribute("cheersCounter", lstObjs.size());//加油机个数
		cheersMap.addAttribute("cheersInfo", info);
		cheersMap.addAttribute("username",users.findAccountByName(request.getUserPrincipal().getName()));
		//cheersMap.put("username",((SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getName() );
		//cheersMap.put("username1 ",SecurityContextHolder.getContext().getAuthentication().getName());
		//cheersMap.put("username2 ",request.getUserPrincipal().getName());
		switch(lstObjs.size()){//不同的IC卡机 不同的布局
		case 1:
			info.get(0).setPositionx("20%");
			info.get(0).setPositiony("30%");
			break;
		case 2:
			info.get(0).setPositionx("30%");
			info.get(0).setPositiony("30%");
			info.get(1).setPositionx("50%");
			info.get(1).setPositiony("30%");
			break;
		case 3:
			info.get(0).setPositionx("10%");
			info.get(0).setPositiony("30%");
			info.get(1).setPositionx("40%");
			info.get(1).setPositiony("30%");
			info.get(2).setPositionx("70%");
			info.get(2).setPositiony("30%");
			break;
		case 4:
			info.get(0).setPositionx("10%");
			info.get(0).setPositiony("30%");
			info.get(1).setPositionx("30%");
			info.get(1).setPositiony("30%");
			info.get(2).setPositionx("50%");
			info.get(2).setPositiony("30%");
			info.get(2).setPositionx("70%");
			info.get(2).setPositiony("30%");
			break;
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:		
//			for(int i=0;i<4;i++)
//				for(int j=0;j<4;j++){
//					info.get(i*4+j).setPositionx((3+j*25)+"%");
//					info.get(i*4+j).setPositiony((50*(i)+20)+"%");
//				}		
//			break;
		}	
		return "main";
	}
}
