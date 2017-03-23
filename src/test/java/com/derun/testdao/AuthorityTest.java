package com.derun.testdao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derun.dao.AuthoritiesDAO;
import com.derun.entity.Authority;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-context.xml")
public class AuthorityTest {
	
	@Autowired
	private AuthoritiesDAO dao;
	
	@Test
	public void select(){
		List<Authority> objLst=dao.findAll();
		for(Authority obj:objLst){
			System.out.println(obj.getAuthority_id()+"\t"+obj.getAuthority_name());
		}
	}
	@Test
	public void insert(){
		Authority obj=new Authority();
		obj.setAuthority_id("0002");
		obj.setAuthority_name("123");
		obj.setAuthority_description("ceshishuju");
		obj.setEnable(1);
		obj.setIs_system_user(1);
		dao.insertOne(obj);
		
	}
	@Test
	public void delete(){
		Authority obj=new Authority();
		obj.setAuthority_id("0001");
		dao.deleteOne(obj);
	}
}
