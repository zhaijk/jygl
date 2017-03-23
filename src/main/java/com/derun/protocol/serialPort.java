package com.derun.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.derun.port.util.parameters;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public final class  serialPort {
	
	private static CommPortIdentifier portIden;   	//串口识别
	private static CommPort commPort;             	//串口 
	private static SerialPort serialPort=null;   	//串行操作口
	private static OutputStream outStream=null;  	//输出流
	public static OutputStream getOutStream() {
		return outStream;
	}
	private static InputStream  inStream=null;   	//输入流
	
	
	private static String portName="COM3"; 		//端口号
	private static  int  bps=4800;		   		//波特率		
	private static  int  dataBits=8;  			//端口参数 数据位数
	private static  int  stopBits=1;  			//端口参数 停止位
	private static  int  parity=0;    			//端口参数 奇偶校验位
	
	
	private static int openTimeout=2000;
	private static int byteTimeout=10;
	
	private static  int status=0; 
	
//	static{		
//		try{
//			//loadParameters();
//			//setParameters();
//		}catch(NoSuchPortException e1){
//			System.out.println("端口不存在");status=2;
//		} catch (PortInUseException e) {
//			System.out.println("端口已经占用");status=3;
//		} catch (IOException e) {			
//			System.out.println("获取输入输出流错误");status=4;
//		} catch (UnsupportedCommOperationException e) {
//			System.out.println("端口参数错误");status=5;
//		}		
//	}
	private serialPort(){
		
	}
	
	public  void loadParameters() throws PortInUseException, NoSuchPortException{
		portName=parameters.getPors("port");
		bps=Integer.parseInt(parameters.getPors("bps"));
		dataBits=Integer.parseInt(parameters.getPors("dataBits"));
		stopBits=Integer.parseInt(parameters.getPors("stopBits"));
		parity=Integer.parseInt(parameters.getPors("parity"));
		openTimeout=Integer.parseInt(parameters.getPors("openTimeout"));
		byteTimeout=Integer.parseInt(parameters.getPors("byteTimeout"));
		//try {
		portIden=CommPortIdentifier.getPortIdentifier(portName);
		//} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}			
		commPort=portIden.open("IC卡机通讯端口", openTimeout);
		serialPort=(SerialPort) commPort;
	}
	
	public  void setParameters(int parity) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{
//		portIden=CommPortIdentifier.getPortIdentifier(portName);			
//		commPort=portIden.open("IC卡机通讯端口", openTimeout);
//		serialPort=(SerialPort) commPort;
		serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
		
		outStream=serialPort.getOutputStream();
		inStream=serialPort.getInputStream();
		status=1;
	}
	
	public static void open(){
		if(status==1) return ;
		try{
			portIden=CommPortIdentifier.getPortIdentifier(portName);			
			commPort=portIden.open("IC卡机通讯端口", openTimeout);
			serialPort=(SerialPort) commPort;
			serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
			
			
			outStream=serialPort.getOutputStream();
			inStream=serialPort.getInputStream();
			status=1;
		}catch(NoSuchPortException e1){
			System.out.println("端口不存在");status=2;
		} catch (PortInUseException e) {
			System.out.println("端口已经占用");status=3;
		} catch (IOException e) {			
			System.out.println("获取输入输出流错误");status=4;
		} catch (UnsupportedCommOperationException e) {
			System.out.println("端口参数错误");status=5;
		}
		
	}
	
	public static void reOpen(){		
//		try{
//			if(serialPort!=null)	
//				serialPort.close();			
//			//setParameters();
//		}catch(NoSuchPortException e){
//			System.out.println("端口不存在");status=2;
//		} catch (PortInUseException e) {
//			System.out.println("端口已经占用");status=3;
//		} catch (IOException e) {			
//			System.out.println("获取输入输出流错误");status=4;
//		} catch (UnsupportedCommOperationException e) {
//			System.out.println("端口参数错误");status=5;
//		}
		
	}
	
	public static void close(){
		try {
			inStream.close();
			outStream.close();
			commPort.close();
			status = 0;
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public static OutputStream getOutputStream(){
		
		if(status==1)
			return outStream;
		else
			return null;		
	}
	
	public static InputStream getInputStream(){
		
		if(status==1)
			return inStream;
		else
			return null;
	}

	public int getBps() {
		return bps;
	}

	public static void setBps(int arg) {
		bps = arg;
	}

	public int getDataBits() {
		return dataBits;
	}

	public static void setDataBits(int arg) {
		dataBits = arg;
	}

	public int getStopBits() {
		return stopBits;
	}

	public static void setStopBits(int arg) {
		stopBits = arg;
	}

	public int getParity() {
		return parity;
	}

	public static void setParity(int arg) {
		parity = arg;
	}
	
	public static void setParam(int arg1,int arg2,int arg3,int arg4){		
		bps=arg1;
		dataBits=arg2;
		stopBits=arg3;
		parity=arg4;
		
	}
	
	//计算校验和
	public  static byte fnChecksumCalc(byte[] databuff, int index , int length) {
			int checkSum = 0;
			for (int i = index; i < length+2; i++) {
				checkSum += databuff[i];
			}
			checkSum = checkSum & 0x7F; // 不要最高位
			return (byte) checkSum;
	}	
	public static String byteToHex(byte data){
		int result=data;
		String strResult = null;
		if(data<0)
			result=256+data;
		int index=result/16;
		switch(index){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			strResult=Integer.toString(index);break;
		case 10:
			strResult="A";break;
		case 11:
			strResult="B";break;
		case 12:
			strResult="C";break;
		case 13:
			strResult="D";break;
		case 14:
			strResult="E";break;
		case 15:
			strResult="F";break;
		}
		index=result%16;
		switch(index){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			strResult+=Integer.toString(index);break;
		case 10:
			strResult+="A";break;
		case 11:
			strResult+="B";break;
		case 12:
			strResult+="C";break;
		case 13:
			strResult+="D";break;
		case 14:
			strResult+="E";break;
		case 15:
			strResult+="F";break;
		}
		return  strResult;
	}
	//private static Lock locker =new ReentrantLock();
	//lock.lock()   task  lock.unlock();	
	public static  synchronized int WriteAndRead(byte[] inbuffer, //synchronized
			byte[] outbuffer, int timeout) {
		//System.out.println("开始执行......" + timeout);
		//locker.lock();
		try {
			int counter = timeout;
			// inStream.reset(); //清空输入流
			while (inStream.available() > 0) {
				inStream.read();
			}
			outStream.write(outbuffer); // 发送数据			
			for (int i = 0; i < timeout; i++)
				// 清除接收缓冲区
				inbuffer[i] = 0;
			
			while (counter > 0) {
				int number =inStream.available();				
				Thread.sleep(byteTimeout);
				if (number >= counter)
					break;
				if (timeout == 0)
					break;
				timeout--;
			}
			System.out.println("缓冲区数据个数： " + inStream.available() + " " + timeout);
			if(counter==inStream.available())
				inStream.read(inbuffer);
			
			// Thread.sleep(100);
			// while (counter > 0) { // 读取数据
			
			// System.out.println("data: "+inbuffer[0]+(int)(inbuffer[1])+inbuffer[2]+(byte)0xE0);
			// System.out.println("缓冲区数据个数： "+inStream.available());

			// Thread.sleep(10);
			// counter--; // 延时退出t
			// }
			return 0;
		} catch (IOException e) {
			System.out.println("读写操作失败...");
			return -1;
		} catch (InterruptedException e) {
			System.out.println("延时计数器出问题");
			return -2;
		} catch (NullPointerException e){
			System.out.println("端口不存在");
			return -3;
		}
		//System.out.println("结束任务......" + timeout);
		//locker.unlock();
	}
	public static void main(String[] args) throws PortInUseException, NoSuchPortException, UnsupportedCommOperationException, IOException, InterruptedException{
		serialPort sp=new serialPort();
		sp.loadParameters();
//		int counter=0;
		while(true){
			System.out.println("发送命令 02 83 00 B1 30");
			//System.out.println("发送命令 01 83 00 41 30");
			//01 83 00 41 30 
			sp.setParameters(SerialPort.PARITY_MARK);
//			sp.getOutStream().write(0x01);
//			counter=counter+1;
//			System.out.println("发送间隔延时"+counter);
			Thread.sleep(200);
			sp.setParameters(SerialPort.PARITY_SPACE);
//			sp.getOutStream().write(0x83);
//			sp.getOutStream().write(0x00);
//			sp.getOutStream().write(0x41);
//			sp.getOutStream().write(0x30);
			byte[] array=new byte[4];
			array[0]=(byte) 0x83;
			array[1]=0x00;
			array[2]=(byte) 0x41;
			array[3]=0x30;
//			sp.getOutStream().write(array);

			System.out.println("读取数据");
			int result = 0;
			for(int i=0;i<30;i++){
//				result=sp.getInputStream().available();
				System.out.print(i+"-"+result+" ");
				 if(result==68) break;
				//System.out.print(sp.getInputStream().available());
				Thread.sleep(20);
			}
			
			System.out.println("处理数据....");
			byte[] readbuff=new byte[500];
			//for(int i=0;i<10;i++){
//				sp.getInputStream().read(readbuff);
			//}
			if(result!=68) continue;	
			for(int i=0;i<68;i++)
			{				
				System.out.print(byteToHex(readbuff[i])+"-");
			}
			System.out.println("通道号: "+readbuff[0]);
			System.out.println("命令: "+byteToHex(readbuff[1]));			
			System.out.print("工作状态: ");
			switch(readbuff[2]){
			case 0:System.out.println("空闲");break;
			case 1:System.out.println("准备");break;
			case 2:System.out.println("发油");break;
			case 3:System.out.println("暂停");break;
			case 4:System.out.println("换A枪");break;
			case 5:System.out.println("换B枪");break;
			case 6:System.out.println("到量");break;
			case 7:System.out.println("选仓后,申请验证");break;
			case 8:System.out.println("暂停继续申请");break;
			case 9:System.out.println("就绪发油申请");break;
			}
			System.out.println("数据帧长度:"+byteToHex(readbuff[3]));
			
			System.out.println("密码: "+(readbuff[4]-0x30)+(readbuff[5]-0x30)+(readbuff[6]-0x30)+(readbuff[7]-0x30)+(readbuff[8]-0x30)+(readbuff[9]-0x30));
			System.out.println("应发量: "+(readbuff[10]-0x30)+(readbuff[11]-0x30)+(readbuff[12]-0x30)+(readbuff[13]-0x30)+(readbuff[14]-0x30)+(readbuff[15]-0x30));
			
			System.out.println("油品符号:"+byteToHex(readbuff[16]));
			System.out.println("油品号:"+byteToHex(readbuff[17])+" "+byteToHex(readbuff[18]));
			
			System.out.println("版本号:"+(readbuff[19]-0x30));
			System.out.println("仓号:"+(readbuff[20]-0x30));
			
			System.out.println("脉冲数"+ byteToHex(readbuff[21])+byteToHex(readbuff[22])+byteToHex(readbuff[23])+byteToHex(readbuff[24]));
			
			
			System.out.println("温度符号 "+byteToHex(readbuff[25]));
			
			System.out.println("温度: "+(readbuff[26]-0x30)+(readbuff[27]-0x30)+(readbuff[28]-0x30)+(readbuff[29]-0x30));
			
			System.out.println("密度: "+(readbuff[30]-0x30)+(readbuff[31]-0x30)+(readbuff[32]-0x30)+(readbuff[33]-0x30)+(readbuff[34]-0x30)+(readbuff[35]-0x30));
			
			System.out.println("瞬时: "+(readbuff[36]-0x30)+(readbuff[37]-0x30)+(readbuff[38]-0x30)+(readbuff[39]-0x30)+(readbuff[40]-0x30));
			System.out.println("设备状态:"+ byteToHex(readbuff[41]));
			if((readbuff[41]&0x80)!=0){
				System.out.print("鹤位在位报警");
			}else{
				System.out.print("鹤位正常");
			}
			System.out.print("-");
			if((readbuff[41]&0x40)!=0){
				System.out.print("油仓可选");
			}else{
				System.out.print("油仓选完");
			}
			System.out.print("-");
			if((readbuff[41]&0x20)!=0){
				System.out.print("联机");
			}else{
				System.out.print("单机");
			}			
			System.out.print("-");
			if((readbuff[41]&0x10)!=0){
				System.out.print("溢出报警");
			}else{
				System.out.print("溢出正常");
			}
			System.out.print("-");
			if((readbuff[41]&0x08)!=0){
				System.out.print("静电报警");
			}else{
				System.out.print("静电正常");
			}
			System.out.print("-");
			if((readbuff[41]&0x04)!=0){
				System.out.print("电液阀B有输出");
			}else{
				System.out.print("电液阀B无输出");
			}
			System.out.print("-");
			if((readbuff[41]&0x02)!=0){
				System.out.print("电液阀A有输出");
			}else{
				System.out.print("电液阀A无输出");
			}
			System.out.print("-");
			if((readbuff[41]&0x01)!=0){
				System.out.print("泵控制异常");
			}else{
				System.out.print("泵控制正常");
			}
			
			System.out.println("计量方式:"+(readbuff[42]-0x30));
			
			System.out.println("IC卡号:"+byteToHex(readbuff[42])+byteToHex(readbuff[43])+byteToHex(readbuff[44])+byteToHex(readbuff[45]));
			
			System.out.println("暂停后继续验证方式: "+(readbuff[46]-0x30));
			
			System.out.println("设备状态: "+byteToHex(readbuff[47]));
			System.out.print("-");
			if((readbuff[47]&0x08)!=0){
				System.out.print("温度信号线断线");
			}else{
				System.out.print("温度信号线正常");
			}
			System.out.print("-");
			if((readbuff[47]&0x04)!=0){
				System.out.print("油温过低");
			}else{
				System.out.print("油温正常");
			}
			System.out.print("-");
			if((readbuff[47]&0x02)!=0){
				System.out.print("油温过高");
			}else{
				System.out.print("油温正常");
			}
			System.out.print("-");
			if((readbuff[47]&0x01)!=0){
				System.out.print("超高流速报警");
			}else{
				System.out.print("流速正常");
			}
			
			System.out.println("视体: "+byteToHex(readbuff[48])+byteToHex(readbuff[49])+byteToHex(readbuff[50]));
			System.out.println("标体: "+byteToHex(readbuff[51])+byteToHex(readbuff[52])+byteToHex(readbuff[53]));
			System.out.println("质量: "+byteToHex(readbuff[54])+byteToHex(readbuff[55])+byteToHex(readbuff[56]));
			
			System.out.println("累计表数: "+byteToHex(readbuff[58])+byteToHex(readbuff[59])+byteToHex(readbuff[60])+byteToHex(readbuff[61]));
			
			System.out.println("AD值: "+byteToHex(readbuff[62])+byteToHex(readbuff[57]));
			for(int i=0;i<68;i++)
			{				
				readbuff[i]=(byte) 0xff;
			}
			
			Thread.sleep(1000);
		}
	}
}
