package com.derun.commnuication;


public class QueryHQAuthID extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double  doubleValue=0;

	public QueryHQAuthID(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READDEPARTMENTID;
		data=new byte[0];
		respLength=99;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[99];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==98){//�жϷ������ݳ���
			if(recvbuff[98]==ProtocolInfo.fnChecksumCalc(recvbuff,1,98)){	//У���
				strValue=new String(recvbuff,1,96);
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
