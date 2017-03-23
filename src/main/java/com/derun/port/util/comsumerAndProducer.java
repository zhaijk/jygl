package com.derun.port.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class comsumerAndProducer {
	
	public static BlockingQueue<String> xiaomiPhone=new SynchronousQueue<String>();
	
	
	public static void main(String[] args) throws InterruptedException{		
		//生产
		new Thread(new Runnable(){
			int counter=1;
			@Override
			public void run() {				
				while(true){
					try {
						comsumerAndProducer.xiaomiPhone.put("xiaomi"+counter);
						System.out.println(Thread.currentThread().getName()+"xiaomi"+counter);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
					counter++;
				}
			}
			
		},"shengchan").start();
		
		//消费者
		int number=100000000;
		for (int i = 0; i < number; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							//System.out.print(Thread.currentThread().getName()
							//		+ "   "+comsumerAndProducer.xiaomiPhone.take());
							//comsumerAndProducer.xiaomiPhone.take();
							//Thread.sleep(100);
							System.out.println(comsumerAndProducer.xiaomiPhone.take());
							Thread.sleep(100);
							break;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}, "thread" + i).start();
		}
	}
}
