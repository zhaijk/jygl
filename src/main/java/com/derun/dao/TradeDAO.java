package com.derun.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.derun.entity.cardtrade;
import com.derun.entity.tradeinfoMapper;


@Repository
public class TradeDAO implements tradeinfoMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public List<cardtrade> findALL() {
		return this.sqlSession.getMapper(tradeinfoMapper.class).findALL();
	}
	@Override
	public List<cardtrade> findBY(Map<String,Object> map){
		return this.sqlSession.getMapper(tradeinfoMapper.class).findBY(map);
	}
	//@Transactional
	@Override
	public int insertOne(cardtrade arg){
//		arg.setBalance(arg.getBalance()/100);	
//		arg.setCardMoney(arg.getCardMoney()/100);
//		arg.setVolumn(arg.getVolumn()/100);
		return this.sqlSession.getMapper(tradeinfoMapper.class).insertOne(arg);
	}
	//@Transactional	
	public int insertOnlineOne(cardtrade arg,String username) {		
//		arg.setBalance(arg.getBalance()/100);	
//		arg.setCardMoney(arg.getCardMoney()/100);
//		arg.setVolumn(arg.getVolumn()/100);
		return this.sqlSession.getMapper(tradeinfoMapper.class).insertOne(arg);
	}
	@Override
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
	@Override
	public int clear() {
		return this.sqlSession.getMapper(tradeinfoMapper.class).clear();
	}
	@Override
	public cardtrade findBy(String cardcode, String mileage) {
		return this.sqlSession.getMapper(tradeinfoMapper.class).findBy(cardcode, mileage);
	}
	@Override
	public int updateOne(String cardcode, String mileage, String tradetype) {
		return this.sqlSession.getMapper(tradeinfoMapper.class).updateOne(cardcode, mileage, tradetype);
	}	
}
