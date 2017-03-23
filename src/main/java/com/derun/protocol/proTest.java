package com.derun.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class proTest {
	
	public static void main(String[] args){
		InputStream  ins=proTest.class.getResourceAsStream("serialPort.properties");
		Properties pros=new Properties();
		
		try {
			pros.load(ins);
			System.out.println(pros.getProperty("port"));
			System.out.println(pros.getProperty("bps"));
			System.out.println(pros.getProperty("dataBits"));
			System.out.println(pros.getProperty("stopBits"));
			System.out.println(pros.getProperty("parity"));
			System.out.println(pros.getProperty("openTimeout"));
			System.out.println(pros.getProperty("byteTimeout"));
			System.out.println(pros.getProperty("byteT"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
