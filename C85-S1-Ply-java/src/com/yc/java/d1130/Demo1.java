package com.yc.java.d1130;

public class Demo1 {
	
	public static void main(String[] args){
		// 0.4 是  double 类型
		float f1 = 0.4f;
		double d1 = 0.4;
		
		// 输出 f1 和 d1 是否相等，结果为 false（不相等）
		System.out.println(f1 == d1 );
		
		// 交换 a b 值
		int a = 100;
		int b = 200;
		
		// 打印 a b 值
		System.out.println(a + "   " + b);
		
		int c = a;   // 将a值赋值给c
		a = b;
		b =c;
		System.out.println(a + "   " + b);
		
		// 不使用第三变量 交换 a b
		// a + b 赋值给  a
		a = a + b;  // a 200  b 100
		// a 减去 b == ？    a 300   b 100
		b = a - b;
		a = a - b;    // a  300   b 200  
		System.out.println(a + "   " + b);
		
		// 使用 异或运算符 ^ 实现交换
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + "   " + b);
	}

}
