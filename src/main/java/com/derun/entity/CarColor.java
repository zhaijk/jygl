package com.derun.entity;

//import org.apache.ibatis.type.Alias;
//@Alias("carcolor")
public class CarColor {
	
	private String code;
	private String name;
	private String tmemo;
	
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
	public String getTmemo() {
		return tmemo;
	}
	public void setTmemo(String tmemo) {
		this.tmemo = tmemo;
	}
	
}
