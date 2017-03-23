package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Role_authorityMapper {

	@Select("select * from pub_role_authorities")
	public List<Role_authority> findAll();
	
	@Select("select * from pub_role_authorities where role_id=#{role_id}")
	public List<Role_authority> findBy(Role_authority obj);
	
	@Insert("insert into pub_role_authorities values(null,#{role_id},#{authority_id},#{enable})")
	public int  insertOne(Role_authority obj);
	
	@Update("update pub_role_authorities set role_id=#{role_id},authority_id=#{authority_id},enable=#{enable} where ra_id=#{ra_id}")
	public int UpdateOne(Role_authority obj);
	
	@Delete("delete from pub_role_authorities where ra_id=#{ra_id}")
	public int deleteOne(Role_authority obj);	
}
