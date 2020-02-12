package com.yc.java.d0212;

public class Test {
	public static void main(String[] args) {
		TestOverload test = new TestOverload();
		test.print(null);
		
		Test t = new Test();
		
		/*t.name;
		
		t.age;
		
		t = null;*/
	}
	
	
	String name;
	
	static int age;
	
	/**
	 * 非静态成员==》 非静态方法
	 */
	void test() {
		
		System.out.println(name);
		System.out.println(age);
	}
	
	/**
	 * 静态成员==》 静态方法 只能访问 静态变量
	 */
	static void test1() {
		//System.out.println(name);
		System.out.println(age);
	}
	
	
	
}

class TestOverload {
	public void print(String some) {
		System.out.println("String version print");
	}

	public void print(Object some) {
		System.out.println("Object version print");
	}
}