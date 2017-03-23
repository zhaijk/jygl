package com.derun.commnuication;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

import com.derun.entity.cardinfo;
import com.derun.protocol.protocolInfo;

//@Service
//@Scope("prototype")
public class queryCardInfosComm extends abstractCommnuication{

	private cardinfo   cardinfo;
	
	public cardinfo getCardinfo() {
		return cardinfo;
	}

	public void setCardinfo(cardinfo cardinfo) {
		this.cardinfo = cardinfo;
	}

	public queryCardInfosComm(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		command=protocolInfo.READCARINFO;
		data=new byte[0];
		respLength=65;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[70];
		cardinfo=new cardinfo();
	}
	
	@Override
	public int analyRecvbuff() {		
		if(recvbuff[0]==64){//�жϷ������ݳ���
			if(recvbuff[64]==protocolInfo.fnChecksumCalc(recvbuff,1,64)){	//У���
				String info=new String(recvbuff,1,62);
				int offset=62-info.length();				
				System.out.println(info+"---"+info.length());
				cardinfo.setCardID(info.substring(0, 12));
				cardinfo.setCardType(info.substring(12, 13));
				cardinfo.setCarNumber(info.substring(13, 29-offset));
				cardinfo.setCarType(info.substring(29-offset, 30-offset));
				cardinfo.setCardBanlance(info.substring(30-offset, 38-offset));
				cardinfo.setIncomingNumber(info.substring(38-offset, 42-offset));
				cardinfo.setTradeCounter(info.substring(42-offset, 48-offset));
				cardinfo.setLastOilDateTime(info.substring(48-offset, 56-offset));
				cardinfo.setLastOilValue(info.substring(56-offset, 62-offset));
				
				System.out.println("�����:"+cardinfo.getCardBanlance());
				System.out.println("����:"+cardinfo.getCardID());
				System.out.println("������:"+cardinfo.getCardType());
				System.out.println("����:"+cardinfo.getCarNumber());				
				System.out.println("������:"+cardinfo.getCarType());
				System.out.println("������:"+cardinfo.getIncomingNumber());
				System.out.println("���һ�μ�������:"+cardinfo.getLastOilDateTime());
				System.out.println("���һ�μ�����:"+cardinfo.getLastOilValue());
				System.out.println("���Ѵ���:"+cardinfo.getTradeCounter());
				return 0;
			}
		}else{
			//return -1;
			cardinfo.setCardID("000000000000");
		}
		return -1;
	}
}
