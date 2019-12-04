package com.yc.java.d1202;

public class Demo4 {

	/**
	 * continue 继续，回到循环的起始处
	 * while ( 条件 ) ｛
	 * 	语句 A
	 *  语句 B
	 *  continue
	 *  语句 C
	 *  语句 D
	 * ｝
	 */
	public static void main(String[] args) {
		// 查找第 N 质数 ？

		int count = 0; // 查找到的质数的个数
		int number = 0; // 记录找到的质数
		int d = 2; // while 循环中的当前的判断是否为质数的数字
		int sum = 0;
		
		// 死循环
		a: while (true) {
			boolean isZhi = true; // 用于记录是质数的变量

			for (int i = 2; i <= d / 2; i++) {
				if (d % i == 0) {
					isZhi = false;
					//break;
					// 使用 continue 继续下一次循环
					d++;  // 测试数字 +1
					continue a; // 表示回到  while 循环的起始处
				}
			}
			// 如果当前 d 值是质数
			if (isZhi == true) {
				count++; // 记录质数的个数
				number = d; // 记录当前的质数
				sum += number;
				// 在循环的内部手动的退出循环
				if(count == 50){
					break;
				}
			}
			d++;  // 测试数字 +1
		}
		System.out.println("第" + count + "个质数是：" + number);
		System.out.println("前" + count + "个的数和是：" + sum);
	}

}
