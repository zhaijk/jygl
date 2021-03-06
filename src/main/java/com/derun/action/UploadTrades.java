package com.derun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.commnuication.UploadCardTrades;
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
	@Autowired
	private UploadCardTrades oper; 
	
	@RequestMapping(value="/uploadTrades.htm",method=RequestMethod.GET)	
	public String init(ModelMap model){
		List<cheerMachine> cheerList=cheerDAO.findALL();
		List<cardtrade> trades=tradeDAO.findOnlineALL();	
		model.put("cheers", cheerList);
		model.put("trades", trades);	
		return "uploadTrades";
	}
	@RequestMapping(value="uploadTrades/code",method=RequestMethod.POST)
	@ResponseBody
	public String all(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){			
			if(obj.getValue()==1){				
				oper.setGunid(obj.getIndex());
				//oper.setCounter(0);
				oper.upload();
//				while(true){
//					if(oper.getCounter()>=oper.getGunid())break;
//					//System.out.println(oper.getGunid()+"号卡机"+" 下载了"+oper.getCounter()+" 共有"+oper.getTotal());
//				}
			}
		}
		return "success";
	}	
	@RequestMapping(value="getUploadInfo/trades",method=RequestMethod.GET,produces="text/plain;utf-8")	
	@ResponseBody
	public String getDownloadInfo(){		
		return oper.getGunid()+","+oper.getCounter()+","+oper.getTotal();	
	}
}
