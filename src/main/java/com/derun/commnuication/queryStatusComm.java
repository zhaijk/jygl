package com.derun.commnuication;

//import java.text.SimpleDateFormat;
//import java.util.Date;

//@Service
public class QueryStatusComm extends abstractCommnuication{

	private boolean trade;   	//脱机记录 	0 没有  	1 有 	低位	
	private boolean card;    	//卡状态   	0 没有  	1 有
	private boolean mileage; 	//里程     	0 没有  	1 有
	private boolean online; 	//是否在线  	0 自控 	1 受控
	private boolean record; 	//记录已满  	0 没有  	1 有
	private boolean oiling; 	//加油机状态	0 停机  	1 开机
	private boolean gun; 		//油枪      	0 挂枪	1 提枪
	private boolean key; 		//等键 		0 不等  	1 等  	高位
	
	private byte carCardIndetifier; //车卡识别	
	private int status;

	public QueryStatusComm(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		//System.out.println("queryStatusComm............");
		super.command=ProtocolInfo.READSTATUS;
		data=new byte[0];
		super.respLength=5;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[6];
	}	
	@Override
	public int analyRecvbuff() {		
			if(recvbuff[0]==4){//判断返回数据长度
				if(recvbuff[4]==ProtocolInfo.fnChecksumCalc(recvbuff,1,4)){	//校验和
					setStatus(recvbuff[1]);
					trade=		((recvbuff[1]&0x01)!=0);				
					card=		((recvbuff[1]&0x02)!=0);
					mileage=	((recvbuff[1]&0x04)!=0);
					online=		((recvbuff[1]&0x08)!=0);
					record=		((recvbuff[1]&0x10)!=0);
					oiling=		((recvbuff[1]&0x20)!=0);
					gun=		((recvbuff[1]&0x40)!=0);
					key=		((recvbuff[1]&0x80)!=0);
					
//					setCarCardIndetifier(recvbuff[2]);
//					StringBuilder sbStatus=new 	StringBuilder();			
//					if(trade==true)sbStatus.append("有记录");
//					else sbStatus.append("无记录");
//					sbStatus.append("-");
//					if(card==true)sbStatus.append("有卡");
//					else sbStatus.append("无卡");
//					sbStatus.append("-");
//					if(mileage==true)sbStatus.append("有里程");
//					else sbStatus.append("无里程");
//					sbStatus.append("-");
//					if(online==true)sbStatus.append("设备在线");
//					else sbStatus.append("自控");
//					sbStatus.append("-");
//					if(record==true)sbStatus.append("记录已满");
//					else sbStatus.append("记录未满");
//					sbStatus.append("-");
//					if(oiling==true)sbStatus.append("加油中");
//					else sbStatus.append("停机");
//					sbStatus.append("-");
//					if(gun==true)sbStatus.append("提枪");
//					else sbStatus.append("挂枪");
//					sbStatus.append("-");
//					if(key==true)sbStatus.append("等键");
//					else sbStatus.append("不等键");
//					//logger.debugLog(new SimpleDateFormat("HH:mm:ss SSS").format(new Date())+":"+this.gunID+" "+this.channelID+" "+sbStatus.toString());
//					logger.debugLog(+Thread.currentThread().getId()+" "+this.gunID+" "+this.channelID+" "+sbStatus.toString());
					return 0;
				}	
			}else{
				return -1;
		}
		return -1;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public byte getCarCardIndetifier() {
		return carCardIndetifier;
	}
	public void setCarCardIndetifier(byte carCardIndetifier) {
		this.carCardIndetifier = carCardIndetifier;
	}

	public boolean isTrade() {
		return trade;
	}

	public void setTrade(boolean trade) {
		this.trade = trade;
	}

	public boolean isCard() {
		return card;
	}

	public void setCard(boolean card) {
		this.card = card;
	}

	public boolean isMileage() {
		return mileage;
	}

	public void setMileage(boolean mileage) {
		this.mileage = mileage;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isRecord() {
		return record;
	}

	public void setRecord(boolean record) {
		this.record = record;
	}

	public boolean isOiling() {
		return oiling;
	}

	public void setOiling(boolean oiling) {
		this.oiling = oiling;
	}

	public boolean isGun() {
		return gun;
	}

	public void setGun(boolean gun) {
		this.gun = gun;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}
}
