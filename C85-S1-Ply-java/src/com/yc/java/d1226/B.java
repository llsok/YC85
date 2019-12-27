package com.yc.java.d1226;

public class B extends A{
	/**
	 * Implicit super constructor A() is undefined. 
	 * Must explicitly invoke another constructor
	 * 
	 * super 超类 、父类
	 * 
	 * 为什么需要父类的无参数的构造方法呢？
	 */
	public B(int a){
		// 明确的调用父类的带参数的构造方法
		super(a);
		System.out.println("B有 int 参数的构造方法");
		
		/**
		 *  The field A.priA is not visible
		 *  priA 不可见
		 */
		
		// super.priA;
		
		// 受保护的属性可以访问
		System.out.println(super.proA);
		
		// 默认作用域 A 也可以访问
		System.out.println(super.defA);
		
	}

}
