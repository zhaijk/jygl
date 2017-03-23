package com.derun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.dao.CheerinfoDAO;
import com.derun.dao.TradeDAO;
import com.derun.entity.cardtrade;
import com.derun.entity.cheerMachine;
@Controller
public class UploadTrades {
	@Autowired
	private CheerinfoDAO cheerDAO;
	@Autowired
	private TradeDAO tradeDAO;
	
	@RequestMapping(value="/uploadTrades.htm",method=RequestMethod.GET)	
	public String init(ModelMap model){
		List<cheerMachine> cheerList=cheerDAO.findALL();
		List<cardtrade> trades=tradeDAO.findOnlineALL();	
		model.put("cheers", cheerList);
		model.put("trades", trades);	
		return "uploadTrades";
	}
	@RequestMapping(value="uploadTrades/all",method=RequestMethod.POST)
	@ResponseBody
	public String all(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}
		return "uploadTrades/all sucess";
	}
	@RequestMapping(value="uploadTrades/code",method=RequestMethod.POST)
	@ResponseBody
	public String code(@RequestBody CheerStatus[] objs){	
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}
		return "uploadTrades/code success";
	}
}
