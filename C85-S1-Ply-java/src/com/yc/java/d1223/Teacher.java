package com.yc.java.d1223;

public class Teacher extends Person{
	
	/**
	 * 子类重写父类属性
	 */
	String name;
	int age;
	
	public void display(){
		
		System.out.print("name："+name);
		System.out.print("，age："+age);
		System.out.println("，gender："+gender);
		
	}
	
	/**
	 * 子类重写父类方法
	 */
	public void eat(){
		System.out.println(name + "大口大口吃东西");
	}

}
