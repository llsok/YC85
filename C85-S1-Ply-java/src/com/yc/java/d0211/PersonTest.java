package com.yc.java.d0211;

import java.util.Arrays;

public class PersonTest {
	public static void main(String[] args) {
		
		/**
		 * The constructor Person() is undefined
		 * 构造方法  Person() 未定义
		 */
		Person p1 = new Person("武松", '男', 35);
		p1.show();
		
		Person p2 = new Person("林冲", '男', 42);
		p2.show();
		
		Person p3 = new Person("孙二娘", '女', 43);
		p3.show();
		
		// 菜园子 张青
		
		p1.marry(p2);
		
		p2.marry(p3);
		
		
		Person.showCount();  // ?? 1 2  3
				
		
		/**
		 * 不创建见对象，不影响对静态属性的访问，原因：静态的属性不属于对象，
		 * 属于类，只有一个
		 * 对count的访问不需要对象
		 * 
		 * The static field Person.count should be accessed 
		 * in a static way
		 * 静态属性  Person.count  请使用 类 来访问 ==》该属性不属于某个对象，
		 * 是属于类的
		 * 
		 */
		// 不建议使用这种方式
		System.out.println( p1.count   );
		System.out.println( p2.count   );
		System.out.println( p3.count   );
		
		// 建议使用这种方式
		System.out.println( Person.count   );
		
		
		
		
		/**
		 * Arrays 数据工具类
		 */
		int[] arr = {4,7,4,2,1,4,6,78,3,2,5,3,2,3,4};
		
		Arrays.sort(arr);
		
		for(int a : arr) {
			System.out.println(a);
		}
		
		/**
		 * 总结：
		 * 1、方法重载：在同一个类中，出现：方法名相同，参数不同
		 * 		1、类型不同
		 * 		2、顺序不同
		 * 		3、数量不同
		 * 2、this 关键字
		 * 		p1.show();
		 * 		在对象内部引用当前对象，就必须使用  this
		 * 3、静态
		 * 		1、静态属性
		 * 		2、静态方法
		 * 
		 * 		特点：使用类型访问、请忘记对象没有this
		 * 
		 * 作业：
		 * 	1、章节刷题
		 * 	2、资源库 OOP封装练习
		 */
		
		
		
		
		
		
		
		
		
	}
}
