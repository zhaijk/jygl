package com.derun.commnuication;


//@Service
//@Scope("prototype")
public class QueryStationID extends abstractCommnuication {
	
	private String 	strValue=null;
	//private int 	intValue=0;
	
	public QueryStationID(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.READSTATIONID;
		data=new byte[0];
		respLength=15;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[15];
	}
	
	@Override
	public int analyRecvbuff() {		
		if(recvbuff[0]==14){//判断返回数据长度
			if(recvbuff[14]==ProtocolInfo.fnChecksumCalc(recvbuff,1,14)){//校验和
				strValue=new String(recvbuff,1,12);				
				return 0;
			}else{
				return -1;
			}
		}else{
			return -1;
		}
	}
	public String getStrValue() {
		return strValue;
	}	
//	public int getIntValue(){
//		return intValue; 
//	}
}
