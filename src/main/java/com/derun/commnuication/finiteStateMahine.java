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
	private QueryStatusComm 		queryStatus ;//= new queryStatusComm(); 			// ״̬��ѯ
	//@Autowired
	private SetOnOffComm 			setOnOff ;//= new setOnOffComm(); 				// ���� ֹͣ����
	//@Autowired
	private SetOnOffLineComm 		setOnOffLine ;//= new setOnOffLineComm(); 		// �Կ� Զ�̼��
	//@Autowired
	private QueryOilNumberComm 		queryOilNumber ;//= new queryOilNumberComm(); 	// ��ѯ��ǰ������
	//@Autowired
	private QueryCardInfosComm 		queryCardInfos ;//= new queryCardInfosComm(); 	// ��ѯ����Ϣ
	//@Autowired
	private QueryLastTradComm 		queryLastTrad ;//= new queryLastTradComm(); 	// ��ѯ���һ�����׼�¼
	
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
	private int 	commStatus=1; //-1 �˿ڴ��� 0 ͨѶʧ�� 1 ����  2 �忨  3 ����
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
		queryLastTrad = 	new QueryLastTradComm(); 	// ��ѯ���һ�����׼�¼
		queryCardInfos =	new QueryCardInfosComm(); 	// ��ѯ����Ϣ		
		queryOilNumber = 	new QueryOilNumberComm(); 	// ��ѯ��ǰ������
		setOnOffLine = 		new SetOnOffLineComm();		//���������������� 		
		setOnOff = 			new SetOnOffComm(); 		//���ͼ��� ֹͣ��������
		queryStatus = 		new QueryStatusComm();		//��ѯIC����״̬	
		setStationID= 		new SetStationID();			//����վ��
		queryStationID=     new QueryStationID();		//��ѯվ��
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
		
		queryLastTrad = 	new QueryLastTradComm(); 	// ��ѯ���һ�����׼�¼
		queryCardInfos =	new QueryCardInfosComm(); 	// ��ѯ����Ϣ		
		queryOilNumber = 	new QueryOilNumberComm(); 	// ��ѯ��ǰ������
		setOnOffLine = 		new SetOnOffLineComm();		//���������������� 		
		setOnOff = 			new SetOnOffComm(); 		//���ͼ��� ֹͣ��������		
		queryStatus = 		new QueryStatusComm();		//��ѯIC����״̬
		
		queryHQAuthID= 		new QueryHQAuthID();		//��ѯ�ܲ�������
		setHQAuthID=		new SetHQAuthID();			//�����ܲ������� 	
		
		queryHTAuthID=		new QueryHTAuthID();		//��ѯ�ܶ�������
		setHTAuthID=		new SetHTAuthID();			//�����ܶ�������
		
		setDateTime=		new SetDateTime();			//����ʱ��
		getDateTime=		new QueryDateTime();		//��ȡʱ��		
		setOilType=			new SetOilType();			//������Ʒ
		getOilType=			new QueryOilType();			//��ȡ��Ʒ
		setPrice=			new SetOilTypePrice();		//���õ���
		getPrice=			new QueryOilTypePrice();	//��ȡ����
		
		setBlackList= 		new SetBlackList();			//�´�������
		clearBlackList=  	new ClearBlackList();		//��������� 
				
		setQuotaList=       new SendQuotas();			//�´�ָ��		
		clearQuotaList=     new ClearQuotas();			//���ָ��
		
		getTrade=			new QueryTradComm();		//��ѯָ����¼
		getTradeNumber=		new QueryTradeNumber();		//��ѯIC������¼��
		
		setStationID= 		new SetStationID();
		queryStationID=     new QueryStationID();		//��ѯվ��
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
		sendCounter++;		//���ʹ���
		if(result!=0)
			errorCounter++;	//�������
		else
			recvCounter++;	//���ܴ���	
	}
	//@Override
	public void run() {		
//		while(true){
//			//setOnOff.setOnStatus();				//���Ϳ�������
//			//setOnOffLine.setOnLineStatus();  	//���ó�����״̬
//			//commStatus=1;//ȱʡ����
//			//logger.debugLog("ǹ��:"+gunId+" ͨ����:"+channelId+"����: "+commCounter+"����: "+errorCounter);
////			if(errorCounter>=10){
////				commStatus=0;
////				errorCounter=0;
////				//return;
////			}
//			int result=queryStatus.query();			//��ѯ״̬			
//			commCounter++;//ͨѶ����
//			if(result!=0){
//				errorCounter++;//�������
//				//commStatus=0;
//				//continue;
//			}
////			if(queryStatus.isOnline()==false) 		//���� ״̬  
////				setOnOffLine.setOnLineStatus();  	//���ó�����״̬
//			
//			if(queryStatus.isTrade()){				//��ѯ�Ƿ������߼�¼
//				result=queryLastTrad.query();		//��ȡ���߼�¼
//				System.out.println("��ȡ���߼�¼: "+result);
//				commCounter++;
//				if(result!=0){
//					errorCounter++;//�������
//					//commStatus=0;
//					//continue;
//				}
//				else// if(result==0)					
//					.add(queryLastTrad.getTradeinfo());				
//			}
//			if(queryStatus.isCard()){//&& (queryStatus.isOiling() != true)){
//				setOnOffLine.setOnLineStatus();  	//���ó�����״̬
//				if(readCardFlag==0){//�忨				
//					result=queryCardInfos.query();		//������Ϣ
//					commCounter++;
//					if(result!=0){
//						errorCounter++;//�������
//						//commStatus=0;
//						//continue;
//					}
//					readCardFlag=1;
//				}
//				if(commStatus==1)
//					commStatus=2;	
////				if((commStatus==2)||(commStatus==3)){//�忨				
////					result=queryCardInfos.query();		//������Ϣ
////					commCounter++;
////					if(result!=0){
////						errorCounter++;//�������
////						//commStatus=0;
////						continue;
////					}
////				}	
//				//commStatus=2;
//			}
//			//��ǹ ���� �п� δ����  ---->���Ϳ�������
//			if ((queryStatus.isGun() == true) && (queryStatus.isOnline()==true) && (queryStatus.isCard()==true) && (queryStatus.isOiling() != true)){				
//				result=setOnOff.setOnStatus();	//���Ϳ�������
////				commCounter++;
////				if(result!=0){
////					errorCounter++;//�������
////					//commStatus=0;
////					continue;
////				}
//			}
//			if((queryStatus.isGun()==true)&&(queryStatus.isOnline())&&(queryStatus.isCard())&&(queryStatus.isOiling())){
//				commStatus=3;//������....
//				result=queryOilNumber.query();	//��ѯ��ǰ��������
//				commCounter++;
//				if(result!=0){
//					errorCounter++;//�������
//					//continue;
//				}
//			}
//			if((queryStatus.isCard()==false)&&(queryStatus.isOiling()==false)){
//				commStatus=1;//���� �޿� ֹͣ����
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
		int result=setDateTime.queryretry(retry);//�´�ʱ��		
		setOilType.setStrValue(cheerDAO.findOilTypeCode(String.format("%02d",gunId)));
		result=setOilType.queryretry(retry);//������Ʒ		
		SysPara paras=stpDAO.findOne();
		setHQAuthID.setStrValue(paras.getHeadQuartersCortrolCode());//������
		setHQAuthID.queryretry(retry);
		setHTAuthID.setStrValue(paras.getAmountCortrolCode());
		setHTAuthID.queryretry(retry);		
		while(runflag){
			result=queryStatus.query();					//��ѯ״̬			
			commcounter(result);
//			result=setOnOffLine.setOnLineStatus();		//���ó�����״̬
//			commcounter(result);		
//����
//			if(queryStatus.isOnline()!=true){
//				setOnOffLine.setOnLineStatus();		//���ó�����״̬
//				commcounter(result);					
//			}
			if(queryStatus.isCard()==false){				
//				if(queryStatus.isOnline()!=true){
//					result=setOnOffLine.setOnLineStatus();		//���ó�����״̬
//					commcounter(result);					
//				}
//				result=queryStatus.query();			//��ѯ״̬			
//				commcounter(result);
				if(queryStatus.isTrade()){			//��ѯ�Ƿ������߼�¼
					result=queryLastTrad.query();	//��ȡ���߼�¼
					commcounter(result);
					if(result==0){
						queryLastTrad.getTradeinfo().setOilType(oiltype);
						cardtrades.add(queryLastTrad.getTradeinfo());
					}
				}
				readCardFlag=0;
				commStatus=1;
			}else {//�忨			
//				if(queryStatus.isOnline()!=true){
//					setOnOffLine.setOnLineStatus();		//���ó�����״̬
//					commcounter(result);					
//				}
				if(readCardFlag==0){	
					result=queryCardInfos.query();		//������Ϣ
					commcounter(result);
					readCardFlag=1;
					commStatus=2;
										
				}				
//				if(queryStatus.isOnline()!=true){
//					setOnOffLine.setOnLineStatus();		//���ó�����״̬
//					commcounter(result);
//				}				
				//�ȴ���������
				if ((queryStatus.isOiling()!=true)&&(queryStatus.isGun() == true) && (queryStatus.isOnline()==true)){				
					result=setOnOff.setOnStatus();	//���Ϳ�������					
					commcounter(result);
					commStatus=3;//������....
				}
				//������
				else if(queryStatus.isOiling()){				
					result=queryOilNumber.query();	//��ѯ��ǰ��������
					commcounter(result);	
					commStatus=3;
				}
				if(commStatus==3){
					result=queryOilNumber.query();	//��ѯ��ǰ��������
					commcounter(result);
				}
			}			
			//logger.debugLog(this.gunId+"��ǹ ��"+commStatus);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//logger.debugLog(gunId+"�˳�");
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
