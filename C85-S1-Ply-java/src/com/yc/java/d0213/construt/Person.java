package com.yc.java.d0213.construt;

public class Person {
	
	String name;
	
	int age;
	
	String id;
	
	public Person() {
	}
	
	public Person(String name, int age) {
		/**
		 * 父类的构造方法负责初始化属于它的成员变量
		 */
		this.name = name;
		this.age = age;
		
		//int a = 1 / 0;
	}

}
