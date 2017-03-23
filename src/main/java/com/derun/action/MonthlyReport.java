package com.derun.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MonthlyReport {
	
	//@RequestMapping(value="monthlyReport/all",method=RequestMethod.GET)
	@RequestMapping(value="monthlyReport.htm",method=RequestMethod.GET)
	public String init(){
		
		return "monthlyReport";
	}
}
