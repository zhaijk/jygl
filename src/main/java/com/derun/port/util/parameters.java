package com.derun.port.util;

import java.io.IOException;
import java.io.InputStream;
//import java.net.URL;
import java.util.Properties;


public class parameters {
	private static String filename;
	private static InputStream input;
	private static Properties pros=new Properties();
	static{
		filename="serialPort.properties";
		input=parameters.class.getResourceAsStream(filename);
		try {
			pros.load(input);
		} catch (IOException e) {
			System.out.println("");
		}
	}
	private parameters(){
		
	}
	public  void setparameters(String args) throws IOException{
		parameters.filename=args;
		parameters.input=this.getClass().getResourceAsStream(parameters.filename);
		pros.load(parameters.input);
	}
	
	public  static String  getPors(String args){
		return pros.getProperty(args);
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(parameters.getPors("port"));
		

	}
}
