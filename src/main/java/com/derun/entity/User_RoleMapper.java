package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface User_RoleMapper {

	@Select("select *  from pub_user_role")
	public List<User_Role> findAll();
	@Select("select *  from pub_user_role where ur_id=#{ur_id}")
	public List<User_Role> findBy(User_Role obj);
	@Insert("insert into pub_user_role values(#{ur_id},#{user_id},#{role_id},#{enable})")
	public int insertOne(User_Role obj);
	@Update("update pub_user_role set role_id=#{role_id},user_id=#{user_id},enable=#{enable} where ur_id=#{ur_id}")
	public int updateOne(User_Role obj);
	@Delete("delete from pub_user_role where ur_id=#{ur_id}")
	public int deleteOne(User_Role obj);
	
}
