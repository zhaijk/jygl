package com.derun.commnuication;

//import org.springframework.stereotype.Service;

//@Service
public class queryStatusComm extends abstractCommnuication{

	private boolean trade;   	//�ѻ���¼ 	0 û��  	1 �� 	��λ	
	private boolean card;    	//��״̬   	0 û��  	1 ��
	private boolean mileage; 	//���     	0 û��  	1 ��
	private boolean online; 	//�Ƿ�����  	0 �Կ� 	1 �ܿ�
	private boolean record; 	//��¼����  	0 û��  	1 ��
	private boolean oiling; 	//���ͻ�״̬	0 ͣ��  	1 ����
	private boolean gun; 		//��ǹ      	0 ��ǹ	1 ��ǹ
	private boolean key; 		//�ȼ� 		0 ����  	1 ��  	��λ
	
	private byte carCardIndetifier; //����ʶ��	
	private int status;

	public queryStatusComm(){
		//ͨѶ�����֡�ͨѶ�������ݡ�ͨѶ��Ӧ���ȡ���ʼ�����������
		//System.out.println("queryStatusComm............");
		super.command=protocolInfo.READSTATUS;
		data=new byte[0];
		super.respLength=5;
		this.sendbuff=new byte[6];
		this.recvbuff=new byte[6];
	}	
	@Override
	public int analyRecvbuff() {		
			if(recvbuff[0]==4){//�жϷ������ݳ���
				if(recvbuff[4]==protocolInfo.fnChecksumCalc(recvbuff,1,4)){	//У���
					setStatus(recvbuff[1]);
					trade=		((recvbuff[1]&0x01)!=0);				
					card=		((recvbuff[1]&0x02)!=0);
					mileage=	((recvbuff[1]&0x04)!=0);
					online=		((recvbuff[1]&0x08)!=0);
					record=		((recvbuff[1]&0x10)!=0);
					oiling=		((recvbuff[1]&0x20)!=0);
					gun=		((recvbuff[1]&0x40)!=0);
					key=		((recvbuff[1]&0x80)!=0);
					
					setCarCardIndetifier(recvbuff[2]);
									
					if(trade==true)System.out.print("�м�¼");
					else System.out.print("�޼�¼");
					System.out.print("-");
					if(card==true)System.out.print("�п�");
					else System.out.print("�޿�");
					System.out.print("-");
					if(mileage==true)System.out.print("�����");
					else System.out.print("�����");
					System.out.print("-");
					if(online==true)System.out.print("�豸����");
					else System.out.print("�Կ�");
					System.out.print("-");
					if(record==true)System.out.print("��¼����");
					else System.out.print("��¼δ��");
					System.out.print("-");
					if(oiling==true)System.out.print("������");
					else System.out.print("ͣ��");
					System.out.print("-");
					if(gun==true)System.out.print("��ǹ");
					else System.out.print("��ǹ");
					System.out.print("-");
					if(key==true)System.out.print("�ȼ�");
					else System.out.print("���ȼ�");
					return 0;
				}	
			}else{
				return -1;
			}
			return -1;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public byte getCarCardIndetifier() {
		return carCardIndetifier;
	}
	public void setCarCardIndetifier(byte carCardIndetifier) {
		this.carCardIndetifier = carCardIndetifier;
	}

	public boolean isTrade() {
		return trade;
	}

	public void setTrade(boolean trade) {
		this.trade = trade;
	}

	public boolean isCard() {
		return card;
	}

	public void setCard(boolean card) {
		this.card = card;
	}

	public boolean isMileage() {
		return mileage;
	}

	public void setMileage(boolean mileage) {
		this.mileage = mileage;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isRecord() {
		return record;
	}

	public void setRecord(boolean record) {
		this.record = record;
	}

	public boolean isOiling() {
		return oiling;
	}

	public void setOiling(boolean oiling) {
		this.oiling = oiling;
	}

	public boolean isGun() {
		return gun;
	}

	public void setGun(boolean gun) {
		this.gun = gun;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}
}
