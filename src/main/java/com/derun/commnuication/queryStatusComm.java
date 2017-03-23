package com.derun.commnuication;

//import org.springframework.stereotype.Service;

//@Service
public class queryStatusComm extends abstractCommnuication{

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

	public queryStatusComm(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		//System.out.println("queryStatusComm............");
		super.command=protocolInfo.READSTATUS;
		data=new byte[0];
		super.respLength=5;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[6];
	}	
	@Override
	public int analyRecvbuff() {		
			if(recvbuff[0]==4){//判断返回数据长度
				if(recvbuff[4]==protocolInfo.fnChecksumCalc(recvbuff,1,4)){	//校验和
					setStatus(recvbuff[1]);
					trade=		((recvbuff[1]&0x01)!=0);				
					card=		((recvbuff[1]&0x02)!=0);
					mileage=	((recvbuff[1]&0x04)!=0);
					online=		((recvbuff[1]&0x08)!=0);
					record=		((recvbuff[1]&0x10)!=0);
					oiling=		((recvbuff[1]&0x20)!=0);
					gun=		((recvbuff[1]&0x40)!=0);
					key=		((recvbuff[1]&0x80)!=0);
					
					setCarCardIndetifier(recvbuff[2]);
									
					if(trade==true)System.out.print("有记录");
					else System.out.print("无记录");
					System.out.print("-");
					if(card==true)System.out.print("有卡");
					else System.out.print("无卡");
					System.out.print("-");
					if(mileage==true)System.out.print("有里程");
					else System.out.print("无里程");
					System.out.print("-");
					if(online==true)System.out.print("设备在线");
					else System.out.print("自控");
					System.out.print("-");
					if(record==true)System.out.print("记录已满");
					else System.out.print("记录未满");
					System.out.print("-");
					if(oiling==true)System.out.print("加油中");
					else System.out.print("停机");
					System.out.print("-");
					if(gun==true)System.out.print("提枪");
					else System.out.print("挂枪");
					System.out.print("-");
					if(key==true)System.out.print("等键");
					else System.out.print("不等键");
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
