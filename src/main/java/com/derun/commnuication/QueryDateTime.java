package com.derun.commnuication;

public class QueryDateTime extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double doubleValue=0;

	public QueryDateTime(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.READDATETIME;
		data=new byte[0];
		respLength=17;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[17];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==16){//判断返回数据长度
			if(recvbuff[16]==ProtocolInfo.fnChecksumCalc(recvbuff,1,16)){	//校验和
				strValue=new String(recvbuff,1,14);				
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
