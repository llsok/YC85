package com.yc.java.d0213;

public class Person {

	// protected 子类可以访问，包内可以访问
	protected String name;

	// 没有定义访问修饰符，那么就是缺省访问作用域
	int age;
	
	private String id;  // 身份证
	
	public void eat() {
		System.out.println(name + " 在吃！！！！");
	}
	
	void showId() {
		System.out.println(id);
	}
	
	void showName() {
		System.out.println(name);
	}

}

