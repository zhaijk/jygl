package com.derun.commnuication;

public class protocolInfo {

	public final static byte framebegin=(byte) 0xF0; 			//帧头
	public final static byte frameend=(byte) 0xCC;   			//帧尾
	
	public final static byte READSTATUS=(byte) 0xA1; 			//读IC卡机状态命令 
	public final static byte READPRESET=(byte) 0xA2; 			//读取预制量
	public final static byte SETPRESET=(byte) 0xA3; 				//设置预制量 
	public final static byte READOILVALUE=(byte) 0xA4; 			//读取加油量 
	public final static byte READOILTOTAL=(byte) 0xA5; 			//读加油总量 低位 
	public final static byte READOILTOTALHIGH=(byte) 0xA6; 		//读取加油总量 高位 
	public final static byte CLEAROILTOTAL=(byte) 0xA7; 			//加油总量清零 
	public final static byte SETBLACKLIST=(byte) 0xAA; 			//下传黑名单 
	public final static byte CLEARBLACKLIST=(byte) 0xAB; 		//清除黑名单 
	public final static byte READCARMILEAGE=(byte) 0xAC; 		//读取卡里程 
	public final static byte READCARINFO=(byte) 0xAD; 			//读取卡信息 
	public final static byte READTOTALTRADECOUNTER=(byte) 0xAE; 	//读取交易记录数 
	public final static byte READTRADERECORD=(byte) 0xAF; 		//读取交易记录 
	
	public final static byte CLEARTRADEREC=(byte) 0xB1; 			//清卡机记录
	public final static byte READLASTTRADEREC=(byte) 0xB2; 		//读最后一条交易记录
	public final static byte SETQUOTAREC=(byte) 0xB3; 			//下传指标记录
	public final static byte CLEARQUOTAREC=(byte) 0xB4; 			//清指标记录
	public final static byte STARTCARCARDIDEN=(byte) 0xB5; 		//设置车卡识别
	public final static byte DISABLECARCARDIDEN=(byte) 0xB6; 	//车卡识别失效
	public final static byte READDATETIME=(byte) 0xB7; 			//读取IC卡机系统时间
	public final static byte SETDATETIME=(byte) 0xB8; 			//设置IC卡机系统时间
	public final static byte READOILQUALITY=(byte) 0xB9; 		//读油品密度
	public final static byte SETOILQUALITY=(byte) 0xBA; 			//设置油品密度
	public final static byte BEGINOILLING=(byte) 0xBB; 			//开机加油
	public final static byte STOPOILLING=(byte) 0xBC; 			//停止加油
	public final static byte ONLINE=(byte) 0xBD; 				//在线
	public final static byte TAKECARD=(byte) 0xBF; 				//退卡
	
	public final static byte READPRICE=(byte) 0xC2; 				//读单价
	public final static byte OFFLINE=(byte) 0xC3; 				//离线
	public final static byte WRITEPRICE=(byte) 0xC4; 			//写单价
	public final static byte READSTATIONID=(byte) 0xC5; 			//读站号
	public final static byte WRITESTATIONID=(byte) 0xC6; 		//写站号
	public final static byte READDEPARTMENTID=(byte) 0xC7; 		//读总部联勤码
	public final static byte WRITEDEPARTMENTID=(byte) 0xC8; 		//写总部联勤码
	public final static byte READTEAMID=(byte) 0xC9; 			//读总队联勤码
	public final static byte WRITETEAMID=(byte) 0xCA; 			//写总队联勤码
	public final static byte WRITEPASSWORD=(byte) 0xCB; 			//写密码
	
	
	
	private byte[] sendbuff;
//	private byte[] recvbuff;
	
	//private final static byte checksumStartIndex=3; 
	
	//计算校验和
	public static byte fnChecksumCalc(byte[] databuff,int start,int end) {
		int checkSum = 0;
		for (int i = start; i < end; i++) {		//校验和从第4个字节(0xF?,length,gunID,command,data,checksum,0xCC )开始计算 M->S
			checkSum += databuff[i];           	//校验和从第2个字节(length,data,command,checksum)开始计算                  S->M
		}
		checkSum = checkSum & 0x7F; // 不要最高位
		return (byte) checkSum;
	}
	
	//F0 03 01 A1 21 CC	
	public void queryStatus(int channel,int ID,int timeout){
		sendbuff=new byte[6];
//		recvbuff=new byte[4];		
		sendbuff[0]=(byte) (0xF0+channel); 	//帧头 +通道号
		sendbuff[1]=(byte) 0x03;			//数据长度
		sendbuff[2]=(byte) ID;             //枪号
		sendbuff[3]=(byte) 0xA1;           //命令
		sendbuff[4]=(byte) 0x00;//fnChecksumCacl(sendbuff,sendbuff[1]); //校验和
		sendbuff[5]=(byte) 0xCC;			//帧尾
		//System.out.println(sendbuff[4]);
		//serialComm.WriteAndRead(recvbuff, sendbuff, timeout);
	}
	
	public void queryMethod(){
		//sendbuff[4]=fnChecksumCacl(sendbuff,sendbuff[1]); //校验和
		//serialPort.WriteAndRead(recvbuff, sendbuff, 1);
	}
	
	public static void main(String[] args){
		//serialPort.setParam(4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		//serialPort.open(); //打开端口
		//new protocol().queryStatus(0,1,20);		
		//serialPort.close();
		return;
	}
}
