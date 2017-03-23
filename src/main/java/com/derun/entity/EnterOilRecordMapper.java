package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface EnterOilRecordMapper {

	@Select("select *  from enteroil_record")
	public List<EnterOilRecord> findALL();
	
	@Select("select *  from enteroil_record where jarcode=#{code} limit 1")
	public EnterOilRecord findBY(String code);
	
	@Insert("insert into enteroil_record values(#{jarCode},"
			+ "#{oilType},#{enterOilDate},#{beginTime},#{endTime},"
			+ "#{beginOilHigh},#{beginWaterHigh},#{beginTemperature},#{beginVal},"
			+ "#{beginWeight},#{endOilHigh},#{endWaterHigh},#{endTemperature},"
			+ "#{endVal},#{endWeight},#{factVal},#{credenceVal},"
			+ "#{credenceNumber},#{operatorName},#{tflag})")
	public int insertONE(EnterOilRecord obj);
	
}
