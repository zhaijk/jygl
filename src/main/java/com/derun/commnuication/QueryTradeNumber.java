package com.derun.commnuication;


//@Service
//@Scope("prototype")
public class QueryTradeNumber extends abstractCommnuication {
	
	private String 	strValue=null;
	private int 	intValue=0;
	
	public QueryTradeNumber(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READTOTALTRADECOUNTER;
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
				intValue=Integer.parseInt(strValue);
				return 0;
			}else{
				return -1;
			}
		}else{
			return -1;
		}
	}
	public String getStrValue() {
		return strValue;
	}	
	public int getIntValue(){
		return intValue; 
	}
}
