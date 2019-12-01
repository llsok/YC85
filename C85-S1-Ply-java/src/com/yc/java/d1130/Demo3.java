package com.yc.java.d1130;

public class Demo3 {
	
	public static void main(String[] args) {
		
		boolean bool = true;
		System.out.println(bool);
		bool = false;
		System.out.println(bool);
		
		int a = 100;
		int b = 200;
		
		bool = a > b;
		
		System.out.println(bool);
		
		System.out.println("========  ++ -- ========");
		int i = 100;
		System.out.println(i++);
		System.out.println(i);
		i = 100;
		System.out.println("================");
		System.out.println(++i);
		System.out.println(i);
		
		System.out.println("======== 赋值 ========");
		
		i = 100;
		 
		i += 100;  // i = i + 100
		System.out.println(i);
		
		i=100;
		i -= 100;  // i = i - 100
		System.out.println(i);
		
		i=100;
		
		i *= 100;  // i = i * 100
		System.out.println(i);
		
		i=100;
		i /= 100;  // i = i / 100
		System.out.println(i);
		
		if( i == 100 ){
			// 如果等式成立  true 执行代码块
			System.out.println("奖励球鞋");
		} else {
			// 如果等式不成立  false 执行代码块
			System.out.println("罚站");
		}

	}

}
