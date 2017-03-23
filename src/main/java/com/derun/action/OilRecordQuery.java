package com.derun.action;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.dao.OilCanDAO;
import com.derun.dao.OilCanRecordDAO;
import com.derun.entity.OilCan;
import com.derun.entity.OilCanRecord;
import com.derun.model.QueryModel;

@Controller
public class OilRecordQuery {

	@Autowired 
	private OilCanDAO tankDAO;
	@Autowired 
	private OilCanRecordDAO recordsDAO;
	
	@RequestMapping(value="queryOilRecord.htm",method=RequestMethod.GET)
	public String query(ModelMap map){
		
		List<OilCan> tanks=tankDAO.findALL();
//		List<cardtrade> lstObjs=tradeDAO.findALL();
//		List<cheerMachine>  cheerinfoObjs=cheerinfoDAO.findALL();
//		List<OilType>  oilTypeObjs=oilTypeDAO.findALL();
		
//		map.put("trades", lstObjs);
//		map.put("cheers", cheerinfoObjs);
//		map.put("oiltype", oilTypeObjs);
		map.put("tanks", tanks);
		
		return "oilRecord";
	}
//	@RequestMapping("test.htm")
//	public String test(){
//		return "UITest";
//	}

	@RequestMapping(value="queryOilRecord/queryALL",method=RequestMethod.GET)	
	@ResponseBody
	public Object queryALL(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("data", recordsDAO.findALL());
		return map;		
	}
	//private static int counter;
	@RequestMapping(value="queryOilRecord/queryBY",method=RequestMethod.POST)	
	@ResponseBody
	public Object queryBoth(HttpServletRequest request,int draw, int start,int length,QueryModel param){
		
//		System.out.println("tankcode"+param.getTankcode());
//		System.out.println(request.getParameter("order[0][column]"));
//		System.out.println(request.getParameter("order[0][dir]"));
//		
//		System.out.println(param.getFrom().length());
//		System.out.println(start+" "+length  +" "+param.getCarcode()+" "+param.getCardcode()+" "+param.getGuncode()+" "+param.getOiltype()+" "+param.getFrom()+" "+param.getTo());
		
		Map<String,Object> paraMap=new HashMap<String ,Object>();
		//paraMap.put("cardcode", param.getCardcode());	//¿¨ºÅ
		//paraMap.put("guncode", new Integer(param.getGuncode()).toString()); //Ç¹ºÅ
		//paraMap.put("oiltype", param.getOiltype()); 	//ÓÍÆ·
		paraMap.put("tankcode", param.getTankcode()); 	//ÓÍ¹ÞºÅ
		paraMap.put("fromDate", param.getFrom());		//from ÈÕÆÚ
		paraMap.put("dateTo", param.getTo());			//to   ÈÕÆÚ		
		paraMap.put("index",request.getParameter("order[0][column]"));
		paraMap.put("orderby",request.getParameter("order[0][dir]"));
		List<OilCanRecord> lstObjs=recordsDAO.findBY(paraMap);
		int count=lstObjs.size();
		paraMap.put("limitM",start);
		paraMap.put("limitN", length);		
		lstObjs=recordsDAO.findBY(paraMap);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("draw", draw++);
		map.put("recordsFiltered", count);
		map.put("recordsTotal", count);		
		map.put("data", lstObjs);		
		return map;		
	}
}
