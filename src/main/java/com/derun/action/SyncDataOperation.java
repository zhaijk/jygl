package com.derun.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SyncDataOperation{
	
	@RequestMapping(value="syncData.htm",method=RequestMethod.GET)
	public String init(){
		
		return "syncData";
	}
}