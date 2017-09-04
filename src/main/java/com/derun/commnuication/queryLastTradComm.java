package com.derun.commnuication;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

import com.derun.entity.cardtrade;

//@Service
//@Scope("prototype")
public class QueryLastTradComm extends abstractCommnuication{

	private cardtrade  tradeinfo;
	
	public QueryLastTradComm(){
		command=ProtocolInfo.READLASTTRADEREC;	//����
		data=new byte[0];						//����
		respLength=79;							//��Ӧ����
		this.sendbuff=new byte[6];				//���ͻ�����
		this.recvbuff=new byte[80];			//���ջ�����
		tradeinfo=new cardtrade();
	}
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==78){//�жϷ������ݳ���
			if(recvbuff[78]==ProtocolInfo.fnChecksumCalc(recvbuff,1,78)){	//У���				
				String info=new String(recvbuff,1,76);
//				System.out.println(info);
				tradeinfo.setCardCode(info.substring(0,12));
				tradeinfo.setCardType(info.substring(12, 13));
				tradeinfo.setTradeDate(info.substring(13, 17)+"-"+info.substring(17, 19)+"-"+info.substring(19, 21));
				tradeinfo.setTradeTime(info.substring(21, 23)+":"+info.substring(23, 25)+":"+info.substring(25, 27));
				tradeinfo.setTradeType(info.substring(27, 28));
				tradeinfo.setGunCode(info.substring(28,30));
				tradeinfo.setVolumn(Double.parseDouble(info.substring(30, 38))/100);
				tradeinfo.setMileage(Integer.parseInt(info.substring(38,44)));
				tradeinfo.setBalance(Double.parseDouble(info.substring(44,52))/100);
				tradeinfo.setSendFlag(Integer.parseInt(info.substring(52,56)));
				tradeinfo.setStationID(info.substring(56,68));
				try{
					tradeinfo.setCardMoney(Double.parseDouble(info.substring(68,76)));
				}catch(Exception e){
					tradeinfo.setCardMoney(0.00);
				}
				//tradeinfo.setOilType("");
//				System.out.println("�����: "+tradeinfo.getBalance());
//				System.out.println("��  ��: "+tradeinfo.getCardCode());
//				System.out.println("������: "+tradeinfo.getCardType());
//				System.out.println("ǹ    ��: "+tradeinfo.getGunCode());
//				System.out.println("������: "+tradeinfo.getSendFlag());
//				System.out.println("������ L: "+tradeinfo.getVolumn());
//				System.out.println("���ͽ�� RMB: "+tradeinfo.getCardMoney());
//				System.out.println("վ    ��: "+tradeinfo.getStationID());
//				System.out.println("��������: "+tradeinfo.getTradeDate());
//				System.out.println("����ʱ��: "+tradeinfo.getTradeTime());
//				System.out.println("���Ѵ���: "+tradeinfo.getMileage());
				return 0;
			}
		}else{
			return -1;
		}
		return -1;
	}
	public cardtrade getTradeinfo() {
		return tradeinfo;
	}
	public void setTradeinfo(cardtrade tradeinfo) {
		this.tradeinfo = tradeinfo;
	}

}
