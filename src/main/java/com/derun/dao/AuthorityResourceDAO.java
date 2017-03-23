package com.derun.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.derun.entity.AuthorityResource;
import com.derun.entity.AuthorityResourceMapper;

@Repository
public class AuthorityResourceDAO implements AuthorityResourceMapper{

	@Autowired 
	private SqlSession session;
	private AuthorityResourceMapper mapper;
	
	@PostConstruct
	private void init(){
		mapper=session.getMapper(AuthorityResourceMapper.class);
	}
	
	@Override
	public List<AuthorityResource> findAll() {		
		return mapper.findAll();
	}
	
	
	@Override
	public int insertOne(AuthorityResource obj) {
		return mapper.insertOne(obj);
	}

	@Override
	public int updateOne(AuthorityResource obj) {		
		return mapper.updateOne(obj);
	}

	@Override
	public int deleteOne(AuthorityResource obj) {	
		return mapper.deleteOne(obj);
	}

	@Override
	public List<AuthorityResource> findBy(AuthorityResource obj) {		
		return mapper.findBy(obj);
	}	
}
