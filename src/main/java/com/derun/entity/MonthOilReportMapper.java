package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MonthOilReportMapper {

	@Select("select * from month_oil_record")
	@Results({
		@Result(column="����",property="date"),
		@Result(column="��Ʒ",property="oilType"),
		@Result(column="�޺�",property="jarCode"),
		@Result(column="������",property="value"),
		@Result(column="�ϼ�",property="total")
	})
	public List<MonthReport> findALL();
	
	@Select("select * from month_oil_record where ����>#{date}")
	@Results({
		@Result(column="����",property="date"),
		@Result(column="��Ʒ",property="oilType"),
		@Result(column="�޺�",property="jarCode"),
		@Result(column="������",property="value"),
		@Result(column="�ϼ�",property="total")
	})
	public List<MonthReport> findBY(String date);
}
