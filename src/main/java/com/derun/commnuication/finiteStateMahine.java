package com.derun.commnuication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.derun.dao.CheerinfoDAO;
import com.derun.dao.SysTemParameterDAO;
import com.derun.entity.SysPara;
//import com.derun.dao.CheerinfoDAO;
import com.derun.entity.cardtrade;
import java.util.concurrent.CopyOnWriteArrayList;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

//@Service
//@Scope("prototype")
public class FiniteStateMahine implements Runnable{

	private   static CopyOnWriteArrayList<cardtrade> cardtrades=new CopyOnWriteArrayList<cardtrade>();
	
	//@Autowired
	private SysTemParameterDAO  stpDAO;
	private CheerinfoDAO cheerDAO;
	//@Resource
	//private cheerinfoDAO cheers;
	//@Resource
	//private commportInfoDAO  portinfo;
	//@Autowired
	private QueryStatusComm 		queryStatus ;//= new queryStatusComm(); 			// 状态查询
	//@Autowired
	private SetOnOffComm 			setOnOff ;//= new setOnOffComm(); 				// 加油 停止加油
	//@Autowired
	private SetOnOffLineComm 		setOnOffLine ;//= new setOnOffLineComm(); 		// 自控 远程监控
	//@Autowired
	private QueryOilNumberComm 		queryOilNumber ;//= new queryOilNumberComm(); 	// 查询当前加油量
	//@Autowired
	private QueryCardInfosComm 		queryCardInfos ;//= new queryCardInfosComm(); 	// 查询卡信息
	//@Autowired
	private QueryLastTradComm 		queryLastTrad ;//= new queryLastTradComm(); 	// 查询最后一条交易记录
	
	private SetStationID 			setStationID;
	private QueryStationID        	queryStationID;     
	
	public QueryStationID getQueryStationID() {
		return queryStationID;
	}

	public void setQueryStationID(QueryStationID queryStationID) {
		this.queryStationID = queryStationID;
	}

	private QueryHQAuthID 			queryHQAuthID;	
	public QueryHQAuthID getQueryHQAuthID() {
		return queryHQAuthID;
	}

	private SetHQAuthID 			setHQAuthID;	
		
	public SetHQAuthID getSetHQAuthID() {
		return setHQAuthID;
	}

	private QueryHTAuthID 			queryHTAuthID;	
	public QueryHTAuthID getQueryHTAuthID() {
		return queryHTAuthID;
	}

	private SetHTAuthID 			setHTAuthID;	
	
	public SetHTAuthID getSetHTAuthID() {
		return setHTAuthID;
	}

	public SetDateTime getSetDateTime() {
		return setDateTime;
	}

	public void setSetDateTime(SetDateTime setDateTime) {
		this.setDateTime = setDateTime;
	}

	public QueryDateTime getGetDateTime() {
		return getDateTime;
	}

	public void setGetDateTime(QueryDateTime getDateTime) {
		this.getDateTime = getDateTime;
	}

	public SetOilType getSetOilType() {
		return setOilType;
	}

	public void setSetOilType(SetOilType setOilType) {
		this.setOilType = setOilType;
	}

	public QueryOilType getGetOilType() {
		return getOilType;
	}

	public void setGetOilType(QueryOilType getOilType) {
		this.getOilType = getOilType;
	}

	public SetOilTypePrice getSetPrice() {
		return setPrice;
	}

	public void setSetPrice(SetOilTypePrice setPrice) {
		this.setPrice = setPrice;
	}

	public QueryOilTypePrice getGetPrice() {
		return getPrice;
	}

	public void setGetPrice(QueryOilTypePrice getPrice) {
		this.getPrice = getPrice;
	}

	private SetDateTime setDateTime;
	private QueryDateTime getDateTime;
	
	private SetOilType setOilType;
	private QueryOilType getOilType;
	
	private SetOilTypePrice setPrice;
	private QueryOilTypePrice getPrice;
	
