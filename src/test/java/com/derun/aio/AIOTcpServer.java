package com.derun.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOTcpServer implements Runnable{

	private AsynchronousChannelGroup acg;
	private AsynchronousServerSocketChannel ascs;
	
	public AIOTcpServer(int port)throws Exception{
		System.out.println("Server open...");
		ExecutorService executor=Executors.newFixedThreadPool(100);
		acg=AsynchronousChannelGroup.withThreadPool(executor);
		ascs=AsynchronousServerSocketChannel.open(acg).bind(new InetSocketAddress(port));
	}
	
	@Override
	public void run() {
		try{
			AIOAcceptHandler handler=new AIOAcceptHandler();
			//ascs.
			ascs.accept(ascs, handler);
			//ascs.accept();
			Thread.sleep(400000);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Server close...");
		}
	}
	
	public static void main(String[] args) throws Exception{
		int port=7001;
		AIOTcpServer server=new AIOTcpServer(port);
		new Thread(server).start();
	}
}
