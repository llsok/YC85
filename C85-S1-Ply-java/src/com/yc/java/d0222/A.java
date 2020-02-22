package com.yc.java.d0222;

import com.yc.java.d0222.util.TestUtil;

/**
 * 类的构成元素：5种元素
1、属性
2、方法
3、构造方法
4、内部类
5、块
	1、看起来像一个没有方法名和参数的代码块
	2、实际上类似于一个构造方法，在构造方法前执行
	3、分类：动态块（每次创建对象都会运行）、静态块（是加载类（约等于 ~= 第一次创建对象）时运行）
 *
 */
public class A {
	
	/**
	 * 当出现类名冲突时，可以使用类的“完全限定名”
	 */
	com.yc.java.d0222.TestUtil a; // 完全限定名
	
	TestUtil b;
	
	// 动态块
	{
		System.out.println("=====动态块======");
	}
	
	// 静态块
	static {
		System.out.println("=====静态块======");
	}
	
	public A() {
		System.out.println("=====A()======");
	}
	
	public static void main(String[] args) {
		new A();
		new A();
		new A();
		
	}
	

}
