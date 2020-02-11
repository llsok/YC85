package com.yc.java.d0211;

public class Demo {

	/**
	 * 方法重载
	 */
	int abs(int num) {
		/*if (num > 0) {
			return num;
		} else {
			return -num;
		}*/
		/**
		 * 使用 三元表达式完成该函数
		 */
		return num > 0 ? num : -num;
	}

	double abs(double num) {
		return num > 0 ? num : -num;
	}

	/*	
	 	double abs(double num, float b) {
			return num > 0 ? num : -num;
		}
	
		double abs(float b, double num) {
			return num > 0 ? num : -num;
			
		}*/	
	
	/**
	 * 重载的要素：
	 * 1、方法名相同
	 * 2、参数不同
	 * 		1、参数类型不同
	 * 		2、参数的数量不同
	 * 		3、参数的顺序不同
	 * 
	 * 请为 所有数字类型定义个abs 函数
	 */

	public static void main(String[] args) {

		Demo d = new Demo();

		System.out.println(d.abs(5));
		System.out.println(d.abs(-8));

		/**
		 * The method abs(int) in the type Demo is not applicable for the arguments (double)
		 * 
		 * 重载方法
		 */
		System.out.println(d.abs(-5.5));

	}

}
