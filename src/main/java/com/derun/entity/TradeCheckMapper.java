package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TradeCheckMapper {
	@Select("select *  from tradecheck")
	public List<cardtrade> findALL();
	@Insert("insert into  tradecheck	 values(#{TradeDate},#{TradeTime},#{TradeType},#{GunCode},#{OilType},#{CardCode},"
	        +"#{CardType},#{Volumn},#{mileage},#{Balance},#{SendFlag},#{StationID},"+
	        "#{CardMoney},#{TFlag},#{OperatorName})")
	public int insertOne(cardtrade arg);
	@Select("select count(*) as count from tradecheck")
	public int totalCounter();
	@Delete("delete from tradecheck")
	public int deleteCounter();
}
