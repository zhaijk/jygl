package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.commportInfo;
import com.derun.entity.commportInfoMapper;

@Repository
public class commportInfoDAO implements commportInfoMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public List<commportInfo> findALL() {
		return sqlSession.getMapper(commportInfoMapper.class).findALL();
	}
	
}
