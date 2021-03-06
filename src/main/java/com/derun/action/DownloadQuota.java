package com.derun.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.commnuication.DownloadQuotaList;
import com.derun.dao.CardPutoutDAO;
import com.derun.dao.CheerinfoDAO;
import com.derun.entity.CardPutout;
import com.derun.entity.cheerMachine;

@Controller
public class DownloadQuota {
	
	@Autowired
	private CheerinfoDAO cheerDAO;
	@Autowired
	private CardPutoutDAO  cardPutoutDAO;
	@Autowired
	private DownloadQuotaList oper; 
	
	@RequestMapping(value="quotaList.htm",method=RequestMethod.GET)
	public String init(ModelMap model){
		List<CardPutout> cardPutouts=cardPutoutDAO.findALL();
		List<cheerMachine> cheerList=cheerDAO.findALL();		
		model.put("cheers", cheerList);
		model.put("cardPutouts", cardPutouts);
		return "downloadQuotalist";
	}
	@RequestMapping(value="downloadQuotalist/all",method=RequestMethod.POST)
	@ResponseBody
	public String download_Blacklist(){
		
		return "success";	
	}
	@RequestMapping(value="downloadQuotalist/code",method=RequestMethod.POST)
	@ResponseBody
	public String downloadc_Blacklist(@RequestBody CheerStatus[] objs){
		for(CheerStatus obj:objs){			
			if(obj.getValue()==1){				
				oper.setGunid(obj.getIndex());
				oper.setCounter(0);
				oper.download();
			}
		}
		return "success";	
	}
	@RequestMapping(value="getDownloadInfo/quota",method=RequestMethod.GET,produces="text/plain;utf-8")	
	@ResponseBody
	public String getDownloadInfo(){		
		return oper.getGunid()+","+oper.getCounter()+","+oper.getTotal();	
	}
}
