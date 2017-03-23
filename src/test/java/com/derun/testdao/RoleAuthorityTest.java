package com.derun.testdao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derun.dao.RoleAuthorityDAO;
import com.derun.entity.Role_authority;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-context.xml")
public class RoleAuthorityTest {

	@Autowired
	private RoleAuthorityDAO dao;
	
	@Test
	public void findAll(){
		List<Role_authority>  objLst=dao.findAll();
		for(Role_authority obj:objLst){
			System.out.println(obj.getRa_id()+"\t"+obj.getRole_id()+"\t"+obj.getAuthority_id());
		}
	}
	//@Test
	public void findBy(){
		Role_authority obj=new Role_authority();
		obj.setRa_id(7);
		List<Role_authority>  objLst=dao.findBy(obj);
		for(Role_authority object:objLst){
			System.out.println(object.getRa_id()+"\t"+object.getRole_id()+"\t"+object.getAuthority_id());
		}
	}
	@Test
	public void insertOne(){
		Role_authority obj=new Role_authority();
		obj.setAuthority_id("0001");
		obj.setRole_id("0001");
		obj.setEnable(1);
		dao.insertOne(obj);
	}
	//@Test
	public void updateOne(){
		Role_authority obj=new Role_authority();
		obj.setAuthority_id("0001");
		obj.setRole_id("0001");
		obj.setEnable(0);
		obj.setRa_id(5);
		dao.UpdateOne(obj);
	}
	//@Test
	public void deleteOne(){
		Role_authority obj=new Role_authority();
		obj.setRa_id(5);
		dao.deleteOne(obj);
	}
}
