package com.yc.java.d0216.sub;

import com.yc.java.d0216.Demo3;

/** 
 * 接口：没有任何实现的方法，只有方法原型的定义
 * 
 * interface 用定义接口   与 class 语法类似
 * 接口定义的特点：
 * 	1、接口中的方法全部是抽象方法，即使不加 abstract 关键字
 * 	2、所有方法的访问修饰符都是 public，即使不写他也是public
 * 	3、接口不能定义对象属性，定义的属性只能是 静态常量
 * 
 * 使用方式：
 * 1、  class 类 implements 接口
 * 2、  class 类 implements 接口a,接口b,接口c
 * 3、  class 类A extends 类B implements 接口a,接口b,接口c
 * 
 * 编码时使用接口
 * 	请把接口当成抽象类来对待
 */
public class InterfaceTest {

	public static void main(String[] args) {
		/*		// Demo3 d = new Dome3();  // 接口不能被创建，原因参考抽象类
				Demo3 d = null;
				// fun1   fun2   fun3   只能那种返回作用域
				1、public    Ok
				2、protected
				3、默认
				4、private
				d.fun1();
				d.fun2();
				d.fun3();
				// final 修饰的变量不允许修改
				//Demo3.a = "test";
		*/
		
		// 接口也可以作为父类对象指向子类对象
		B b = new B();
		Demo3 d3 = b;
		Demo4 d4 = b;
		Demo5 d5 = b;
		
		b.fun1();
		d3.fun1();
		
		d4.fun4();
		
	}

}

/**
 * 接口的使用，接口也可以当成父类来使用
 * implements 是实现的意思，接口类通过该关键字使用
 */
class A implements Demo3 {

	public void fun1() {
		System.out.println("fun1");
	}

	public void fun2() {
		System.out.println("fun2");
	}

	public void fun3() {
		System.out.println("fun3");
	}

}

/**
 * 接口实现可以允许多实现
 * @author hy2005zyx
 *
 */
class B implements Demo3, Demo4, Demo5 {

	public void fun4() {
		System.out.println("fun4");
	}

	public void fun1() {
		System.out.println("fun1");
	}

	public void fun2() {
	}

	public void fun3() {
	}

}

class C {

}

/**
 * 接口配合 继承关键字一同实现
 */
class D extends C implements Demo4, Demo5 {
	public void fun4() {
	}
}

interface Demo4 {
	void fun4();
}

/**
 * 接口也可以不定义任何的抽象方法， 标记接口
 */
interface Demo5 {

}
