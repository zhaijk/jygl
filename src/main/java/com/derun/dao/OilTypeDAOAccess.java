package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.OilType;
import com.derun.entity.OilTypeMapper;


@Repository
public class OilTypeDAOAccess implements OilTypeMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="accesssqlSession")
	private SqlSession sqlSession;

	@Override
	public List<OilType> findBY(String code) {
		
		return sqlSession.getMapper(OilTypeMapper.class).findBY(code);
	}	
	@Override
	public int clear() {
		
		return sqlSession.getMapper(OilTypeMapper.class).clear();
	}
	@Override
	public List<OilType> findALL() {
		return sqlSession.getMapper(OilTypeMapper.class).findALL();
	}
	@Override
	public int deleteOne(OilType obj) {
		
		return sqlSession.getMapper(OilTypeMapper.class).deleteOne(obj);
	}
	@Override
	public int insertOne(OilType obj) {
		
		return sqlSession.getMapper(OilTypeMapper.class).insertOne(obj);
	}
	@Override
	public int updateOne(OilType obj) {
		
		return sqlSession.getMapper(OilTypeMapper.class).updateOne(obj);
	}
	
}
