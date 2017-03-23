package com.derun.protocol;

public abstract interface protocol {
	
	//实时监控命令
	public int queryMachineStatus();					//读取状态
	public int setOnOffLineStatus(boolean OnOff);		//在线（等待联机命令 ）离线（自控 不需要等待联机命令）状态
	public int setOnOffStatus(boolean OnOff);			//开始加油 停止加油
	public int queryOilValue();						//读取当前加油数据
	public int queryPresetValue();						//读 取预制量
	public int setPresetValue();						//设 置预制量
	public int queryCardInfo();						//读取卡信息
	public int setCardInvalid();						//退卡
	
	
	//参数设置
	public int queryOilType();
	public int setOilType();
	public int querySysDateTime();
	public int setSysDateTime();
	public int setPrice();
	public int queryPrice();
	public int queryStationID();
	public int setStationID();
	public int queryHeadID();
	public int setHeadID();
	public int queryTeamID();
	public int setTeamID();
	
	
	//记录操作
	public int downloadBlackList();
	public int clearBlackList();
	public int downloadQutoaList();
	public int clearQuotaList();
	public int queryNumberOfTrades();
	public int queryTrades();							
	public int clearTrades();
	public int queryLastTrade();						//读取最后一条交易记录(在线数据操作)
	
	
}
