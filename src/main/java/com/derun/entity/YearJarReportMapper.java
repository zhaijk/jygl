package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

public interface YearJarReportMapper {
	
	@Select("select *  from yearjarreport")
	@Results({
		@Result(column="month1",property="month"),
		@Result(column="”Õπﬁ01",property="tank1"),
		@Result(column="”Õπﬁ02",property="tank2"),
		@Result(column="”Õπﬁ03",property="tank3"),
		@Result(column="∫œº∆",property="total")
	})
	public List<YearJarReport> findALL();
	
	@Insert("insert into  yearjarreport  values(#{month},#{tank1},#{tank2},#{tank3},#{total})")
	public int insertOne(YearJarReport arg);
	
	@Delete("delete  from  yearjarreport")
	public int clear();
	
}
