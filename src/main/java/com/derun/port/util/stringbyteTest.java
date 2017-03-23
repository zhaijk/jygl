package com.derun.port.util;

public class stringbyteTest {
	
	public static void main(String[]  args){
		
		byte[] info=new byte[100];
		
		for(int i=0;i<100;i++)
		{
			info[i]=(byte) (0x30+i);
		}
		String strInfo=new String(info,0,99);
		System.out.println(strInfo);
		System.out.println(strInfo.substring(0, 10));
		System.out.println(strInfo.substring(10, 17));
		System.out.println(strInfo.substring(17, 43));
		System.out.println(strInfo.substring(43, 49));
		System.out.println(strInfo.substring(49, 75));
		System.out.println(strInfo.substring(75, 76));		
	}
}
