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
	
	private  CommPortIdentifier portIden;   		//����ʶ��
	private  CommPort commPort;             		//���� 
	private  SerialPort sp=null;   				//���в�����
	private static  OutputStream outStream=null;  	//�����
	private static  InputStream  inStream=null;   	//������
	
	
	private  String portName="COM4"; 				//�˿ں�
	@Value("#{sys.bps}")
	private   int  bps=9600;		   				//������
	@Value("#{sys.dataBits}")
	private   int  dataBits=8;  					//�˿ڲ��� ����λ��
	@Value("#{sys.stopBits}")
	private   int  stopBits=1;  					//�˿ڲ��� ֹͣλ
	@Value("#{sys.parity}")
	private   int  parity=0;    					//�˿ڲ��� ��żУ��λ
	
	
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
//			logger.debugLog("��ʼ��.ͨѶ�˿�...");
//			loadParameters();
//			setParameters();
//			logger.debugLog("��ʼ��.�ɹ�...");
//		}catch(NoSuchPortException e1){
//			logger.debugLog("�˿ڲ�����");status=2;
//		} catch (PortInUseException e) {
//			logger.debugLog("�˿��Ѿ�ռ��");status=3;
//		} catch (IOException e) {			
//			logger.debugLog("��ȡ�������������");status=4;
//		} catch (UnsupportedCommOperationException e) {
//			logger.debugLog("�˿ڲ�������");status=5;
//		}		
//	}
	@Autowired
	public  SerialPortLocal(SysTemParameterDAO dao){
		try{
			String strCom="COM"+dao.findALL().get(0).getMachinePort();
			//String strCom="COM4";
			logger.debugLog("��ʼ��.ͨѶ�˿�..."+strCom);
			portName=strCom;
			loadParameters();
			setParameters();
			logger.debugLog("��ʼ��.�ɹ�...");
			status=1;
		}catch(NoSuchPortException e1){
			logger.debugLog("�˿ڲ�����");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("�˿��Ѿ�ռ��");status=3;
		} catch (IOException e) {			
			logger.debugLog("��ȡ�������������");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("�˿ڲ�������");status=5;
		}	
	}	
	public  SerialPortLocal(){
		try{
			//String strCom="COM"+dao.findALL().get(0).getMachinePort();
			//String strCom="COM4";			
			//portName=portName;
			logger.debugLog("��ʼ��.ͨѶ�˿�..."+portName);
			loadParameters();
			setParameters();
			logger.debugLog("��ʼ��.�ɹ�...");
			status=1;
		}catch(NoSuchPortException e1){
			logger.debugLog("�˿ڲ�����");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("�˿��Ѿ�ռ��");status=3;
		} catch (IOException e) {			
			logger.debugLog("��ȡ�������������");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("�˿ڲ�������");status=5;
		}	
	}	
	private  void loadParameters(){
		//portName=parameters.getPors("port");
		bps=Integer.parseInt(parameters.getPors("bps"));
		dataBits=Integer.parseInt(parameters.getPors("dataBits"));
		stopBits=Integer.parseInt(parameters.getPors("stopBits"));
		parity=Integer.parseInt(parameters.getPors("parity"));
		openTimeout=Integer.parseInt(parameters.getPors("openTimeout"));
		logger.debugLog("byteTimeout�� "+Integer.parseInt(parameters.getPors("byteTimeout")));
		byteTimeout=Integer.parseInt(parameters.getPors("byteTimeout"));
		
	}
	
	private  void setParameters() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{		
		portIden=CommPortIdentifier.getPortIdentifier(portName);			
		commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
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
			commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
			sp=(SerialPort) commPort;
			sp.setSerialPortParams(bps, dataBits, stopBits, parity);
			outStream=sp.getOutputStream();
			inStream=sp.getInputStream();			
		}catch(NoSuchPortException e1){
			logger.debugLog("�˿ڲ�����");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("�˿��Ѿ�ռ��");status=3;
		} catch (IOException e) {			
			logger.debugLog("��ȡ�������������");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("�˿ڲ�������");status=5;
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
			logger.debugLog("�˿ڲ�����");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("�˿��Ѿ�ռ��");status=3;
		} catch (IOException e) {			
			logger.debugLog("��ȡ�������������");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("�˿ڲ�������");status=5;
		} catch (InterruptedException e) {
			logger.debugLog("ʵʱ�쳣 ��ʱ����");status=5;
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
	
	//����У���
	public  static byte fnChecksumCalc(byte[] databuff, int index , int length) {
			int checkSum = 0;
			for (int i = index; i < length+2; i++) {
				checkSum += databuff[i];
			}
			checkSum = checkSum & 0x7F; // ��Ҫ���λ
			return (byte) checkSum;
	}	
	
	//private static Lock locker =new ReentrantLock();
	//lock.lock()   task  lock.unlock();	
	//private static int count=100;

	public  synchronized static int WriteAndRead(byte[] inbuffer, byte[] outbuffer, int timeout,int delaycounter) {
		//logger.debugLog("��ʼִ��......" + timeout);
		//locker.lock();
		try {			
			int counter = timeout*10;
			// inStream.reset(); //���������
			while (inStream.available() > 0) {
				inStream.read();
			}
			outStream.write(outbuffer); //��������
			// ������ջ�����
			for (int i = 0; i < timeout; i++)				
				inbuffer[i] = 0;
			int number=0; 
//			System.out.println("��ʼ  ������"+counter+"������������"+number +"yanshi :"+byteTimeout);
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
				//logger.debugLog("���������ݸ����� " + inStream.available() + " " + timeout);
			}
			//logger.debugLog("����  ������"+counter+"������������"+number);
//			for(int i=0;i<timeout;i++)
//				Thread.sleep(byteTimeout*10);			
//			System.out.println("���������ݸ����� " + inStream.available() + " " + counter+" "+byteTimeout);
			if(timeout==inStream.available()){
//				System.out.println("get data");
				number=inStream.read(inbuffer);	
//				for(int i=0;i<20;i++)
//					System.out.println(inbuffer[i]+" ");
			}
			//System.out.println(result);
			//Thread.sleep(100);
			// while (counter > 0) { // ��ȡ����
			
			// logger.debugLog("data: "+inbuffer[0]+(int)(inbuffer[1])+inbuffer[2]+(byte)0xE0);
			// logger.debugLog("���������ݸ����� "+inStream.available());

			// Thread.sleep(10);
			// counter--; // ��ʱ�˳�t
			// }
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			logger.debugLog("��д����ʧ��...");
			return -1;
		} catch (InterruptedException e) {
			logger.debugLog("��ʱ������������");
			return -2;
		} catch (NullPointerException e){
			logger.debugLog("�˿ڲ�����");
			return -3;
		}
		//logger.debugLog("��������......" + timeout);
		//locker.unlock();
	}
	
//	public static void main(String[] args) {
////		byte[] sendbuff={(byte) 0xF0,0x03,0x01,(byte) 0xA1,0x21,(byte) 0xCC};
////		byte[] recvbuff=new byte[20];
////		
//		
//		//SerialPortLocal  sp=new SerialPortLocal();
//		  CommPortIdentifier portIden;   		//����ʶ��
//		  CommPort commPort = null;             		//���� 
//		  SerialPort sp=null;   				//���в�����
//		 
//		
//		
//		  String portName="COM4"; 				//�˿ں�
//		   int  bps=4800;		   				//������		
//		   int  dataBits=8;  					//�˿ڲ��� ����λ��
//		   int  stopBits=1;  					//�˿ڲ��� ֹͣλ
//		   int  parity=0;    					//�˿ڲ��� ��żУ��λ
//		while(true){
////			SerialPortLocal  sp=new SerialPortLocal();
////			sp.open();
////			System.out.println(sp.status);
//			try{
//				//CommPortIdentifier.getPortIdentifier(commPort);
//				portIden=CommPortIdentifier.getPortIdentifier(portName);			
//				commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
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
