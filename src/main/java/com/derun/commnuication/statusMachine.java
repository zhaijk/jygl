package com.derun.commnuication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.stereotype.Service;


//@Service
public class statusMachine {
		
	public static void main (String[]  args){		
		ExecutorService exec=Executors.newFixedThreadPool(1);		
		exec.execute(new Runnable(){
			@Override
			public void run() {
				Map<Integer,Integer> machine=new HashMap<Integer,Integer>();				
				machine.put(1, 0);	//1号枪 0号通道
				machine.put(2, 1);	//2号枪 1号通道
				machine.put(3, 2);	//3号枪 2号通道
				machine.put(4, 3);	//4号枪 3号通道
				machine.put(5, 4);	//5号枪 4号通道
				machine.put(6, 5);	//6号枪 5号通道
				machine.put(7, 6);	//7号枪 6号通道
				machine.put(8, 7);	//8号枪 7号通道
				machine.put(9, 8);	//9号枪 8号通道
				machine.put(10, 9);	//10号枪 9号通道
				machine.put(11, 10);//11号枪 10号通道
				machine.put(12, 11);//12号枪 11号通道
				machine.put(13, 12);//13号枪 12号通道
				machine.put(14, 13);//14号枪 13号通道
				machine.put(15, 14);//15号枪 14号通道
				machine.put(16, 15);//16号枪 15号通道
				while(true){
					for(final Map.Entry<Integer,Integer> e: machine.entrySet()){	
						queryStatusComm 	queryStatus = new queryStatusComm(); 			// 状态查询
						setOnOffComm 		setOnOff = new setOnOffComm(); 				// 加油 停止加油
						setOnOffLineComm 	setOnOffLine = new setOnOffLineComm(); 		// 自控 远程监控
						queryOilNumberComm 	queryOilNumber = new queryOilNumberComm(); 	// 查询当前加油量
						queryCardInfosComm 	queryCardInfos = new queryCardInfosComm(); 	// 查询卡信息
						queryLastTradComm 	queryLastTrad = new queryLastTradComm(); 	// 查询最后一条交易记录
						int errorCounter=0;
						int gunId=e.getKey();
						int channelId=e.getValue();
						queryStatus.setParam(channelId,gunId);
						setOnOff.setParam(channelId,gunId);
						setOnOffLine.setParam(channelId, gunId);
						queryOilNumber.setParam(channelId,gunId);
						queryCardInfos.setParam(channelId,gunId);
						queryLastTrad.setParam(channelId,gunId);	
						while(true){//空闲状态
							logger.debugLog("空闲状态....枪号: "+gunId+" 通道号:"+channelId+" "+errorCounter);
							int result=queryStatus.query();
							if(result==-1)
								errorCounter++;
							if(queryStatus.isOnline()==false) 		//离线 状态  
								setOnOffLine.setOnLineStatus();  	//设置成在线状态
							if(queryStatus.isTrade()){
								queryLastTrad.query();
							}
							if(queryStatus.isCard())break;			//插卡	
							break;
							//if(errorCounter>100) return ;
						}
						while(true){//插卡
							logger.debugLog("插卡.....");
							if(queryStatus.isCard()){
								queryCardInfos.query();
								break;
							}
							break;
							//queryStatus.query();
						}
						while(true){//提枪加油
							logger.debugLog("提枪.....");
							if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling()!=true))
								setOnOff.setOnStatus();//发送开机命令
							if(queryStatus.isOnline()==false) 		//离线 状态  
								setOnOffLine.setOnLineStatus();  	//设置成在线状态
							queryStatus.query();
							if(queryStatus.isOiling()==true) break;
							break;
						}
						while(true){//加油
							logger.debugLog("加油..........");
							if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling()==true)){
								queryOilNumber.query();					
							}
							if(queryStatus.isOiling()==false)
								break;
							//p4.queryOilValue();
							queryStatus.query();
							break;
						}	
					}	
				}
			}
		});	
	}
