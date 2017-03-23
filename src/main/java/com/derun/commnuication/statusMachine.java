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
				machine.put(1, 0);	//1��ǹ 0��ͨ��
				machine.put(2, 1);	//2��ǹ 1��ͨ��
				machine.put(3, 2);	//3��ǹ 2��ͨ��
				machine.put(4, 3);	//4��ǹ 3��ͨ��
				machine.put(5, 4);	//5��ǹ 4��ͨ��
				machine.put(6, 5);	//6��ǹ 5��ͨ��
				machine.put(7, 6);	//7��ǹ 6��ͨ��
				machine.put(8, 7);	//8��ǹ 7��ͨ��
				machine.put(9, 8);	//9��ǹ 8��ͨ��
				machine.put(10, 9);	//10��ǹ 9��ͨ��
				machine.put(11, 10);//11��ǹ 10��ͨ��
				machine.put(12, 11);//12��ǹ 11��ͨ��
				machine.put(13, 12);//13��ǹ 12��ͨ��
				machine.put(14, 13);//14��ǹ 13��ͨ��
				machine.put(15, 14);//15��ǹ 14��ͨ��
				machine.put(16, 15);//16��ǹ 15��ͨ��
				while(true){
					for(final Map.Entry<Integer,Integer> e: machine.entrySet()){	
						queryStatusComm 	queryStatus = new queryStatusComm(); 			// ״̬��ѯ
						setOnOffComm 		setOnOff = new setOnOffComm(); 				// ���� ֹͣ����
						setOnOffLineComm 	setOnOffLine = new setOnOffLineComm(); 		// �Կ� Զ�̼��
						queryOilNumberComm 	queryOilNumber = new queryOilNumberComm(); 	// ��ѯ��ǰ������
						queryCardInfosComm 	queryCardInfos = new queryCardInfosComm(); 	// ��ѯ����Ϣ
						queryLastTradComm 	queryLastTrad = new queryLastTradComm(); 	// ��ѯ���һ�����׼�¼
						int errorCounter=0;
						int gunId=e.getKey();
						int channelId=e.getValue();
						queryStatus.setParam(channelId,gunId);
						setOnOff.setParam(channelId,gunId);
						setOnOffLine.setParam(channelId, gunId);
						queryOilNumber.setParam(channelId,gunId);
						queryCardInfos.setParam(channelId,gunId);
						queryLastTrad.setParam(channelId,gunId);	
						while(true){//����״̬
							logger.debugLog("����״̬....ǹ��: "+gunId+" ͨ����:"+channelId+" "+errorCounter);
							int result=queryStatus.query();
							if(result==-1)
								errorCounter++;
							if(queryStatus.isOnline()==false) 		//���� ״̬  
								setOnOffLine.setOnLineStatus();  	//���ó�����״̬
							if(queryStatus.isTrade()){
								queryLastTrad.query();
							}
							if(queryStatus.isCard())break;			//�忨	
							break;
							//if(errorCounter>100) return ;
						}
						while(true){//�忨
							logger.debugLog("�忨.....");
							if(queryStatus.isCard()){
								queryCardInfos.query();
								break;
							}
							break;
							//queryStatus.query();
						}
						while(true){//��ǹ����
							logger.debugLog("��ǹ.....");
							if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling()!=true))
								setOnOff.setOnStatus();//���Ϳ�������
							if(queryStatus.isOnline()==false) 		//���� ״̬  
								setOnOffLine.setOnLineStatus();  	//���ó�����״̬
							queryStatus.query();
							if(queryStatus.isOiling()==true) break;
							break;
						}
						while(true){//����
							logger.debugLog("����..........");
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
//		machine.put(1, 0);	//1��ǹ 0��ͨ��
//		machine.put(2, 1);	//2��ǹ 1��ͨ��
//		machine.put(3, 2);	//3��ǹ 2��ͨ��
//		machine.put(4, 3);	//4��ǹ 3��ͨ��
//		machine.put(5, 4);	//5��ǹ 4��ͨ��
//		machine.put(6, 5);	//6��ǹ 5��ͨ��
//		machine.put(7, 6);	//7��ǹ 6��ͨ��
//		machine.put(8, 7);	//8��ǹ 7��ͨ��
//		machine.put(9, 8);	//9��ǹ 8��ͨ��
//		machine.put(10, 9);	//10��ǹ 9��ͨ��
//		machine.put(11, 10);//11��ǹ 10��ͨ��
//		machine.put(12, 11);//12��ǹ 11��ͨ��
//		machine.put(13, 12);//13��ǹ 12��ͨ��
//		machine.put(14, 13);//14��ǹ 13��ͨ��
//		machine.put(15, 14);//15��ǹ 14��ͨ��
//		machine.put(16, 15);//16��ǹ 15��ͨ��
//		
//		
//		ExecutorService exec=Executors.newFixedThreadPool(20);
//		for(final Map.Entry<Integer,Integer> e: machine.entrySet()){
//			exec.execute(new Runnable(){
//			@Override
//			public void run() {
//				queryStatusComm 	queryStatus = new queryStatusComm(); 			// ״̬��ѯ
//				setOnOffComm 		setOnOff = new setOnOffComm(); 				// ���� ֹͣ����
//				setOnOffLineComm 	setOnOffLine = new setOnOffLineComm(); 		// �Կ� Զ�̼��
//				queryOilNumberComm 	queryOilNumber = new queryOilNumberComm(); 	// ��ѯ��ǰ������
//				queryCardInfosComm 	queryCardInfos = new queryCardInfosComm(); 	// ��ѯ����Ϣ
//				queryLastTradComm 	queryLastTrad = new queryLastTradComm(); 	// ��ѯ���һ�����׼�¼
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
//					while(true){//����״̬
//						logger.debugLog("����״̬....ǹ��: "+gunId+" ͨ����:"+channelId+" "+errorCounter);
//						int result=queryStatus.query();
//						if(result==-1)
//							errorCounter++;
//						if(queryStatus.isOnline()==false) 		//���� ״̬  
//							setOnOffLine.setOnLineStatus();  	//���ó�����״̬
//						if(queryStatus.isTrade()){
//							queryLastTrad.query();
//						}
//						if(queryStatus.isCard())break;			//�忨	
//						if(errorCounter>100) return ;
//					}
//					while(true){//�忨
//						logger.debugLog("�忨.....");
//						if(queryStatus.isCard()){
//							queryCardInfos.query();
//							break;
//						}
//						//queryStatus.query();
//					}
//					while(true){//��ǹ����
//						logger.debugLog("��ǹ.....");
//						if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling()!=true))
//							setOnOff.setOnStatus();//���Ϳ�������
//						if(queryStatus.isOnline()==false) 		//���� ״̬  
//							setOnOffLine.setOnLineStatus();  	//���ó�����״̬
//						queryStatus.query();
//						if(queryStatus.isOiling()==true) break;
//					}
//					while(true){//����
//						logger.debugLog("����..........");
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

