package com.derun.entity;

import java.io.Serializable;

public class OilCanRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stationID;
	private String jarCode;
	private String collectionDate;
	private String collectionTime;
	private double oilHigh;
	private double waterHigh;
	private double temperature;
	private double oilCubage;
	private double oilWeight;
	private boolean tFlag;
	private double cubage;
	
	public String getStationID() {
		return stationID;
	}
	public void setStationID(String stationID) {
		this.stationID = stationID;
	}
	public String getJarCode() {
		return jarCode;
	}
	public void setJarCode(String jarCode) {
		this.jarCode = jarCode;
	}
	public String getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
	public String getCollectionTime() {
		return collectionTime;
	}
	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}
	public double getOilHigh() {
		return oilHigh;
	}
	public void setOilHigh(double oilHigh) {
		this.oilHigh = oilHigh;
	}
	public double getWaterHigh() {
		return waterHigh;
	}
	public void setWaterHigh(double waterHigh) {
		this.waterHigh = waterHigh;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getOilCubage() {
		return oilCubage;
	}
	public void setOilCubage(double oilCubage) {
		this.oilCubage = oilCubage;
	}
	public double getOilWeight() {
		return oilWeight;
	}
	public void setOilWeight(double oilWeight) {
		this.oilWeight = oilWeight;
	}
	public boolean istFlag() {
		return tFlag;
	}
	public void settFlag(boolean tFlag) {
		this.tFlag = tFlag;
	}
	public double getCubage() {
		return cubage;
	}
	public void setCubage(double cubage) {
		this.cubage = cubage;
	}
	
}
