package com.yc.java.d0218;

public class Demo1 {
	
	/**
	 * 1、类型判断和类型转换
	 * A a = new B();
	 *  a instanceof B   ==> true
	 *  a instanceof C   ==> false
	 *  a instanceof A   ==> true
	 *  instanceof 用于判断对象是否是属于某类或其父类
	 *  强制类型转换
	 *  B b = (B) a;   // 父 转 子
	 *  
	 *  2、抽象类
	 *  	1、使用 abstract 修饰的类
	 *  	2、有抽象方法（被abstract修饰的方法）的类一定是抽象类
	 *  
	 * 	3、接口
	 * 		1、所有的方法都是抽象的，那么就可以将其定义为接口
	 * 		2、接口的方法都是共有的，即使不加 public，同时也是没有方法体
	 * 		3、接口定义的变量都是常量： public static final
	 * 
	 * 		接口实现语法：
	 * 		1、class A implements B;
	 * 		2、class A implements B,C,D;  // 接口可以多实现 
	 * 		3、class A extends X implements B,C,D;
	 * 		4、interface A extends B			// 接口继承接口
	 * 
	 */

}
