package com.derun.commnuication;



public class QueryPreset extends abstractCommnuication {

	private String 	strValue="";
	private int    	intValue=0;
	private double doubleValue=0;

	public QueryPreset(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READPRESET;
		data=new byte[0];
		respLength=9;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[10];
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==8){//�жϷ������ݳ���
			if(recvbuff[8]==ProtocolInfo.fnChecksumCalc(recvbuff,1,8)){	//У���
				strValue=new String(recvbuff,1,6);
				try{
					doubleValue=Double.parseDouble(strValue)/100;					
					intValue=((int) (doubleValue*100));
				}catch(Exception e){
					intValue=0;
					return 0;
				}
				return 0;
			}else{
				return -1;
			}
		}else{
			intValue=0;
			doubleValue=0;
			strValue="";
			return -1;
		}
	}
	public String getStrValue() {
		return strValue;
	}	
	public int getIntValue() {
		return intValue;
	}
	public double getDoubleValue() {
		return doubleValue;
	}
}
