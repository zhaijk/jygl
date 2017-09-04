package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.derun.entity.cheerMachine;
import com.derun.entity.cheerinfoMapper;

@Repository
public class CheerinfoDAOAccess implements cheerinfoMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="accesssqlSession")
	private SqlSession sqlSession;

	public List<cheerMachine> findALL() {
		return sqlSession.getMapper(cheerinfoMapper.class).findALL();
	}

	public String findOilType(String guncode) {
		return sqlSession.getMapper(cheerinfoMapper.class).findOilType(guncode);
	}
	public String findOilTypeCode(String guncode) {
		return sqlSession.getMapper(cheerinfoMapper.class).findOilTypeCode(guncode);
	}
	@Override
	public int updateOne(cheerMachine obj) {
		return sqlSession.getMapper(cheerinfoMapper.class).updateOne(obj);
	}

	
	@Override
	public int insertOne(cheerMachine obj) {		
		return sqlSession.getMapper(cheerinfoMapper.class).insertOne(obj);
	}

	@Override
	public int deleteOne(cheerMachine obj) {
		return sqlSession.getMapper(cheerinfoMapper.class).deleteOne(obj);
	}

	@Override
	public int clear() {
		return sqlSession.getMapper(cheerinfoMapper.class).clear();
	}
	
}
