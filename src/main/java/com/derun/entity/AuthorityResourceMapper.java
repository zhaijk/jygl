package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AuthorityResourceMapper {

	@Select("select * from pub_authorities_resources")
	public List<AuthorityResource> findAll();
	@Select("select * from pub_authorities_resources where ar_id=#{ar_id}") 
	public List<AuthorityResource> findBy(AuthorityResource obj);
	@Insert("insert into pub_authorities_resources values(#{authority_id},#{resource_id},#{enable})")
	public int insertOne(AuthorityResource obj);
	@Update("update  pub_authorities_resources set authority_id=#{authority_id} ,"
			+ "resource_id=#{resource_id},"
			+ "enable=#{enable}"
			+ "where ar_id=#{ar_id}")
	public int updateOne(AuthorityResource obj);
	@Delete("delete from pub_authorities_resources where ar_id=#{ar_id} ")
	public int deleteOne(AuthorityResource obj);
	
}
