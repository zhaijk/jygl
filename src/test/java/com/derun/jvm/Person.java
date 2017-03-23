package com.derun.jvm;

public class Person {
	
	public Person(String name ,String password,int age){
		this.name=name;
		this.password=password;
		this.age=age;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String password;
	private int age;
	
	
	
}
