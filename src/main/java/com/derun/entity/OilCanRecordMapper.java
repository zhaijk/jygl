package com.derun.entity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface OilCanRecordMapper {

	@Select("select *  from oildigit_record")
	public List<OilCanRecord> findALL();
	
	@Insert("insert into oildigit_record values(#{stationID},"
			+ "#{jarCode},#{collectionDate},#{collectionTime},#{oilHigh},"
			+ "#{waterHigh},#{temperature},#{oilCubage},#{oilWeight},"
			+ "#{beginWeight},#{endOilHigh},#{endWaterHigh},#{endTemperature},"
			+ "#{tFlag},#{cubage}")
	public int insertONE(OilCanRecord obj);
	public List<OilCanRecord> findBY(Map<String,Object> map);
}
