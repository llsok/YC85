package com.yc.java.d0213;

/**
 * 
 * extends Person 表示继承于  Person 类
 *
 */
public class Student extends Person{
	
	String sn;
	
	
	public void  myShow() {
		//System.out.println(id);  // id 是 私有的不能在子类访问
		System.out.println(name);
	}

}
