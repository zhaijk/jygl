package com.derun.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.derun.entity.CardPutout;
import com.derun.entity.CardPutoutMapper;
import com.derun.entity.QuotaRecordMapper;

@Repository//("sqlSessionFactory")
public class CardPutoutDAOAccess implements CardPutoutMapper ,QuotaRecordMapper{

	//@Autowired
	//@Qualifier("sqlSession")
	@Resource(name="accesssqlSession")
	private SqlSession session;
	
	@Override
	public List<CardPutout> findALL() {
		return session.getMapper(CardPutoutMapper.class).findALL();
	}

	@Override
	public int insertONE(CardPutout obj) {
		return session.getMapper(CardPutoutMapper.class).insertONE(obj);
	}

	@Override
	public List<CardPutout> findBy(CardPutout obj) {
		return session.getMapper(CardPutoutMapper.class).findBy(obj);
	}

	@Override
	public int clear() {
		return session.getMapper(CardPutoutMapper.class).clear();
	}
	@Override
	public int delete(CardPutout obj) {
		return session.getMapper(CardPutoutMapper.class).delete(obj);
	}

	@Override
	public List<CardPutout> findBY(Map<String, Object> map) {		
		return session.getMapper(QuotaRecordMapper.class).findBY(map);
	}

	@Override
	public List<CardPutout> findByGuncode(String guncode) {		
		return session.getMapper(CardPutoutMapper.class).findByGuncode(guncode);
	}
}
