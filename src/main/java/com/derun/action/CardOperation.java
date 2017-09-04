package com.derun.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.derun.dao.SysTemParameterDAO;
import com.derun.dao.TradeDAO;
import com.derun.entity.cardtrade;

@Controller
public class CardOperation {
	
	@Autowired
	private TradeDAO dao ;
	@Autowired
	private SysTemParameterDAO sdao;

	@RequestMapping(value="cardOperator.htm",method=RequestMethod.GET)
	public String init(ModelMap map){		
		return "cardOperator";
	}
	@RequestMapping(value="query/graytrade",method=RequestMethod.POST)
	@ResponseBody
	public cardtrade query(cardtrade obj){
		//System.out.println(obj.getCardCode()+" "+obj.getMileage());		
		cardtrade result=dao.findBy(obj.getCardCode(), String.valueOf(obj.getMileage()));
		return result;
	}
	@RequestMapping("disable/gray")
	@ResponseBody
	public String disablegray(String cardcode,String mileage){
		//System.out.println(cardcode+ " "+mileage);
		cardtrade obj=dao.findBy(cardcode,  String.valueOf(Integer.parseInt(mileage)));
		if("4".equals(obj.getTradeType())){
			int result=dao.updateOne(cardcode, mileage, "1");
			if(result==1) return "success";
		}else if(obj.getTradeType().equals("3")){
			int result=dao.updateOne(cardcode, mileage, "2");
			if(result==1) return "success";
		}else
			return "failure";
		return "failure";
	}
	@RequestMapping(value="query/maketrade",method=RequestMethod.POST)
	@ResponseBody
	public cardtrade maketrade(cardtrade obj){
		obj.setTradeDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		obj.setTradeTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		obj.setGunCode("0");
		obj.setTFlag(false);
		obj.setStationID(sdao.findOne().getStationCode());
		//
		//obj.setTradeType("4");
		obj.setOperatorName("¶Ïµç½â»Ò");
		obj.setCardMoney(0.00);		
		obj.setBalance(obj.getBalance()-obj.getVolumn());
		dao.insertOne(obj);	
		return obj;
	}
}