//	public statusMachine(){
//		Map<Integer,Integer> machine=new HashMap<Integer,Integer>();
//		
//		machine.put(1, 0);	//1号枪 0号通道
//		machine.put(2, 1);	//2号枪 1号通道
//		machine.put(3, 2);	//3号枪 2号通道
//		machine.put(4, 3);	//4号枪 3号通道
//		machine.put(5, 4);	//5号枪 4号通道
//		machine.put(6, 5);	//6号枪 5号通道
//		machine.put(7, 6);	//7号枪 6号通道
//		machine.put(8, 7);	//8号枪 7号通道
//		machine.put(9, 8);	//9号枪 8号通道
//		machine.put(10, 9);	//10号枪 9号通道
//		machine.put(11, 10);//11号枪 10号通道
//		machine.put(12, 11);//12号枪 11号通道
//		machine.put(13, 12);//13号枪 12号通道
//		machine.put(14, 13);//14号枪 13号通道
//		machine.put(15, 14);//15号枪 14号通道
//		machine.put(16, 15);//16号枪 15号通道
//		
//		
//		ExecutorService exec=Executors.newFixedThreadPool(20);
//		for(final Map.Entry<Integer,Integer> e: machine.entrySet()){
//			exec.execute(new Runnable(){
//			@Override
//			public void run() {
//				queryStatusComm 	queryStatus = new queryStatusComm(); 			// 状态查询
//				setOnOffComm 		setOnOff = new setOnOffComm(); 				// 加油 停止加油
//				setOnOffLineComm 	setOnOffLine = new setOnOffLineComm(); 		// 自控 远程监控
//				queryOilNumberComm 	queryOilNumber = new queryOilNumberComm(); 	// 查询当前加油量
//				queryCardInfosComm 	queryCardInfos = new queryCardInfosComm(); 	// 查询卡信息
//				queryLastTradComm 	queryLastTrad = new queryLastTradComm(); 	// 查询最后一条交易记录
//				int errorCounter=0;
//				int gunId=e.getKey();
//				int channelId=e.getValue();
//				queryStatus.setParam(channelId,gunId);
//				setOnOff.setParam(channelId,gunId);
//				setOnOffLine.setParam(channelId, gunId);
//				queryOilNumber.setParam(channelId,gunId);
//				queryCardInfos.setParam(channelId,gunId);
//				queryLastTrad.setParam(channelId,gunId);	
//				while(true){				
//					
//					
//					while(true){//空闲状态
//						logger.debugLog("空闲状态....枪号: "+gunId+" 通道号:"+channelId+" "+errorCounter);
//						int result=queryStatus.query();
//						if(result==-1)
//							errorCounter++;
//						if(queryStatus.isOnline()==false) 		//离线 状态  
//							setOnOffLine.setOnLineStatus();  	//设置成在线状态
//						if(queryStatus.isTrade()){
//							queryLastTrad.query();
//						}
//						if(queryStatus.isCard())break;			//插卡	
//						if(errorCounter>100) return ;
//					}
//					while(true){//插卡
//						logger.debugLog("插卡.....");
//						if(queryStatus.isCard()){
//							queryCardInfos.query();
//							break;
//						}
//						//queryStatus.query();
//					}
//					while(true){//提枪加油
//						logger.debugLog("提枪.....");
//						if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling()!=true))
//							setOnOff.setOnStatus();//发送开机命令
//						if(queryStatus.isOnline()==false) 		//离线 状态  
//							setOnOffLine.setOnLineStatus();  	//设置成在线状态
//						queryStatus.query();
//						if(queryStatus.isOiling()==true) break;
//					}
//					while(true){//加油
//						logger.debugLog("加油..........");
//						if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling()==true)){
//							queryOilNumber.query();					
//						}
//						if(queryStatus.isOiling()==false)
//							break;
//						//p4.queryOilValue();
//						queryStatus.query();
//					}	
//				}	
//			}
//		});	
//	}}
}

