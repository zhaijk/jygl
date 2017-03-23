package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface  AuthorityMapper {
		
	@Select("select * from pub_authorities")
	public List<Authority> findAll();
	@Select("select * from pub_authorities where authority_id=#{authority_id}") 
	public List<Authority> findOne(Authority obj);
	@Insert("insert into pub_authorities values(#{authority_id},#{authority_name},#{authority_description},#{enable},#{is_system_user})")
	public int insertOne(Authority obj);
	@Update("update  pub_authorities set authority_name=#{authority_name} ,"
			+ "authority_description=#{authority_description},"
			+ "enable=#{enable},is_system_user=#{is_system_user} "
			+ "where authority_id=#{authority_id}")
	public int updateOne(Authority obj);
	@Delete("delete from pub_authorities where authority_id=#{authority_id} ")
	public int deleteOne(Authority obj);
}
