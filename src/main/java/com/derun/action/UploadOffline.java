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
public class UploadOffline {

	@Autowired
	private TradeDAO tradeDAO;
	@Autowired
	private CheerinfoDAO cheerDAO;
	
	@RequestMapping(value="/uploadOffline.htm",method=RequestMethod.GET)	
	public String init(ModelMap model){
		List<cheerMachine> cheerList=cheerDAO.findALL();
		List<cardtrade> trades=tradeDAO.findOfflineALL();	
		model.put("cheers", cheerList);
		model.put("trades", trades);		
		return "uploadOfflineTrade";
	}
	@RequestMapping(value="uploadOffline/all",method=RequestMethod.POST)
	@ResponseBody
	public String all(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}
		return "uploadOffline/all sucess";
	}
	@RequestMapping(value="uploadOffline/code",method=RequestMethod.POST)
	@ResponseBody
	public String code(@RequestBody CheerStatus[] objs){	
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}
		return "uploadOffline/code success";
	}
		
}
