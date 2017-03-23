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
	private queryStatusComm 	queryStatus ;//= new queryStatusComm(); 			// ״̬��ѯ
	//@Autowired
	private setOnOffComm 			setOnOff ;//= new setOnOffComm(); 				// ���� ֹͣ����
	//@Autowired
	private setOnOffLineComm 		setOnOffLine ;//= new setOnOffLineComm(); 		// �Կ� Զ�̼��
	//@Autowired
	private queryOilNumberComm 	queryOilNumber ;//= new queryOilNumberComm(); 	// ��ѯ��ǰ������
	//@Autowired
	private queryCardInfosComm 	queryCardInfos ;//= new queryCardInfosComm(); 	// ��ѯ����Ϣ
	//@Autowired
	private queryLastTradComm 		queryLastTrad ;//= new queryLastTradComm(); 	// ��ѯ���һ�����׼�¼
		
	private int gunId;
	private int channelId;
	private long commCounter=0;
	private long errorCounter=0;
	private int commStatus=1; //0 ͨѶʧ�� 1 ����  2 �忨  3 ����
	private int readCardFlag=0;
	
	public finiteStateMahine(){		
		errorCounter=0;
		commCounter=0;		
		queryLastTrad = new queryLastTradComm(); 	// ��ѯ���һ�����׼�¼
		queryCardInfos = new queryCardInfosComm(); 	// ��ѯ����Ϣ
		queryCardInfos = new queryCardInfosComm(); 	// ��ѯ����Ϣ
		queryOilNumber = new queryOilNumberComm(); 	// ��ѯ��ǰ������
		setOnOffLine = new setOnOffLineComm();		//���������������� 		
		setOnOff = new setOnOffComm(); 				//���ͼ��� ֹͣ��������
		queryStatus = new queryStatusComm();		//��ѯIC����״̬	
	}
	
//	public finiteStateMahine(int channelId,int gunId){
//		
////		queryLastTrad = new queryLastTradComm(); 	// ��ѯ���һ�����׼�¼
////		queryCardInfos = new queryCardInfosComm(); 	// ��ѯ����Ϣ
////		queryCardInfos = new queryCardInfosComm(); 	// ��ѯ����Ϣ
////		queryOilNumber = new queryOilNumberComm(); 	// ��ѯ��ǰ������
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
			//setOnOff.setOnStatus();				//���Ϳ�������
			//setOnOffLine.setOnLineStatus();  	//���ó�����״̬
			//commStatus=1;//ȱʡ����
			System.out.println("ǹ��: "+gunId+" ͨ����:"+channelId+"����: "+commCounter+"����: "+errorCounter);
			if(errorCounter>=10){
				commStatus=0;
				errorCounter=0;
				return;
			}
			int result=queryStatus.query();			//��ѯ״̬
			commCounter++;//ͨѶ����
			if(result!=0){
				errorCounter++;//�������
				//commStatus=0;
				continue;
			}
			if(queryStatus.isOnline()==false) 		//���� ״̬  
				setOnOffLine.setOnLineStatus();  	//���ó�����״̬
			
			if(queryStatus.isTrade()){				//��ѯ�Ƿ������߼�¼
				result=queryLastTrad.query();		//��ȡ���߼�¼
				commCounter++;
				if(result!=0){
					errorCounter++;//�������
					//commStatus=0;
					continue;
				}
				else// if(result==0)					
					lstObjs.add(queryLastTrad.getTradeinfo());
			}
			if(queryStatus.isCard()){//&& (queryStatus.isOiling() != true)){
				if(readCardFlag==0){//�忨				
					result=queryCardInfos.query();		//������Ϣ
					commCounter++;
					if(result!=0){
						errorCounter++;//�������
						//commStatus=0;
						continue;
					}
					readCardFlag=1;
				}
				if(commStatus==1)
					commStatus=2;	
//				if((commStatus==2)||(commStatus==3)){//�忨				
//					result=queryCardInfos.query();		//������Ϣ
//					commCounter++;
//					if(result!=0){
//						errorCounter++;//�������
//						//commStatus=0;
//						continue;
//					}
//				}	
				//commStatus=2;
			}
			//��ǹ ���� �п� δ����  ---->���Ϳ�������
			if ((queryStatus.isGun() == true) && (queryStatus.isOnline()==true) && (queryStatus.isCard()==true) && (queryStatus.isOiling() != true)){				
//				result=setOnOff.setOnStatus();	//���Ϳ�������
//				commCounter++;
//				if(result!=0){
//					errorCounter++;//�������
//					//commStatus=0;
//					continue;
//				}
			}
			if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling())){
				commStatus=3;//������....
				result=queryOilNumber.query();	//��ѯ��ǰ��������
				commCounter++;
				if(result!=0){
					errorCounter++;//�������
					continue;
				}
			}
			if((queryStatus.isCard()==false)&&(queryStatus.isOiling()==false)){
				commStatus=1;//���� �޿� ֹͣ����
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
