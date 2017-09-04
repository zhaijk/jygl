package com.derun.commnuication;



public class QueryOilTypePrice extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
	private double doubleValue=0;

	public QueryOilTypePrice(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.READPRICE;
		data=new byte[0];
		respLength=7;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[7];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==6){//判断返回数据长度
			if(recvbuff[6]==ProtocolInfo.fnChecksumCalc(recvbuff,1,6)){	//校验和
				strValue=new String(recvbuff,1,4);	
				doubleValue=Double.parseDouble(strValue)/100;
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

	public double getDoubleValue() {
		return doubleValue;
	}
}
