package com.derun.testdao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derun.dao.UsersDAO;
import com.derun.entity.Users;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:spring-context.xml")
@ContextConfiguration(locations="file:src/main/resources/spring-context.xml")
public class UserDaoTest {
	
	@Autowired
	private UsersDAO dao;
	
	@Test
	public void R(){
		List<Users> lstObjs=dao.findAll();
		for(Users obj:lstObjs){
			System.out.println(obj.getUser_name()+"-"+obj.getUser_password());
		}
	}
	@Test
	public void C(){
		List<Users> lstObjs=dao.findAll();
		for(Users obj:lstObjs){
			System.out.println(obj.getUser_name()+"-"+obj.getUser_password());
		}
	}
}