	private SetBlackList 	setBlackList;
	public SetBlackList getSetBlackList() {
		return setBlackList;
	}

	public ClearBlackList getClearBlackList() {
		return clearBlackList;
	}

	private ClearBlackList clearBlackList;
	
	private SendQuotas 		setQuotaList;
	private ClearQuotas 	clearQuotaList;
	
	
	public SendQuotas getSetQuotaList() {
		return setQuotaList;
	}

	public ClearQuotas getClearQuotaList() {
		return clearQuotaList;
	}

	private QueryTradComm 		getTrade;
	public QueryTradComm getGetTrade() {
		return getTrade;
	}

	public QueryTradeNumber getGetTradeNumber() {
		return getTradeNumber;
	}

	private QueryTradeNumber 	getTradeNumber;
	
	
	private volatile boolean runflag=true;
	private int 	gunId;
	private int		channelId;
	private long 	sendCounter=0;
	private long 	recvCounter=0;
	private long 	errorCounter=0;
	private int 	commStatus=1; //-1 端口错误 0 通讯失败 1 待机  2 插卡  3 加油
	private int 	readCardFlag=0;
	private String oiltype="";	

	public String getOiltype() {
		return oiltype;
	}

	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}
	
	public FiniteStateMahine(){		
		errorCounter=0;
		sendCounter=0;	
		recvCounter=0;
		queryLastTrad = 	new QueryLastTradComm(); 	// 查询最后一条交易记录
		queryCardInfos =	new QueryCardInfosComm(); 	// 查询卡信息		
		queryOilNumber = 	new QueryOilNumberComm(); 	// 查询当前加油量
		setOnOffLine = 		new SetOnOffLineComm();		//发送在线离线命令 		
		setOnOff = 			new SetOnOffComm(); 		//发送加油 停止加油命令
		queryStatus = 		new QueryStatusComm();		//查询IC卡机状态	
		setStationID= 		new SetStationID();			//设置站号
		queryStationID=     new QueryStationID();		//查询站号
		//oiltype=			new CheerinfoDAO().findOilType("01");
	}
	public FiniteStateMahine(int channelId,int gunId,SysTemParameterDAO  stpDAO,CheerinfoDAO cheerDAO){		
		this.channelId=channelId;
		this.gunId=gunId;
		this.stpDAO=stpDAO;
		this.cheerDAO=cheerDAO;
		errorCounter=0;
		sendCounter=0;	
		recvCounter=0;	
		
		queryLastTrad = 	new QueryLastTradComm(); 	// 查询最后一条交易记录
		queryCardInfos =	new QueryCardInfosComm(); 	// 查询卡信息		
		queryOilNumber = 	new QueryOilNumberComm(); 	// 查询当前加油量
		setOnOffLine = 		new SetOnOffLineComm();		//发送在线离线命令 		
		setOnOff = 			new SetOnOffComm(); 		//发送加油 停止加油命令		
		queryStatus = 		new QueryStatusComm();		//查询IC卡机状态
		
		queryHQAuthID= 		new QueryHQAuthID();		//查询总部联勤码
		setHQAuthID=		new SetHQAuthID();			//设置总部联勤码 	
		
		queryHTAuthID=		new QueryHTAuthID();		//查询总队联勤码
		setHTAuthID=		new SetHTAuthID();			//设置总队联勤码
		
		setDateTime=		new SetDateTime();			//设置时钟
		getDateTime=		new QueryDateTime();		//读取时钟		
		setOilType=			new SetOilType();			//设置油品
		getOilType=			new QueryOilType();			//读取油品
		setPrice=			new SetOilTypePrice();		//设置单价
		getPrice=			new QueryOilTypePrice();	//读取单价
		
		setBlackList= 		new SetBlackList();			//下传黑名单
		clearBlackList=  	new ClearBlackList();		//清除黑名单 
				
		setQuotaList=       new SendQuotas();			//下传指标		
		clearQuotaList=     new ClearQuotas();			//清除指标
		
		getTrade=			new QueryTradComm();		//查询指定记录
		getTradeNumber=		new QueryTradeNumber();		//查询IC卡机记录数
		
		setStationID= 		new SetStationID();
		queryStationID=     new QueryStationID();		//查询站号
		//try{			
		//	String s=new CheerinfoDAO().findOilType("01");
		//	System.out.println(s);
		//}catch(Exception e){
		//	e.printStackTrace();
		//}
		//System.out.println(queryStatus);
		
		queryStatus.setParam(channelId,gunId);
		setOnOff.setParam(channelId,gunId);
		setOnOffLine.setParam(channelId, gunId);
		queryOilNumber.setParam(channelId,gunId);
		queryCardInfos.setParam(channelId,gunId);
		queryLastTrad.setParam(channelId,gunId);
		queryHQAuthID.setParam(channelId,gunId);
		setHQAuthID.setParam(channelId,gunId);
		queryHTAuthID.setParam(channelId,gunId);
		setHTAuthID.setParam(channelId,gunId);	
		setDateTime.setParam(channelId,gunId);
		getDateTime.setParam(channelId,gunId);	
		setOilType.setParam(channelId,gunId);
		getOilType.setParam(channelId,gunId);
		setPrice.setParam(channelId,gunId);
		getPrice.setParam(channelId,gunId);
		setBlackList.setParam(channelId, gunId);
		clearBlackList.setParam(channelId, gunId);
		setQuotaList.setParam(channelId, gunId);
		getTrade.setParam(channelId, gunId);
		getTradeNumber.setParam(channelId, gunId);
		setStationID.setParam(channelId, gunId);
		queryStationID.setParam(channelId, gunId);
	}
