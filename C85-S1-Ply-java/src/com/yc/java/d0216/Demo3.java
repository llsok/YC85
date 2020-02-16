package com.yc.java.d0216;

public interface Demo3 {
	/**
	 * Illegal modifier for the interface method fun1; only public, 
	 * abstract, default, static and strictfp are permitted
	 * 接口方法只能使用  public  abstract  默认 进行修饰
	 */
	void fun1();
	void fun2();
	void fun3();
	
	/**
	 * Illegal modifier for the interface field Demo3.a; 
	 * only public, static & final are permitted
	 * 接口属性只能使用 public static final 进行修饰（常量）
	 */
	String a = "Test";
}

