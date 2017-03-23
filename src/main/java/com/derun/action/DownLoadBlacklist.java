package com.derun.action;

import java.util.List;

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
		for(CheerStatus obj:objs){
			System.out.println(obj.getIndex()+"-"+obj.getValue());
		}
		return "success";	
	}
}
