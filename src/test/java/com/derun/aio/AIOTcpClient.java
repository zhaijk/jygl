package com.derun.aio;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;

public class AIOTcpClient {
	
//	 public static void main(String... args) throws Exception {  
//		 for(int i=0;i<10000;i++)
//		 new Thread(new Runnable(){
//			 @Override
//		     public void run() {
//				 AsynchronousSocketChannel client = null;
//				try {
//					client = AsynchronousSocketChannel.open();
//					client.connect(new InetSocketAddress("localhost", 7001));
//					Thread.sleep(1000);
//				    while(true){
//				    	 try {
//				    		client.write(ByteBuffer.wrap("test".getBytes())).get();
//							Thread.sleep((long) (Math.random()*100000));
//						} catch (InterruptedException e) {
//							
//							e.printStackTrace();
//						}
//				     }
//				} catch (IOException e) { 
//					e.printStackTrace();
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				} catch (ExecutionException e1) {			
//					e1.printStackTrace();
//				}  
//			     
//		     }	    	 
//	     }).start();	
//	     
//	 }  
	
	private AsynchronousChannelGroup acg;
	//private final CharsetDecoder decoder=Charset.forName("GBK").newDecoder();
	
	public AIOTcpClient() throws IOException{
		ExecutorService executor=Executors.newFixedThreadPool(10);
		acg=AsynchronousChannelGroup.withThreadPool(executor);
	}	
	public void start(final String ip,final int port,final int id){		
		try{				
			new Thread(new Runnable(){
				@Override
				public void run() {
					AsynchronousSocketChannel channel=null;
					if(channel==null||channel.isOpen()){
						try{
							channel=AsynchronousSocketChannel.open(acg);
							channel.setOption(StandardSocketOptions.TCP_NODELAY, true);
							channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
							channel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
						}catch(IOException e){
							e.printStackTrace();	
						}
						channel.connect(new InetSocketAddress(ip,port),channel, new AIOClientConnectHandler(id));
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
					
						e1.printStackTrace();
					}
					while(true){
						//int res;
						try {
							channel.write(ByteBuffer.wrap(("客户端发送数据......id:"+id).getBytes())).get();			
							//System.out.println("client get ...."+res);			
							//ByteBuffer buffer=ByteBuffer.allocate(1024);
							//channel.read(buffer, buffer,new AIOReadHandler(channel));
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} catch (ExecutionException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
				
		}catch(Exception e){
				e.printStackTrace();
		}	
	}
	public static void main(String[] args) throws IOException{
		for(int i=0;i<10;i++){
			AIOTcpClient client=new AIOTcpClient();		
			client.start("localhost", 7001,i);
		}
	}
}
