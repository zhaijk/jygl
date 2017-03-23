package com.derun.testdao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derun.dao.ResourceDAO;
import com.derun.entity.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:spring-context.xml")
@ContextConfiguration(locations="file:src/main/resources/spring-context.xml")
public class ResourceTest {
	
	@Autowired
	private ResourceDAO  dao; 
	
	@Test
	public void select(){
		Resource obj=new Resource();
		obj.setResource_uri("/monitor.htm");
		System.out.println(dao.findBy("/monitor.htm"));
//		List<Resource> objLst=dao.findAll();
//		System.out.println("资源名称\t资源类型");
//		for(Resource obj:objLst){			
//			System.out.println(obj.getResource_name()+"\t"+obj.getResource_type());
//		}
	}
	//@Test
	public void insert() {
		Resource obj=new Resource();
		obj.setResource_id("0004");
		obj.setResource_name("i want to make friend with you!!");
		obj.setResource_type("2");
		obj.setIs_system(1);
		obj.setPriority(1);
		obj.setResource_description("testing for update");
		//dao.insertOne(obj);
		try{
			dao.insertOne(obj);
		}catch(Exception e){
			e.printStackTrace();
			dao.updateOne(obj);
		}
	}
	//@Test
	public void delete(){
		Resource obj=new Resource();
		obj.setResource_id("001");
		dao.deleteOne(obj);
	}
}
