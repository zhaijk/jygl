package com.derun.buffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ByteBufferTest {

	public static void main(String[] args) throws UnsupportedEncodingException{
//		System.out.println(Runtime.getRuntime().freeMemory());
//		ByteBuffer buffer1=ByteBuffer.allocate(4624);
//		System.out.println(buffer1);
//		System.out.println(Runtime.getRuntime().freeMemory());
//		ByteBuffer buffer2=ByteBuffer.allocateDirect(1024);
//		System.out.println(buffer2);
//		System.out.println(Runtime.getRuntime().freeMemory());
//		
//		byte[] bytes=new byte[32];
//		buffer1=ByteBuffer.wrap(bytes);
//		System.out.println(buffer1);
//		System.out.println(Runtime.getRuntime().freeMemory());
//		
//		buffer1=ByteBuffer.wrap(bytes,10,10);
//		System.out.println(buffer1);
//		System.out.println(Runtime.getRuntime().freeMemory());
		ByteBuffer buffer=ByteBuffer.allocate(5);
		
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
		System.out.println(buffer);
		buffer.flip();
		System.out.println(buffer);
		byte[] array=new byte[5];
		ByteBuffer.wrap(array);
		for(int i=0;i<5;i++){
			
		}
		for(int i=0;buffer.hasRemaining();i++){
			System.out.println((char)buffer.get());
		}
	}
}
