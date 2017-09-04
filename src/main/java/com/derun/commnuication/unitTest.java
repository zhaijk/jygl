package com.derun.commnuication;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.Test;
//import com.derun.entity.CardPutout;

import org.junit.Test;

public class UnitTest {
//
//	//@Before()
//	//@Test
//	public void comm() throws InterruptedException{
//		SerialPortLocal sp=new SerialPortLocal();
//		QueryPreset qp=new QueryPreset();
////		queryStatusComm qsc=new queryStatusComm();
////		SetPreset spt=new SetPreset();
////		qsc.setParam(0, 2);
//		qp.setParam(0, 2);
////		spt.setParam(0, 2);
////		double counter=111.11;
////		QueryTradeNumber at=new QueryTradeNumber();
////		QueryTradComm qtc=new QueryTradComm();
////		at.setParam(1, 2);
////		qtc.setParam(1, 2);
////		at.query();
////		int counter=at.getIntValue();
////		int counter=1;
//		while(true){
////			at.setParam(1,3);
////			qtc.setParam(1,3);
////			System.out.println("op"+counter+" "+ at.query()+" number:"+at.getIntValue());
////			int number=at.getIntValue();
////			int result=0;
////			for(int i=1;i<=number;i++){				
////				qtc.setCounter(i);
////				for(int j=0;j<4;j++){
////					result=qtc.query();
////					if (result==0) break;
////				}				
////				System.out.println("序号:"+i+" "+result);
////			}
////			counter++;
////			if(counter>4) counter=1;
////			spt.setDoubleValue(counter);			
////			qsc.query();
////			qp.query();
////			System.out.println(qp.getDoubleValue());
////			
////			counter+=0.01;
////			spt.query();
////			at.query();
////			System.out.println(at.getIntValue()+" "+at.getStrValue());
////			qtc.setCounter(counter);
////			qtc.query();
////			//Thread.sleep(1000);			
////			/at.setParam(1, 1);
//			
//			System.out.println(qp.query()+" "+qp.getDoubleValue());
//		}
//	}
////	@Test
////	public void change(){
////		double d=856.23;
////		String str=String.valueOf((int)(d*100));
////		byte[] array=str.getBytes();
////		
////		//System.out.println(String.format(arg0, arg1));
//////		for(int i=0;i<array.length;i++)
//////			System.out.println((char)(array[i]));
//////		for(int i=0;i<array.length;i++)
//////			System.out.println(String.format("%02X",array[i]));
////			//Integer.toHexString(array);
////	}
//	//@Test
//	public void clearTrades(){
//		SerialPortLocal sp=new SerialPortLocal();
//		ClearTrade ct= new ClearTrade();
//		ClearQuota cq= new ClearQuota();
//		DisableCard dc=new DisableCard();
//		ClearBlackList  cb=new ClearBlackList();
//		ct.setParam(4, 5);
//		cq.setParam(4, 5);
//		dc.setParam(4, 5);
//		cb.setParam(4, 5);
//		ct.query();
//		cq.query();
//		dc.query();
//		cb.query();
//	}
////	@Test
////	public void t(){
////		double d=12.3456;
////		System.out.println(String.format("%06d",(int)(d*100)));
////		int i=12412;
////		System.out.println(String.format("%04d",i%10000).getBytes()[0]-0x30);
////		
////	}
//	//@Test
//	public void sendq() throws InterruptedException{
//		SerialPortLocal sp=new SerialPortLocal();
//		SendQuotas sq1= new SendQuotas();
//		SendQuotas sq2= new SendQuotas();
//		SendQuotas sq3= new SendQuotas();
//		SendQuotas sq4= new SendQuotas();
//		CardPutout q= new CardPutout();
//		
//		sq1.setParam(2,1);
//		sq2.setParam(2,2);
//		sq3.setParam(2,3);
//		sq4.setParam(2,4);
//		
//		q.setProvidedate("2017-05-15");
//		q.setProvidetime("17:57:00");
//		q.setCardcode("720000123456");
//		q.setGuidelinecount(12.34);
//		q.setSendflag(1234);
//		sq1.setQuota(q);
//		sq2.setQuota(q);
//		sq3.setQuota(q);
//		sq4.setQuota(q);
//		ClearQuota cq=new ClearQuota();
//		cq.setParam(0, 2);
//		int counter=1;
//		while(true){			
////			System.out.println("sq1: "+sq1.query());
////			System.out.println("sq2"+sq2.query());
////			System.out.println("sq3"+sq3.query());
////			System.out.println("sq4"+sq4.query());
//			cq.setParam(0, counter);
//			System.out.println(cq.query());
//			counter++;
//			if(counter>4)counter=1;
////			
//			//cq.setParam(0,counter++);
//			//System.out.println(cq.query());
//			//Thread.sleep(1000);
//		}
//	}
//	//@Test
//	public void querys() throws InterruptedException{
//		SerialPortLocal sp=new SerialPortLocal();
////		QueryDateTime qdt=new QueryDateTime();
////		SetDateTime sdt=new SetDateTime();
//		
//		QueryOilType qot=new QueryOilType();
//		SetOilType sot=new SetOilType();
////		QueryOilTypePrice qotp=new QueryOilTypePrice();
////		QueryDepartmentID qdid= new QueryDepartmentID();
////		QueryHQAuthID qhqid= new QueryHQAuthID();
////		QueryHTAuthID qhtid=new QueryHTAuthID();
//		
//		qot.setParam(2, 4);
//		sot.setParam(2, 4);
////		qot.setParam(2, 2);
////		qotp.setParam(2, 2);
////		qdid.setParam(2, 2);
////		qhqid.setParam(2, 2);
////		qhtid.setParam(2, 2);
//		int counter=1;
//		while(true){
////			String str=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
////			System.out.println(str);			
////			sdt.setStrValue(str);
////			sdt.query(); //break;
////			
////			qdt.query();
//			System.out.println("油品类型:"+qot.query()+"  "+qot.getStrValue());
//			
//			System.out.println(String.format("%02d",counter));
//			sot.setStrValue(String.format("%02d",counter));
//			
//			System.out.println("设置油品类型:"+sot.query());
//			counter++;
//			//qot.query();
//			//qotp.query();
//			//qdid.query();
//			//qhqid.query();
//			//qhtid.query();
//			//System.out.println(qdt.getStrValue());
//			//System.out.println("油品:"+qot.getStrValue());
//			//System.out.println("单价:"+qotp.getStrValue());
//			//System.out.println("站号:"+qdid.getStrValue());
//			//System.out.println("总部编码:"+qhqid.getStrValue());
//			//System.out.println("总队编码:"+qhtid.getStrValue());
//			
//			//Thread.sleep(1000);
//		}
//	}
//	//@Test
//	public void price() throws InterruptedException{
//		
//		SerialPortLocal sp=new SerialPortLocal();
//		QueryOilTypePrice qot=new QueryOilTypePrice();
//		SetOilTypePrice sot=new SetOilTypePrice();
//		
//		qot.setParam(1, 3);
//		sot.setParam(1, 3);
//		int counter=0;
//		while(true){			
//			System.out.println("op: "+qot.query()+"油品单价"+qot.getStrValue());			
//			//Thread.sleep(1000);
//			sot.setStrValue(String.format("%04d", counter));
//			System.out.println("油品单价 "+String.format("%04d", counter)+"op: "+sot.query());
//			counter++;
//		}
//	}
//	//@Test
//	public void station() throws InterruptedException{
//		
//		SerialPortLocal sp=new SerialPortLocal();
//		
//		QueryDepartmentID 	qqdi=	new QueryDepartmentID();		
//		SetStationID 		ssid=	new SetStationID();
//		
//		qqdi.setParam(1, 3);
//		ssid.setParam(1, 3);
//		int counter=123456789;
//		while(true){			
//			System.out.println("op: "+qqdi.query()+"油站编号"+qqdi.getStrValue());			
//			//Thread.sleep(1000);
//			ssid.setStrValue(String.format("%012d", counter));
//			System.out.println("油站编号"+String.format("%012d", counter)+"op: "+ssid.query());
//			counter++;
//		}
//	}
//	//@Test
//	public void auth() throws InterruptedException{
//		
//		SerialPortLocal sp=new SerialPortLocal();
//		
//		QueryHQAuthID 	qqdi=	new QueryHQAuthID();		
//		SetHQAuthID 	ssid=	new SetHQAuthID();
//		
//		qqdi.setParam(1, 3);
//		ssid.setParam(1, 3);
//		int counter=123456789;
//		String str="1";
//		while(true){	
//			qqdi.query();
//			System.out.println(qqdi.getStrValue());			
//			//Thread.sleep(1000);
//			//String str=String.format("%096d", counter);
//			System.out.println(str);
//			ssid.setStrValue(str);
//			System.out.println("op: "+ssid.query());
//			//counter++;
//			//str
//			str=str+"10";
//		}
//	}
//	//@Test
//	public void authT() throws InterruptedException{
//		
//		SerialPortLocal sp=new SerialPortLocal();
//		
//		QueryHTAuthID 	qqdi=	new QueryHTAuthID();		
//		SetHTAuthID 	ssid=	new SetHTAuthID();
//		
//		qqdi.setParam(1, 3);
//		ssid.setParam(1, 3);
//		int counter=123456789;
//		String str="1";
//		while(true){	
//			qqdi.query();
//			System.out.println(qqdi.getStrValue());			
//			//Thread.sleep(1000);
//			//String str=String.format("%096d", counter);
////			System.out.println(str);
//			ssid.setStrValue(str);
//			System.out.println("op: "+ssid.query());
////			//counter++;
////			//str
//			str=str+"10";
//		}
//	}
//	@Test
//	public void dateTime() throws InterruptedException{
//		
//		SerialPortLocal sp=new SerialPortLocal();
//		
//		SetDateTime 	sdt=	new SetDateTime();		
//		QueryDateTime 	qdt=	new QueryDateTime();
//		
////		String str=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
////		System.out.println(str);			
////		sdt.setStrValue(str);
////		sdt.query(); //break;
//		int counter=1;
//		while(true){	
//			sdt.setParam(counter, counter);
//			qdt.setParam(counter, counter);			
//			String str=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//			System.out.println(" get op:"+qdt.query());
//			sdt.setStrValue(str);
//			System.out.println(" set op:"+sdt.query());
//			System.out.println(str);
//			System.out.println(qdt.getStrValue());
//			counter++;
//			if(counter>4) break;
//		}
//	}
	@Test
	public void blacklistTest() throws InterruptedException{
		SetBlackList sbl=new SetBlackList();
		ClearBlackList cbl=new ClearBlackList();
		
		sbl.setParam(2, 3);		
		cbl.setParam(2, 3);
		
		int counter=1;
		cbl.query();
		while(true){
			//String str=String.format("%06d", counter);
			String str="123456789012";
			//if(counter==100)break;
			//int result=cbl.query();
			Thread.sleep(100);
			//assert result!=0:"通讯出错";
			str=counter+str;	
			System.out.println(str);
			sbl.setCardCode12(counter,str);
			sbl.query();
			counter++;			
		}
	}
}

