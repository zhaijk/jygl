package com.derun.buffer;

import java.nio.CharBuffer;

public class CharBufferTest {
	
	private static void drainBuffer(CharBuffer buffer){
		while(buffer.hasRemaining()){
			System.out.print(buffer.get());
		}
		System.out.println();
		//System.out.println("get:"+buffer);
	}
	private static int index=0;
	private static String[] str={
		"Hello I'm a robot!!",
		"wiki?",
		"no I'm siri!!",
		"ok get out my place!!"
	};
	private static  boolean  fillBuffer(CharBuffer buffer){
		if(index>=str.length){
			return false;
		}
		int local=index++;
		for(int i=0;i<str[local].length();i++){
			buffer.put(str[local].charAt(i));
		}
		//System.out.println("put:"+buffer);
		return true;
	}
	public static void main(String[] args){
	
		CharBuffer buffers=CharBuffer.allocate(1024);
		while(fillBuffer(buffers)){
			buffers.flip();
			drainBuffer(buffers);
			buffers.clear();
		}
	}
	
}
