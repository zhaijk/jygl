package com.derun.commnuication;

import com.derun.entity.CardPutout;


public class SendQuotas extends abstractCommnuication {
	
	private CardPutout  quota;
	
	public SendQuotas(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=ProtocolInfo.SETQUOTAREC;
		data=new byte[40];
		for(int i=0;i<40;i++)
			data[i]=0x30;
		respLength=3;
		this.sendbuff=new byte[46];
		this.recvbuff=new byte[4];
		delaycounter=250;
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==2){//�жϷ������ݳ���
			if(recvbuff[2]==ProtocolInfo.fnChecksumCalc(recvbuff,1,2))	//У���
				return 0;
		}
		return -1;
	}
//	public String getStrValue() {
//		return strValue;
//	}	
//	public int getIntValue() {
//		return intValue;
//	}
//	public double getDoubleValue() {
//		return doubleValue;
//	}

//	public double getDoubleValue() {
//		return doubleValue;
//	}

	public void setQuota(int flag,CardPutout  quota) {
		this.quota = quota;
		if(flag==1)
			data[0]=0x11;
		else
			data[0]=0x22;
		quotaToData();
//		StringBuilder strB=new StringBuilder();
//		strB.append(quota.getProvidedate().replaceAll("-", ""));//����
//		strB.append(quota.getProvidetime().replaceAll(":", ""));//ʱ��
//		strB.append(quota.getCardcode());//����
		//for(int i=0;i<8;i++){
		
	}
	private void quotaToData(){	
		System.out.println(quota.getProvidedate());
		byte buffer[]=quota.getProvidedate().replaceAll("-", "").getBytes();
		for(int i=1;i<buffer.length+1;i++)//����
			data[i]=buffer[i-1];		
		buffer=quota.getProvidetime().replaceAll(":", "").getBytes();
		for(int i=9;i<buffer.length+9;i++)//ʱ��
			data[i]=buffer[i-9];
		buffer=quota.getCardcode().getBytes();
		for(int i=15;i<buffer.length+15;i++)//����
			data[i]=buffer[i-15];
		if(quota.getGuidelinecount()>0)	  //���ű�־ 0x55+ 0x66- 
			data[27]=0x55;				  //         0x77 1 0x88 2 0x99	3
		else
			data[27]=0x66;		
		buffer=String.format("%08d",(int)(quota.getGuidelinecount()*100)).getBytes();
		for(int i=28;i<buffer.length+28;i++)//������
			data[i]=buffer[i-28];
		buffer=String.format("%04d",quota.getSendflag()).getBytes();
		for(int i=36;i<buffer.length+36;i++)//������
			data[i]=buffer[i-36];
	}
}
