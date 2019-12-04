package com.yc.java.d1202;

public class Demo3 {

	public static void main(String[] args) {

		// 判断 d 是否为质数

		// 查找第 N 质数 ？

		int count = 0; // 查找到的质数的个数
		int number = 0; // 记录找到的质数
		int d = 2; // while 循环中的当前的判断是否为质数的数字
		int sum = 0;
		
		// 2 3 5 7 11 13 17 19 23 29 31
		while (count < 50) {
			boolean isZhi = true; // 用于记录是质数的变量
			/**
			 *  d 值 除以 2 必须使用   <= 判断     d=4    4 / 2 == 2  2 <= 2
			 */
			for (int i = 2; i <= d / 2; i++) {
				if (d % i == 0) {
					isZhi = false;
					break;
				}
			}
			// 如果当前 d 值是质数
			if (isZhi == true) {
				count++; // 记录质数的个数
				number = d; // 记录当前的质数
				sum += number;
			}
			d++;
		}
		// System.out.println(d + ( isZhi ? "是" : "不是" ) + "质数");
		System.out.println("第" + count + "个质数是：" + number);
		System.out.println("前" + count + "个的数和是：" + sum);
	}

}
