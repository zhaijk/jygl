package com.derun.protocol;

public abstract interface protocol {
	
	//ʵʱ�������
	public int queryMachineStatus();					//��ȡ״̬
	public int setOnOffLineStatus(boolean OnOff);		//���ߣ��ȴ��������� �����ߣ��Կ� ����Ҫ�ȴ��������״̬
	public int setOnOffStatus(boolean OnOff);			//��ʼ���� ֹͣ����
	public int queryOilValue();						//��ȡ��ǰ��������
	public int queryPresetValue();						//�� ȡԤ����
	public int setPresetValue();						//�� ��Ԥ����
	public int queryCardInfo();						//��ȡ����Ϣ
	public int setCardInvalid();						//�˿�
	
	
	//��������
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
	
	
	//��¼����
	public int downloadBlackList();
	public int clearBlackList();
	public int downloadQutoaList();
	public int clearQuotaList();
	public int queryNumberOfTrades();
	public int queryTrades();							
	public int clearTrades();
	public int queryLastTrade();						//��ȡ���һ�����׼�¼(�������ݲ���)
	
	
}
