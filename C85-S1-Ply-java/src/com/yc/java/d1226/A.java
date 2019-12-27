package com.yc.java.d1226;

public class A {
	
	private int priA = 100;
	public  int pubA = 200;
	
	protected int proA = 300;  // 受保护的属性
	int defA = 400; 		   // 默认访问域的属性

	public A() {
		System.out.println("A的无参数的构造方法");
	}

	public A(int a) {
		System.out.println("A有 int 参数的构造方法");
	}

	private void test() {

	}

}
