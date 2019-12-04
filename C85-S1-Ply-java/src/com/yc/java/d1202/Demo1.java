package com.yc.java.d1202;

public class Demo1 {

	public static void main(String[] args) {
		int i = 6, j = 8, k = 10, m = 7;
		
		   //true      true
		if (i < j || m < k--)
			// 单 | 会使 运算符两边的表达式都会计算
			// 双 || ，如果左边成立（true） 那么右边的就不会再计算了
			k++;
		else
			k--;
		System.out.println(k);
		
		i = 6;
		j = 8;
		k = 10;
		m = 7;
		
		// false   true   false
		if (i > j && m < k--)
			// 单 & 会使 运算符两边的表达式都会计算
			// 双 && ，如果左边不成立（false） 那么右边的就不会再计算了
			k++;
		else
			k--;
		System.out.println(k);
		
	}
}
