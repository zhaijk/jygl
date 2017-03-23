package com.derun.testdao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.derun.dao.AuthorityResourceDAO;
import com.derun.entity.AuthorityResource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-context.xml")
public class AuthorityResourcceTest{

	@Autowired
	private AuthorityResourceDAO dao;
	
	@Test
	public void findAll(){
		List<AuthorityResource> objLst=dao.findAll();
		for(AuthorityResource object:objLst){
			System.out.println(object.getAuthority_id()+"\t"+object.getResource_id());
		}
	}
	@Test
	public void findBy(){
		AuthorityResource obj=new AuthorityResource();
		List<AuthorityResource> objLst=dao.findBy(obj);
		for(AuthorityResource object:objLst){
			System.out.println(object.getAuthority_id()+"\t"+object.getResource_id());
		}
	}
	@Test
	public void insertOne(){
		AuthorityResource obj=new AuthorityResource();
		int result=dao.insertOne(obj);
		System.out.println("Insert op result:"+result);
	}
	@Test
	public void updateOne(){
		AuthorityResource obj=new AuthorityResource();
		int result=dao.updateOne(obj);
		System.out.println("Update op result:"+result);
	}
	@Test
	public void deleteOne(){
		AuthorityResource obj=new AuthorityResource();
		int result=dao.deleteOne(obj);
		System.out.println("Delete op result:"+result);
	}
}
