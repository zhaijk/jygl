package com.derun.port.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Test {

	public static void  eccrypt(String info) throws NoSuchAlgorithmException, UnsupportedEncodingException{
				
		MessageDigest md5=MessageDigest.getInstance("md5");
		byte[] srcBytes=info.getBytes();
		md5.update(srcBytes);
		byte[] resultBytes=md5.digest();
		System.out.println();
		for(int i=0;i<resultBytes.length;i++)
			System.out.print(String.format("%02X", resultBytes[i]));
		System.out.println();
	}
	public static void main(String[] args ) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String str="user";
		String strSalt="user{derun}";
		
		Md5Test.eccrypt(str);
		Md5Test.eccrypt(strSalt);
		
	}
}
