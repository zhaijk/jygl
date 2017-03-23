package com.derun.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.derun.entity.CarType;
import com.derun.entity.CarTypeMapper;

@Repository
public class CarTypeDAO implements CarTypeMapper{

	@Autowired
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

}
