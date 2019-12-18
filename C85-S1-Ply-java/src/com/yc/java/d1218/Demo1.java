package com.yc.java.d1218;


/**
 * 定义类的格式
 * 
 * 作用域 class 类名 {
 * 
 * }
 *
 */
public class Demo1 {
	
	public static void main(String[] args) {
		// 定义一 人类对象变量
		Person p1 = new Person();
		// . 号操作符
		p1.setAge(1025);
		// The field Person.age is not visible
		// Person.age 不可见
		p1.setName("武松真的很厉害，真的厉害");
		p1.setId("430....");
		p1.eat();
		p1.sleep();
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getId());
		
		Person p2 = new Person();
		p2.setName("宋江");
		p2.setAge(200);
		
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println(p2.getId());
		p2.eat();
		p2.sleep();
	}
	
	


}
