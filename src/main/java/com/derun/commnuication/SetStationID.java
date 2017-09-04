package com.derun.commnuication;

public class SetStationID extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double doubleValue=0;

	public SetStationID(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.WRITESTATIONID;
		//data=String.valueOf((int)(doubleValue*100)).getBytes();
		data=new byte[12];
		for(int i=0;i<12;i++)
			data[i]=0x30;
		respLength=3;
		this.sendbuff=new byte[18];
		this.recvbuff=new byte[4];
		delaycounter=200;
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==2){//�жϷ������ݳ���
			if(recvbuff[2]==ProtocolInfo.fnChecksumCalc(recvbuff,1,2))	//У���
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
		int len=ar.length>12?12:ar.length;
		for(int i=0;i<len;i++){
			data[11-i]=ar[len-1-i];
		}
	}
}
