package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface PassportMapper {
	
	@Select("select * from passport_dictionary")
	public List<Passport> findALL();
	
	@Select("select * from passport_dictionary where code=#{code}")
	public Passport findBY(String code);
	
}
