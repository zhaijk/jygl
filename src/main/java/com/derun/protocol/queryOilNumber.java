package com.derun.protocol;

public class queryOilNumber extends  protocolAdapter{
	
	private final byte length=3;
	private byte[] sendbuff=new byte[6];
	private byte[] recvbuff=new byte[10];	
	
	private int 		gunID;
	private int 		channelID;	
	
	private String 	strOilValue=null;
	public String getStrOilValue() {
		return strOilValue;
	}

	private int    	intOilValue=0;
	private double 	dblOilValue=0;
	public double getDblOilValue() {
		return dblOilValue;
	}

	public queryOilNumber(int gunID,int channelID){
		this.gunID=gunID;
		this.channelID=channelID;
	}

	private void makeupSendbuff(){
		sendbuff[0]=(byte) (protocolInfo.framebegin + channelID);
		sendbuff[1]=length;
		sendbuff[2]=(byte) gunID;
		sendbuff[3]=protocolInfo.READOILVALUE;		
		sendbuff[4]=protocolInfo.fnChecksumCalc(sendbuff,3,4);
		sendbuff[5]=(byte) (protocolInfo.frameend + channelID);
	}
	
	private void analyRecvbuff(){
		if(recvbuff[0]==8){//判断返回数据长度
			if(recvbuff[8]==protocolInfo.fnChecksumCalc(recvbuff,1,8))	//校验和
				//System.out.println();
				strOilValue=recvbuff[1]+""+recvbuff[2]+""+recvbuff[3]+""+recvbuff[4]+"."+recvbuff[5]+recvbuff[6];
				strOilValue=new String(recvbuff,1,6);
				dblOilValue=Double.parseDouble(strOilValue)/100;
				intOilValue=((int) (dblOilValue*100));
				System.out.println(strOilValue);
				System.out.println(dblOilValue);
				System.out.println(intOilValue);
		}else{
			dblOilValue=0;
			intOilValue=0;
			strOilValue="";
		}
	}
	
	public int  queryOilValue(){
		makeupSendbuff();
		int result=serialPort.WriteAndRead(recvbuff, sendbuff, 9);
		analyRecvbuff();
		if(result!=0)return -1;
		return result;
	}	
	
	
	public static void main(String[] args){		
		
	}

	public int getIntOilValue() {
		return intOilValue;
	}	
	
}
