package com.derun.jvm;

import java.util.HashSet;
import java.util.Set;

public class FixedSet {
	
	public static void main(String[] args){
		
		Set<Person>  persons=new HashSet<Person>();
		Person p1=new Person("��ɮ","tangs",25);
		persons.add(p1);
		persons.add(new Person("�����","shunwk",1000));
		persons.add(new Person("��˽�","zhubj",600));
		persons.add(new Person("ɳɮ","tangs",760));
		
		
		System.out.println(persons.size());
		
		//Person  p1=(Person) persons.toArray()[0];
		System.out.println(p1.hashCode()+""+p1);
		
		p1.setAge(10);
		
		System.out.println(p1.hashCode()+""+p1);
		
		persons.remove(p1);
		
		System.out.println(persons.size());
		
	}
}
