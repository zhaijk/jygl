package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CardPutoutMapper {

	@Select("select *  from card_putout")
	public List<CardPutout> findALL();
	
	@Insert("insert into card_putout values(#{providedate},#{providetime},#{cardcode},#{guidelinecount},#{sendflag},#{oilytpe},#{operatorname},#{note})")
	public int insertONE(CardPutout obj);
	
	@Select("select * from card_putout where cardcode like \"%\"#{%cardcode%}\"%\"")
	public List<CardPutout> findBy(CardPutout obj);
	
	@Delete("delete from card_putout")
	public int clear();
	
	@Delete("delete card_putout where cardcode=#{cardcode}")
	public int delete(CardPutout obj);
	
}
