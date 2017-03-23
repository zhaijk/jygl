package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface CardTypeMapper {
	@Select("select * from cardtype_dictionary")
	public List<CardType> findALL();
	@Select("select * from cardtype_dictionary where code=#{code}")
	public List<CardType> findBy(String code);

}
