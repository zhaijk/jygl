package com.derun.port.util;


public class tools {

	//����У���
	public byte fnChecksumCacl(byte[] databuff, int length) {
		int checkSum = 0;
		for (int i = 0; i < length; i++) {
			checkSum += databuff[i];
		}
		checkSum = checkSum & 0x7F; // ��Ҫ���λ
		return (byte) checkSum;
	}
	
	public static void main(String[]  args){
		byte status=2;
		boolean b=((status & 0x01)!=0);
		System.out.println(b);
		
		
	}
}
