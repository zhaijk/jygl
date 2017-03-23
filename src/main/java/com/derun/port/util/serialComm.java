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
	
	private static CommPortIdentifier portIden;   	//����ʶ��
	private static CommPort commPort;             	//���� 
	private static SerialPort serialPort=null;   	//���в�����
	private static OutputStream outStream=null;  	//�����
	private static InputStream  inStream=null;   	//������
	
	
	private static String portName="COM3"; 		//�˿ں�
	private static  int  bps=4800;		   				//������		
	private static  int  dataBits=8;  					//�˿ڲ��� ����λ��
	private static  int  stopBits=1;  					//�˿ڲ��� ֹͣλ
	private static  int  parity=0;    					//�˿ڲ��� ��żУ��λ
	
	
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
			commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
			//((SerialPort)(CommPortIdentifier.getPortIdentifier(portName)).open("IC����ͨѶ�˿�", openTimeout)).setSerialPortParams(bps, dataBits, stopBits, parity);
			
			outStream=serialPort.getOutputStream();
			inStream=serialPort.getInputStream();
			status=1;
		}catch(NoSuchPortException e1){
			System.out.println("�˿ڲ�����");status=2;
		} catch (PortInUseException e) {
			System.out.println("�˿��Ѿ�ռ��");status=3;
		} catch (IOException e) {			
			System.out.println("��ȡ�������������");status=4;
		} catch (UnsupportedCommOperationException e) {
			System.out.println("�˿ڲ�������");status=5;
		}
		
	}
	
	public static void reOpen(){		
		try{
			if(serialPort!=null)	
				serialPort.close();			
			portIden=CommPortIdentifier.getPortIdentifier(portName);
			commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
			serialPort=(SerialPort) commPort;
			serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
			
			outStream=serialPort.getOutputStream();
			inStream=serialPort.getInputStream();
			status=1;
		}catch(NoSuchPortException e){
			System.out.println("�˿ڲ�����");status=2;
		} catch (PortInUseException e) {
			System.out.println("�˿��Ѿ�ռ��");status=3;
		} catch (IOException e) {			
			System.out.println("��ȡ�������������");status=4;
		} catch (UnsupportedCommOperationException e) {
			System.out.println("�˿ڲ�������");status=5;
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
		System.out.println("��ʼִ��......"+timeout);
		try {
			int counter = timeout;
			//inStream.reset(); //���������
			outStream.write(outbuffer); // ��������
			while (counter > 0) { // ��ȡ����
				if (inStream.available() > 0)
					inStream.read(inbuffer);				
				Thread.sleep(10);
				counter--; // ��ʱ�˳�
			}

		} catch (IOException e) {
			System.out.println("��д����ʧ��...");
		} catch (InterruptedException e) {
			System.out.println("��ʱ������������");
		}
		System.out.println("��������......"+timeout);
	}
}
