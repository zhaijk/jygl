package com.derun.entity;

import java.io.Serializable;

public class CardPutout implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String providedate;
	private String providetime;
	private String cardcode;
	private Double guidelinecount;
	private int sendflag;
	private String oiltype;
	private String operatorname;
	private String note;
	
	public String getProvidedate() {
		return providedate;
	}
	public void setProvidedate(String providedate) {
		this.providedate = providedate;
	}
	public String getProvidetime() {
		return providetime;
	}
	public void setProvidetime(String providetime) {
		this.providetime = providetime;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public Double getGuidelinecount() {
		return guidelinecount;
	}
	public void setGuidelinecount(Double guidelinecount) {
		this.guidelinecount = guidelinecount;
	}
	public int getSendflag() {
		return sendflag;
	}
	public void setSendflag(int sendflag) {
		this.sendflag = sendflag;
	}
	public String getOiltype() {
		return oiltype;
	}
	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
