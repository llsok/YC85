package com.yc.java.d1130;

public class Demo2 {

	// main alt + / 代码提示，自动生成代码
	public static void main(String[] args) {
		// 关于类型转换
		byte b = 100;
		int i = b; // 将 b 变量值赋值给 i 自动类型转换
		b = (byte) i; // 将 i 变量值赋值给 b 强制类型转换

		char c = 'A';
		c = '\377';
		c = '\uffff';
		c = 'A';

		System.out.println(c); // 打印 A
		int ic = c; // 将 char 转成 int
		System.out.println(ic); // 打印出来就是 A 的编号
		System.out.println(c + 10);

		int a = 100;

		a = 0x100; // 十六进制数字表示 0x开头
		System.out.println(a);
		a = 0100; // 八进制数字表示 0开头
		System.out.println(a);

		char cc = 123; // 123 是一个 byte 类型

		float f = (float) 12.345E2;
		System.out.println(f);
		
		int  a1=123;                   
		char  b1='\u007B'; 
		
		System.out.println(a1);
		System.out.println((int)b1);  // 强制转换 char  ==》 int

	}

}
