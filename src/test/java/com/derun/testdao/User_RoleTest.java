package com.derun.testdao;

import com.derun.dao.User_RoleDAO;
import com.derun.entity.User_Role;

import java.util.List;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-context.xml")
public class User_RoleTest {
	
	@Autowired
	private User_RoleDAO dao;
		
	@Test
	public void findAll(){
		List<User_Role> objLst=dao.findAll();
		for(User_Role obj:objLst){
			System.out.println(obj.getUr_id()+"\t"+obj.getUser_id()+"\t"+obj.getRole_id());
		}
	}
	
	@Test
	public void findBy(){
		
	}
	
	@Test
	public void insertOne(){
		User_Role obj=new User_Role();
		obj.setUr_id(1);
		obj.setUser_id("0001");
		obj.setRole_id("0001");
		obj.setEnable(1);
		dao.insertOne(obj);
	}
	//@Test
	public void deleteOne(){
		User_Role obj=new User_Role();
		obj.setUr_id(1);
		dao.deleteOne(obj);
	}
	@Test
	public void updateOne(){
		User_Role obj=new User_Role();
		obj.setUr_id(1);
		obj.setUser_id("0001");
		obj.setRole_id("0001");
		obj.setEnable(1);
		dao.updateOne(obj);
	}
}
