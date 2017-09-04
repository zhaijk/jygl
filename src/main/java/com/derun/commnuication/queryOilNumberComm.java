package com.derun.commnuication;


//@Service
//@Scope("prototype")
public class QueryOilNumberComm extends abstractCommnuication {
	
	private String 	strOilValue=null;
	private int    	intOilValue=0;
	private double 	dblOilValue=0;

	public QueryOilNumberComm(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.READOILVALUE;
		data=new byte[0];
		respLength=9;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[10];
	}
	
	@Override
	public int analyRecvbuff() {		
		if(recvbuff[0]==8){//�жϷ������ݳ���
			if(recvbuff[8]==ProtocolInfo.fnChecksumCalc(recvbuff,1,8))	//У���
				//System.out.println();
				//strOilValue=recvbuff[1]+""+recvbuff[2]+""+recvbuff[3]+""+recvbuff[4]+"."+recvbuff[5]+recvbuff[6];
				strOilValue=new String(recvbuff,1,6);
//				System.out.println(strOilValue);
				try{
					dblOilValue=Double.parseDouble(strOilValue)/100;
					intOilValue=((int) (dblOilValue*100));
				}catch(Exception e){
					intOilValue=0;
				}
//				System.out.println("�ַ���:"+strOilValue);
//				System.out.println("����:"+dblOilValue);
//				System.out.println("����:"+intOilValue);
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
