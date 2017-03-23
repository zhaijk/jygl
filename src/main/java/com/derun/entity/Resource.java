package com.derun.entity;

public class Resource {
	
	private String resource_id;
	private String resource_name;
	private String resource_type;
	private int priority;
	private String resource_uri;
	private int enable;
	private int is_system;
	private String resource_description;
	
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getResource_uri() {
		return resource_uri;
	}
	public void setResource_uri(String resource_uri) {
		this.resource_uri = resource_uri;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getIs_system() {
		return is_system;
	}
	public void setIs_system(int is_system) {
		this.is_system = is_system;
	}
	public String getResource_description() {
		return resource_description;
	}
	public void setResource_description(String resource_description) {
		this.resource_description = resource_description;
	}	
}
