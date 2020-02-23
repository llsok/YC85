package com.yc.java.d0223;

/**
 * 重点：
 * 	如何阅读异常信息？
 * 	1、看懂第一行（看懂报错信息），搞清除报错模糊的原因
 * 		java.lang.ArithmeticException: / by zero
 * 		异常的种类（异常类）				 : 异常信息，大部分的信息都是英文
 *	2、看方法调用的栈信息
 *		查看报错的最上面的你的那行代码
 */
public class Demo1 {

	public static void main(String[] args) {
		/**
		 * 异常可分为两大类：编译时异常(错误)和运行时异常；
		 */
		a();
	}

	public static void a() {
		b();
	}

	public static void c() {
		int a23 = 1;
		System.out.println("开始");
		System.out.println("abc".substring(1));
		/**
		 * 请模拟数组越界的异常
		 */
		int[] a = {1,2};
		System.out.println(a[10]);
		//System.out.println(a23 / 0);
		// java虚拟机在里输出了异常信息
		System.out.println("完成");
	}

	public static void b() {
		c();
	}

}
