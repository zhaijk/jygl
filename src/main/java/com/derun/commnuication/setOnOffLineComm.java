package com.derun.commnuication;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//@Service
//@Scope("prototype")
public class SetOnOffLineComm extends abstractCommnuication{

	public SetOnOffLineComm(){
		command=ProtocolInfo.ONLINE;		//命令
		data=new byte[0];					//数据
		respLength=3;						//响应长度
		this.sendbuff=new byte[6];			//发送缓冲区
		this.recvbuff=new byte[6];			//接收缓冲区
	}
	
	public int  setOnLineStatus(){	
		//System.out.println("在线命令");
		return super.query(ProtocolInfo.ONLINE);
	}
	
	public int  setOffLineStatus(){
		return super.query(ProtocolInfo.OFFLINE);
	}	
	
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==2){//判断返回数据长度
			if(recvbuff[2]==ProtocolInfo.fnChecksumCalc(recvbuff,1,2))	//校验和
				return 0;
		}
		return -1;
	}

}
