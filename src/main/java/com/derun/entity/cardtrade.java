package com.derun.entity;

import java.io.Serializable;

public class cardtrade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String 	TradeDate;//��������
	private String 	TradeTime;//����ʱ��
	private String 	TradeType;//��������
	private String 	GunCode;//����ǹ��
	private String 	OilType;//��Ʒ����
	private String 	CardCode;//����
	private String 	CardType;//������
	private Double 	Volumn;	//������
	private Integer 	mileage;//���Ѵ���
	private Double 	Balance ;//�������
	private Integer 	SendFlag;//����־(���ű�־)
	private String 	StationID;//������λ����
	private Double 	CardMoney;//���ѽ��=������*����
	private Boolean 	TFlag;//�ϴ���־
	private String 	OperatorName;//����Ա����
	
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
