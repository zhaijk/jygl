package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface BlackListMapper {
 
	@Select("select * from blacklist")
	public List<Blacklist> findALL();
	@Select("select *  from blacklist where cardcode = #{code}  ")
	public List<Blacklist> findOne(String code);
	@Select("select *  from blacklist where cardcode like \"%\" #{code} \"%\"")
	public List<Blacklist> findBy(String code);
	@Insert("insert into blacklist values(#{cardcode})")
	public int insertOne(Blacklist obj);
	@Delete("delete from blacklist where cardcode =#{cardcode}")
	public int deleteOne(Blacklist obj);
	@Delete("delete from blacklist")
	public int clear();
	
}
