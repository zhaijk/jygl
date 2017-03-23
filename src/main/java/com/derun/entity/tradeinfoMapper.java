package com.derun.entity;

import java.util.List;
import java.util.Map;
//import com.derun.model.QueryModel;



public interface tradeinfoMapper {
	//@Select("select *  from card_trade")
	public List<cardtrade> findALL();
	//@Insert("insert into  Card_Trade	 values(#{TradeDate},#{TradeTime},#{TradeType},#{GunCode},#{OilType},#{CardCode},"
	//        +"#{CardType},#{Volumn},#{mileage},#{Balance},#{SendFlag},#{StationID},"+
	//        "#{CardMoney},#{TFlag},#{OperatorName})")
	public int insertOne(cardtrade arg);
	//@Select("select count(*) as count from Card_Trade")
	public int totalCounter();	
	public List<cardtrade> findBY(Map<String,Object> map);
	public List<cardtrade> findOfflineALL();
	public List<cardtrade> findOnlineALL();
}
