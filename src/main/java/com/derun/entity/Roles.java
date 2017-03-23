package com.derun.entity;

public class Roles {
	
	private String role_id;
	private String role_name;
	private int enable;
	private int is_system_role;
	private String role_description;

	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getIs_system_role() {
		return is_system_role;
	}
	public void setIs_system_role(int is_system_role) {
		this.is_system_role = is_system_role;
	}
	public String getRole_description() {
		return role_description;
	}
	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
}
