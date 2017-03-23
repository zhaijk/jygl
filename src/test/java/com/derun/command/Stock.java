package com.derun.command;

public class Stock {

	private String name="";
	private int quantity=10;
	
	public void buy(){
		quantity++;
		System.out.println("Name: "+name+" Quantity: "+quantity);
	}
		
	public void sell(){
		quantity--;
		System.out.println("Name: "+name+" Quantity: "+quantity);
	}
}
