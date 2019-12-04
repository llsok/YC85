package com.yc.java.d1202;

public class Demo2 {

	public static void main(String[] args) {
		int sex = 0; // 0 女 1男
		char cSex;
		/*if(sex == 0){
			cSex = '女';
		} else {
			cSex = '男';
		}*/
		cSex = sex == 0 ? '女' : '男';
		System.out.println(cSex);

		// 求 a b c 中的最大值
		int a = 30, b = 20, c = 45;
		int max;
		max = a > b ? a : b;
		// 请完成剩下代码
		max = max > c ? max : c;
		
		/**
		 * 三元表达式可以相互嵌套
		 */
		// max = a > b ? a : (  b > c ? b : c );
		
		
		
		
		System.out.println("最大值是：" + max);

	}

}
