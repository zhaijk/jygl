package com.derun.protocol;

import com.derun.entity.cardinfo;

public class queryCardInfos extends  protocolAdapter{
	
	private final byte length=3;
	private byte[] sendbuff=new byte[6];
	private byte[] recvbuff=new byte[70];	
	
	private int 		gunID;
	private int 		channelID;	
	
	private cardinfo   cardinfo;
	
		
	public queryCardInfos(int gunID,int channelID){
		this.gunID=gunID;
		this.channelID=channelID;
		cardinfo=new cardinfo();
	}

	private void makeupSendbuff(){
		
		sendbuff[0]=(byte) (protocolInfo.framebegin + channelID);
		sendbuff[1]=length;
		sendbuff[2]=(byte) gunID;
		sendbuff[3]=protocolInfo.READCARINFO;		
		sendbuff[4]=protocolInfo.fnChecksumCalc(sendbuff,3,4);
		sendbuff[5]=(byte) (protocolInfo.frameend + channelID);
		
	}
	
	private void analyRecvbuff(){		
		if(recvbuff[0]==64){//�жϷ������ݳ���
			if(recvbuff[64]==protocolInfo.fnChecksumCalc(recvbuff,1,64)){	//У���
				
				String info=new String(recvbuff,1,62);
				System.out.println(info+info.length());
				cardinfo.setCardID(info.substring(0, 12));
				cardinfo.setCardType(info.substring(12, 13));
				cardinfo.setCarNumber(info.substring(13, 29));
				cardinfo.setCarType(info.substring(29, 30));
				cardinfo.setCardBanlance(info.substring(30, 38));
				cardinfo.setIncomingNumber(info.substring(38, 42));
				cardinfo.setTradeCounter(info.substring(42, 48));
				cardinfo.setLastOilDateTime(info.substring(48, 56));
				cardinfo.setLastOilValue(info.substring(56, 62));
				
				System.out.println("�����:"+cardinfo.getCardBanlance());
				System.out.println("����:"+cardinfo.getCardID());
				System.out.println("������:"+cardinfo.getCardType());
				System.out.println("����:"+cardinfo.getCarNumber());				
				System.out.println("������:"+cardinfo.getCarType());
				System.out.println("������:"+cardinfo.getIncomingNumber());
				System.out.println("���һ�μ�������:"+cardinfo.getLastOilDateTime());
				System.out.println("���һ�μ�����:"+cardinfo.getLastOilValue());
				System.out.println("���Ѵ���:"+cardinfo.getTradeCounter());
				
			}
		}else{
			
		}
	}
	
	public int  queryCardInfo(){
		
		makeupSendbuff();
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, 65);
		analyRecvbuff();
		if(result!=0)return -1;
		return result;
	}	
	
	public cardinfo getCardinfo() {
		return cardinfo;
	}	
	
}
