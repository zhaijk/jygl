package com.derun.aio;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.nio.channels.AsynchronousSocketChannel;

public class AIOClientConnectHandler implements CompletionHandler<Void , AsynchronousSocketChannel> {
	
	private Integer content;
	
	public AIOClientConnectHandler(Integer content){
		this.content=content;
	}
	@Override
	public void completed(Void result, AsynchronousSocketChannel channel) {
		
		//int res;
		try {
			channel.write(ByteBuffer.wrap(("ÄãºÃ ·þÎñÆ÷......id:"+content).getBytes())).get();			
			//System.out.println("client get ...."+res);			
			ByteBuffer buffer=ByteBuffer.allocate(1024);
			channel.read(buffer, buffer,new AIOReadHandler(channel));			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
		exc.printStackTrace();
	}
}
