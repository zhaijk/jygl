package com.derun.commnuication;

import gnu.io.CommPort;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.PortInUseException;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derun.dao.commportInfoDAO;

import gnu.io.UnsupportedCommOperationException;

@Service
public final class  serialPort {
	
	private  CommPortIdentifier portIden;   	//串口识别
	private  CommPort commPort;             	//串口 
	private  SerialPort serialPort=null;   	//串行操作口
	private static  OutputStream outStream=null;  	//输出流
	private static  InputStream  inStream=null;   	//输入流
	
	
	private  String portName="COM3"; 		//端口号
	private   int  bps=4800;		   		//波特率		
	private   int  dataBits=8;  			//端口参数 数据位数
	private   int  stopBits=1;  			//端口参数 停止位
	private   int  parity=0;    			//端口参数 奇偶校验位
	
	
	private static int openTimeout=2000;
	private static int byteTimeout=10;
	
	private static  int status=0; 
	
	//@Autowired
	//private commportInfoDAO parameters;
//	static{		
//		try{
//			logger.debugLog("初始化.通讯端口...");
//			loadParameters();
//			setParameters();
//			logger.debugLog("初始化.成功...");
//		}catch(NoSuchPortException e1){
//			logger.debugLog("端口不存在");status=2;
//		} catch (PortInUseException e) {
//			logger.debugLog("端口已经占用");status=3;
//		} catch (IOException e) {			
//			logger.debugLog("获取输入输出流错误");status=4;
//		} catch (UnsupportedCommOperationException e) {
//			logger.debugLog("端口参数错误");status=5;
//		}		
//	}
	@Autowired
	public  serialPort(commportInfoDAO param){
		try{
			String strCom=param.findALL().get(0).getDeviceNumber();
			logger.debugLog("初始化.通讯端口..."+strCom);
			portName=strCom;
			loadParameters();
			setParameters();
			logger.debugLog("初始化.成功...");
		}catch(NoSuchPortException e1){
			logger.debugLog("端口不存在");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("端口已经占用");status=3;
		} catch (IOException e) {			
			logger.debugLog("获取输入输出流错误");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("端口参数错误");status=5;
		}	
	}
	
	private  void loadParameters(){
		//portName=parameters.getPors("port");
		bps=Integer.parseInt(parameters.getPors("bps"));
		dataBits=Integer.parseInt(parameters.getPors("dataBits"));
		stopBits=Integer.parseInt(parameters.getPors("stopBits"));
		parity=Integer.parseInt(parameters.getPors("parity"));
		openTimeout=Integer.parseInt(parameters.getPors("openTimeout"));
		byteTimeout=Integer.parseInt(parameters.getPors("byteTimeout"));
		
	}
	
	private  void setParameters() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{
		portIden=CommPortIdentifier.getPortIdentifier(portName);			
		commPort=portIden.open("IC卡机通讯端口", openTimeout);
		serialPort=(SerialPort) commPort;
		serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
		
		
		outStream=serialPort.getOutputStream();
		inStream=serialPort.getInputStream();
		status=1;
	}
	
	public  void open(){
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
			logger.debugLog("端口不存在");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("端口已经占用");status=3;
		} catch (IOException e) {			
			logger.debugLog("获取输入输出流错误");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("端口参数错误");status=5;
		}
		
	}
	
	public  void reOpen(){		
		try{
			if(serialPort!=null)	
				serialPort.close();			
			setParameters();
		}catch(NoSuchPortException e){
			logger.debugLog("端口不存在");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("端口已经占用");status=3;
		} catch (IOException e) {			
			logger.debugLog("获取输入输出流错误");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("端口参数错误");status=5;
		}
		
	}
	
	public  void close(){
		try {
			inStream.close();
			outStream.close();
			commPort.close();
			status = 0;
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	public  OutputStream getOutputStream(){
		
		if(status==1)
			return outStream;
		else
			return null;		
	}
	
	public  InputStream getInputStream(){
		
		if(status==1)
			return inStream;
		else
			return null;
	}

	public int getBps() {
		return bps;
	}

	public  void setBps(int arg) {
		bps = arg;
	}

	public int getDataBits() {
		return dataBits;
	}

	public  void setDataBits(int arg) {
		dataBits = arg;
	}

	public int getStopBits() {
		return stopBits;
	}

	public  void setStopBits(int arg) {
		stopBits = arg;
	}

	public int getParity() {
		return parity;
	}

	public  void setParity(int arg) {
		parity = arg;
	}
	
	public  void setParam(int arg1,int arg2,int arg3,int arg4){		
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
	
	//private static Lock locker =new ReentrantLock();
	//lock.lock()   task  lock.unlock();	
	public static synchronized int WriteAndRead(byte[] inbuffer, byte[] outbuffer, int timeout) {
		//logger.debugLog("开始执行......" + timeout);
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
				//System.out.println("byteTimeout"+byteTimeout);
				Thread.sleep(byteTimeout);
				if (number >= counter)
					break;
				if (timeout == 0)
					break;
				timeout--;
				//logger.debugLog("缓冲区数据个数： " + inStream.available() + " " + timeout);
			}
			//logger.debugLog("缓冲区数据个数： " + inStream.available() + " " + timeout);
			if(counter==inStream.available())
				inStream.read(inbuffer);
			
			//Thread.sleep(100);
			// while (counter > 0) { // 读取数据
			
			// logger.debugLog("data: "+inbuffer[0]+(int)(inbuffer[1])+inbuffer[2]+(byte)0xE0);
			// logger.debugLog("缓冲区数据个数： "+inStream.available());

			// Thread.sleep(10);
			// counter--; // 延时退出t
			// }
			return 0;
		} catch (IOException e) {
			logger.debugLog("读写操作失败...");
			return -1;
		} catch (InterruptedException e) {
			logger.debugLog("延时计数器出问题");
			return -2;
		} catch (NullPointerException e){
			logger.debugLog("端口不存在");
			return -3;
		}
		//logger.debugLog("结束任务......" + timeout);
		//locker.unlock();
	}
}
