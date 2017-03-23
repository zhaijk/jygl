package com.derun.entity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface DailyRecordMapper {

	
	@Select("select * from daily_record")
	@Results({		
    	@Result(column="operatedate",property="date"),
		@Result(column="operatetime",property="time"),
		@Result(column="operatetype",property="type"),
		@Result(column="operatorname",property="name"),
		@Result(column="tmemo",property="tmemo")
	})
	//@ResultMap(value = "daily_report")
	public List<DailyRecord> findALL();
	
	//@Select("select * from daily_record where operatorname=#{name}")
	public List<DailyRecord> findBy(Map<String,Object> map);
	
	@Insert("insert into  daily_record values(#{date},#{time},#{type},#{name},#{tmemo})")	
	public int insertOne(DailyRecord obj);
}
