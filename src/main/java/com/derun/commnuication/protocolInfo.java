package com.derun.commnuication;

public class protocolInfo {

	public final static byte framebegin=(byte) 0xF0; 			//֡ͷ
	public final static byte frameend=(byte) 0xCC;   			//֡β
	
	public final static byte READSTATUS=(byte) 0xA1; 			//��IC����״̬���� 
	public final static byte READPRESET=(byte) 0xA2; 			//��ȡԤ����
	public final static byte SETPRESET=(byte) 0xA3; 				//����Ԥ���� 
	public final static byte READOILVALUE=(byte) 0xA4; 			//��ȡ������ 
	public final static byte READOILTOTAL=(byte) 0xA5; 			//���������� ��λ 
	public final static byte READOILTOTALHIGH=(byte) 0xA6; 		//��ȡ�������� ��λ 
	public final static byte CLEAROILTOTAL=(byte) 0xA7; 			//������������ 
	public final static byte SETBLACKLIST=(byte) 0xAA; 			//�´������� 
	public final static byte CLEARBLACKLIST=(byte) 0xAB; 		//��������� 
	public final static byte READCARMILEAGE=(byte) 0xAC; 		//��ȡ����� 
	public final static byte READCARINFO=(byte) 0xAD; 			//��ȡ����Ϣ 
	public final static byte READTOTALTRADECOUNTER=(byte) 0xAE; 	//��ȡ���׼�¼�� 
	public final static byte READTRADERECORD=(byte) 0xAF; 		//��ȡ���׼�¼ 
	
	public final static byte CLEARTRADEREC=(byte) 0xB1; 			//�忨����¼
	public final static byte READLASTTRADEREC=(byte) 0xB2; 		//�����һ�����׼�¼
	public final static byte SETQUOTAREC=(byte) 0xB3; 			//�´�ָ���¼
	public final static byte CLEARQUOTAREC=(byte) 0xB4; 			//��ָ���¼
	public final static byte STARTCARCARDIDEN=(byte) 0xB5; 		//���ó���ʶ��
	public final static byte DISABLECARCARDIDEN=(byte) 0xB6; 	//����ʶ��ʧЧ
	public final static byte READDATETIME=(byte) 0xB7; 			//��ȡIC����ϵͳʱ��
	public final static byte SETDATETIME=(byte) 0xB8; 			//����IC����ϵͳʱ��
	public final static byte READOILQUALITY=(byte) 0xB9; 		//����Ʒ�ܶ�
	public final static byte SETOILQUALITY=(byte) 0xBA; 			//������Ʒ�ܶ�
	public final static byte BEGINOILLING=(byte) 0xBB; 			//��������
	public final static byte STOPOILLING=(byte) 0xBC; 			//ֹͣ����
	public final static byte ONLINE=(byte) 0xBD; 				//����
	public final static byte TAKECARD=(byte) 0xBF; 				//�˿�
	
	public final static byte READPRICE=(byte) 0xC2; 				//������
	public final static byte OFFLINE=(byte) 0xC3; 				//����
	public final static byte WRITEPRICE=(byte) 0xC4; 			//д����
	public final static byte READSTATIONID=(byte) 0xC5; 			//��վ��
	public final static byte WRITESTATIONID=(byte) 0xC6; 		//дվ��
	public final static byte READDEPARTMENTID=(byte) 0xC7; 		//���ܲ�������
	public final static byte WRITEDEPARTMENTID=(byte) 0xC8; 		//д�ܲ�������
	public final static byte READTEAMID=(byte) 0xC9; 			//���ܶ�������
	public final static byte WRITETEAMID=(byte) 0xCA; 			//д�ܶ�������
	public final static byte WRITEPASSWORD=(byte) 0xCB; 			//д����
	
	
	
	private byte[] sendbuff;
//	private byte[] recvbuff;
	
	//private final static byte checksumStartIndex=3; 
	
	//����У���
	public static byte fnChecksumCalc(byte[] databuff,int start,int end) {
		int checkSum = 0;
		for (int i = start; i < end; i++) {		//У��ʹӵ�4���ֽ�(0xF?,length,gunID,command,data,checksum,0xCC )��ʼ���� M->S
			checkSum += databuff[i];           	//У��ʹӵ�2���ֽ�(length,data,command,checksum)��ʼ����                  S->M
		}
		checkSum = checkSum & 0x7F; // ��Ҫ���λ
		return (byte) checkSum;
	}
	
	//F0 03 01 A1 21 CC	
	public void queryStatus(int channel,int ID,int timeout){
		sendbuff=new byte[6];
//		recvbuff=new byte[4];		
		sendbuff[0]=(byte) (0xF0+channel); 	//֡ͷ +ͨ����
		sendbuff[1]=(byte) 0x03;			//���ݳ���
		sendbuff[2]=(byte) ID;             //ǹ��
		sendbuff[3]=(byte) 0xA1;           //����
		sendbuff[4]=(byte) 0x00;//fnChecksumCacl(sendbuff,sendbuff[1]); //У���
		sendbuff[5]=(byte) 0xCC;			//֡β
		//System.out.println(sendbuff[4]);
		//serialComm.WriteAndRead(recvbuff, sendbuff, timeout);
	}
	
	public void queryMethod(){
		//sendbuff[4]=fnChecksumCacl(sendbuff,sendbuff[1]); //У���
		//serialPort.WriteAndRead(recvbuff, sendbuff, 1);
	}
	
	public static void main(String[] args){
		//serialPort.setParam(4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		//serialPort.open(); //�򿪶˿�
		//new protocol().queryStatus(0,1,20);		
		//serialPort.close();
		return;
	}
}
