package com.derun.entity;

public class commportInfo {
	
	private String DeviceNumber;
	private String BaudRate;
	private String DataBit;
	private String StopBit;
	private String Parity;
	private Integer ReadBuff;
	private Integer ReadTimeOut;
	private Integer WriteBuff;	
	private Integer WriteTimeOut;
	private Integer NewLine;
	
	public String getDeviceNumber() {
		return DeviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		DeviceNumber = deviceNumber;
	}
	public String getBaudRate() {
		return BaudRate;
	}
	public void setBaudRate(String baudRate) {
		BaudRate = baudRate;
	}
	public String getDataBit() {
		return DataBit;
	}
	public void setDataBit(String dataBit) {
		DataBit = dataBit;
	}
	public String getStopBit() {
		return StopBit;
	}
	public void setStopBit(String stopBit) {
		StopBit = stopBit;
	}
	public String getParity() {
		return Parity;
	}
	public void setParity(String parity) {
		Parity = parity;
	}
	public Integer getReadBuff() {
		return ReadBuff;
	}
	public void setReadBuff(Integer readBuff) {
		ReadBuff = readBuff;
	}
	public Integer getReadTimeOut() {
		return ReadTimeOut;
	}
	public void setReadTimeOut(Integer readTimeOut) {
		ReadTimeOut = readTimeOut;
	}
	public Integer getWriteBuff() {
		return WriteBuff;
	}
	public void setWriteBuff(Integer writeBuff) {
		WriteBuff = writeBuff;
	}
	public Integer getWriteTimeOut() {
		return WriteTimeOut;
	}
	public void setWriteTimeOut(Integer writeTimeOut) {
		WriteTimeOut = writeTimeOut;
	}
	public Integer getNewLine() {
		return NewLine;
	}
	public void setNewLine(Integer newLine) {
		NewLine = newLine;
	}
	
}
