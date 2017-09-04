package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OilCanMapper {
	
	@Select("select *  from oilcan_parameter order by jarcode")
	public List<OilCan> findALL();	
	
	@Select("select *  from oilcan_parameter where jarcode=#{code}")
	public List<OilCan> findBY(String code);
	
	@Delete("delete from oilcan_parameter where jarcode=#{jarCode}")
	public int deleteOne(OilCan arg);	
	
	@Insert("insert into  oilcan_parameter	 values(#{jarCode},#{oilType},#{cubage},#{alarmUpperLimit},#{alarmLowerLimit})")
	public int insertOne(OilCan arg);
	
	@Update("update oilcan_parameter set oilType=#{oilType},cubage=#{cubage},alarmUpperLimit=#{alarmUpperLimit},alarmLowerLimit=#{alarmLowerLimit}where jarcode=#{jarCode} ") 
	public int updateOne(OilCan arg);
	
	@Delete("delete from oilcan_parameter")
	public int clear();	
	
}
