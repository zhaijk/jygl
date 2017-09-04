package com.derun.commnuication;



public class QueryHTAuthID extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double  doubleValue=0;

	public QueryHTAuthID(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.READTEAMID;
		data=new byte[0];
		respLength=67;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[67];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==66){//判断返回数据长度
			if(recvbuff[66]==ProtocolInfo.fnChecksumCalc(recvbuff,1,66)){	//校验和
				strValue=new String(recvbuff,1,64);
				return 0;				
			}else{
				return -1;
			}
		}else{
			strValue="";
			return -1;
		}
	}
	public String getStrValue() {
		return strValue;
	}
}
