package com.derun.commnuication;

import com.derun.protocol.protocolInfo;

//@Service
//@Scope("prototype")
public class queryOilNumberComm extends abstractCommnuication {
	
	private String 	strOilValue=null;
	private int    	intOilValue=0;
	private double 	dblOilValue=0;

	public queryOilNumberComm(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=protocolInfo.READOILVALUE;
		data=new byte[0];
		respLength=9;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[10];
	}
	
	@Override
	public int analyRecvbuff() {		
		if(recvbuff[0]==8){//�жϷ������ݳ���
			if(recvbuff[8]==protocolInfo.fnChecksumCalc(recvbuff,1,8))	//У���
				//System.out.println();
				//strOilValue=recvbuff[1]+""+recvbuff[2]+""+recvbuff[3]+""+recvbuff[4]+"."+recvbuff[5]+recvbuff[6];
				strOilValue=new String(recvbuff,1,6);
				System.out.println(strOilValue);
				dblOilValue=Double.parseDouble(strOilValue)/100;
				intOilValue=((int) (dblOilValue*100));
				System.out.println("�ַ���:"+strOilValue);
				System.out.println("����:"+dblOilValue);
				System.out.println("����:"+intOilValue);
				return 0;
		}else{
			dblOilValue=0;
			intOilValue=0;
			strOilValue="";
			return -1;
		}
	}
	public String getStrOilValue() {
		return strOilValue;
	}	
	public int getIntOilValue() {
		return intOilValue;
	}
	public double getDblOilValue() {
		return dblOilValue;
	}
	
}
