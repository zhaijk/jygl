package com.derun.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.derun.entity.BlackListMapper;
import com.derun.entity.Blacklist;

@Repository
public class BlacklistDAO implements BlackListMapper{
	@Autowired
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
	public int insertONE(Blacklist obj) {
		return session.getMapper(BlackListMapper.class).insertONE(obj);
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
