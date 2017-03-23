package com.derun.port.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadT {

	
	public  static void main (String[] args){
		
		ExecutorService exec=Executors.newFixedThreadPool(10);
		for(int i=0;i<100;i++){
			exec.execute(new Runnable() {
				@Override
				public void run() {
					int counter = 0;
					while (true) {
						System.out.println(new SimpleDateFormat("HH:mm:ss ").format(new Date()));						
						counter++;
						try {
							Thread.sleep(1000);
							if (counter > 10) { System.out.println(Thread.currentThread().getName()+" exit.."); break;}
								
						} catch (InterruptedException e) {

						}						
					}
				}
			});
		}
	}
}
