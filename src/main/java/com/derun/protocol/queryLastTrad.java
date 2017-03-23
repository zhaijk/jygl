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
		if(recvbuff[0]==78){//判断返回数据长度
			if(recvbuff[78]==protocolInfo.fnChecksumCalc(recvbuff,1,78)){	//校验和
				
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
//				System.out.println("卡余额: "+tradeinfo.getBalance());
//				System.out.println("卡  号: "+tradeinfo.getCardID());
//				System.out.println("卡类型: "+tradeinfo.getCardType());
//				System.out.println("枪    号: "+tradeinfo.getGunID());
//				System.out.println("入款次数: "+tradeinfo.getImcomingNumber());
//				System.out.println("加油量 L: "+tradeinfo.getOilValue());
//				System.out.println("加油金额 RMB: "+tradeinfo.getSale());
//				System.out.println("站    号: "+tradeinfo.getStationID());
//				System.out.println("消费日期: "+tradeinfo.getStrDate());
//				System.out.println("消费时间: "+tradeinfo.getStrTime());
//				System.out.println("消费次数: "+tradeinfo.getTradeCounter());				
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
