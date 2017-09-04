package com.derun.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.dao.CheerinfoDAO;
import com.derun.dao.SysTemParameterDAO;
import com.derun.entity.SysPara;
import com.derun.entity.cheerMachine;
import com.derun.commnuication.CommController;
import com.derun.commnuication.FiniteStateMahine;;
@Controller
public class DeviceParameterEditor {
	
	@Autowired
	private CheerinfoDAO cheerDAO;
	@Autowired
	private SysTemParameterDAO sysParaDAO; 
	@Autowired
	private CommController controller;
	
	@RequestMapping(value="downloadDevicePara.htm",method=RequestMethod.GET)
	public String loadParameter(ModelMap loadConfig){
		List<SysPara> sysPara=sysParaDAO.findALL();
		List<cheerMachine> cheers=cheerDAO.findALL();
		loadConfig.put("paras", sysPara.get(0));
		loadConfig.put("cheers", cheers);
		return "downloadParas";
	}
	@RequestMapping(value="setCheers/all",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setCheers(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}		
		//下传控制码
		//下传时间
		//下传油品单价
		return "1 2 3 4 5 6 7 8 号卡机 "
				+ "下传控制码成功下传时间下传油品单价";
	}
	@RequestMapping(value="setCheers/code",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setCode(@RequestBody CheerStatus[] objs){
		StringBuilder str=new StringBuilder();
		for(CheerStatus obj:objs){
			//System.out.println(obj.getIndex()+"-"+obj.getValue());
			if(obj.getValue()==1){
				FiniteStateMahine  fsm=controller.getLstMachine(obj.getIndex());
				SysPara sysP=sysParaDAO.findOne();
//				System.out.println(sysP.getHeadQuartersCortrolCode());
//				System.out.println(sysP.getAmountCortrolCode());
				fsm.getSetHQAuthID().setStrValue(sysP.getHeadQuartersCortrolCode());
				fsm.getSetHTAuthID().setStrValue(sysP.getAmountCortrolCode());
				fsm.getSetStationID().setStrValue(sysP.getStationCode());
				for(int i=0;i<4;i++){
					int result=fsm.getSetHQAuthID().query();
					//System.out.println(result);
					if(result!=0) continue;
					result=fsm.getQueryHQAuthID().query();
					//System.out.println(result);
					//System.out.println(fsm.getQueryHQAuthID().getStrValue()+" "+i);
					if(result!=0) continue;
					if(fsm.getQueryHQAuthID().getStrValue().equals(sysP.getHeadQuartersCortrolCode())){
						str.append("下传"+fsm.getGunId()+"号IC卡机 总部联勤码成功");
						break;
					}	
				}
				for(int i=0;i<4;i++){
					int result=fsm.getSetHTAuthID().query();
					///System.out.println(result);
					if(result!=0) continue;
					result=fsm.getQueryHTAuthID().query();
					//System.out.println(result);
					//System.out.println(fsm.getQueryHTAuthID().getStrValue()+" "+i);
					if(result!=0) continue;
					if(fsm.getQueryHTAuthID().getStrValue().equals(sysP.getAmountCortrolCode())){
						str.append("下传"+fsm.getGunId()+"号IC卡机 总队联勤码成功");
						break;
					}	
				}
				for(int i=0;i<4;i++){
					int result=fsm.getSetStationID().query();
					//System.out.println(result);
					if(result!=0) continue;
					result=fsm.getQueryStationID().query();
					//System.out.println(result);
					//System.out.println(fsm.getQueryStationID().getStrValue()+" "+i);
					if(result!=0) continue;
					if(fsm.getQueryStationID().getStrValue().equals(sysP.getStationCode())){
						str.append("下传"+fsm.getGunId()+"号IC卡机 站号成功");
						break;
					}	
				}
			}
		}		
		return str+"";
	}
	@RequestMapping(value="setCheers/clock",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setClock(@RequestBody CheerStatus[] objs){
		StringBuilder str=new StringBuilder();
		for(CheerStatus obj:objs){		
			//System.out.println("设置时钟:"+obj.getIndex()+"-"+obj.getValue());
			if(obj.getValue()==1){
				FiniteStateMahine  fsm=controller.getLstMachine(obj.getIndex());
//				SysPara sysP=sysParaDAO.findOne();
//				System.out.println(sysP.getHeadQuartersCortrolCode());
//				System.out.println(sysP.getAmountCortrolCode());
				String strValue=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				//System.out.println(strValue);
				fsm.getSetDateTime().setStrValue(strValue);				
				for(int i=0;i<4;i++){
					int result=fsm.getSetDateTime().query();
					//System.out.println(fsm.getGunId()+"设置时钟:"+result);
					if(result!=0) continue;
					result=fsm.getGetDateTime().query();
					//System.out.println("读取时钟:"+result);
					if(result!=0) continue;
					//System.out.println(fsm.getGetDateTime().getStrValue().substring(0,12));
					//System.out.println(strValue.substring(0,12));
					//					
					if(fsm.getGetDateTime().getStrValue().substring(0,12).equals(strValue.substring(0,12))){
						str.append(fsm.getGunId()+" ");
						break;
					}	
				}
			}
		}		
		return str+"成功";
		//下传系统时钟
		//return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
	}	
	@RequestMapping(value="getCheerClock/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getClock(@PathVariable int id){
		//StringBuilder str=new StringBuilder();
		//for(CheerStatus obj:objs){		
			//System.out.println("设置时钟:"+obj.getIndex()+"-"+obj.getValue());
			//if(obj.getValue()==1){
		FiniteStateMahine  fsm=controller.getLstMachine(id);
//				SysPara sysP=sysParaDAO.findOne();
//				System.out.println(sysP.getHeadQuartersCortrolCode());
//				System.out.println(sysP.getAmountCortrolCode());
		//String strValue=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				//System.out.println(strValue);
		//		fsm.getSetDateTime().setStrValue(strValue);				
		for(int i=0;i<4;i++){
			int result=fsm.getGetDateTime().query();
					//System.out.println("读取时钟:"+result);
			if(result!=0) continue;
					//System.out.println(fsm.getGetDateTime().getStrValue().substring(0,12));
					//System.out.println(strValue.substring(0,12));
					//					
		}	
		String strValue=fsm.getGetDateTime().getStrValue();
		if(strValue.length()==14){
			StringBuilder str=new StringBuilder();
			str.append(strValue.substring(0, 4));
			str.append("-");
			str.append(strValue.substring(4, 6));
			str.append("-");
			str.append(strValue.substring(6, 8));
			str.append(" ");
			str.append(strValue.substring(8, 10));
			str.append(":");
			str.append(strValue.substring(10, 12));
			str.append(":");
			str.append(strValue.substring(12, 14));
			strValue=str.toString();
		}
		return strValue;
		//return id+" "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	@RequestMapping(value="setCheers/price",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String setPrice(@RequestBody CheerStatus[] objs){		
		StringBuilder str=new StringBuilder();
		//fsm.getSetOilType().setStrValue(deviceDao.findOilTypeCode(obj.getGunCode()));
//		int oiltype=objs[objs.length-1].getIndex();
//		int price=objs[objs.length-1].getValue();
		//System.out.println("oiltype:"+oiltype+" price:"+price);
		//int counter=0;
		for(CheerStatus obj:objs){
			//System.out.println(obj.getIndex()+" "+obj.getValue());
			//System.out.println(objs.length-1+" "+counter);
			//if(counter==objs.length-1) break;
			//else counter++;			
			if(obj.getValue()==1){
				//System.out.println("2"+obj.getIndex());
				FiniteStateMahine  fsm=controller.getLstMachine(obj.getIndex());								
				for(int i=0;i<4;i++){
					//fsm.getSetOilType().setStrValue(String.format("%02d",oiltype));
					String oiltype=cheerDAO.findOilTypeCode(String.format("%02d",fsm.getGunId()));
					fsm.getSetOilType().setStrValue(oiltype);
					//fsm.setOiltype();
					int result=fsm.getSetOilType().query();					
					if(result!=0) continue;
					result=fsm.getGetOilType().query();					
					if(result!=0) continue;
					if(oiltype.equals(fsm.getGetOilType().getStrValue())){
						str.append(fsm.getGunId()+"号 设置油品");
						fsm.setOiltype(oiltype);
						break;
					}	
				}
				//System.out.println("3");
				for(int i=0;i<4;i++){
					fsm.getSetPrice().setStrValue("100");
					int result=fsm.getSetPrice().query();
					if(result!=0) continue;
					result=fsm.getGetPrice().query();					
					if(result!=0) continue;					
					if("0100".equals(fsm.getGetPrice().getStrValue())){
						str.append(fsm.getGunId()+"号 设置单价");
						break;
					}	
				}
				//break;
			}
		}		
		///System.out.println("4");
		return str+"成功";
	}	
	@RequestMapping(value="getCheerPrice/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getPrice(@PathVariable int id){	
		//StringBuilder str=new StringBuilder();
		//for(CheerStatus obj:objs){		
			//System.out.println("设置时钟:"+obj.getIndex()+"-"+obj.getValue());
			//if(obj.getValue()==1){
		FiniteStateMahine  fsm=controller.getLstMachine(id);
//				SysPara sysP=sysParaDAO.findOne();
//				System.out.println(sysP.getHeadQuartersCortrolCode());
//				System.out.println(sysP.getAmountCortrolCode());
		//String strValue=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				//System.out.println(strValue);
		//		fsm.getSetDateTime().setStrValue(strValue);				
		for(int i=0;i<4;i++){
			int result=fsm.getGetPrice().query();			
			if(result!=0) continue;
			result=fsm.getGetOilType().query();
			if(result!=0) continue;	
		}
		return fsm.getGetOilType().getStrValue()+","+fsm.getGetPrice().getStrValue();
	}
}
