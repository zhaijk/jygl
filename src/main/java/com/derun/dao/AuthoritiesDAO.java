package com.derun.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.derun.entity.AuthorityMapper;
import com.derun.entity.Authority;

@Repository
public class AuthoritiesDAO implements AuthorityMapper{

	@Autowired
	@Qualifier("sqlSession")
	//@Resource(name="sqlSession")
	private SqlSession session;	
	private AuthorityMapper mapper;
	
	@PostConstruct
	public void init(){
		mapper=session.getMapper(AuthorityMapper.class);
	}
	
	@Override
	public List<Authority> findAll() {		
		return mapper.findAll();
	}

	@Override
	public List<Authority> findOne(Authority obj) {		
		return mapper.findOne(obj);
	}

	@Override
	public int insertOne(Authority obj) {		
		return mapper.insertOne(obj);
	}

	@Override
	public int updateOne(Authority obj) {		
		return mapper.updateOne(obj);
	}

	@Override
	public int deleteOne(Authority obj) {		
		return mapper.deleteOne(obj);
	}

}
