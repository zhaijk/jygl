package com.derun.db;

import java.util.List;

import javax.annotation.Resource;

//import org.apache.tomcat.util.http.mapper.Mapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derun.dao.UsersDAO;
import com.derun.entity.Users;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("applicationContext.xml")
@ContextConfiguration(locations ="classpath:spring-context.xml")
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@ContextConfiguration(value  = "classpath:applicationContext.xml")
public class userinfoTest {	
	@Resource
	private UsersDAO dao;
	//private ApplicationContext context;
	@Before
	public void init(){
		//ServletContext sc = null;
		//context=new ClassPathXmlApplicationContext("spring-context.xml");
		//context=WebApplicationContextUtils.getWebApplicationContext(sc);
		//context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//dao=context.getBean(CarColorDAO.class);
		System.out.println("init.............");
	}
	
	@Test
	public void test(){
		//CarColorDAO dao=context.getBean(CarColorDAO.class);
		Users objs=new Users();
		objs.setEnable(1);
		objs.setUser_name("user");
		objs.setUser_password("liaojing");		
		objs.setUser_id("2");
		//dao.InsertONE(objs);
		dao.updateOne(objs);
		List<Users> lstObjs=dao.findAll();
		for(Users obj:lstObjs){
			System.out.println(obj.getUser_name()+"-"+obj.getUser_password());
		}
		
	}
	@After
	public void destory(){
		//context.
	}
//	public static void main(String[] args) {	
	
//		SqlSession session=sqlhelper.getSession();
//		
//		userinfoMapper mapper=session.getMapper(userinfoMapper.class);
//		
//		List<userinfo> lstObjs=mapper.findALL();
//		
//		
//		for(Reissue obj:lstObjs){
//			//System.out.println(obj.getCode()+"-"+obj.getName());
//			//System.out.println(obj.getJarCode()+"-"+obj.istFlag()+obj.getCollectionDate()+"-"+obj.getOilHigh()+"-"+obj.getOilWeight());
//			//System.out.println(obj.getBuilddate()+obj.getOperatorname());
//			//System.out.println(obj.getCode()+obj.getName()+obj.gettMemo());
//			System.out.println(obj.getHigh());
//		}
//		//Passport obj=mapper.findBY("06");
//		//System.out.println(obj.getCode()+obj.getName()+obj.gettMemo());
////		EnterOilRecord obj=new EnterOilRecord();
////		obj.setJarCode("01");
////		obj.setOilType("23");
////		obj.setEnterOilDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
////		obj.setBeginTime(new SimpleDateFormat("HH-mm-ss").format(new Date()));
////		obj.setEndTime(new SimpleDateFormat("HH-mm-ss").format(new Date()));
////		mapper.insertONE(obj);
////		session.commit();
////		obj=mapper.findBY("01");
//		Reissue obj=new Reissue();
//		//BigDecimal num=new BigDecimal("123");
//		//Long num=new Long(12);
//		
//		obj.setHigh(123);
//		obj.setCapability(34.56);
//		mapper.insertONE(obj);
//		session.commit();
		
		
//		SqlSession session=sqlhelper.getSession();
//		SysParaMapper mapper=session.getMapper(SysParaMapper.class);
//		//ShowPara save = null;
//		List<SysPara> objLst=mapper.findALL();
//		for(SysPara obj:objLst){
//			System.out.println(obj.getSystemKey()+obj.getStationBenelux()+obj.getBackgroundBmp()+obj.getUseCarType()+obj.getPcToPcPort());
//			System.out.println(obj.getHeadQuartersCortrolCode());
//			System.out.println(obj.getAmountCortrolCode());
//			//save=obj;
//		}
		//System.out.println(1);
//		SqlSession session =sqlhelper.getSession();
//		tradeinfoMapper mapper=session.getMapper(tradeinfoMapper.class);
//		List<cardtrade> lstObjs=mapper.findALL();
//		
//		for(cardtrade obj:lstObjs){
//			//System.out.println(obj.getMonth()+"-"+obj.getTank1()+"-"+obj.getTotal());
//			System.out.println(obj.getCardCode());
//		}
//		YearJarReport obj=new YearJarReport();
//		for(int i=1;i<=12;i++){
//			obj.setMonth(String.format("%02d", i));
//			obj.setTank1(i*100.01);
//			obj.setTank2(i*200.02);
//			obj.setTank3(i*300.03);
//			obj.setTotal(i*600.06);
//			mapper.insertOne(obj);
//		}
//		session.commit();
		
//	}
}
