package com.derun.port.util;


public class tools {

	//计算校验和
	public byte fnChecksumCacl(byte[] databuff, int length) {
		int checkSum = 0;
		for (int i = 0; i < length; i++) {
			checkSum += databuff[i];
		}
		checkSum = checkSum & 0x7F; // 不要最高位
		return (byte) checkSum;
	}
	
	public static void main(String[]  args){
		byte status=2;
		boolean b=((status & 0x01)!=0);
		System.out.println(b);
		
		
	}
}
