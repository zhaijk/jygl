package com.derun.aopTEST;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Component;

@Service("hei")
public class haha {

	public long add() {
		System.out.println("���Ǽӷ�");
		return 0;
	}

	public long sub() {
		System.out.println("���Ǽ���");
		return 0;
	}

	public long mul() {
		System.out.println("���ǳ˷�");
		return 0;
	}

	public long div() {
		System.out.println("����	����");
		return 0;
	}

}
