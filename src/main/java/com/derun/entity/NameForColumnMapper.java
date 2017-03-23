package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface NameForColumnMapper {

	@Select("select *  from tk_xt_blb")
	public List<NameForColumn> findALL();
	
	@Select("select *  from tk_xt_blb where bdm=#{name}")
	public NameForColumn totalCounter(String name);
}
