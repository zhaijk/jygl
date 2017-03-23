package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface OperatorTypeMapper {

	@Select("select * from operatortype_dictionary")
	public List<OperatorType> findALL();
	
	@Select("select * from operatortype_dictionary where typecode=#{code}")
	public OperatorType findBY(String code);
		
}
