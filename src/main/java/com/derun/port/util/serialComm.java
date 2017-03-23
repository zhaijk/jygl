package com.derun.port.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public final class  serialComm {
	
	private static CommPortIdentifier portIden;   	//串口识别
	private static CommPort commPort;             	//串口 
	private static SerialPort serialPort=null;   	//串行操作口
	private static OutputStream outStream=null;  	//输出流
	private static InputStream  inStream=null;   	//输入流
	
	
	private static String portName="COM3"; 		//端口号
	private static  int  bps=4800;		   				//波特率		
	private static  int  dataBits=8;  					//端口参数 数据位数
	private static  int  stopBits=1;  					//端口参数 停止位
	private static  int  parity=0;    					//端口参数 奇偶校验位
	
	
	private final static int openTimeout=2000;
	
	private static  int status=0; 
	
	private serialComm(){
		
	}
	
	public static void open(){
		if(status==1) return ;
		try{
			portIden=CommPortIdentifier.getPortIdentifier(portName);			
			serialPort=(SerialPort) commPort;
			serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
			commPort=portIden.open("IC卡机通讯端口", openTimeout);
			//((SerialPort)(CommPortIdentifier.getPortIdentifier(portName)).open("IC卡机通讯端口", openTimeout)).setSerialPortParams(bps, dataBits, stopBits, parity);
			
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
		try{
			if(serialPort!=null)	
				serialPort.close();			
			portIden=CommPortIdentifier.getPortIdentifier(portName);
			commPort=portIden.open("IC卡机通讯端口", openTimeout);
			serialPort=(SerialPort) commPort;
			serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
			
			outStream=serialPort.getOutputStream();
			inStream=serialPort.getInputStream();
			status=1;
		}catch(NoSuchPortException e){
			System.out.println("端口不存在");status=2;
		} catch (PortInUseException e) {
			System.out.println("端口已经占用");status=3;
		} catch (IOException e) {			
			System.out.println("获取输入输出流错误");status=4;
		} catch (UnsupportedCommOperationException e) {
			System.out.println("端口参数错误");status=5;
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
	//lock =new ReentrantLock()
	//lock.lock()   task  lock.unlock();	
	public static synchronized void WriteAndRead( byte[] inbuffer, byte[] outbuffer, int timeout){
		System.out.println("开始执行......"+timeout);
		try {
			int counter = timeout;
			//inStream.reset(); //清空输入流
			outStream.write(outbuffer); // 发送数据
			while (counter > 0) { // 读取数据
				if (inStream.available() > 0)
					inStream.read(inbuffer);				
				Thread.sleep(10);
				counter--; // 延时退出
			}

		} catch (IOException e) {
			System.out.println("读写操作失败...");
		} catch (InterruptedException e) {
			System.out.println("延时计数器出问题");
		}
		System.out.println("操作结束......"+timeout);
	}
}
