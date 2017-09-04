package com.derun.commnuication;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

import com.derun.entity.cardtrade;

//@Service
//@Scope("prototype")
public class QueryLastTradComm extends abstractCommnuication{

	private cardtrade  tradeinfo;
	
	public QueryLastTradComm(){
		command=ProtocolInfo.READLASTTRADEREC;	//命令
		data=new byte[0];						//数据
		respLength=79;							//响应长度
		this.sendbuff=new byte[6];				//发送缓冲区
		this.recvbuff=new byte[80];			//接收缓冲区
		tradeinfo=new cardtrade();
	}
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==78){//判断返回数据长度
			if(recvbuff[78]==ProtocolInfo.fnChecksumCalc(recvbuff,1,78)){	//校验和				
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
//				System.out.println("卡余额: "+tradeinfo.getBalance());
//				System.out.println("卡  号: "+tradeinfo.getCardCode());
//				System.out.println("卡类型: "+tradeinfo.getCardType());
//				System.out.println("枪    号: "+tradeinfo.getGunCode());
//				System.out.println("入款次数: "+tradeinfo.getSendFlag());
//				System.out.println("加油量 L: "+tradeinfo.getVolumn());
//				System.out.println("加油金额 RMB: "+tradeinfo.getCardMoney());
//				System.out.println("站    号: "+tradeinfo.getStationID());
//				System.out.println("消费日期: "+tradeinfo.getTradeDate());
//				System.out.println("消费时间: "+tradeinfo.getTradeTime());
//				System.out.println("消费次数: "+tradeinfo.getMileage());
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
