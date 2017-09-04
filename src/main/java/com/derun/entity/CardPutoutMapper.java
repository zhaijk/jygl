package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CardPutoutMapper {

	@Select("select *  from card_putout")
	public List<CardPutout> findALL();
	
	@Insert("insert into card_putout values(#{providedate},#{providetime},#{cardcode},#{guidelinecount},#{sendflag},#{oiltype},#{operatorname},#{note})")
	public int insertONE(CardPutout obj);
	
	@Select("select * from card_putout where cardcode like \"%\"#{%cardcode%}\"%\"")
	public List<CardPutout> findBy(CardPutout obj);	
	@Select("select * from card_putout where oiltype=(select b.oiltype  from cheermachine_parameter a ,oilcan_parameter b where  a.jarcode=b.jarcode and a.guncode=#{guncode})")
	public List<CardPutout> findByGuncode(String  guncode);
	@Delete("delete from card_putout")
	public int clear();
	
	@Delete("delete card_putout where cardcode=#{cardcode}")
	public int delete(CardPutout obj);
	
}