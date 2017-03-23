package com.derun.entity;

import java.io.Serializable;

public class OilCan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  jarCode;
	private String  oilType;
	private double cubage;
	private double alarmUpperLimit;
	private double alarmLowerLimit;
	
	public String getJarCode() {
		return jarCode;
	}
	public void setJarCode(String jarCode) {
		this.jarCode = jarCode;
	}
	public String getOilType() {
		return oilType;
	}
	public void setOilType(String oilType) {
		this.oilType = oilType;
	}
	public double getCubage() {
		return cubage;
	}
	public void setCubage(double cubage) {
		this.cubage = cubage;
	}
	public double getAlarmUpperLimit() {
		return alarmUpperLimit;
	}
	public void setAlarmUpperLimit(double alarmUpperLimit) {
		this.alarmUpperLimit = alarmUpperLimit;
	}
	public double getAlarmLowerLimit() {
		return alarmLowerLimit;
	}
	public void setAlarmLowerLimit(double alarmLowerLimit) {
		this.alarmLowerLimit = alarmLowerLimit;
	}	 
}
