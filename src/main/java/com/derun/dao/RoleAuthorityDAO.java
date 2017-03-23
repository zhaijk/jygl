package com.derun.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.derun.entity.Role_authority;
import com.derun.entity.Role_authorityMapper;

@Repository
public class RoleAuthorityDAO implements Role_authorityMapper{
	
	@Autowired
	private SqlSession session;
	private Role_authorityMapper mapper;
	
	@PostConstruct
	private void init(){
		mapper=session.getMapper(Role_authorityMapper.class);
	}
	@Override
	public List<Role_authority> findAll() {		
		return mapper.findAll();
	}

	@Override
	public List<Role_authority> findBy(Role_authority obj) {		
		return mapper.findBy(obj);
	}

	@Override
	public int insertOne(Role_authority obj) {		
		return mapper.insertOne(obj);
	}

	@Override
	public int UpdateOne(Role_authority obj) {		
		return mapper.UpdateOne(obj);
	}

	@Override
	public int deleteOne(Role_authority obj) {		
		return mapper.deleteOne(obj);
	}
	 
}
