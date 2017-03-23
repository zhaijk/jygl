package com.derun.protocol;

//import java.io.IOException;

public class unitTest {
	
	public static void main(String[] args) {

		int gunid = 1;
		int channel = 0;

		queryStatus p1 = new queryStatus(gunid, channel); 	// 状态查
		protocol p2 = new setOnOff(gunid, channel); 		// 加油 停止加油
		protocol p3 = new setOnOffline(gunid, channel); 	// 自控 远程监控
		protocol p4 = new queryOilNumber(gunid, channel); 	// 查询当前加油量
		protocol p5 = new queryCardInfos(gunid, channel); 	// 查询卡信息
		protocol p6 = new queryLastTrad(gunid, channel); 	// 查询最后一条交易记录

		
		while (true) {	//状态机
			while(true){//空闲状态
				p1.queryMachineStatus();
				if(p1.isOnline()==false) 			//离线 状态  
					p3.setOnOffLineStatus(true);  	//设置成在线状态
				if(p1.isTrade()){
					p6.queryLastTrade();
				}
				if(p1.isCard())break;
			}
			while(true){//插卡
				System.out.println("插卡");
				if(p1.isCard()){
					p5.queryCardInfo();
					break;
				}
				p1.queryMachineStatus();
			}
			while(true){//提枪加油
				System.out.println("提枪");
				if((p1.isGun()==true)&&(p1.isOnline())&&(p1.isCard())&&(p1.isOiling()!=true))//{
					p2.setOnOffStatus(true);			
				//}
				p1.queryMachineStatus();
				if(p1.isOiling()==true) break;
			}
			while(true){//加油
				System.out.println("加油");
				if((p1.isGun()==true)&&(p1.isOnline())&&(p1.isCard())&&(p1.isOiling()==true)){
					p4.queryOilValue();					
				}
				if(p1.isOiling()==false)
					break;
				//p4.queryOilValue();
				p1.queryMachineStatus();
			}			
			//System.out.print("请输入命令0-9: ");
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
