package com.derun.entity;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PortConfig {
	@Value("port")
	public String port;
	@Value("bps")
	public int bps;
	@Value("dataBits")
	public int dataBits;
	@Value("stopBits")
	public int stopBits;
	@Value("parity")
	public int parity;
	@Value("openTimeout")
	public int openTimeout;
	@Value("byteTimeout")
	public int byteTimeout;
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getBps() {
		return bps;
	}

	public void setBps(int bps) {
		this.bps = bps;
	}

	public int getDataBits() {
		return dataBits;
	}

	public void setDataBits(int dataBits) {
		this.dataBits = dataBits;
	}

	public int getStopBits() {
		return stopBits;
	}

	public void setStopBits(int stopBits) {
		this.stopBits = stopBits;
	}

	public int getParity() {
		return parity;
	}

	public void setParity(int parity) {
		this.parity = parity;
	}

	public int getOpenTimeout() {
		return openTimeout;
	}

	public void setOpenTimeout(int openTimeout) {
		this.openTimeout = openTimeout;
	}

	public int getByteTimeout() {
		return byteTimeout;
	}

	public void setByteTimeout(int byteTimeout) {
		this.byteTimeout = byteTimeout;
	}

	public  static void main(String[] args){
		
		//ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");		
		//System.out.println();context.getBean(PortConfig.class).getBps()
		System.out.println();
	}
	
}
