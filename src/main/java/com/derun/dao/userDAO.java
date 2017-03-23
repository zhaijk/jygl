package com.derun.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.derun.entity.userinfo;
import com.derun.entity.userinfoMapper;

@Repository
public class userDAO implements userinfoMapper{

	@Autowired
	private SqlSession sqlSession;

	
	//@Override
	public userinfo findByName(String username) {		
		return this.sqlSession.getMapper(userinfoMapper.class).findByName(username);
	}

	//@Override
	public List<userinfo> findALL() {		
		return this.sqlSession.getMapper(userinfoMapper.class).findALL();
	}
}
