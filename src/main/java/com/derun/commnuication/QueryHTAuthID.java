package com.derun.commnuication;



public class QueryHTAuthID extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double  doubleValue=0;

	public QueryHTAuthID(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READTEAMID;
		data=new byte[0];
		respLength=67;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[67];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==66){//�жϷ������ݳ���
			if(recvbuff[66]==ProtocolInfo.fnChecksumCalc(recvbuff,1,66)){	//У���
				strValue=new String(recvbuff,1,64);
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
