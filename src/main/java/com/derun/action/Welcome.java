package com.derun.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Welcome {
	
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
	@RequestMapping()
	public String fnFail(){
		return "loginFailure";
	}
}
