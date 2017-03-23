package com.derun.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.dao.DailyRecordDAO;
import com.derun.entity.DailyRecord;
import com.derun.entity.Users;
import com.derun.model.QueryModel;


@Controller
public class OperatorLogQuery {

	@Autowired 
	private com.derun.dao.UsersDAO userDAO;
	@Autowired 
	private DailyRecordDAO dao;
	
	@RequestMapping(value="queryOperatorLog.htm",method=RequestMethod.GET)
	public String init(ModelMap map){
		List<Users> users =userDAO.findAll();
		map.put("users",users);
		return "operatorLog";
	}
	@RequestMapping(value="queryOperatorLog/queryALL",method=RequestMethod.GET)	
	@ResponseBody
	public Object queryALL(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("data", dao.findALL());
		return map;		
	}
	//private static int counter;
	@RequestMapping(value="queryOperatorLog/queryBY",method=RequestMethod.POST)	
	@ResponseBody
	public Object queryBoth(HttpServletRequest request,int draw, int start,int length,QueryModel param){
		
		//System.out.println(request.getParameter("order[0][column]"));
		//System.out.println(request.getParameter("order[0][dir]"));
		
		//System.out.println(param.getFrom().length());
		//System.out.println(start+" "+length  +" "+param.getCarcode()+" "+param.getCardcode()+" "+param.getGuncode()+" "+param.getOiltype()+" "+param.getFrom()+" "+param.getTo());
		
		Map<String,Object> paraMap=new HashMap<String ,Object>();
		paraMap.put("username", param.getUsername());	//卡号
		//paraMap.put("guncode", new Integer(param.getGuncode()).toString()); //枪号
		//paraMap.put("oiltype", param.getOiltype()); 	//油品
		paraMap.put("fromDate", param.getFrom());		//from 日期
		paraMap.put("dateTo", param.getTo());			//to   日期		
		paraMap.put("index",request.getParameter("order[0][column]"));
		paraMap.put("orderby",request.getParameter("order[0][dir]"));
		
		List<DailyRecord> lstObjs=dao.findBy(paraMap);
		int count=lstObjs.size();
		paraMap.put("limitM",start);
		paraMap.put("limitN", length);		
		lstObjs=dao.findBy(paraMap);		
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("draw", draw++);
		map.put("recordsFiltered", count);
		map.put("recordsTotal", count);		
		map.put("data", lstObjs);		
		return map;		
	}
}
