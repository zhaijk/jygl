package com.derun.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class YearlyReport {
	
	//@RequestMapping(value="yearlyReport/all",method=RequestMethod.GET)
	@RequestMapping(value="yearlyReport.htm",method=RequestMethod.GET)
	public String init(){
		
		return "yearlyReport";
	}
}
