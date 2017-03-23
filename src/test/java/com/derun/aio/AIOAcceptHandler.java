package com.derun.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>{

	 public void completed(AsynchronousSocketChannel socket, AsynchronousServerSocketChannel attachment) { 
		 try { 
	        	System.out.println("AioAcceptHandler.completed called");
	            attachment.accept(attachment, this); 
	            System.out.println("client info:" + socket.getRemoteAddress().toString());
	            
	            ByteBuffer clientBuffer = ByteBuffer.allocate(1024); 
		        socket.read(clientBuffer, clientBuffer, new AIOReadHandler(socket));
	     } catch (IOException e) { 
	            e.printStackTrace(); 
	     } 
	 } 
	 
	    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) { 
	        exc.printStackTrace(); 
	    } 
	 
//	    public void startRead(AsynchronousSocketChannel socket) { 
//	        
//	    } 
	    public void cancelled(AsynchronousServerSocketChannel attachment) { 
	        System.out.println("cancelled"); 
	    } 
	
}
