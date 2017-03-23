package com.derun.entity;

public class User_Role {

	private int 	ur_id;
	private String role_id;
	private String user_id;
	private int 	enable;

	public int getUr_id() {
		return ur_id;
	}
	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	
}
