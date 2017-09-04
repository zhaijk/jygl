package com.derun.commnuication;

public class QueryDepartmentID extends abstractCommnuication {

	private String 	strValue="";
//	private int    	intValue=0;
//	private double  doubleValue=0;

	public QueryDepartmentID(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READSTATIONID;
		data=new byte[0];
		respLength=15;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[15];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==14){//�жϷ������ݳ���
			if(recvbuff[14]==ProtocolInfo.fnChecksumCalc(recvbuff,1,14)){	//У���
				strValue=new String(recvbuff,1,12);
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
