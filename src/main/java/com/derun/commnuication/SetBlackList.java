package com.derun.commnuication;

//import com.derun.entity.Blacklist;

public class SetBlackList extends abstractCommnuication {

	//private Blacklist obj;

	public SetBlackList(){
		//通讯命令字、通讯命令数据、通讯响应长度、初始化输入输出区
		command=ProtocolInfo.SETBLACKLIST;
		data=new byte[7];
		for(int i=0;i<7;i++)
			data[i]=0x30;
		respLength=3;
		this.sendbuff=new byte[13];
		this.recvbuff=new byte[4];
		delaycounter=60;
	}
		
	@Override
	public int analyRecvbuff() {
		if(recvbuff[0]==2){//判断返回数据长度
			if(recvbuff[2]==ProtocolInfo.fnChecksumCalc(recvbuff,1,2))	//校验和
				return 0;
		}
		return -1;
	}
	public void setCardCode6(int flag,String cardcode) {
		if(flag==1)
			data[0]=0x11;
		else
			data[0]=0x22;
		byte[] bytes =cardcode.getBytes();
		int len=bytes.length>6?6:bytes.length;
		for(int i=0;i<len;i++){
			data[6-i]=bytes[bytes.length-i-1];
		}
	}
	public void setCardCode12(int flag,String cardcode) {
		if(flag==1)
			data[0]=0x11;
		else
			data[0]=0x22;
		if(cardcode.length()!=12)
			cardcode=cardcode+"000000000000";
		//System.out.println(cardcode);
		for(int i=0;i<6;i++){
			int index=i*2;
			int high=Integer.parseInt(cardcode.substring(index,index+1));
			int low=Integer.parseInt(cardcode.substring(index+1,index+2));
			data[i+1]=(byte)(high*16+low);
		}
	}
}
