package com.derun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersMapper {
	
	@Select("select *  from pub_users order by user_id")
	public List<Users> findAll();
		
	@Select("select *  from pub_users where user_name=#{user_name} order by user_id")
	public List<Users> findBy(Users obj);
	
	@Select("select user_password  from pub_users where user_name=#{user_name} order by user_id")
	public String findByName(String user_name);
	
	@Select("select user_account  from pub_users where user_name=#{user_name}")
	public String findAccountByName(String user_name);
	
	@Select("select r.role_name  from pub_users u,pub_user_role ur,pub_roles r where u.user_name=#{user_name} and u.user_id=ur.user_id and ur.role_id=r.role_id")
	public List<String> findRoleByName(String user_name);	
	
	@Insert("insert into pub_users values(#{user_id},#{user_account},#{user_name},#{user_password},#{enable},#{is_system_user},#{user_description})")
	public int InsertOne(Users obj);
	
	@Update("update pub_users set user_password=#{user_password},user_name=#{user_name} where user_id=#{user_id}")
	public int updateOne(Users obj);
	
	@Delete("delete from  pub_users where user_id=#{user_id}")
	public int deleteONE(Users obj);
}
