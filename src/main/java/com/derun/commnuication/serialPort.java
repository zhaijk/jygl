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
	
	private  CommPortIdentifier portIden;   	//����ʶ��
	private  CommPort commPort;             	//���� 
	private  SerialPort serialPort=null;   	//���в�����
	private static  OutputStream outStream=null;  	//�����
	private static  InputStream  inStream=null;   	//������
	
	
	private  String portName="COM3"; 		//�˿ں�
	private   int  bps=4800;		   		//������		
	private   int  dataBits=8;  			//�˿ڲ��� ����λ��
	private   int  stopBits=1;  			//�˿ڲ��� ֹͣλ
	private   int  parity=0;    			//�˿ڲ��� ��żУ��λ
	
	
	private static int openTimeout=2000;
	private static int byteTimeout=10;
	
	private static  int status=0; 
	
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
	public  serialPort(commportInfoDAO param){
		try{
			String strCom=param.findALL().get(0).getDeviceNumber();
			logger.debugLog("��ʼ��.ͨѶ�˿�..."+strCom);
			portName=strCom;
			loadParameters();
			setParameters();
			logger.debugLog("��ʼ��.�ɹ�...");
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
		byteTimeout=Integer.parseInt(parameters.getPors("byteTimeout"));
		
	}
	
	private  void setParameters() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{
		portIden=CommPortIdentifier.getPortIdentifier(portName);			
		commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
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
			commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
			serialPort=(SerialPort) commPort;
			serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
			
			
			outStream=serialPort.getOutputStream();
			inStream=serialPort.getInputStream();
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
	
	public  void reOpen(){		
		try{
			if(serialPort!=null)	
				serialPort.close();			
			setParameters();
		}catch(NoSuchPortException e){
			logger.debugLog("�˿ڲ�����");status=2;
		} catch (PortInUseException e) {
			logger.debugLog("�˿��Ѿ�ռ��");status=3;
		} catch (IOException e) {			
			logger.debugLog("��ȡ�������������");status=4;
		} catch (UnsupportedCommOperationException e) {
			logger.debugLog("�˿ڲ�������");status=5;
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
	public static synchronized int WriteAndRead(byte[] inbuffer, byte[] outbuffer, int timeout) {
		//logger.debugLog("��ʼִ��......" + timeout);
		//locker.lock();
		try {
			int counter = timeout;
			// inStream.reset(); //���������
			while (inStream.available() > 0) {
				inStream.read();
			}
			outStream.write(outbuffer); // ��������			
			for (int i = 0; i < timeout; i++)
				// ������ջ�����
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
				//logger.debugLog("���������ݸ����� " + inStream.available() + " " + timeout);
			}
			//logger.debugLog("���������ݸ����� " + inStream.available() + " " + timeout);
			if(counter==inStream.available())
				inStream.read(inbuffer);
			
			//Thread.sleep(100);
			// while (counter > 0) { // ��ȡ����
			
			// logger.debugLog("data: "+inbuffer[0]+(int)(inbuffer[1])+inbuffer[2]+(byte)0xE0);
			// logger.debugLog("���������ݸ����� "+inStream.available());

			// Thread.sleep(10);
			// counter--; // ��ʱ�˳�t
			// }
			return 0;
		} catch (IOException e) {
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
}
