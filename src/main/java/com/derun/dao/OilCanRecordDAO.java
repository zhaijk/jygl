package com.derun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.derun.entity.OilCanRecord;
import com.derun.entity.OilCanRecordMapper;


@Repository
public class OilCanRecordDAO implements OilCanRecordMapper {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<OilCanRecord> findALL() {
		return session.getMapper(OilCanRecordMapper.class).findALL();
	}

	@Override
	public int insertONE(OilCanRecord obj) {		
		return session.getMapper(OilCanRecordMapper.class).insertONE(obj);
	}

	@Override
	public List<OilCanRecord> findBY(Map<String, Object> map) {
		return session.getMapper(OilCanRecordMapper.class).findBY(map);
	}	
}
