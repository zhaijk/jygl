package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface GuidelineMapper {

	@Select("select * from guideline_dictionary")
	public List<Guideline> findALL();
	@Select("select * from guideline_dictionary where code=#{code}")
	public List<Guideline> findBY(String code);
	
}
