package com.derun.protocol;

public class setOnOff extends  protocolAdapter{
	
	private final byte length=3;
	private byte[] sendbuff=new byte[6];
	private byte[] recvbuff=new byte[6];	
	
	private int gunID;
	private int channelID;
	
	private boolean status; 
	
	public setOnOff(int gunID,int channelID){
		this.gunID=gunID;
		this.channelID=channelID;
	}

	private void makeupSendbuff(byte command){
		sendbuff[0]=(byte) (protocolInfo.framebegin + channelID);
		sendbuff[1]=length;
		sendbuff[2]=(byte) gunID;
		sendbuff[3]=command;
		sendbuff[4]=protocolInfo.fnChecksumCalc(sendbuff,3,4);
		sendbuff[5]=(byte) (protocolInfo.frameend + channelID);
		status=false;
	}
	
	private void analyRecvbuff(){
		if(recvbuff[0]==2){//判断返回数据长度
			if(recvbuff[2]==protocolInfo.fnChecksumCalc(recvbuff,1,2))	//校验和
				status=true;
		}
	}

	public int  setOnStatus(){		
		makeupSendbuff(protocolInfo.BEGINOILLING);
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, 3);
		analyRecvbuff();
		if(result!=0)return -1;
		return result;
	}
	public int  setOffStatus(){
		makeupSendbuff(protocolInfo.STOPOILLING);
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, 3);
		analyRecvbuff();
		if(result!=0)return -1;
		return result;
	}

	public boolean isStatus() {
		return status;
	}

	@Override
	public int setOnOffStatus(boolean OnOff) {
		int result;
		if(OnOff==true)
			result=setOnStatus();
		else
			result=setOffStatus();
		if(result!=0)return -1;
		return result;
	}

	/*
	public static void main(String[] args){		
		ExecutorService server=Executors.newFixedThreadPool(20);
		for(int i = 0; i < 8; i++) {
			server.execute(new scanthread("thread "+i,i+1,i));
		}
		for(int i=8;i<16;i++)
			new scanthread(i+"",i+1,i).start();
	}
	*/	
}
