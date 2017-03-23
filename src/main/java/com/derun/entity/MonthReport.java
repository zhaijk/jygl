package com.derun.entity;

public class MonthReport {

	private String date;
	private String oilType;
	private String jarCode;
	private double value;
	private double total;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOilType() {
		return oilType;
	}
	public void setOilType(String oilType) {
		this.oilType = oilType;
	}
	public String getJarCode() {
		return jarCode;
	}
	public void setJarCode(String jarCode) {
		this.jarCode = jarCode;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
