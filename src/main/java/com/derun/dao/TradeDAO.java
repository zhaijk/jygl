package com.derun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.derun.entity.cardtrade;
import com.derun.entity.tradeinfoMapper;
//import com.derun.model.QueryModel;

@Repository
public class TradeDAO implements tradeinfoMapper{

	@Autowired
	private SqlSession sqlSession;

	//@Override
	public List<cardtrade> findALL() {
		return this.sqlSession.getMapper(tradeinfoMapper.class).findALL();
	}
	//@Override
	public List<cardtrade> findBY(Map<String,Object> map){
		return this.sqlSession.getMapper(tradeinfoMapper.class).findBY(map);
	}
	//@Override
	public int insertOne(cardtrade arg) {
		return this.sqlSession.getMapper(tradeinfoMapper.class).insertOne(arg);
	}
	//@Override
	public int totalCounter() {
		return this.sqlSession.getMapper(tradeinfoMapper.class).totalCounter();
	}
	@Override
	public List<cardtrade> findOfflineALL() {
		return this.sqlSession.getMapper(tradeinfoMapper.class).findOfflineALL();
	}
	@Override
	public List<cardtrade> findOnlineALL() {
		return this.sqlSession.getMapper(tradeinfoMapper.class).findOnlineALL();
	}

	
	
}
