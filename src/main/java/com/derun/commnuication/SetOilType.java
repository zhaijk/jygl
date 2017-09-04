package com.derun.commnuication;


public class SetOilType extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double doubleValue=0;

	public SetOilType(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.SETOILQUALITY;
		//data=String.valueOf((int)(doubleValue*100)).getBytes();
		data=new byte[8];
		for(int i=0;i<8;i++)
			data[i]=0x30;
		respLength=3;
		this.sendbuff=new byte[14];
		this.recvbuff=new byte[4];
		delaycounter=100;
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==2){//判断返回数据长度
			if(recvbuff[2]==ProtocolInfo.fnChecksumCalc(recvbuff,1,2))	//校验和
				return 0;
		}
		return -1;
	}
//	public String getStrValue() {
//		return strValue;
//	}	
//	public int getIntValue() {
//		return intValue;
//	}
//	public double getDoubleValue() {
//		return doubleValue;
//	}

//	public double getDoubleValue() {
//		return doubleValue;
//	}
//
//	public void setDoubleValue(double doubleValue) {
//		this.doubleValue = doubleValue;		
//		byte[] ar =String.valueOf((int)(doubleValue*100)).getBytes();
//		
//		for(int i=0;i<ar.length;i++){
//			data[5-i]=ar[ar.length-i-1];
//		}
//	}
	public void setStrValue(String value){
		this.strValue=value;
		byte[] ar =strValue.getBytes();
		if(ar.length==2){
			data[0]=ar[0];
			data[1]=ar[1];
		}
		data[2]=(byte) 0x96;
		data[3]=0x38;
		data[4]=0x52;
		data[5]=0x74;
		data[6]=0x19;
		data[7]=0x21;
	}
}
