package com.derun.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class SocketChannelTest {
	private static CharsetDecoder decoder = Charset.forName("GBK").newDecoder();
	
	public static void main(String[] args) throws IOException{
		SocketChannel sc=SocketChannel.open();
		sc.connect(new InetSocketAddress("localhost",7001));
		sc.write(ByteBuffer.wrap("hello ÄãÂèÊÇºï...".getBytes()));
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		sc.read(buffer);
		buffer.flip();
		System.out.println(decoder.decode(buffer));
		
	}
}
