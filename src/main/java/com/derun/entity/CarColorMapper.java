package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CarColorMapper {

	@Select("select *  from carcolor_dictionary")
	public List<CarColor> findALL();
	@Select("select *  from carcolor_dictionary where code=#{param}")
	public List<CarColor> findByCode(String code);
	@Insert("insert into carcolor_dictionary values(#{code},#{name},#{tmemo})")
	public int insertOne(CarColor obj);
	
}
