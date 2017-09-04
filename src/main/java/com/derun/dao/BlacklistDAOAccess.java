package com.derun.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.derun.entity.BlackListMapper;
import com.derun.entity.Blacklist;

@Repository
public class BlacklistDAOAccess implements BlackListMapper{
	
//	@Autowired
//	@Qualifier("sqlSession")
	@Resource(name="accesssqlSession")
	private SqlSession session;
	@Override
	public List<Blacklist> findALL() {
		return session.getMapper(BlackListMapper.class).findALL();
	}

	@Override
	public List<Blacklist> findOne(String code) {
		return session.getMapper(BlackListMapper.class).findOne(code);
	}

	@Override
	public List<Blacklist> findBy(String code) {
		return session.getMapper(BlackListMapper.class).findBy(code);
	}

	@Override
	public int insertOne(Blacklist obj) {
		return session.getMapper(BlackListMapper.class).insertOne(obj);
	}

	@Override
	public int deleteOne(Blacklist obj) {
		return session.getMapper(BlackListMapper.class).deleteOne(obj);
	}

	@Override
	public int clear() {
		return session.getMapper(BlackListMapper.class).clear();
	}

}
