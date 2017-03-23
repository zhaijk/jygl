package com.derun.jms;

import java.io.IOException;
import java.net.InetAddress;
//import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScanPorts implements Runnable{

	//public static InetAddress host;
	public static int MIN_port=0;
	public static int MAX_port=10000;
	public static int MAX_Thread;
	
	//private int threadNumbers;
	
	public ScanPorts(){
		//this.threadNumbers=threadNumbers;
	}
	@Override
	public void run() {
		//int i;
		Socket theTcpSocket = null ;
		for(int i=MIN_port;i<MAX_port+1;i++){
			try {
				theTcpSocket=new Socket("localhost",i);
				System.out.println("端口 "+i+" kongzhi");
			} catch (IOException e) {
				System.out.println("端口 "+i+" 被占用");
				//e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ExecutorService exec=Executors.newSingleThreadExecutor();
		exec.execute(new ScanPorts());
	}	
}
