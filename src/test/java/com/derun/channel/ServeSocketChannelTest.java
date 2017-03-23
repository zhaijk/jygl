package com.derun.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServeSocketChannelTest{

	public static void main(String[] args) throws IOException{
		ServerSocketChannel ssc=ServerSocketChannel.open();
		ssc.bind(new InetSocketAddress("localhost", 7001));
		SocketChannel sc=ssc.accept();
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		sc.read(buffer);
		buffer.flip();
		System.out.println(buffer);
		System.out.println(Charset.forName("GBK").newDecoder().decode(buffer));
		sc.write(ByteBuffer.wrap(("hello Äã°ÖÊÇ¹·.......").getBytes()));
		
	}
}
