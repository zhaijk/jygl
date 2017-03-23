package com.derun.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CardOperation {

	@RequestMapping(value="cardOperator.htm",method=RequestMethod.GET)
	public String init(ModelMap map){
		
		return "cardOperator";
	}
}
