package com.derun.action;

import java.util.List;

import com.derun.commnuication.DownloadBlackList;
import com.derun.dao.BlacklistDAO;
import com.derun.dao.CheerinfoDAO;
import com.derun.entity.Blacklist;
import com.derun.entity.cheerMachine;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownLoadBlacklist {
	
	@Autowired
	private CheerinfoDAO cheerDAO;
	@Autowired
	private BlacklistDAO blackListDAO;	
	@Autowired
	private DownloadBlackList oper; 
	
	@RequestMapping(value="blackList.htm",method=RequestMethod.GET)
	public String init(ModelMap model){
		List<Blacklist> blackList=blackListDAO.findALL();
		List<cheerMachine> cheerList=cheerDAO.findALL();
		model.put("blackList" ,blackList);
		model.put("cheers", cheerList);
		return "downloadBlacklist";	
	}	
	@RequestMapping(value="downloadBlacklist/all",method=RequestMethod.POST)
	@ResponseBody
	public String download_Blacklist(){
		
		return "success";	
	}
	@RequestMapping(value="downloadBlacklist/code",method=RequestMethod.POST)
	@ResponseBody
	public String downloadc_Blacklist(@RequestBody CheerStatus[] objs){
//		for(CheerStatus obj:objs){	
//			System.out.println(obj.getIndex()+" "+obj.getValue());
//		}
		for(CheerStatus obj:objs){			
			if(obj.getValue()==1){				
				oper.setGunid(obj.getIndex());
				oper.setCounter(0);
				oper.download();
//				while(true){
//					if(oper.getCounter()>=oper.getGunid())break;
//					//System.out.println(oper.getGunid()+"号卡机"+" 下载了"+oper.getCounter()+" 共有"+oper.getTotal());
//				}
			}
		}
//		while(true){
//			System.out.println(oper.getGunid()+"号卡机"+" 下载了"+oper.getCounter()+" 共有"+oper.getTotal());
//			if(oper.getCounter()==oper.getTotal()) break;
//		}
		return "success";	
	}
	@RequestMapping(value="getDownloadInfo/blacklist",method=RequestMethod.GET,produces="text/plain;utf-8")	
	@ResponseBody
	public String getDownloadInfo(){		
		return oper.getGunid()+","+oper.getCounter()+","+oper.getTotal();	
	}
}
