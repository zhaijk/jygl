package com.derun.action;

import java.io.IOException;
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

import com.derun.dao.CardPutoutDAO;
import com.derun.dao.CheerinfoDAO;
import com.derun.dao.OilTypeDAO;
import com.derun.entity.CardPutout;
//import com.derun.dao.TradeDAO;
import com.derun.entity.OilType;
//import com.derun.entity.cardtrade;
//import com.derun.entity.cardtrade;
import com.derun.entity.cheerMachine;
import com.derun.model.QueryModel;
import com.derun.util.ExportExcel;

import freemarker.template.TemplateException;

@Controller
public class QuotaQuery {

	@Autowired
	private CardPutoutDAO quotaDAO;
	@Autowired
	private CheerinfoDAO cheerinfoDAO;
	@Autowired
	private OilTypeDAO oilTypeDAO;
	
	@RequestMapping(value="queryQuotaRecord.htm",method=RequestMethod.GET)
	public String query(ModelMap map){
		List<CardPutout>  quotas=quotaDAO.findALL();
		List<cheerMachine>  cheerinfoObjs=cheerinfoDAO.findALL();
		List<OilType>  oilTypeObjs=oilTypeDAO.findALL();
		map.put("quotas", quotas);
		map.put("cheers", cheerinfoObjs);
		map.put("oiltype", oilTypeObjs);
		
		return "quotaRecord";
	}
	//@RequestMapping("test.htm")
	public String test(){
		return "UITest";
	}

	@RequestMapping(value="quota/queryALL",method=RequestMethod.GET)	
	@ResponseBody
	public Object queryALL(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("data", quotaDAO.findALL());		
		return map;		
	}
	//private static int counter;
	@RequestMapping(value="quota/queryBY",method=RequestMethod.POST)	
	@ResponseBody
	public Object queryBoth(HttpServletRequest request,int draw, int start,int length,QueryModel param){
		
		//System.out.println(request.getParameter("order[0][column]"));
		//System.out.println(request.getParameter("order[0][dir]"));
		
		//System.out.println(param.getFrom().length());
		//System.out.println(start+" "+length  +" "+param.getCarcode()+" "+param.getCardcode()+" "+param.getGuncode()+" "+param.getOiltype()+" "+param.getFrom()+" "+param.getTo());
		
		Map<String,Object> paraMap=new HashMap<String ,Object>();
		paraMap.put("cardcode", param.getCardcode());	//卡号
		//paraMap.put("guncode", new Integer(param.getGuncode()).toString()); //枪号
		paraMap.put("oiltype", param.getOiltype()); 	//油品
		paraMap.put("fromDate", param.getFrom());		//from 日期
		paraMap.put("dateTo", param.getTo());			//to   日期		
		paraMap.put("index",request.getParameter("order[0][column]"));
		paraMap.put("orderby",request.getParameter("order[0][dir]"));
		
		List<CardPutout> lstObjs=quotaDAO.findBY(paraMap);
		String path = request.getSession().getServletContext().getRealPath("download/");
		ExportExcel util=new ExportExcel();
		try{
			util.init(path);
			util.process("",lstObjs,path,"quotatrade.ftl","quotatrade.xls");
		}catch(IOException e){
			e.printStackTrace();
			//return "ftl file failure";
		}catch(TemplateException e){
			e.printStackTrace();
			//return "xls file failure";
		}
		int count=lstObjs.size(); 
		paraMap.put("limitM",start);
		paraMap.put("limitN", length);		
		
		lstObjs=quotaDAO.findBY(paraMap);		
		
		Map<String,Object> map=new HashMap<String,Object>();
		//int count=lstObjs.size();
		map.put("draw", draw++);
		map.put("recordsFiltered",count);
		map.put("recordsTotal", count);		
		map.put("data", lstObjs);		
		return map;		
	}
	@RequestMapping(value="queryQuota/exportBY",method=RequestMethod.POST)	
	@ResponseBody
	public String  export(HttpServletRequest request,QueryModel param) {
		
		Map<String,Object> paraMap=new HashMap<String ,Object>();
		
		paraMap.put("cardcode", param.getCardcode());	//卡号
		//paraMap.put("guncode", new Integer(param.getGuncode()).toString()); //枪号
		paraMap.put("oiltype", param.getOiltype()); 	//油品
		paraMap.put("fromDate", param.getFrom());		//from 日期
		paraMap.put("dateTo", param.getTo());			//to   日期		
		paraMap.put("index",request.getParameter("order[0][column]"));
		paraMap.put("orderby",request.getParameter("order[0][dir]"));
		
		List<CardPutout> lstObjs=quotaDAO.findBY(paraMap);		
		String path = request.getSession().getServletContext().getRealPath("download/");
		ExportExcel util=new ExportExcel();
		try{
			util.init(path);
			util.process("",lstObjs,path,"quotatrade.ftl","quotatrade.xls");
		}catch(IOException e){
			e.printStackTrace();
			return "ftl file failure";
		}catch(TemplateException e){
			e.printStackTrace();
			return "xls file failure";
		}
		return "export success";
	}
}
