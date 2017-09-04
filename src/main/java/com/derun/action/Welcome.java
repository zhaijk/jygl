package com.derun.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.commnuication.DownloadDeviceParameters;
import com.derun.dao.InitSystemDBFromAccess;


@Controller
public class Welcome {
	
	@Autowired 
	private InitSystemDBFromAccess dao;
	@Autowired
	private DownloadDeviceParameters ddps;
	
	@RequestMapping("/")
	public String welcomepage(){		
		return "login";		
	}
	@RequestMapping("/404")
	public String fn404(){		
		return "404";		
	}
	@RequestMapping("/401")
	public String fn401(){		
		return "401";		
	}
	@RequestMapping("/403")
	public String fn403(){		
		return "403";		
	}
//	@RequestMapping()
//	public String fnFail(){
//		return "loginFailure";
//	}
	@RequestMapping("/init/sys")@ResponseBody	
	public String initSys(){
		return String.valueOf(dao.initSys());
	}
	@RequestMapping("/init/oiltype")@ResponseBody
	public String initOilType(){
		return String.valueOf(dao.initOilType());
	}
	@RequestMapping("/init/cartype")@ResponseBody
	public String initCarType(){
		return String.valueOf(dao.initCarType());
	}
	@RequestMapping("/init/device")@ResponseBody
	public String initDevice(){
		return String.valueOf(dao.initDevice());
	}
	@RequestMapping("/init/oilcan")@ResponseBody
	public String initOilCan(){
		return String.valueOf(dao.initOilCan());
	}
	@RequestMapping("/init/blacklist")@ResponseBody
	public String initBlacklist(){
		return String.valueOf(dao.initBlacklist());
	}
	@RequestMapping("/init/quota")@ResponseBody
	public String initQuota(){
		return String.valueOf(dao.initQuota());
	}
	@RequestMapping("/init/trade")@ResponseBody
	public String initTrade(){
		return String.valueOf(dao.initTrade());
	}
	@RequestMapping("/init/all")@ResponseBody
	public String initAll(){
		return String.valueOf(dao.initAll());
	}
	@RequestMapping("/initdevice/{id}")@ResponseBody
	public String initdevice(@PathVariable int id){
		try{
			ddps.download(id);
			return "success";
		}catch(Exception e ){
			return "failure";
		}
	}
	@RequestMapping("/initdevice/all")@ResponseBody
	public String initdeviceall(){
		try{
			ddps.download();
			return "success";
		}catch(Exception e ){
			return "failure";
		}
	}
}
