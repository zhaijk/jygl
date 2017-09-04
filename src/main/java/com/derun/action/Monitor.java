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
		List<FiniteStateMahine> lstObjs=controller.getLstMachines();//��ǰIC����Ӧ�ö���
		for(FiniteStateMahine object:lstObjs){			
			if(object.getGunId()==id){
				switch(object.getCommStatus()){
				case 2://�忨 ��������
					object.setOn_Off(true);
					return "success";
				case 3://������ ֹͣ��������
					object.setOn_Off(false);
					return "success";
				default://������
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
	List<machineStatus> infos=new ArrayList<machineStatus>();//��������
	
	@RequestMapping(value="getdevinfo/{id}",method=RequestMethod.GET)	
	@ResponseBody
	public Object  getOilgunInfo(@PathVariable int id){
		
//		machineStatus info=new machineStatus();
//		List<machineStatus> infos=new ArrayList<machineStatus>();
//		
//		if((id%2)==0){
//			info.setCommStatus("ͨѶ����");
//			info.setStatus("�ȴ��忨");
//		}
//		else{
//			info.setCommStatus("ͨѶʧ��");
//			info.setStatus("����....");
//		}
//			
//		info.setItem1("�ϴμ���");
//		info.setItem2("�ϴ�����");
//		info.setItem3("����");
//		info.setItem4("��������");
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
//			System.out.println(object.getGunId()+"��ǹ  ״̬"+object.getCommStatus()+" "+object.getQueryStatus().query());
//			System.out.println(object.getQueryCardInfos());
//			System.out.println(object.getQueryOilNumber());
//			//object.setOn_Off(false);
//			//object.setOn_Off(true);
//			if(object.getCommStatus()==0)
//				new Thread(object).start();
//		}
		infos.clear();
		machineStatus info;
		List<FiniteStateMahine> lstObjs=controller.getLstMachines();//��ǰIC����Ӧ�ö���
		for(FiniteStateMahine object:lstObjs){
			if(id==0){				
				info=new machineStatus();
				info.setCommStatus("����:"+object.getSendCounter()+" ����:"+(object.getRecvCounter())+" ͨ��:"+(object.getChannelId()+1));
				switch(object.getCommStatus()){
				case 0:				
					info.setCommStatus("ͨѶʧ��"+" ͨ��:"+(object.getChannelId()+1));
					info.setStatus("ͨѶʧ��");
					info.setItem1("�ϴμ���");
					info.setItem2("�ϴ�����");
					info.setItem3("���Ϳ���");
					info.setItem4("��������");
					info.setValue1("????.??");
					info.setValue2("????-??-??");
					info.setValue3("??????????");
					info.setValue4("images/car.gif");		
				break;
				case 1:
					info.setStatus("�ȴ��忨....");
					info.setItem1("�ϴμ���");
					info.setItem2("�ϴ�����");
					info.setItem3("���Ϳ���");
					info.setItem4("��������");
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
					info.setStatus("(����)");
					info.setItem1("���Ϳ���");
					info.setItem2("�������");
					info.setItem3("�����ƺ�");
					info.setItem4("���Ѵ���");
					info.setValue1(object.getQueryCardInfos().getCardinfo().getCardID());
					String strValue=object.getQueryCardInfos().getCardinfo().getCardBanlance();
					//logger.debugLog("�������"+strValue);
					//Integer intValue=Integer.parseInt();
					//value=intValue.toString();
					//value=value.substring(0,value.length()-2)+"."+value.substring(value.length()-2,value.length());
					info.setValue2(strValue);
					info.setValue3(object.getQueryCardInfos().getCardinfo().getCarNumber());
					info.setValue4(object.getQueryCardInfos().getCardinfo().getTradeCounter());
				break;
				case 3:
					info.setStatus("������ (ֹͣ����)");
					info.setItem1("���Ϳ���");
					info.setItem2("�������");
					info.setItem3("�����ƺ�");
					info.setItem4("��������");
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
					case 1://С�ͳ�
						info.setValue4("images/car.gif");
					break;
					case 2://�����
						info.setValue4("images/bus.gif");
					break;
					case 3://��ͳ�
					info.setValue4("images/bigbus.gif");
					break;
					case 4://����
						info.setValue4("images/truck.gif");
						break;
					case 5://ԽҰ��
						info.setValue4("images/jeep.gif");
						break;
					default:
						info.setValue4("images/car.gif");
					}				
					break;
				default:
					info.setCommStatus("ͨѶʧ��"+" ͨ��:"+(object.getChannelId()+1));
					info.setStatus("�ȴ��忨....");
					info.setItem1("�ϴμ���");
					info.setItem2("�ϴ�����");
					info.setItem3("���Ϳ���");
					info.setItem4("��������");
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
				info.setCommStatus("����:"+object.getSendCounter()+" ����:"+(object.getRecvCounter())+" ͨ��:"+(object.getChannelId()+1));
				switch(object.getCommStatus()){
				case 0:				
					info.setCommStatus("ͨѶʧ��"+" ͨ��:"+(object.getChannelId()+1));
					info.setStatus("ͨѶʧ��");
					info.setItem1("�ϴμ���");
					info.setItem2("�ϴ�����");
					info.setItem3("���Ϳ���");
					info.setItem4("��������");
					info.setValue1("????.??");
					info.setValue2("????-??-??");
					info.setValue3("??????????");
					info.setValue4("images/car.gif");		
				break;
				case 1:
					info.setStatus("�ȴ��忨....");
					info.setItem1("�ϴμ���");
					info.setItem2("�ϴ�����");
					info.setItem3("���Ϳ���");
					info.setItem4("��������");
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
					info.setStatus("(����)");
					info.setItem1("���Ϳ���");
					info.setItem2("�������");
					info.setItem3("�����ƺ�");
					info.setItem4("���Ѵ���");
					info.setValue1(object.getQueryCardInfos().getCardinfo().getCardID());
					String strValue=object.getQueryCardInfos().getCardinfo().getCardBanlance();
					//logger.debugLog("�������"+strValue);
					//Integer intValue=Integer.parseInt();
					//value=intValue.toString();
					//value=value.substring(0,value.length()-2)+"."+value.substring(value.length()-2,value.length());
					info.setValue2(strValue);
					info.setValue3(object.getQueryCardInfos().getCardinfo().getCarNumber());
					info.setValue4(object.getQueryCardInfos().getCardinfo().getTradeCounter());
				break;
				case 3:
					info.setStatus("������ (ֹͣ����)");
					info.setItem1("���Ϳ���");
					info.setItem2("�������");
					info.setItem3("�����ƺ�");
					info.setItem4("��������");
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
					case 1://С�ͳ�
						info.setValue4("images/car.gif");
					break;
					case 2://�����
						info.setValue4("images/bus.gif");
					break;
					case 3://��ͳ�
					info.setValue4("images/bigbus.gif");
					break;
					case 4://����
						info.setValue4("images/truck.gif");
						break;
					case 5://ԽҰ��
						info.setValue4("images/jeep.gif");
						break;
					default:
						info.setValue4("images/car.gif");
					}				
					break;
				default:
					info.setCommStatus("ͨѶʧ��"+" ͨ��:"+(object.getChannelId()+1));
					info.setStatus("�ȴ��忨....");
					info.setItem1("�ϴμ���");
					info.setItem2("�ϴ�����");
					info.setItem3("���Ϳ���");
					info.setItem4("��������");
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
	@RequestMapping("monitor.htm")//����ҳ����Ϣ ���������� ���� ͨѶ״̬ ��ǰ����״̬	
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
		cheersMap.addAttribute("cheersCounter", lstObjs.size());//���ͻ�����
		cheersMap.addAttribute("cheersInfo", info);
		cheersMap.addAttribute("username",users.findAccountByName(request.getUserPrincipal().getName()));
		//cheersMap.put("username",((SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getName() );
		//cheersMap.put("username1 ",SecurityContextHolder.getContext().getAuthentication().getName());
		//cheersMap.put("username2 ",request.getUserPrincipal().getName());
		switch(lstObjs.size()){//��ͬ��IC���� ��ͬ�Ĳ���
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
