package com.derun.dao;


import com.derun.entity.SysPara;
import com.derun.entity.SysParaMapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SysTemParameterDAO implements SysParaMapper{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<SysPara> findALL() {		
		return session.getMapper(SysParaMapper.class).findALL();
	}

	@Override
	public int insertOne(SysPara arg) {	
		return session.getMapper(SysParaMapper.class).insertOne(arg);
	}

	@Override
	public int clear() {
		return session.getMapper(SysParaMapper.class).clear();
	}

	@Override
	public int updateOne(SysPara arg) {
		return session.getMapper(SysParaMapper.class).updateOne(arg);
	}
	
}
