package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ShowParaMapper {
	
	@Select("select *  from show_parameter")
	public List<ShowPara> findALL();
	
	@Insert("insert into  show_parameter values(#{lastTimeCheer},#{lastTimeDate},#{oilName},"
			+ "#{balance},#{currentMileage},#{cardCode},#{carCode},#{autoCarType},#{cardType},#{beforeVal},"
			+ "#{sandFlag},#{stopDisplay},#{gotoDisplay},#{intoDisplay})")
	public int insertOne(ShowPara arg);	
	
	@Delete("delete from show_parameter")
	public int clear();
}
