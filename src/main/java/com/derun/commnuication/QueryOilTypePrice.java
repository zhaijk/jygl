package com.derun.commnuication;



public class QueryOilTypePrice extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
	private double doubleValue=0;

	public QueryOilTypePrice(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READPRICE;
		data=new byte[0];
		respLength=7;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[7];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==6){//�жϷ������ݳ���
			if(recvbuff[6]==ProtocolInfo.fnChecksumCalc(recvbuff,1,6)){	//У���
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
