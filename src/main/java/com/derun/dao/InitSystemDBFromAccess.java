package com.derun.dao;


import java.util.List;
import com.derun.entity.OilCan;
import com.derun.entity.OilType;
import com.derun.entity.SysPara;
import com.derun.entity.CarType;
import com.derun.entity.Blacklist;
import com.derun.entity.cardtrade;
import com.derun.entity.CardPutout;
import com.derun.entity.cheerMachine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class InitSystemDBFromAccess {

	@Autowired
	private   OilTypeDAO 			oilTypeDAO;
	@Autowired
	private   OilTypeDAOAccess 		oilTypeDAOAccess;
	@Autowired
	private   CarTypeDAO 			carTypeDAO;
	@Autowired
	private   CarTypeDAOAccess 		carTypeDAOAccess;
	@Autowired
	private   CheerinfoDAO 			deviceDAO;
	@Autowired
	private   CheerinfoDAOAccess 	deviceDAOAccess;
	@Autowired
	private   OilCanDAO 			oilCanDAO;
	@Autowired
	private   OilCanDAOAccess 		oilCanDAOAccess;
	@Autowired
	private   BlacklistDAO 			blackListDAO;
	@Autowired
	private   BlacklistDAOAccess 	blackListDAOAccess;
	@Autowired
	private   CardPutoutDAO 		quotaDAO;
	@Autowired
	private   CardPutoutDAOAccess 	quotaDAOAccess;
	@Autowired
	private   TradeDAO 				tradesDAO;
	@Autowired
	private   TradeDAOAccess 		tradesDAOAccess;	
	@Autowired
	private   SysTemParameterDAO 	sysDAO;
	@Autowired
	private   SysTemParameterDAOAccess 	sysDAOAccess;
	
	public int initOilType(){		
		List<OilType> objs=oilTypeDAOAccess.findALL();		
		int result=oilTypeDAO.clear();
		for(OilType obj:objs){
			result+=oilTypeDAO.insertOne(obj);
		}
		return result;
	}
	public int initCarType(){		
		List<CarType> objs=carTypeDAOAccess.findALL();		
		int result=carTypeDAO.clear();
		for(CarType obj:objs){
			result+=carTypeDAO.insertOne(obj);
			//System.out.println(obj.getClasscode()+obj.getCode());
		}
		return result;
	}
	public int initDevice(){		
		List<cheerMachine> objs=deviceDAOAccess.findALL();		
		int result=deviceDAO.clear();
		for(cheerMachine obj:objs){
			result+=deviceDAO.insertOne(obj);
		}
		return result;
	}
	public int initOilCan(){		
		List<OilCan> objs=oilCanDAOAccess.findALL();		
		int result=oilCanDAO.clear();
		for(OilCan obj:objs){
			result=oilCanDAO.insertOne(obj);
		}
		return result;
	}
	public int initBlacklist(){		
		List<Blacklist> objs=blackListDAOAccess.findALL();		
		int result=blackListDAO.clear();
		for(Blacklist obj:objs){
			result+=blackListDAO.insertOne(obj);
		}
		return result;
	}
	public int initQuota(){		
		List<CardPutout> objs=quotaDAOAccess.findALL();		
		int result=quotaDAO.clear();
		for(CardPutout obj:objs){
			result+=quotaDAO.insertONE(obj);
		}
		return result;
	}
	public int initTrade(){		
		List<cardtrade> objs=tradesDAOAccess.findALL();		
		int result=tradesDAO.clear();
		System.out.println(objs.size());
		
		for(cardtrade obj:objs){
			try{
				result+=tradesDAO.insertOne(obj);
			}catch(Exception e){
				//e.printStackTrace();
				//System.out.println("同步消费记录出错.......");
				//System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int initSys(){
		int result=0;
		SysPara obj=sysDAOAccess.findOne();
		if(obj!=null){
			result=sysDAO.clear();
			result=sysDAO.insertOne(obj);
		}else
			return 0;
		return result;
	}
	
	public int initAll(){
		int result=initSys();
		result+=initOilType();
		result+=initCarType();
		result+=initDevice();
		result+=initOilCan();
		result+=initBlacklist();
		result+=initQuota();
		result+=initTrade();
		return result;
	}
}
