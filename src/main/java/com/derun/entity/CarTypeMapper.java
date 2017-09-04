package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface CarTypeMapper {
	@Select("select * from cartype_dictionary order by code")
	public List<CarType> findALL();
	@Select("select * from cartype_dictionary where code=#{code}")
	public List<CarType> findBy(CarType arg);
	@Insert("insert into cartype_dictionary values(#{code},#{name},#{classcode})")
	public int insertOne(CarType arg);
	@Update("update cartype_dictionary set name=#{name},classcode=#{classcode} where code=#{code}")
	public int updateOne(CarType arg);
	@Delete("delete from cartype_dictionary where code=#{code}")
	public int deleteOne(CarType arg);
	@Delete("delete from cartype_dictionary ")
	public int clear();

}
