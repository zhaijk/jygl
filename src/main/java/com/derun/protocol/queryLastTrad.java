package com.derun.protocol;

import com.derun.entity.cardtrade;

public class queryLastTrad extends  protocolAdapter{
	
	private final byte length=3;
	private byte[] sendbuff=new byte[6];
	private byte[] recvbuff=new byte[80];	
	
	private int 		gunID;
	private int 		channelID;	
	
	private cardtrade   tradeinfo;
	
		
	public queryLastTrad(int gunID,int channelID){
		this.gunID=gunID;
		this.channelID=channelID;
		tradeinfo=new cardtrade();
	}

	private void makeupSendbuff(){
		
		sendbuff[0]=(byte) (protocolInfo.framebegin + channelID);
		sendbuff[1]=length;
		sendbuff[2]=(byte) gunID;
		sendbuff[3]=protocolInfo.READLASTTRADEREC;		
		sendbuff[4]=protocolInfo.fnChecksumCalc(sendbuff,3,4);
		sendbuff[5]=(byte) (protocolInfo.frameend + channelID);
		
	}
	
	private void analyRecvbuff(){		
		if(recvbuff[0]==78){//�жϷ������ݳ���
			if(recvbuff[78]==protocolInfo.fnChecksumCalc(recvbuff,1,78)){	//У���
				
				String info=new String(recvbuff,1,76);
				System.out.println(info);
//				tradeinfo.setCardID(info.substring(0,12));
//				tradeinfo.setCardType(info.substring(12, 13));
//				tradeinfo.setStrDate(info.substring(13, 21));
//				tradeinfo.setStrTime(info.substring(21, 27));
//				tradeinfo.setType(info.substring(27, 28));
//				tradeinfo.setGunID(info.substring(28,30));
//				tradeinfo.setOilValue(info.substring(30, 38));
//				tradeinfo.setTradeCounter(info.substring(38,44));
//				tradeinfo.setBalance(info.substring(44,52));
//				tradeinfo.setImcomingNumber(info.substring(52,56));
//				tradeinfo.setStationID(info.substring(56,68));
//				tradeinfo.setSale(info.substring(68,76));
//				System.out.println("�����: "+tradeinfo.getBalance());
//				System.out.println("��  ��: "+tradeinfo.getCardID());
//				System.out.println("������: "+tradeinfo.getCardType());
//				System.out.println("ǹ    ��: "+tradeinfo.getGunID());
//				System.out.println("������: "+tradeinfo.getImcomingNumber());
//				System.out.println("������ L: "+tradeinfo.getOilValue());
//				System.out.println("���ͽ�� RMB: "+tradeinfo.getSale());
//				System.out.println("վ    ��: "+tradeinfo.getStationID());
//				System.out.println("��������: "+tradeinfo.getStrDate());
//				System.out.println("����ʱ��: "+tradeinfo.getStrTime());
//				System.out.println("���Ѵ���: "+tradeinfo.getTradeCounter());				
			}
		}else{
			
		}
	}
	
	public int  queryLastTrade(){
		
		makeupSendbuff();
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, 79);
		analyRecvbuff();
		if(result!=0)return -1;
		return result;
	}	
	

	public cardtrade getTradeinfo() {
		return tradeinfo;
	}
	
}
