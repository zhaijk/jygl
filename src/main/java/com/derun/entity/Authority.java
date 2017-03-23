package com.derun.entity;

public class Authority {

	private String authority_id;
	private String authority_name;
	private String authority_description;
	private int enable;
	private int is_system_user;
	
	public String getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(String authority_id) {
		this.authority_id = authority_id;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public String getAuthority_description() {
		return authority_description;
	}
	public void setAuthority_description(String authority_description) {
		this.authority_description = authority_description;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getIs_system_user() {
		return is_system_user;
	}
	public void setIs_system_user(int is_system_user) {
		this.is_system_user = is_system_user;
	}
}
