package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface commportInfoMapper {
	
	@Select("select  * from Communication_parameter")
	public List<commportInfo> findALL();
	
}
