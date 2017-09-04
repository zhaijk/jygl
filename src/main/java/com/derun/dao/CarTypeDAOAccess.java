package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.CarType;
import com.derun.entity.CarTypeMapper;

@Repository//("sqlSessionFactory")
public class CarTypeDAOAccess implements CarTypeMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="accesssqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<CarType> findALL() {		
		return sqlSession.getMapper(CarTypeMapper.class).findALL();
	}	
	@Override
	public List<CarType> findBy(CarType arg) {		
		return sqlSession.getMapper(CarTypeMapper.class).findBy(arg);
	}
	@Override
	public int insertOne(CarType arg) {
		return sqlSession.getMapper(CarTypeMapper.class).insertOne(arg);
	}
	@Override
	public int updateOne(CarType arg) {
		return sqlSession.getMapper(CarTypeMapper.class).updateOne(arg);
	}
	@Override
	public int deleteOne(CarType arg) {
		return sqlSession.getMapper(CarTypeMapper.class).deleteOne(arg);
	}
	@Override
	public int clear() {
		return sqlSession.getMapper(CarTypeMapper.class).clear();
	}

}