//	public finiteStateMahine(int channelId,int gunId){
//		
////		queryLastTrad = new queryLastTradComm(); 	// 查询最后一条交易记录
////		queryCardInfos = new queryCardInfosComm(); 	// 查询卡信息
////		queryCardInfos = new queryCardInfosComm(); 	// 查询卡信息
////		queryOilNumber = new queryOilNumberComm(); 	// 查询当前加油量
////		setOnOffLine = new setOnOffLineComm(); 		
////		setOnOff = new setOnOffComm(); 		
////		queryStatus = new queryStatusComm();
////		
////		cheers=new cheerinfoDAO();
////		portinfo=new commportInfoDAO();
////		trades=new tradeDAO();
//		
//		setParams(channelId,gunId);
//		
//	}
	
	public  void setParams(int channelId,int gunId){
		
		this.channelId=channelId;
		this.gunId=gunId;
		errorCounter=0;
		sendCounter=0;	
		recvCounter=0;		
		//System.out.println(queryStatus);
		queryStatus.setParam(channelId,gunId);
		setOnOff.setParam(channelId,gunId);
		setOnOffLine.setParam(channelId, gunId);
		queryOilNumber.setParam(channelId,gunId);
		queryCardInfos.setParam(channelId,gunId);
		queryLastTrad.setParam(channelId,gunId);
		queryHQAuthID.setParam(channelId,gunId);
		setHQAuthID.setParam(channelId,gunId);
		queryHTAuthID.setParam(channelId,gunId);
		setHTAuthID.setParam(channelId,gunId);	
		setDateTime.setParam(channelId,gunId);
		getDateTime.setParam(channelId,gunId);	
		setOilType.setParam(channelId,gunId);
		getOilType.setParam(channelId,gunId);
		setPrice.setParam(channelId,gunId);
		getPrice.setParam(channelId,gunId);
		setBlackList.setParam(channelId, gunId);
		clearBlackList.setParam(channelId, gunId);
		clearBlackList.setParam(channelId, gunId);
		setQuotaList.setParam(channelId, gunId);
		setStationID.setParam(channelId, gunId);
		queryStationID.setParam(channelId, gunId);
	}
	private void commcounter(int result){
		sendCounter++;		//发送次数
		if(result!=0)
			errorCounter++;	//错误次数
		else
			recvCounter++;	//接受次数	
	}
	//@Override
	public void run() {		
//		while(true){
//			//setOnOff.setOnStatus();				//发送开机命令
//			//setOnOffLine.setOnLineStatus();  	//设置成在线状态
//			//commStatus=1;//缺省待机
//			//logger.debugLog("枪号:"+gunId+" 通道号:"+channelId+"发送: "+commCounter+"错误: "+errorCounter);
////			if(errorCounter>=10){
////				commStatus=0;
////				errorCounter=0;
////				//return;
////			}
//			int result=queryStatus.query();			//查询状态			
//			commCounter++;//通讯次数
//			if(result!=0){
//				errorCounter++;//错误次数
//				//commStatus=0;
//				//continue;
//			}
////			if(queryStatus.isOnline()==false) 		//离线 状态  
////				setOnOffLine.setOnLineStatus();  	//设置成在线状态
//			
//			if(queryStatus.isTrade()){				//查询是否有在线纪录
//				result=queryLastTrad.query();		//读取在线纪录
//				System.out.println("读取在线纪录: "+result);
//				commCounter++;
//				if(result!=0){
//					errorCounter++;//错误次数
//					//commStatus=0;
//					//continue;
//				}
//				else// if(result==0)					
//					.add(queryLastTrad.getTradeinfo());				
//			}
//			if(queryStatus.isCard()){//&& (queryStatus.isOiling() != true)){
//				setOnOffLine.setOnLineStatus();  	//设置成在线状态
//				if(readCardFlag==0){//插卡				
//					result=queryCardInfos.query();		//读卡信息
//					commCounter++;
//					if(result!=0){
//						errorCounter++;//错误次数
//						//commStatus=0;
//						//continue;
//					}
//					readCardFlag=1;
//				}
//				if(commStatus==1)
//					commStatus=2;	
////				if((commStatus==2)||(commStatus==3)){//插卡				
////					result=queryCardInfos.query();		//读卡信息
////					commCounter++;
////					if(result!=0){
////						errorCounter++;//错误次数
////						//commStatus=0;
////						continue;
////					}
////				}	
//				//commStatus=2;
//			}
//			//提枪 在线 有卡 未加油  ---->发送开机命令
//			if ((queryStatus.isGun() == true) && (queryStatus.isOnline()==true) && (queryStatus.isCard()==true) && (queryStatus.isOiling() != true)){				
//				result=setOnOff.setOnStatus();	//发送开机命令
////				commCounter++;
////				if(result!=0){
////					errorCounter++;//错误次数
////					//commStatus=0;
////					continue;
////				}
//			}
//			if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling())){
//				commStatus=3;//加油中....
//				result=queryOilNumber.query();	//查询当前加油数据
//				commCounter++;
//				if(result!=0){
//					errorCounter++;//错误次数
//					//continue;
//				}
//			}
//			if((queryStatus.isCard()==false)&&(queryStatus.isOiling()==false)){
//				commStatus=1;//待机 无卡 停止加油
//				readCardFlag=0;
//			}
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		int result=0;
		//while(runflag){
		int retry=4;		
		setDateTime.setStrValue(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));	
		int result=setDateTime.queryretry(retry);//下传时钟		
		setOilType.setStrValue(cheerDAO.findOilTypeCode(String.format("%02d",gunId)));
		result=setOilType.queryretry(retry);//设置油品		
		SysPara paras=stpDAO.findOne();
		setHQAuthID.setStrValue(paras.getHeadQuartersCortrolCode());//联勤码
		setHQAuthID.queryretry(retry);
		setHTAuthID.setStrValue(paras.getAmountCortrolCode());
		setHTAuthID.queryretry(retry);		
		while(runflag){
			result=queryStatus.query();					//查询状态			
			commcounter(result);
//			result=setOnOffLine.setOnLineStatus();		//设置成在线状态
//			commcounter(result);		
//空闲
//			if(queryStatus.isOnline()!=true){
//				setOnOffLine.setOnLineStatus();		//设置成在线状态
//				commcounter(result);					
//			}
			if(queryStatus.isCard()==false){				
//				if(queryStatus.isOnline()!=true){
//					result=setOnOffLine.setOnLineStatus();		//设置成在线状态
//					commcounter(result);					
//				}
//				result=queryStatus.query();			//查询状态			
//				commcounter(result);
				if(queryStatus.isTrade()){			//查询是否有在线纪录
					result=queryLastTrad.query();	//读取在线纪录
					commcounter(result);
					if(result==0){
						queryLastTrad.getTradeinfo().setOilType(oiltype);
						cardtrades.add(queryLastTrad.getTradeinfo());
					}
				}
				readCardFlag=0;
				commStatus=1;
			}else {//插卡			
//				if(queryStatus.isOnline()!=true){
//					setOnOffLine.setOnLineStatus();		//设置成在线状态
//					commcounter(result);					
//				}
				if(readCardFlag==0){	
					result=queryCardInfos.query();		//读卡信息
					commcounter(result);
					readCardFlag=1;
					commStatus=2;
										
				}				
//				if(queryStatus.isOnline()!=true){
//					setOnOffLine.setOnLineStatus();		//设置成在线状态
//					commcounter(result);
//				}				
				//等待联机命令
				if ((queryStatus.isOiling()!=true)&&(queryStatus.isGun() == true) && (queryStatus.isOnline()==true)){				
					result=setOnOff.setOnStatus();	//发送开机命令					
					commcounter(result);
					commStatus=3;//加油中....
				}
				//加油中
				else if(queryStatus.isOiling()){				
					result=queryOilNumber.query();	//查询当前加油数据
					commcounter(result);	
					commStatus=3;
				}
				if(commStatus==3){
					result=queryOilNumber.query();	//查询当前加油数据
					commcounter(result);
				}
			}			
			//logger.debugLog(this.gunId+"号枪 ："+commStatus);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//logger.debugLog(gunId+"退出");
	}	
	public static List<cardtrade> getLstObjs() {
		return cardtrades;
	}

	public void setOn_Off(boolean ONOFF) {
		if(ONOFF)
			this.setOnOff.setOnStatus();
		else
			this.setOnOff.setOffStatus();
	}	

	public int getGunId() {
		return gunId;
	}
	
	public int getChannelId() {
		return channelId;
	}
	
	public long getSendCounter() {
		return sendCounter;
	}
	
	public long getRecvCounter() {
		return recvCounter;
	}
	
	public long getErrorCounter() {
		return errorCounter;
	}
	
	public void setSendCounter(long sendCounter) {
		this.sendCounter =sendCounter;
	}
	
	public void setRecvCounter(long recvCounter) {
		this.recvCounter=recvCounter;
	}
	
	public void setErrorCounter(long errorCounter) {
		this.errorCounter = errorCounter;
	}
	
	public int getCommStatus() {
		return commStatus;
	}
	public void setCommStatus(int commStatus) {
		this.commStatus=commStatus;
	}
	public QueryStatusComm getQueryStatus() {
		return queryStatus;
	}

	public QueryOilNumberComm getQueryOilNumber() {
		return queryOilNumber;
	}

	public QueryCardInfosComm getQueryCardInfos() {
		return queryCardInfos;
	}

	public QueryLastTradComm getQueryLastTrad() {
		return queryLastTrad;
	}	
	public boolean isRunflag() {
		return runflag;
	}

	public void setRunflag(boolean runflag) {
		this.runflag = runflag;
	}
//	public static void main(String[] args){
//		
//		new serialPort(null);
//		finiteStateMahine f=new finiteStateMahine();
//		f.setParams(2, 3);
//		new Thread(f).start();
//	}

	public SetStationID getSetStationID() {
		return setStationID;
	}	
}
