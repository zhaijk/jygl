package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MonthJarReportMapper {

	@Select("select *  from monthjarreport")
	@Results({
		@Result(column="date1",property="date"),
		@Result(column="�͹�01",property="tank1"),
		@Result(column="�͹�02",property="tank2"),
		@Result(column="�͹�03",property="tank3"),
		@Result(column="�͹�04",property="tank4"),
		@Result(column="�ϼ�",property="total")
	})
	public List<MonthJarReport> findALL();
	
	@Insert("insert into monthjarreport values(#{date},#{tank1},#{tank2},#{tank3},#{tank4},#{total}")
	public int insertONE(MonthJarReport obj);
}
