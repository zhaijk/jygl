package com.derun.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.derun.entity.DailyRecord;
import com.derun.entity.DailyRecordMapper;

@Repository
public class DailyRecordDAO implements DailyRecordMapper{//,DailyLogMapper {
	@Autowired
	private SqlSession session;
	private DailyRecordMapper mapper;//=session.getMapper(DailyRecordMapper.class);
	
	@PostConstruct
	public void init(){
		mapper=session.getMapper(DailyRecordMapper.class);
	}
	@Override
	public List<DailyRecord> findALL() {
		return mapper.findALL();
	}

	@Override
	public List<DailyRecord> findBy(Map<String, Object> map) {
		return mapper.findBy(map);
	}
	@Override
	public int insertOne(DailyRecord obj) {
		return mapper.insertOne(obj);
	}

}
