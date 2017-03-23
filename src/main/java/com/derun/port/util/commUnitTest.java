package com.derun.port.util;

//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

import gnu.io.SerialPort;

import org.junit.Test;

import com.derun.protocol.serialPort;

public class commUnitTest {

	public  static int timeout=1;
	
	@Test
	public void main(){
		
		serialPort.setParam(4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		serialPort.open(); //´ò¿ª¶Ë¿Ú
		//ExecutorService exec=Executors.newFixedThreadPool(10);
		
		/*exec.execute(new Runnable(){
			@Override
			public void run() {
				while(true){
					
					
					byte[] readbuff = new byte[256];
					byte[] writebuff = new byte[6];						
					writebuff[0]=(byte) 0xF0;
					writebuff[1]=(byte) 0x03;
					writebuff[2]=(byte) 0x01;
					writebuff[3]=(byte) 0xA1;
					writebuff[4]=(byte) 0x22;
					writebuff[5]=(byte) 0xCC;
					
					//serialComm.WriteAndRead(readbuff, writebuff, timeout);
					System.out.println("......"+timeout);
					try {
						Thread.sleep(timeout);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					timeout++;
				}
			}
			
		});*/
		new Thread(new Runnable(){

			@Override
			public void run() {
				int i = 0;
				while(true){
					System.out.println("......"+i);
				
					i++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		
	}
	public static void send(){
		while(true){
			int timeout=1;
			byte[] readbuff = new byte[256];
			byte[] writebuff = new byte[6];						
			writebuff[0]=(byte) 0xF0;
			writebuff[1]=(byte) 0x03;
			writebuff[2]=(byte) 0x01;
			writebuff[3]=(byte) 0xA1;
			writebuff[4]=(byte) 0x22;
			writebuff[5]=(byte) 0xCC;
			serialPort.WriteAndRead(readbuff, writebuff, timeout);
			//System.out.println("......");
		}
	}
}
