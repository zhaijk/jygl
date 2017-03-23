package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface CarTypeClassMapper {
	
	@Select("select * from cartypeclass")
	public List<CarTypeClass> findALL();
	@Select("select * from cartypeclass where classcode=#{code}")
	public List<CarTypeClass> findBY(String code);
	
}
