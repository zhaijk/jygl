package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SysParaMapper {
	@Select("select *  from system_parameter ")
	public List<SysPara> findALL();
	
	@Select("select *  from system_parameter limit 1")
	public SysPara findOne();
	
	@Insert("insert into  system_parameter values(#{machinePort},#{liquidPort},#{readerPort},"
			+ "#{pcToPcPort},#{timerInterval},#{machineCount},#{jarCount},#{execPath},#{stationBenelux},#{stationName},"
			+ "#{stationCode},#{headQuartersCortrolCode},#{amountCortrolCode},#{useCarType},"
			+ "#{useEspecialCard},#{inspectModel},#{useAutoOffLine},#{useAutoGuideLine},"
			+ "#{numberScreenWordColor},#{numberScreenBackgroundColor},#{buttonWordColor},#{buttonBackgroundColor},"
			+ "#{showWordColor},#{showBackGroundColor},#{dataShowWordCowlor},#{dataShowBackgroundColor},"
			+ "#{backgroundBmp},#{systemKey})")
	public int insertOne(SysPara arg);	
	
	@Delete("delete from system_parameter")
	public int clear();
	
	@Update("update  system_parameter  set MachinePort=#{machinePort},MachineCount=#{machineCount},JarCount=#{jarCount},TimerInterval=#{timerInterval},UseCarType=#{useCarType},UseEspecialCard=#{useEspecialCard},InspectModel=#{inspectModel},UseAutoOffLine=#{useAutoOffLine},UseAutoGuideLine=#{useAutoGuideLine}")
	public int updateOne(SysPara arg);
}
