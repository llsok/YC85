package com.yc.api.d0228;

public class Demo {

	public static void main(String[] args) {
		B b = new B();
		System.out.println(B.b);
		System.out.println(b.b);
		System.out.println(getVal(null));
		System.out.println(getVal("x"));
		System.out.println(getVal("-2"));
		System.out.println(getVal("10"));
	}

	public static int getVal(String str) {
		/**
		 * finally 代码块会在  return 前执行, 但是不会影响return的值
		 */
		int val = 0;
		try {
			val = Integer.parseInt(str);
			return val;
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			return val;
		} finally {
			val = -1;
		}
	}
}

//一个类有基类、内部有一个其他类的成员对象，构造函数的执行顺序是怎样的
/**
 * 1, 父类的构造函数先执行 
 * 2, 属性的创建先于构造函数
 */
class A {
	
	
	
	A(){
		System.out.println("A");
	}
}

class B extends A{
	static B b = new B();
	B(){
		System.out.println("B");
	}
	C c = new C();
}

class C {
	C(){
		System.out.println("C");
	}
}























