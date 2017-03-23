package com.derun.model;

public class refueler {
	
	private String gunID;		//加油机枪号
	private String channelID;	//通道号
	private String price;		//加油单价
	private String money;		//加油金额
	private String liter;		//加油升数
	private String oilType;	//油品
	private String type; 		//加油机类型
	private String commstatus;	//通讯状态
	private String positionx;	//位置坐标x
	private String positiony;	//位置坐标y
	
	
	
	public String getCommstatus() {
		return commstatus;
	}
	public void setCommstatus(String commstatus) {
		this.commstatus = commstatus;
	}
	public String getPositionx() {
		return positionx;
	}
	public void setPositionx(String positionx) {
		this.positionx = positionx;
	}
	public String getPositiony() {
		return positiony;
	}
	public void setPositiony(String positiony) {
		this.positiony = positiony;
	}	
	public String getGunID() {
		return gunID;
	}
	public void setGunID(String gunID) {
		this.gunID = gunID;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getLiter() {
		return liter;
	}
	public void setLiter(String liter) {
		this.liter = liter;
	}
	public String getOilType() {
		return oilType;
	}
	public void setOilType(String oilType) {
		this.oilType = oilType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
	
}
