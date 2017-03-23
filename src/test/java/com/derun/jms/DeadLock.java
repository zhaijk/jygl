package com.derun.jms;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DeadLock {

	private volatile  int lower,upper;
	public DeadLock(int lower,int upper){
		this.lower=lower;
		this.upper=upper;
	}

	public int getLower() {
		return lower;
	}

	public synchronized void setLower(int lower) {
		if (lower > this.getLower()) 
			this.setUpper(lower);
	}

	public int getUpper() {
		return upper;
	}

	public synchronized  void setUpper(int upper) {
		if (upper < this.getUpper()) 
            this.setLower(upper);
	}
	
	public static void main(String[] args){
		final DeadLock dl=new DeadLock(0,5);
		Executor exec=Executors.newFixedThreadPool(10);
		exec.execute(new Runnable(){

			@Override
			public void run() {
				
				dl.setLower(4);
			}
			
		});
		exec.execute(new Runnable(){

			@Override
			public void run() {
				dl.setUpper(3);
				
			}
			
		});
	}
}
