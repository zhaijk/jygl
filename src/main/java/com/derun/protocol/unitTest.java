package com.derun.protocol;

//import java.io.IOException;

public class unitTest {
	
	public static void main(String[] args) {

		int gunid = 1;
		int channel = 0;

		queryStatus p1 = new queryStatus(gunid, channel); 	// ״̬��
		protocol p2 = new setOnOff(gunid, channel); 		// ���� ֹͣ����
		protocol p3 = new setOnOffline(gunid, channel); 	// �Կ� Զ�̼��
		protocol p4 = new queryOilNumber(gunid, channel); 	// ��ѯ��ǰ������
		protocol p5 = new queryCardInfos(gunid, channel); 	// ��ѯ����Ϣ
		protocol p6 = new queryLastTrad(gunid, channel); 	// ��ѯ���һ�����׼�¼

		
		while (true) {	//״̬��
			while(true){//����״̬
				p1.queryMachineStatus();
				if(p1.isOnline()==false) 			//���� ״̬  
					p3.setOnOffLineStatus(true);  	//���ó�����״̬
				if(p1.isTrade()){
					p6.queryLastTrade();
				}
				if(p1.isCard())break;
			}
			while(true){//�忨
				System.out.println("�忨");
				if(p1.isCard()){
					p5.queryCardInfo();
					break;
				}
				p1.queryMachineStatus();
			}
			while(true){//��ǹ����
				System.out.println("��ǹ");
				if((p1.isGun()==true)&&(p1.isOnline())&&(p1.isCard())&&(p1.isOiling()!=true))//{
					p2.setOnOffStatus(true);			
				//}
				p1.queryMachineStatus();
				if(p1.isOiling()==true) break;
			}
			while(true){//����
				System.out.println("����");
				if((p1.isGun()==true)&&(p1.isOnline())&&(p1.isCard())&&(p1.isOiling()==true)){
					p4.queryOilValue();					
				}
				if(p1.isOiling()==false)
					break;
				//p4.queryOilValue();
				p1.queryMachineStatus();
			}			
			//System.out.print("����������0-9: ");
			//try {
				//System.in.read(buffer);
			//} //catch (IOException e) {
				
			//}
			//p1.queryMachineStatus();
			/*
			switch(buffer[0]){
			case 48:
				p1.queryMachineStatus();break;				
			case 49:
				p2.setOnOffStatus(true);break;
			case 50:
				p2.setOnOffStatus(false);break;
			case 51:
				p3.setOnOffLineStatus(true);break;
			case 52:
				p3.setOnOffLineStatus(false);break;
			case 53:
				p4.queryOilValue();break;
			case 54:
				p5.queryCardInfo();break;
			case 55:
				p6.queryLastTrade();break;			
			}*/
		}
	}
}
