package com.derun.commnuication;

public class QueryDateTime extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double doubleValue=0;

	public QueryDateTime(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READDATETIME;
		data=new byte[0];
		respLength=17;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[17];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==16){//�жϷ������ݳ���
			if(recvbuff[16]==ProtocolInfo.fnChecksumCalc(recvbuff,1,16)){	//У���
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
