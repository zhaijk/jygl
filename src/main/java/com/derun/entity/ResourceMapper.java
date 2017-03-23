package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ResourceMapper {
	
	@Select("select *  from pub_resources order by resource_id")
	public List<Resource> findAll();
	
	@Select("select *  from pub_resources where resource_name=#{resource_name}")
	public List<Resource> findOne(Resource obj);
	
	@Update("update pub_resources "
			+ "set resource_id=#{resource_id},resource_name=#{resource_name},"
			+ "resource_type=#{resource_type},priority=#{priority},"
			+ "resource_uri=#{resource_uri},enable=#{enable},is_system=#{is_system},"
			+ "resource_description=#{resource_description} where resource_id=#{resource_id}")
	public int updateOne(Resource obj);
	
	@Delete("delete from pub_resources where resource_name=#{resource_name}")
	public int deleteOne(Resource obj);
	
	@Insert("insert into pub_resources values(#{resource_id},#{resource_name},"
			+ "#{resource_type},#{priority},#{resource_uri},#{enable},"
			+ "#{is_system},#{resource_description})")
	public int insertOne(Resource obj);
	
	@Select("select a.role_name from pub_roles a,pub_roLe_authorities b,pub_authorities_resources c,pub_resources d "
			+ "where a.role_id=b.role_id and b.authority_id=c.authority_id and c.resource_id=d.resource_id and "
			+ "d.resource_uri=#{resource_id}")
	public List<String> findBy(String resource_id);
	
}
