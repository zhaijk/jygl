package com.derun.jvm;

public class FunctionTest {
	
	public void showinfo(){
		int i=0;
		String ls[] = new String[1000000];
		while(true){
			i++;
			ls[i]=i+"Hello It's me!!!";
			System.out.println(ls[i]);
		}
	}
	
	public void over(){
		while(true){
			new Thread(new Runnable(){				
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getId());
					System.out.println(Thread.currentThread().getStackTrace());
					System.out.println(Thread.currentThread().getState());
					System.out.println(Thread.getAllStackTraces());
				}
			}
			}).start();
		}
	}
	public static void main(String[] args){
//		for(int i=0;i<100;i++)
//		new Thread(new Runnable(){
//			
//			private void loop(int i){
//				while(true){
//					//if(i<1000) 
//						i++;
//					//else
//					//	break;
//					System.out.println("counter: "+i);
//					//loop(i);
//				}
//			}
//			//@Override
//			public void run() {
//				loop(0);
//				
//			}
//			
//		}).start();
		//new FunctionTest().showinfo();
		
		
//		String a="a1";
//		String b="a"+1;
//		System.out.println(a==b);//false
//		
//		String c="1";
//		String d="a"+c;
//		System.out.println(a==d);//true
//		
//		
//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
//		System.out.println(c.hashCode());
//		System.out.println(d.hashCode());
		
		new FunctionTest().over();
		
	}
}
