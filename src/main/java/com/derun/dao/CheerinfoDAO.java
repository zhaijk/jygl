package com.derun.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

import com.derun.entity.cheerMachine;
import com.derun.entity.cheerinfoMapper;

@Repository
public class CheerinfoDAO implements cheerinfoMapper{

	@Autowired
	private SqlSession sqlSession;

	public List<cheerMachine> findALL() {
		return sqlSession.getMapper(cheerinfoMapper.class).findALL();
	}

	public String findOilType(String guncode) {
		return sqlSession.getMapper(cheerinfoMapper.class).findOilType(guncode);
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
	
}
