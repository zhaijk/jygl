package com.derun.protocol;

public abstract class protocolAdapter implements protocol{

	//@Override
	public int queryLastTrade() {
		return -1;
				
	}

	//@Override
	public int setPrice() {
		return -1;
		
	}

	//@Override
	public int queryPrice() {
		return -1;
		
	}

	//@Override
	public int queryStationID() {
		return -1;
		
	}

	//@Override
	public int setStationID() {
		return -1;
		
	}

	@Override
	public int queryHeadID() {
		return -1;
		
	}

	@Override
	public int setHeadID() {
		return -1;
		
	}

	@Override
	public int queryTeamID() {
		return -1;
		
	}

	@Override
	public int setTeamID() {
		return -1;
		
	}

	@Override
	public int downloadBlackList() {
		return -1;
		
	}

	//@Override
	public int clearBlackList() {
		return -1;
		
	}

	//@Override
	public int downloadQutoaList() {
		return -1;
		
	}

	@Override
	public int clearQuotaList() {
		return -1;
		
	}

	@Override
	public int queryNumberOfTrades() {
		return -1;
		
	}

	@Override
	public int queryTrades() {
		return -1;
		
	}

	@Override
	public int clearTrades() {
		return -1;
		
	}

	@Override
	public int setOnOffStatus(boolean OnOff) {
		return -1;
				
	}

	@Override
	public int queryMachineStatus() {
		return -1;
		
	}

	@Override
	public int setOnOffLineStatus(boolean OnOff) {
		return -1;		
		
	}

	@Override
	public int queryOilValue() {
		return -1;
		
		
	}

	@Override
	public int queryPresetValue() {
		return -1;
		
		
	}

	@Override
	public int setPresetValue() {
		return -1;		
		
	}

	@Override
	public int queryCardInfo() {
		return -1;		
		
	}

	@Override
	public int setCardInvalid() {
		return -1;		
		
	}

	@Override
	public int queryOilType() {
		return -1;	
		
	}

	@Override
	public int setOilType() {
		return -1;
	
	}

	@Override
	public int querySysDateTime() {
		return -1;	
		
	}

	@Override
	public int setSysDateTime() {
		return -1;
			
	}
	
}
