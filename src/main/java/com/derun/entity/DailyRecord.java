package com.derun.entity;

import java.io.Serializable;

public class DailyRecord implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date;
	private String time;
	private String type;
	private String name;
	private String tmemo;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
