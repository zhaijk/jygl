package com.derun.protocol;

//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

public class queryStatus extends  protocolAdapter{
	
	private final byte length=3;
	private byte[] sendbuff=new byte[6];
	private byte[] recvbuff=new byte[6];	
	
	private int gunID;
	private int channelID;
	
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
	
	public byte getCarCardIndetifier() {
		return carCardIndetifier;
	}

	public queryStatus(int gunID,int channelID){
		this.gunID=gunID;
		this.channelID=channelID;
	}

	private void makeupSendbuff(){
		sendbuff[0]=(byte) (protocolInfo.framebegin + channelID);
		sendbuff[1]=length;
		sendbuff[2]=(byte) gunID;
		sendbuff[3]=protocolInfo.READSTATUS;		
		sendbuff[4]=protocolInfo.fnChecksumCalc(sendbuff,3,4);
		sendbuff[5]=(byte) (protocolInfo.frameend + channelID);
	}
	
	private void analyRecvbuff(){
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
				
				carCardIndetifier=recvbuff[2];
								
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
			}	
		}else{
			
		}
	}
	
	public int  queryMachineStatus(){
		makeupSendbuff();
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, 5);
		analyRecvbuff();
		if(result==0)
			return recvbuff[0];
		return -1;
	}
	
	public int getGunID() {
		return gunID;
	}

	public int getChannelID() {
		return channelID;
	}

	public boolean isTrade() {
		return trade;
	}

	public boolean isCard() {
		return card;
	}

	public boolean isMileage() {
		return mileage;
	}

	public boolean isOnline() {
		return online;
	}

	public boolean isRecord() {
		return record;
	}

	public boolean isOiling() {
		return oiling;
	}

	public boolean isGun() {
		return gun;
	}

	public boolean isKey() {
		return key;
	}
	/*
	public static void main(String[] args){
		
		final protocol[]  p=new protocol[16];		
		for(int i = 0; i < 16; i++) {
			p[i] = new queryStatus(1 + i, i);
		}	
		new Thread(new Runnable() {			
			@Override
			public void run() {
				while (true)
					p[0].queryMachineStatus();
				//System.out.println("111");
			}
		}).start();
	}*/
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
//	public static void main(String[] args){		
//		ExecutorService server=Executors.newFixedThreadPool(20);
//		for(int i = 0; i < 8; i++) {
//			server.execute(new scanthread("thread "+i,i+1,i));
//		}
//		for(int i=8;i<16;i++)
//			new scanthread(i+"",i+1,i).start();
//	}
}
