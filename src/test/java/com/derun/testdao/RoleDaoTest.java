package com.derun.testdao;

import org.junit.Test;
import java.util.List;
import com.derun.dao.RolesDAO;
import com.derun.entity.Roles;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-context.xml")
public class RoleDaoTest {
	
	@Autowired
	private RolesDAO  dao;
	
	@Test
	public void main(){
		
		Roles  object=new Roles();		
//		object.setRole_id("0001");
//		object.setRole_name("user");
//		object.setEnable(1);
//		object.setIs_system_role(1);
//		object.setRole_description("2016-1-1 for testing");
//		dao.insertONE(object);
		
		List<Roles>  objLst=dao.findALL();
//		
//		for(Roles obj:objLst){
//			System.out.println(obj.getRole_name()+"-"+obj.getRole_description());
//			//obj.setRole_name("¹þ");
//			//dao.updateOne(obj);
//			//int result=dao.deleteONE(obj);
//			//System.out.println("É¾³ý½á¹û: "+result);
//		}
		object.setRole_name("user");
		objLst=dao.findBy(object);		
		for(Roles obj:objLst){
			System.out.println(obj.getRole_name()+"-"+obj.getRole_description());
		}
	}
}
