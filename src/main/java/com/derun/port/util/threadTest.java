package com.derun.port.util;

import gnu.io.SerialPort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.derun.protocol.serialPort;

public class threadTest  implements Runnable{
	
	Thread  thread=null;//new Thread(this,"countThread");
	String name;
	int id;
	public threadTest(String name,int id){
		thread=new Thread(this,name);
		this.name=name;
		this.id=id;
		serialPort.setParam(4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		serialPort.open(); //´ò¿ª¶Ë¿Ú		
	}
	@Override
	public void run() {
		while(true){			
				System.out.print(name+"--"+new SimpleDateFormat("[yyyy-MM-dd]  HH:mm:ss  ").format(new Date()));
				int timeout=5;
				byte[] readbuff = new byte[256];
				byte[] writebuff = new byte[6];						
				writebuff[0]=(byte) ((byte) 0xF0+id);
				writebuff[1]=(byte) 0x03;
				writebuff[2]=(byte) 0x01;
				writebuff[3]=(byte) 0xA1;
				writebuff[4]=(byte) 0x22;
				writebuff[5]=(byte) 0xCC;
				serialPort.WriteAndRead(readbuff, writebuff, timeout);
		}
	}
	public void start(){
		thread.start();
	}
	
	public static void main(String[] args){
		
		//for( int i=0;i<30;i++)
		//	new threadTest("send "+i,i).start();
		ExecutorService exec=Executors.newFixedThreadPool(20);
		for( int i=0;i<1;i++)
			//new threadTest("send "+i,i).start();
			exec.execute(new threadTest("sendData "+i,i));
				
		//exec.execute(new threadTest("s1",1000));
		//new threadTest("send "+1).start();
		//new threadTest("send "+2).start();
		//new threadTest("send "+3).start();
	}
}
