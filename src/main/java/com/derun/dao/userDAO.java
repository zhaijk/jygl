package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.userinfo;
import com.derun.entity.userinfoMapper;

@Repository
public class userDAO implements userinfoMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="sqlSession")
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
