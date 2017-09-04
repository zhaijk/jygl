package com.derun.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.derun.authority.ManagerDeviceInfo;
import com.derun.dao.CarTypeDAO;
import com.derun.dao.CheerinfoDAO;
import com.derun.dao.OilCanDAO;
import com.derun.dao.OilTypeDAO;
import com.derun.entity.CarType;
import com.derun.entity.OilCan;
import com.derun.entity.OilType;
import com.derun.entity.cheerMachine;

@Controller
public class DeviceConfigEditor {

	@Autowired
	private OilTypeDAO oiltypeDAO;
	@Autowired
	private CheerinfoDAO cheerinfoDAO;
	@Autowired
	private CarTypeDAO carTypeDAO;
	@Autowired
	private OilCanDAO oilcanDAO;	
	//@Autowired 
	//private ManagerDeviceInfo info;
	
	@RequestMapping(value="/deviceInfoManager.htm",method=RequestMethod.GET)
	public String init(ModelMap map){
		List<OilType>  oiltypes=oiltypeDAO.findALL();
		List<cheerMachine>  cheerinfos=cheerinfoDAO.findALL();
		List<CarType>  cartypes=carTypeDAO.findALL();
		List<OilCan>  oilcans=oilcanDAO.findALL();
		//System.out.println(cheerinfos.size());
		map.put("oiltypes", oiltypes);
		map.put("cheerinfos", cheerinfos);
		map.put("cartypes", cartypes);
		map.put("oilcans", oilcans);		
		return "deviceConfigInfo";
	}	
	
	@RequestMapping(value="/editCheer/update",method=RequestMethod.POST)		
	@ResponseBody 
	public String updateCheerInfo(@RequestBody cheerMachine[] objs){
		if(objs.length==0){
			return "failure";
		}else{
			for(cheerMachine obj:objs){				
				int result=cheerinfoDAO.updateOne(obj);
				if(result==0){					
					cheerinfoDAO.insertOne(obj);
					//info.insertONE(obj);
				}
			}
		}
		return "success";
	}
	@RequestMapping(value="/editCheer/delete",method=RequestMethod.POST)
	@ResponseBody
	public String deleteCheerInfo(@RequestBody cheerMachine[] objs ){
		if(objs.length==0){
			return "failure";
		}else{
			for(cheerMachine obj:objs){
				cheerinfoDAO.deleteOne(obj);
			}
		}
		return "success";		
	}
	@RequestMapping(value="/editOilcans/update",method=RequestMethod.POST)		
	@ResponseBody 
	public String updateOilcanInfo(@RequestBody OilCan[] objs){
		if(objs.length==0){
			return "failure";
		}else{
			for(OilCan obj:objs){				
				int result=oilcanDAO.updateOne(obj);
				if(result==0){
					oilcanDAO.insertOne(obj);
				}
			}
		}
		return "success";
	}
	@RequestMapping(value="/editOilcans/delete",method=RequestMethod.POST)
	@ResponseBody
	public String deleteOilcanInfo(@RequestBody OilCan[] objs ){
		if(objs.length==0){
			return "failure";
		}else{
			for(OilCan obj:objs){
				oilcanDAO.deleteOne(obj);
			}
		}
		return "success";		
	}
	@RequestMapping(value="/editOilType/update",method=RequestMethod.POST)
	@ResponseBody
	public String updateOrInsertOiltype(@RequestBody OilType[] objs){
		if(objs.length==0){
			return "failure";
		}else{
			for(OilType obj:objs){				
				int result=oiltypeDAO.updateOne(obj);
				if(result==0){
					oiltypeDAO.insertOne(obj);
				}
			}
		}
		return "success";
	}
	@RequestMapping(value="/editOilType/delete",method=RequestMethod.POST)
	@ResponseBody
	public String deleteOiltype(@RequestBody OilType[] objs){
		if(objs.length==0){
			return "failure";
		}else{
			for(OilType obj:objs){
				oiltypeDAO.deleteOne(obj);
			}
		}
		return "success";
	}
	@RequestMapping(value="/editCarType/update",method=RequestMethod.POST)
	@ResponseBody
	public String updateOrInsertCartype(@RequestBody CarType[] objs){
		if(objs.length==0){
			return "failure";
		}else{
			for(CarType obj:objs){				
				int result=carTypeDAO.updateOne(obj);
				if(result==0){
					carTypeDAO.insertOne(obj);
				}
			}
		}
		return "success";
	}
	@RequestMapping(value="/editCarType/delete",method=RequestMethod.POST)
	@ResponseBody
	public String deleteCartype(@RequestBody CarType[] objs){
		if(objs.length==0){
			return "failure";
		}else{
			for(CarType obj:objs){
				carTypeDAO.deleteOne(obj);
			}
		}
		return "success";
	}
}
