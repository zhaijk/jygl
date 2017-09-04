package com.derun.commnuication;



public class QueryOilType extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double doubleValue=0;

	public QueryOilType(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.READOILQUALITY;
		data=new byte[0];
		respLength=5;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[5];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==4){//判断返回数据长度
			if(recvbuff[4]==ProtocolInfo.fnChecksumCalc(recvbuff,1,4)){	//校验和
				strValue=new String(recvbuff,1,2);	
				//doubleValue=Double.parseDouble(strValue)/100;
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

//	public double getDoubleValue() {
//		return doubleValue;
//	}
}
