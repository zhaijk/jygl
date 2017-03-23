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
	
	private static CommPortIdentifier portIden;   	//����ʶ��
	private static CommPort commPort;             	//���� 
	private static SerialPort serialPort=null;   	//���в�����
	private static OutputStream outStream=null;  	//�����
	public static OutputStream getOutStream() {
		return outStream;
	}
	private static InputStream  inStream=null;   	//������
	
	
	private static String portName="COM3"; 		//�˿ں�
	private static  int  bps=4800;		   		//������		
	private static  int  dataBits=8;  			//�˿ڲ��� ����λ��
	private static  int  stopBits=1;  			//�˿ڲ��� ֹͣλ
	private static  int  parity=0;    			//�˿ڲ��� ��żУ��λ
	
	
	private static int openTimeout=2000;
	private static int byteTimeout=10;
	
	private static  int status=0; 
	
//	static{		
//		try{
//			//loadParameters();
//			//setParameters();
//		}catch(NoSuchPortException e1){
//			System.out.println("�˿ڲ�����");status=2;
//		} catch (PortInUseException e) {
//			System.out.println("�˿��Ѿ�ռ��");status=3;
//		} catch (IOException e) {			
//			System.out.println("��ȡ�������������");status=4;
//		} catch (UnsupportedCommOperationException e) {
//			System.out.println("�˿ڲ�������");status=5;
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
		commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
		serialPort=(SerialPort) commPort;
	}
	
	public  void setParameters(int parity) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException{
//		portIden=CommPortIdentifier.getPortIdentifier(portName);			
//		commPort=portIden.open("IC����ͨѶ�˿�", openTimeout);
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
//		try{
//			if(serialPort!=null)	
//				serialPort.close();			
//			//setParameters();
//		}catch(NoSuchPortException e){
//			System.out.println("�˿ڲ�����");status=2;
//		} catch (PortInUseException e) {
//			System.out.println("�˿��Ѿ�ռ��");status=3;
//		} catch (IOException e) {			
//			System.out.println("��ȡ�������������");status=4;
//		} catch (UnsupportedCommOperationException e) {
//			System.out.println("�˿ڲ�������");status=5;
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
	
	//����У���
	public  static byte fnChecksumCalc(byte[] databuff, int index , int length) {
			int checkSum = 0;
			for (int i = index; i < length+2; i++) {
				checkSum += databuff[i];
			}
			checkSum = checkSum & 0x7F; // ��Ҫ���λ
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
			System.out.println("���������ݸ����� " + inStream.available() + " " + timeout);
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
	public static void main(String[] args) throws PortInUseException, NoSuchPortException, UnsupportedCommOperationException, IOException, InterruptedException{
		serialPort sp=new serialPort();
		sp.loadParameters();
//		int counter=0;
		while(true){
			System.out.println("�������� 02 83 00 B1 30");
			//System.out.println("�������� 01 83 00 41 30");
			//01 83 00 41 30 
			sp.setParameters(SerialPort.PARITY_MARK);
//			sp.getOutStream().write(0x01);
//			counter=counter+1;
//			System.out.println("���ͼ����ʱ"+counter);
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

			System.out.println("��ȡ����");
			int result = 0;
			for(int i=0;i<30;i++){
//				result=sp.getInputStream().available();
				System.out.print(i+"-"+result+" ");
				 if(result==68) break;
				//System.out.print(sp.getInputStream().available());
				Thread.sleep(20);
			}
			
			System.out.println("��������....");
			byte[] readbuff=new byte[500];
			//for(int i=0;i<10;i++){
//				sp.getInputStream().read(readbuff);
			//}
			if(result!=68) continue;	
			for(int i=0;i<68;i++)
			{				
				System.out.print(byteToHex(readbuff[i])+"-");
			}
			System.out.println("ͨ����: "+readbuff[0]);
			System.out.println("����: "+byteToHex(readbuff[1]));			
			System.out.print("����״̬: ");
			switch(readbuff[2]){
			case 0:System.out.println("����");break;
			case 1:System.out.println("׼��");break;
			case 2:System.out.println("����");break;
			case 3:System.out.println("��ͣ");break;
			case 4:System.out.println("��Aǹ");break;
			case 5:System.out.println("��Bǹ");break;
			case 6:System.out.println("����");break;
			case 7:System.out.println("ѡ�ֺ�,������֤");break;
			case 8:System.out.println("��ͣ��������");break;
			case 9:System.out.println("������������");break;
			}
			System.out.println("����֡����:"+byteToHex(readbuff[3]));
			
			System.out.println("����: "+(readbuff[4]-0x30)+(readbuff[5]-0x30)+(readbuff[6]-0x30)+(readbuff[7]-0x30)+(readbuff[8]-0x30)+(readbuff[9]-0x30));
			System.out.println("Ӧ����: "+(readbuff[10]-0x30)+(readbuff[11]-0x30)+(readbuff[12]-0x30)+(readbuff[13]-0x30)+(readbuff[14]-0x30)+(readbuff[15]-0x30));
			
			System.out.println("��Ʒ����:"+byteToHex(readbuff[16]));
			System.out.println("��Ʒ��:"+byteToHex(readbuff[17])+" "+byteToHex(readbuff[18]));
			
			System.out.println("�汾��:"+(readbuff[19]-0x30));
			System.out.println("�ֺ�:"+(readbuff[20]-0x30));
			
			System.out.println("������"+ byteToHex(readbuff[21])+byteToHex(readbuff[22])+byteToHex(readbuff[23])+byteToHex(readbuff[24]));
			
			
			System.out.println("�¶ȷ��� "+byteToHex(readbuff[25]));
			
			System.out.println("�¶�: "+(readbuff[26]-0x30)+(readbuff[27]-0x30)+(readbuff[28]-0x30)+(readbuff[29]-0x30));
			
			System.out.println("�ܶ�: "+(readbuff[30]-0x30)+(readbuff[31]-0x30)+(readbuff[32]-0x30)+(readbuff[33]-0x30)+(readbuff[34]-0x30)+(readbuff[35]-0x30));
			
			System.out.println("˲ʱ: "+(readbuff[36]-0x30)+(readbuff[37]-0x30)+(readbuff[38]-0x30)+(readbuff[39]-0x30)+(readbuff[40]-0x30));
			System.out.println("�豸״̬:"+ byteToHex(readbuff[41]));
			if((readbuff[41]&0x80)!=0){
				System.out.print("��λ��λ����");
			}else{
				System.out.print("��λ����");
			}
			System.out.print("-");
			if((readbuff[41]&0x40)!=0){
				System.out.print("�Ͳֿ�ѡ");
			}else{
				System.out.print("�Ͳ�ѡ��");
			}
			System.out.print("-");
			if((readbuff[41]&0x20)!=0){
				System.out.print("����");
			}else{
				System.out.print("����");
			}			
			System.out.print("-");
			if((readbuff[41]&0x10)!=0){
				System.out.print("�������");
			}else{
				System.out.print("�������");
			}
			System.out.print("-");
			if((readbuff[41]&0x08)!=0){
				System.out.print("���籨��");
			}else{
				System.out.print("��������");
			}
			System.out.print("-");
			if((readbuff[41]&0x04)!=0){
				System.out.print("��Һ��B�����");
			}else{
				System.out.print("��Һ��B�����");
			}
			System.out.print("-");
			if((readbuff[41]&0x02)!=0){
				System.out.print("��Һ��A�����");
			}else{
				System.out.print("��Һ��A�����");
			}
			System.out.print("-");
			if((readbuff[41]&0x01)!=0){
				System.out.print("�ÿ����쳣");
			}else{
				System.out.print("�ÿ�������");
			}
			
			System.out.println("������ʽ:"+(readbuff[42]-0x30));
			
			System.out.println("IC����:"+byteToHex(readbuff[42])+byteToHex(readbuff[43])+byteToHex(readbuff[44])+byteToHex(readbuff[45]));
			
			System.out.println("��ͣ�������֤��ʽ: "+(readbuff[46]-0x30));
			
			System.out.println("�豸״̬: "+byteToHex(readbuff[47]));
			System.out.print("-");
			if((readbuff[47]&0x08)!=0){
				System.out.print("�¶��ź��߶���");
			}else{
				System.out.print("�¶��ź�������");
			}
			System.out.print("-");
			if((readbuff[47]&0x04)!=0){
				System.out.print("���¹���");
			}else{
				System.out.print("��������");
			}
			System.out.print("-");
			if((readbuff[47]&0x02)!=0){
				System.out.print("���¹���");
			}else{
				System.out.print("��������");
			}
			System.out.print("-");
			if((readbuff[47]&0x01)!=0){
				System.out.print("�������ٱ���");
			}else{
				System.out.print("��������");
			}
			
			System.out.println("����: "+byteToHex(readbuff[48])+byteToHex(readbuff[49])+byteToHex(readbuff[50]));
			System.out.println("����: "+byteToHex(readbuff[51])+byteToHex(readbuff[52])+byteToHex(readbuff[53]));
			System.out.println("����: "+byteToHex(readbuff[54])+byteToHex(readbuff[55])+byteToHex(readbuff[56]));
			
			System.out.println("�ۼƱ���: "+byteToHex(readbuff[58])+byteToHex(readbuff[59])+byteToHex(readbuff[60])+byteToHex(readbuff[61]));
			
			System.out.println("ADֵ: "+byteToHex(readbuff[62])+byteToHex(readbuff[57]));
			for(int i=0;i<68;i++)
			{				
				readbuff[i]=(byte) 0xff;
			}
			
			Thread.sleep(1000);
		}
	}
}
