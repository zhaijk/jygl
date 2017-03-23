package com.derun.dao;

import java.util.List;

import com.derun.entity.User_Role;
import com.derun.entity.User_RoleMapper;

import javax.annotation.PostConstruct;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class User_RoleDAO implements User_RoleMapper{
	@Autowired
	private SqlSession session;
	private User_RoleMapper mapper; 
	
	@PostConstruct
	public void init(){
		mapper=session.getMapper(User_RoleMapper.class);
	}
	@Override
	public List<User_Role> findAll() {	
		return mapper.findAll();
	}
	@Override
	public List<User_Role> findBy(User_Role obj) {		
		return mapper.findBy(obj);
	}
	@Override
	public int insertOne(User_Role obj) {
		return mapper.insertOne(obj);
	}
	@Override
	public int updateOne(User_Role obj) {
		return mapper.updateOne(obj);
	}
	@Override
	public int deleteOne(User_Role obj) {
		return mapper.deleteOne(obj);
	}
}
