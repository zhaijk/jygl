package com.derun.commnuication;

//通讯协议模板
public abstract class abstractCommnuication {

	protected final byte length=3;//发送数据长度
	protected byte[] sendbuff;
	protected byte[] recvbuff;	  
	
	
	protected  int 		gunID; 		//枪号
	protected  int 		channelID;  //通道号
	//protected static int      errorCounter=0;//通讯错误计数器
	protected byte 	command;	//通讯命令
	protected byte[]  data;		//参数
	protected int     	respLength; //回传数据长度
	
	public void setParam(int channelID,int gunID){
		
		this.channelID=(byte)channelID;
		this.gunID=(byte)gunID;
		
	}
	
	protected void makeupSendbuff(){		
		sendbuff[0]=(byte) (protocolInfo.framebegin + channelID);
		sendbuff[1]=length;
		sendbuff[2]=(byte) gunID;
		sendbuff[3]=this.command;
		if(data.length!=0){
			for(int i=0;i<data.length;i++)
				sendbuff[4+i]=data[i];
		}
		sendbuff[4+data.length]=protocolInfo.fnChecksumCalc(sendbuff,3,4+data.length);
		sendbuff[5+data.length]=protocolInfo.frameend;
		//System.out.println(sendbuff[2]+" "+channelID+" "+protocolInfo.framebegin);
	}
	protected void makeupSendbuff(byte arg){		
		sendbuff[0]=(byte) (protocolInfo.framebegin + channelID);
		sendbuff[1]=length;
		sendbuff[2]=(byte) gunID;
		sendbuff[3]=arg;
		if(data.length!=0){
			for(int i=0;i<data.length;i++)
				sendbuff[4+i]=data[i];
		}
		sendbuff[4+data.length]=protocolInfo.fnChecksumCalc(sendbuff,3,4+data.length);
		sendbuff[5+data.length]=protocolInfo.frameend;
	}
	
	public abstract int analyRecvbuff();
	
	public  int  query(){		
		makeupSendbuff();
		//System.out.println("respLength:"+respLength);
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, respLength);
		if(result!=0)return -1;
		result=analyRecvbuff();
		if(result!=0)return -1;
		return result;
	}
	public  int  query(byte arg){		
		makeupSendbuff(arg);
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, respLength);
		if(result!=0)return -1;
		result=analyRecvbuff();
		if(result!=0)return -1;
		return result;
	}
	
}
