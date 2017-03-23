package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface EnterOilMapper {

	@Select("select * from enteroil_odd")
	@Results({
		@Result(column="enteroildate",property="date"),
		@Result(column="enteroilime",property="time"),
		@Result(column="credencenumber",property="number"),
		@Result(column="jarcode",property="jarcode"),
		@Result(column="enterval",property="value"),
		@Result(column="density",property="density"),
		@Result(column="byName",property="byName"),
		@Result(column="operatorName",property="operatorName")
	})
	public List<EnterOil> findALL();
	@Select("select * from enteroil_odd where enteroildate=#{date}")
	public List<EnterOil> findBy(String date);
}
