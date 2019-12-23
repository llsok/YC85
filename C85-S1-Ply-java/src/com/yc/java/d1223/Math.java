package com.yc.java.d1223;

/**
 * 数学计算类，方法重载
 */
public class Math {
	
	// 加法方法
	public int add(int a, int b){
		System.out.println("=====int=======");
		return a + b;
	}
	
	// 参数的类型不同
	public double add(double a, double b){
		System.out.println("=====double=======");
		return a + b;
	}
	
	// 参数的数量不同
	public int add(int a, int b, int c){
		System.out.println("=====int a b c =======");
		return a + b + c;
	}
	
	// 参数类型的顺序不同
	public double add (double a, int b){
		return a + b;
	}
	
	// 参数类型的顺序不同
	public double add (int b, double a){
		return a + b;
	}
	
	/**
	 * 绝对值函数，请完成 double 类型的 abs 函数重载
	 * @param a
	 * @return
	 */
	public int abs(int a){
		return a >= 0 ? a : -a;
	}
	

}
