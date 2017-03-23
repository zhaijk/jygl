package com.derun.entity;

public class OilType {

	private String code;
	private String name;
	private double density;
	private double unitPrice;
	private String tMemo;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDensity() {
		return density;
	}
	public void setDensity(double density) {
		this.density = density;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String gettMemo() {
		return tMemo;
	}
	public void settMemo(String tMemo) {
		this.tMemo = tMemo;
	}	
}
