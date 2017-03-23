package com.derun.commnuication;

//import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

//import com.derun.dao.tradeDAO;
import com.derun.entity.cardtrade;

//@Service
//@Scope("prototype")
public class finiteStateMahine implements Runnable{

	private   static CopyOnWriteArrayList<cardtrade> lstObjs=new CopyOnWriteArrayList<cardtrade>();
	
	//@Resource
	//private cheerinfoDAO cheers;
	//@Resource
	//private commportInfoDAO  portinfo;
	//@Autowired
	private queryStatusComm 	queryStatus ;//= new queryStatusComm(); 			// 状态查询
	//@Autowired
	private setOnOffComm 			setOnOff ;//= new setOnOffComm(); 				// 加油 停止加油
	//@Autowired
	private setOnOffLineComm 		setOnOffLine ;//= new setOnOffLineComm(); 		// 自控 远程监控
	//@Autowired
	private queryOilNumberComm 	queryOilNumber ;//= new queryOilNumberComm(); 	// 查询当前加油量
	//@Autowired
	private queryCardInfosComm 	queryCardInfos ;//= new queryCardInfosComm(); 	// 查询卡信息
	//@Autowired
	private queryLastTradComm 		queryLastTrad ;//= new queryLastTradComm(); 	// 查询最后一条交易记录
		
	private int gunId;
	private int channelId;
	private long commCounter=0;
	private long errorCounter=0;
	private int commStatus=1; //0 通讯失败 1 待机  2 插卡  3 加油
	private int readCardFlag=0;
	
	public finiteStateMahine(){		
		errorCounter=0;
		commCounter=0;		
		queryLastTrad = new queryLastTradComm(); 	// 查询最后一条交易记录
		queryCardInfos = new queryCardInfosComm(); 	// 查询卡信息
		queryCardInfos = new queryCardInfosComm(); 	// 查询卡信息
		queryOilNumber = new queryOilNumberComm(); 	// 查询当前加油量
		setOnOffLine = new setOnOffLineComm();		//发送在线离线命令 		
		setOnOff = new setOnOffComm(); 				//发送加油 停止加油命令
		queryStatus = new queryStatusComm();		//查询IC卡机状态	
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
		commCounter=0;
		//System.out.println(queryStatus);
		queryStatus.setParam(channelId,gunId);
		setOnOff.setParam(channelId,gunId);
		setOnOffLine.setParam(channelId, gunId);
		queryOilNumber.setParam(channelId,gunId);
		queryCardInfos.setParam(channelId,gunId);
		queryLastTrad.setParam(channelId,gunId);
	}
	
	//@Override
	public void run() {		
		while(true){
			//setOnOff.setOnStatus();				//发送开机命令
			//setOnOffLine.setOnLineStatus();  	//设置成在线状态
			//commStatus=1;//缺省待机
			System.out.println("枪号: "+gunId+" 通道号:"+channelId+"发送: "+commCounter+"错误: "+errorCounter);
			if(errorCounter>=10){
				commStatus=0;
				errorCounter=0;
				return;
			}
			int result=queryStatus.query();			//查询状态
			commCounter++;//通讯次数
			if(result!=0){
				errorCounter++;//错误次数
				//commStatus=0;
				continue;
			}
			if(queryStatus.isOnline()==false) 		//离线 状态  
				setOnOffLine.setOnLineStatus();  	//设置成在线状态
			
			if(queryStatus.isTrade()){				//查询是否有在线纪录
				result=queryLastTrad.query();		//读取在线纪录
				commCounter++;
				if(result!=0){
					errorCounter++;//错误次数
					//commStatus=0;
					continue;
				}
				else// if(result==0)					
					lstObjs.add(queryLastTrad.getTradeinfo());
			}
			if(queryStatus.isCard()){//&& (queryStatus.isOiling() != true)){
				if(readCardFlag==0){//插卡				
					result=queryCardInfos.query();		//读卡信息
					commCounter++;
					if(result!=0){
						errorCounter++;//错误次数
						//commStatus=0;
						continue;
					}
					readCardFlag=1;
				}
				if(commStatus==1)
					commStatus=2;	
//				if((commStatus==2)||(commStatus==3)){//插卡				
//					result=queryCardInfos.query();		//读卡信息
//					commCounter++;
//					if(result!=0){
//						errorCounter++;//错误次数
//						//commStatus=0;
//						continue;
//					}
//				}	
				//commStatus=2;
			}
			//提枪 在线 有卡 未加油  ---->发送开机命令
			if ((queryStatus.isGun() == true) && (queryStatus.isOnline()==true) && (queryStatus.isCard()==true) && (queryStatus.isOiling() != true)){				
//				result=setOnOff.setOnStatus();	//发送开机命令
//				commCounter++;
//				if(result!=0){
//					errorCounter++;//错误次数
//					//commStatus=0;
//					continue;
//				}
			}
			if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling())){
				commStatus=3;//加油中....
				result=queryOilNumber.query();	//查询当前加油数据
				commCounter++;
				if(result!=0){
					errorCounter++;//错误次数
					continue;
				}
			}
			if((queryStatus.isCard()==false)&&(queryStatus.isOiling()==false)){
				commStatus=1;//待机 无卡 停止加油
				readCardFlag=0;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}	
	public static List<cardtrade> getLstObjs() {
		return lstObjs;
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

	
	public long getCommCounter() {
		return commCounter;
	}

	
	public long getErrorCounter() {
		return errorCounter;
	}

	
	public int getCommStatus() {
		return commStatus;
	}

	public queryStatusComm getQueryStatus() {
		return queryStatus;
	}

	public queryOilNumberComm getQueryOilNumber() {
		return queryOilNumber;
	}

	public queryCardInfosComm getQueryCardInfos() {
		return queryCardInfos;
	}

	public queryLastTradComm getQueryLastTrad() {
		return queryLastTrad;
	}	
	
	public static void main(String[] args){
		
		new serialPort(null);
		finiteStateMahine f=new finiteStateMahine();
		f.setParams(2, 3);
		new Thread(f).start();
	}
}
