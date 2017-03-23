package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RolesMapper {

	@Select("select *  from pub_roles order by role_id")
	public List<Roles> findALL();
	
	@Select("select *  from pub_roles where role_name=#{role_name} order by role_id")
	public List<Roles> findBy(Roles obj);
	
	@Update("update pub_roles set role_name=#{role_name},enable=#{enable},is_system_role=#{is_system_role},role_description=#{role_description} where role_id=#{role_id}")
	public int  updateOne(Roles obj);
	
	@Insert("insert into pub_roles values(#{role_id},#{role_name},#{enable},#{is_system_role},#{role_description})")
	public int insertONE(Roles obj);
	
	@Delete("delete from  pub_roles where role_id=#{role_id}")
	public int deleteONE(Roles obj);
	
}
