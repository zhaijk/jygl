package com.derun.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Oiltankinfo {

	@RequestMapping("getTanksinfo")
	public String getTankInfo(){
		
		return "tankinfo";
	}
}
