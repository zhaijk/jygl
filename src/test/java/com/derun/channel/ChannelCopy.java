package com.derun.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public class ChannelCopy {

	public static void main(String[] args) throws IOException{
		
		ReadableByteChannel src=Channels.newChannel(System.in); 
		WritableByteChannel dest=Channels.newChannel(System.out);
		ByteBuffer buffer=ByteBuffer.allocate(1024);
//		while(src.read(buffer)!=-1){
//			buffer.flip();
//			dest.write(buffer);
//			buffer.clear();
//		}
		while(src.read(buffer)!=-1){
			buffer.flip();
			System.out.println("Console:"+Charset.forName("GBK").newDecoder().decode(buffer));
			while(buffer.hasRemaining()){
				dest.write(buffer);
			}
			buffer.clear();
		}
		src.close();
		dest.close();
	}
}
