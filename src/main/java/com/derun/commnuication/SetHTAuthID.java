package com.derun.commnuication;



public class SetHTAuthID extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double doubleValue=0;

	public SetHTAuthID(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.WRITETEAMID;
		//data=String.valueOf((int)(doubleValue*100)).getBytes();
		data=new byte[64];
		for(int i=0;i<64;i++)
			data[i]=0x30;
		respLength=3;
		this.sendbuff=new byte[70];
		this.recvbuff=new byte[4];
		delaycounter=500;
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
		int len=ar.length>64?64:ar.length;
		for(int i=0;i<len;i++){
			data[63-i]=ar[len-1-i];
		}
	}
}
