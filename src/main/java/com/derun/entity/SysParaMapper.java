package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SysParaMapper {
	@Select("select *  from system_parameter")
	public List<SysPara> findALL();
	
	@Insert("insert into  show_parameter values(#{lastTimeCheer},#{lastTimeDate},#{oilName},"
			+ "#{balance},#{currentMileage},#{cardCode},#{carCode},#{autoCarType},#{cardType},#{beforeVal},"
			+ "#{sandFlag},#{stopDisplay},#{gotoDisplay},#{intoDisplay})")
	public int insertOne(SysPara arg);	
	
	@Delete("delete from SysPara")
	public int clear();
	
	@Update("update  system_parameter  set MachinePort=#{machinePort},MachineCount=#{machineCount},JarCount=#{jarCount},TimerInterval=#{timerInterval},UseCarType=#{useCarType},UseEspecialCard=#{useEspecialCard},InspectModel=#{inspectModel},UseAutoOffLine=#{useAutoOffLine},UseAutoGuideLine=#{useAutoGuideLine}")
	public int updateOne(SysPara arg);
}
