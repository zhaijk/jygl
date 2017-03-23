package com.derun.entity;

public class AuthorityResource {
	
	private int ar_id;
	private String authority_id;
	private String resource_id;
	private int enable;
	
	public int getAr_id() {
		return ar_id;
	}
	public void setAr_id(int ar_id) {
		this.ar_id = ar_id;
	}
	public String getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(String authority_id) {
		this.authority_id = authority_id;
	}
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
}
