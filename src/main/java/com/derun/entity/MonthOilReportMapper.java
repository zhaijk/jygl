package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MonthOilReportMapper {

	@Select("select * from month_oil_record")
	@Results({
		@Result(column="日期",property="date"),
		@Result(column="油品",property="oilType"),
		@Result(column="罐号",property="jarCode"),
		@Result(column="加油量",property="value"),
		@Result(column="合计",property="total")
	})
	public List<MonthReport> findALL();
	
	@Select("select * from month_oil_record where 日期>#{date}")
	@Results({
		@Result(column="日期",property="date"),
		@Result(column="油品",property="oilType"),
		@Result(column="罐号",property="jarCode"),
		@Result(column="加油量",property="value"),
		@Result(column="合计",property="total")
	})
	public List<MonthReport> findBY(String date);
}
