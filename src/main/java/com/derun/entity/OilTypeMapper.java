package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OilTypeMapper {

	@Select("select *  from oil_dictionary order by code")
	public List<OilType> findALL();
	@Select("select *  from oil_dictionary where code=#{code}")
	public List<OilType> findBY(String code);
	@Delete("delete from  oil_dictionary")
	public int clear();
	@Delete("delete from  oil_dictionary where code=#{code}")
	public int deleteOne(OilType obj);
	@Insert("insert into oil_dictionary values(#{code},#{name},#{density},#{unitPrice},#{tMemo})")
	public int insertOne(OilType obj);	
	@Update("update oil_dictionary set name=#{name},density=#{density},unitPrice=#{unitPrice},tMemo=#{tMemo} where code=#{code}")
	public int updateOne(OilType obj);	
	
}
