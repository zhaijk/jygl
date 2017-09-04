package com.derun.commnuication;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;

import com.derun.entity.cardinfo;
//import com.derun.protocol.protocolInfo;

//@Service
//@Scope("prototype")
public class QueryCardInfosComm extends abstractCommnuication{

	private cardinfo   cardinfo;
	
	public synchronized cardinfo getCardinfo() {
		return cardinfo;
	}

	public synchronized void setCardinfo(cardinfo cardinfo) {
		this.cardinfo = cardinfo;
	}

	public QueryCardInfosComm(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.READCARINFO;
		data=new byte[0];
		respLength=65;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[70];
		cardinfo=new cardinfo();
	}
	
	@Override
	public int analyRecvbuff() {		
		if(recvbuff[0]==64){//判断返回数据长度
			if(recvbuff[64]==ProtocolInfo.fnChecksumCalc(recvbuff,1,64)){	//校验和
				String info=new String(recvbuff,1,62);
				int offset=62-info.length();				
				//logger.debugLog(info+" "+info.length()+" "+offset);
				cardinfo.setCardID(info.substring(0, 12));
				cardinfo.setCardType(info.substring(12, 13));
				cardinfo.setCarNumber(info.substring(13, 29-offset));
				cardinfo.setCarType(info.substring(29-offset, 30-offset));
				cardinfo.setCardBanlance(info.substring(30-offset, 38-offset));
				cardinfo.setIncomingNumber(info.substring(38-offset, 42-offset));
				cardinfo.setTradeCounter(info.substring(42-offset, 48-offset));
				cardinfo.setLastOilDateTime(info.substring(48-offset, 56-offset));
				cardinfo.setLastOilValue(info.substring(56-offset, 62-offset));
				
				
				//logger.debugLog("卡余额:"+cardinfo.getCardBanlance());

//				System.out.println("卡余额:"+cardinfo.getCardBanlance());
//				System.out.println("卡号:"+cardinfo.getCardID());
//				System.out.println("卡类型:"+cardinfo.getCardType());
//				System.out.println("车号:"+cardinfo.getCarNumber());				
//				System.out.println("车类型:"+cardinfo.getCarType());
//				System.out.println("入款次数:"+cardinfo.getIncomingNumber());
//				System.out.println("最后一次加油日期:"+cardinfo.getLastOilDateTime());
//				System.out.println("最后一次加油量:"+cardinfo.getLastOilValue());
//				System.out.println("消费次数:"+cardinfo.getTradeCounter());
				return 0;
			}
		}else{
			//return -1;
			cardinfo.setCardID("000000000000");
		}
		return -1;
	}
}
