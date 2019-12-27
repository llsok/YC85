package com.yc.java.d1226.other;

import com.yc.java.d1226.A;

public class B extends A{
	
	/**
	 * Cannot reduce the visibility of the inherited method from A
	 * 重写的方法不能 降低 方法的可见性（作用域：private protected 默认   public）
	 */
	void test(){
		/**
		 * A cannot be resolved to a type
		 * A 无法解析为一个类
		 */
		
		System.out.println(super.pubA);
		
		System.out.println(super.proA); 
		
	}

}
