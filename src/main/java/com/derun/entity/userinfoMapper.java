package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;


public interface userinfoMapper {	
	
	@Select("select  * from Operator_Info order by operatorcode")
	public List<userinfo> findALL();
	
	@Select("select  * from Operator_Info where OperatorCode= #{code}")
	public userinfo findByName(String code);
	
	
}
