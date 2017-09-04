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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.derun.dao.SysTemParameterDAO;
//import com.derun.dao.commportInfoDAO;

import gnu.io.UnsupportedCommOperationException;

@Service
public class  SerialPortLocal {
	
	private  CommPortIdentifier portIden;   		//串口识别
	private  CommPort commPort;             		//串口 
	private  SerialPort sp=null;   				//串行操作口
	private static  OutputStream outStream=null;  	//输出流
	private static  InputStream  inStream=null;   	//输入流
	
	
	private  String portName="COM4"; 				//端口号
	@Value("#{sys.bps}")
	private   int  bps=9600;		   				//波特率
	@Value("#{sys.dataBits}")
	private   int  dataBits=8;  					//端口参数 数据位数
	@Value("#{sys.stopBits}")
	private   int  stopBits=1;  					//端口参数 停止位
	@Value("#{sys.parity}")
	private   int  parity=0;    					//端口参数 奇偶校验位
	
	
	private static int openTimeout=2000;
	private static int byteTimeout=1;
	
	private  volatile int status=0; 
	
	public synchronized int getStatus() {
		return status;
	}

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
	public  SerialPortLocal(SysTemParameterDAO dao){
		try{
			String strCom="COM"+dao.findALL().get(0).getMachinePort();
			//String strCom="COM4";
			logger.debugLog("初始化.通讯端口..."+strCom);
			portName=strCom;
			loadParameters();
			setParameters();
			logger.debugLog("初始化.成功...");
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
	public  SerialPortLocal(){
		try{
			//String strCom="COM"+dao.findALL().get(0).getMachinePort();
			//String strCom="COM4";			
			//portName=portName;
			logger.debugLog("初始化.通讯端口..."+portName);
			loadParameters();
			setParameters();
			logger.debugLog("初始化.成功...");
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
	private  void loadParameters(){
		//portName=parameters.getPors("port");
		bps=Integer.parseInt(parameters.getPors("bps"));
		dataBits=Integer.parseInt(parameters.getPors("dataBits"));
		stopBits=Integer.parseInt(parameters.getPors("stopBits"));
		parity=Integer.parseInt(parameters.getPors("parity"));
		openTimeout=Integer.parseInt(parameters.getPors("openTimeout"));
		logger.debugLog("byteTimeout： "+Integer.parseInt(parameters.getPors("byteTimeout")));
		byteTimeout=Integer.parseInt(parameters.getPors("byteTimeout"));
		
	}
	
	private  void setParameters() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{		
		portIden=CommPortIdentifier.getPortIdentifier(portName);			
		commPort=portIden.open("IC卡机通讯端口", openTimeout);
		sp=(SerialPort) commPort;
		sp.setSerialPortParams(bps, dataBits, stopBits, parity);
		outStream=sp.getOutputStream();
		inStream=sp.getInputStream();
		status=1;
	}
	
	public  void open(){
		if(status==1) return ;
		try{
			portIden=CommPortIdentifier.getPortIdentifier(portName);			
			commPort=portIden.open("IC卡机通讯端口", openTimeout);
			sp=(SerialPort) commPort;
			sp.setSerialPortParams(bps, dataBits, stopBits, parity);
			outStream=sp.getOutputStream();
			inStream=sp.getInputStream();			
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
	
	public  void reopen(){		
		try{
			if(sp!=null)	
				sp.close();
			sp=null;
			Thread.sleep(100);
			setParameters();
			open();
		}catch(NoSuchPortException e){
			logger.debugLog("端口不存在");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("端口已经占用");status=3;
		} catch (IOException e) {			
			logger.debugLog("获取输入输出流错误");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("端口参数错误");status=5;
		} catch (InterruptedException e) {
			logger.debugLog("实时异常 延时错误");status=5;
		}
		
	}
	
	public  void close(){
		try {
			inStream.close();
			outStream.close();
			commPort.close();
			status = 0;
		} catch (IOException e) {			
			status=0;
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
	//private static int count=100;

	public  synchronized static int WriteAndRead(byte[] inbuffer, byte[] outbuffer, int timeout,int delaycounter) {
		//logger.debugLog("开始执行......" + timeout);
		//locker.lock();
		try {			
			int counter = timeout*10;
			// inStream.reset(); //清空输入流
			while (inStream.available() > 0) {
				inStream.read();
			}
			outStream.write(outbuffer); //发送数据
			// 清除接收缓冲区
			for (int i = 0; i < timeout; i++)				
				inbuffer[i] = 0;
			int number=0; 
//			System.out.println("开始  计数器"+counter+"缓冲区个数："+number +"yanshi :"+byteTimeout);
			//System.out.println(outbuffer.length);
//			if(outbuffer.length>44){
			//	Thread.sleep(500);
////				//System.out.println("sleep............"+count);
//			}
//				System.out.println("sleep............"+outbuffer.length);
//			}else{
//				System.out.println("no..............."+outbuffer.length);
//				//Thread.sleep(300);
//			}
			Thread.sleep(delaycounter);
			while (counter > 0) {				
				number =inStream.available();
				//System.out.println(counter+" "+number);
				if (number >= timeout){
					break;
				}
				//if (timeout == 0)
				//	break;
				counter--;
				Thread.sleep(byteTimeout);
//				System.out.println("timeout: "+byteTimeout+" counter: "+counter+" recv:"+number);				
				//logger.debugLog("缓冲区数据个数： " + inStream.available() + " " + timeout);
			}
			//logger.debugLog("结束  计数器"+counter+"缓冲区个数："+number);
//			for(int i=0;i<timeout;i++)
//				Thread.sleep(byteTimeout*10);			
//			System.out.println("缓冲区数据个数： " + inStream.available() + " " + counter+" "+byteTimeout);
			if(timeout==inStream.available()){
//				System.out.println("get data");
				number=inStream.read(inbuffer);	
//				for(int i=0;i<20;i++)
//					System.out.println(inbuffer[i]+" ");
			}
			//System.out.println(result);
			//Thread.sleep(100);
			// while (counter > 0) { // 读取数据
			
			// logger.debugLog("data: "+inbuffer[0]+(int)(inbuffer[1])+inbuffer[2]+(byte)0xE0);
			// logger.debugLog("缓冲区数据个数： "+inStream.available());

			// Thread.sleep(10);
			// counter--; // 延时退出t
			// }
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
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
	
//	public static void main(String[] args) {
////		byte[] sendbuff={(byte) 0xF0,0x03,0x01,(byte) 0xA1,0x21,(byte) 0xCC};
////		byte[] recvbuff=new byte[20];
////		
//		
//		//SerialPortLocal  sp=new SerialPortLocal();
//		  CommPortIdentifier portIden;   		//串口识别
//		  CommPort commPort = null;             		//串口 
//		  SerialPort sp=null;   				//串行操作口
//		 
//		
//		
//		  String portName="COM4"; 				//端口号
//		   int  bps=4800;		   				//波特率		
//		   int  dataBits=8;  					//端口参数 数据位数
//		   int  stopBits=1;  					//端口参数 停止位
//		   int  parity=0;    					//端口参数 奇偶校验位
//		while(true){
////			SerialPortLocal  sp=new SerialPortLocal();
////			sp.open();
////			System.out.println(sp.status);
//			try{
//				//CommPortIdentifier.getPortIdentifier(commPort);
//				portIden=CommPortIdentifier.getPortIdentifier(portName);			
//				commPort=portIden.open("IC卡机通讯端口", openTimeout);
//				sp=(SerialPort) commPort;
//				sp.setSerialPortParams(bps, dataBits, stopBits, parity);
//				Thread.sleep(1000);
//			}catch(Exception e){
//				e.printStackTrace();
//			}				
//			
//			//sp=new SerialPortLocal();
////			sp=null;
////			sp=new SerialPortLocal();
//			
//		}
//	}
}
