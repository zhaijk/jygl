package com.derun.commnuication;

import gnu.io.CommPort;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.PortInUseException;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.UnsupportedCommOperationException;

//@Service
public final class  serialPortStatic {
	
	private static CommPortIdentifier portIden;   	//����ʶ��
	private static CommPort commPort;             	//���� 
	private static SerialPort serialPort=null;   	//���в�����
	private static OutputStream outStream=null;  	//�����
	private static InputStream  inStream=null;   	//������
	
	
	private static String portName="COM3"; 		//�˿ں�
	private static  int  bps=4800;		   		//������		
	private static  int  dataBits=8;  			//�˿ڲ��� ����λ��
	private static  int  stopBits=1;  			//�˿ڲ��� ֹͣλ
	private static  int  parity=0;    			//�˿ڲ��� ��żУ��λ
	
	
	private static int openTimeout=2000;
	private static int byteTimeout=10;
	
	private static  int status=0; 
	
	static{		
		try{
			loadParameters();
			setParameters();
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
	private serialPortStatic(){
		
	}
	
	private static void loadParameters(){
		portName=parameters.getPors("port");
		bps=Integer.parseInt(parameters.getPors("bps"));
		dataBits=Integer.parseInt(parameters.getPors("dataBits"));
		stopBits=Integer.parseInt(parameters.getPors("stopBits"));
		parity=Integer.parseInt(parameters.getPors("parity"));
		openTimeout=Integer.parseInt(parameters.getPors("openTimeout"));
		byteTimeout=Integer.parseInt(parameters.getPors("byteTimeout"));
		
	}
	
	private static void setParameters() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{
		portIden=CommPortIdentifier.getPortIdentifier(portName);			
		commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
		serialPort=(SerialPort) commPort;
		serialPort.setSerialPortParams(bps, dataBits, stopBits, parity);
		
		
		outStream=serialPort.getOutputStream();
		inStream=serialPort.getInputStream();
		status=1;
	}
	
	public static void open(){
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
			setParameters();
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
	public static  synchronized int WriteAndRead(byte[] inbuffer, //synchronized
			byte[] outbuffer, int timeout) {
		//System.out.println("��ʼִ��......" + timeout);
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
				Thread.sleep(byteTimeout);
				if (number >= counter)
					break;
				if (timeout == 0)
					break;
				timeout--;
			}
			//System.out.println("���������ݸ����� " + inStream.available() + " " + timeout);
			if(counter==inStream.available())
				inStream.read(inbuffer);
			
			// Thread.sleep(100);
			// while (counter > 0) { // ��ȡ����
			
			// System.out.println("data: "+inbuffer[0]+(int)(inbuffer[1])+inbuffer[2]+(byte)0xE0);
			// System.out.println("���������ݸ����� "+inStream.available());

			// Thread.sleep(10);
			// counter--; // ��ʱ�˳�t
			// }
			return 0;
		} catch (IOException e) {
			System.out.println("��д����ʧ��...");
			return -1;
		} catch (InterruptedException e) {
			System.out.println("��ʱ������������");
			return -2;
		} catch (NullPointerException e){
			System.out.println("�˿ڲ�����");
			return -3;
		}
		//System.out.println("��������......" + timeout);
		//locker.unlock();
	}
}
