package com.derun.entity;

public class Role_authority {

	private int ra_id;
	private String role_id;
	private String authority_id;
	private int enable;
	
	public int getRa_id() {
		return ra_id;
	}
	public void setRa_id(int ra_id) {
		this.ra_id = ra_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(String authority_id) {
		this.authority_id = authority_id;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
}
