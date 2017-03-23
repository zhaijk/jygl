package com.derun.jvm;

import java.util.Vector;

public class StaticRef {
	
	public void test(){
		new StaticRef().test();
	}
	public void over(){
		// int[] a = new int[2000000000];
		//int[] a = new int[2000000000];
		//for(int i=0;i<300;i++){
		//	a[i]=i;
		//}
		int counter = 0;
		while(true){
			StaticRef a1=new StaticRef();
			//System.out.println("c: "+counter+a.hashCode());
			counter++;
		}
	}
	public  static Vector v=new Vector(10);
	public static void main(String[] args){
		
//		System.out.println("---------------");
//		System.out.println(jvm.class.getClassLoader());		
//		System.out.println("---------------");
//		System.out.println(jvm.class.getClassLoader().getParent());
//		System.out.println("---------------");
//		System.out.println(jvm.class.getClassLoader().getParent().getParent());
//		//jvm.test();
//		new jvm().test();
		for(int i=0;i<1000000000;i++){
			Object obj=new Object();
			StaticRef.v.add(obj);
			System.out.println(StaticRef.v.size()+""+obj);
		}
	}
}
