package com.derun.entity;

/**
 * @author Administrator
 *
 */
public class Users {

	private String user_id;
	private String user_account;
	private String user_name;
	private String user_password;
	private int enable;
	private int is_system_user;
	private String user_description;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
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
	public String getUser_description() {
		return user_description;
	}
	public void setUser_description(String user_description) {
		this.user_description = user_description;
	}
}
