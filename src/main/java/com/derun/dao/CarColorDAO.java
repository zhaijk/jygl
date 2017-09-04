package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.CarColor;
import com.derun.entity.CarColorMapper;

@Repository//("sqlSessionFactory")
public class CarColorDAO implements CarColorMapper{
	
	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public List<CarColor> findALL() {		
		return sqlSession.getMapper(CarColorMapper.class).findALL();
	}

	@Override
	public List<CarColor> findByCode(String code) {
		
		return sqlSession.getMapper(CarColorMapper.class).findByCode(code);
	}

	@Override
	public int insertOne(CarColor obj) {		
		return sqlSession.getMapper(CarColorMapper.class).insertOne(obj);
	}
	
	
}
