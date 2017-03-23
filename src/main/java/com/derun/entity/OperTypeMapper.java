package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface OperTypeMapper {
	

	@Select("select * from opertype_dictionary")
	public List<OperType> findALL();
	
	@Select("select * from opertype_dictionary where code=#{code}")
	public OperType findBY(String code);
		

}
