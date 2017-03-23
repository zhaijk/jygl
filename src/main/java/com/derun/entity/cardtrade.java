package com.derun.entity;

import java.io.Serializable;

public class cardtrade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String 	TradeDate;//消费日期
	private String 	TradeTime;//消费时间
	private String 	TradeType;//消费类型
	private String 	GunCode;//加油枪号
	private String 	OilType;//油品类型
	private String 	CardCode;//卡号
	private String 	CardType;//卡类型
	private Double 	Volumn;	//加油量
	private Integer 	mileage;//消费次数
	private Double 	Balance ;//卡上余额
	private Integer 	SendFlag;//入款标志(发放标志)
	private String 	StationID;//助供单位代码
	private Double 	CardMoney;//消费金额=加油量*单价
	private Boolean 	TFlag;//上传标志
	private String 	OperatorName;//操作员代码
	
	public String getTradeDate() {
		return TradeDate;
	}
	public void setTradeDate(String tradeDate) {
		TradeDate = tradeDate;
	}
	public String getTradeTime() {
		return TradeTime;
	}
	public void setTradeTime(String tradeTime) {
		TradeTime = tradeTime;
	}
	public String getTradeType() {
		return TradeType;
	}
	public void setTradeType(String tradeType) {
		TradeType = tradeType;
	}
	public String getGunCode() {
		return GunCode;
	}
	public void setGunCode(String gunCode) {
		GunCode = gunCode;
	}
	public String getOilType() {
		return OilType;
	}
	public void setOilType(String oilType) {
		OilType = oilType;
	}
	public String getCardCode() {
		return CardCode;
	}
	public void setCardCode(String cardCode) {
		CardCode = cardCode;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public Double getVolumn() {
		return Volumn;
	}
	public void setVolumn(Double volumn) {
		Volumn = volumn;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public Integer getSendFlag() {
		return SendFlag;
	}
	public void setSendFlag(Integer sendFlag) {
		SendFlag = sendFlag;
	}
	public String getStationID() {
		return StationID;
	}
	public void setStationID(String stationID) {
		StationID = stationID;
	}
	public Double getCardMoney() {
		return CardMoney;
	}
	public void setCardMoney(Double cardMoney) {
		CardMoney = cardMoney;
	}
	public Boolean getTFlag() {
		return TFlag;
	}
	public void setTFlag(Boolean tFlag) {
		TFlag = tFlag;
	}
	public String getOperatorName() {
		return OperatorName;
	}
	public void setOperatorName(String operatorName) {
		OperatorName = operatorName;
	}
	public String toString(){
		return  TradeDate+" "+TradeTime+","+CardCode+","+TradeType+","+OilType+","+Volumn+","+mileage+","+SendFlag+","+CardMoney;
	}
}
