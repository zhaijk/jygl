package com.derun.commnuication;



public class QueryOilType extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double doubleValue=0;

	public QueryOilType(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READOILQUALITY;
		data=new byte[0];
		respLength=5;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[5];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==4){//�жϷ������ݳ���
			if(recvbuff[4]==ProtocolInfo.fnChecksumCalc(recvbuff,1,4)){	//У���
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
