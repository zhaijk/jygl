package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.OilCan;
import com.derun.entity.OilCanMapper;

@Repository
public class OilCanDAOAccess implements OilCanMapper{
	
	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="accesssqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<OilCan> findALL() {		
		return sqlSession.getMapper(OilCanMapper.class).findALL();
	}

	@Override
	public List<OilCan> findBY(String code) {
		return sqlSession.getMapper(OilCanMapper.class).findBY(code);
	}

	@Override
	public int deleteOne(OilCan arg) {
		return sqlSession.getMapper(OilCanMapper.class).deleteOne(arg);	
	}
	
	@Override
	public int insertOne(OilCan arg) {
		return sqlSession.getMapper(OilCanMapper.class).insertOne(arg);
	}

	@Override
	public int updateOne(OilCan arg) {
		return sqlSession.getMapper(OilCanMapper.class).updateOne(arg);
	}

	@Override
	public int clear() {
		return sqlSession.getMapper(OilCanMapper.class).clear();
	}
}
