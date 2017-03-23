package com.derun.aopTEST;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Component;

@Service("hei")
public class haha {

	public long add() {
		System.out.println("我是加法");
		return 0;
	}

	public long sub() {
		System.out.println("我是减法");
		return 0;
	}

	public long mul() {
		System.out.println("我是乘法");
		return 0;
	}

	public long div() {
		System.out.println("我是	除法");
		return 0;
	}

}
