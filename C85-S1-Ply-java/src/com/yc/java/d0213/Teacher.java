package com.yc.java.d0213;

public class Teacher extends Person{
	
	int workAge;
	
	/**
	 * 子类可以重写父类的方法
	 * 
	 * 重载：同类、同名、不同参
	 * 
	 * 重写：子类、同名、同参数
	 */
	public void eat() {
		System.out.println(name + " 在大口大口的吃，很开心！！");
	}
	
	public void eat1() {
		
	}

}
