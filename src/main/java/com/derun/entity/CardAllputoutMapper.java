package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CardAllputoutMapper {

	@Select("select *  from card_allputout")
	public List<CardPutout> findALL();
	
	@Insert("insert into card_allputout values(#{providedate},#{providetime},#{cardcode},#{guidelinecount},#{sendflag},#{oilytpe},#{operatorname},#{note})")
	public int insertONE(CardPutout obj);
	
	@Select("select * from card_allputout where cardcode like \"%\"#{%cardcode%}\"%\"")
	public List<CardPutout> findBy(String cardcode);
	
}
