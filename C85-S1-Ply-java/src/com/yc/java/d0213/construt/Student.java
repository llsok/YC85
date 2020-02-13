package com.yc.java.d0213.construt;

public class Student extends Person {
	
	
	// Implicit super constructor Person() is undefined for default constructor. 
	// Must define an explicit constructor
	// 父类无参数的构造方法不存在，必须明确的定义一个
	
	
	String sn;
	
	public Student(String name, int age, String sn) {
		super(name,age);  // super 用于指向父类对象
		/**
		 * 子类的构造方法则只需考虑属于自己的成员变量，不必去关注父类的情况
		 */
		this.sn = sn;
	}

}
