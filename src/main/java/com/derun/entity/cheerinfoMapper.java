package com.derun.entity;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface cheerinfoMapper {
	@Select("select * from CheerMachine_Parameter order by GunCode")
	public List<cheerMachine> findALL();
	@Select("select Name from Oil_Dictionary where code=(select oilType from Oilcan_Parameter where JarCode=(select JarCode from CheerMachine_Parameter where Guncode =#{guncode})) ")
    public String findOilType(String guncode);
	@Select("select oilType from Oilcan_Parameter where JarCode=(select JarCode from CheerMachine_Parameter where Guncode =#{guncode}) ")
    public String findOilTypeCode(String guncode);	
	@Update("update CheerMachine_Parameter set machineCode=#{machineCode},jarCode=#{jarCode},machineType=#{machineType},alleywayMark=#{alleywayMark} where gunCode=#{gunCode}")
	public int updateOne(cheerMachine obj);
	@Insert("insert into CheerMachine_Parameter values(#{gunCode},#{machineCode},#{jarCode},#{machineType},#{alleywayMark})")
	public int insertOne(cheerMachine obj);
	@Delete("delete from cheerMachine_Parameter where gunCode=#{gunCode}")
	public int deleteOne(cheerMachine obj);
	@Delete("delete from cheerMachine_Parameter")
	public int clear();
}
