package com.yc.java.d0216;

import java.util.Random;

/**
 * OOP编程：多态
 * 引用转型
 * 	A( name test()) ===》 B ( name test() )
 * 	B b = new B();
 * 	A a = new B();
 * 	A a = B;
 * 
 * 	属性访问看 = 号的左边
 * 	方法的调用看 =号的右边
 * 
 *	本节课内容
 * 	1、类型判断和转型
 * 		A 
 * 		==》	B 、  C 、D
 * 		A a1 = new B();
 * 		A a2 = new C();
 * 		A a3 = new D();
 *  instanceof 用于判断对象是否属于某个类或其子类
 * 
 * 
 * 
 * 	2、抽象类的定义
 * 	3、接口的定义
 * 
 * 
 */
public class Demo1 {

	public static void main(String[] args) {

		Animal a = new Cat();

		// instance 实例、对象
		if (a instanceof Cat) {
			System.out.println(" a 是一只猫");
		} else if (a instanceof Dog) {
			System.out.println(" a 是一只狗");
		} else if (a instanceof Fish) {
			System.out.println(" a 是一条鱼");
		}

		// a 既是 Cat 也是 Animal
		System.out.println(a instanceof Animal);

		long l = 100;
		int i = (int) l; // 显式转换（强制转）  潜台词：我知道这个转换有风险，但我确认没关系
		// 类型的转型， 父类 转 子类   ===》  大的基本数据类型 转 小的基本数据类型
		Cat c = (Cat) a;
		c.eat();
		// 当前的转换一定会出现错误，猫不能转成狗
		// Dog d = (Dog)a;

		/**
		 * Exception in thread "main" java.lang.ClassCastException: 
		 * com.yc.java.d0216.Cat cannot be cast to com.yc.java.d0216.Dog
			Cat 无法转成 Dog
		 */

		/**
		 * 测试代码
		 */
		Demo1 d = new Demo1();
		d.showResult();
	}

	Animal[] animals = new Animal[100];

	public Demo1() {
		// 创建随机对象
		Random r = new Random();
		for (int i = 0; i < animals.length; i++) {
			// 根据随机数的值，随机创建动物（猫、狗、鱼）对象
			Animal a = null;
			int j = r.nextInt(3);
			switch (j) {
			case 0:
				a = new Cat();
				break;
			case 1:
				a = new Dog();
				break;
			case 2:
				a = new Fish();
				break;
			}
			// 将创建的动物加入到数组中
			animals[i] = a;
		}
	}

	/**
	 * 显示结果
	 */
	public void showResult() {
		/**
		 * 1、请统计猫狗鱼的数量，并输出
		 * 2、请为狗添加玩的方法，鱼添加游泳的方法
		 * 3、循环动物数组，让所有猫狗鱼都执行各自方法
		 */
		int c = 0, d = 0, f = 0;
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] instanceof Cat) {
				c++;
				Cat cat = (Cat) animals[i];  	// 类型转换
				cat.eat();
			} else if (animals[i] instanceof Dog) {
				d++;
				Dog dog = (Dog) animals[i];		// 类型转换
				dog.play();
			} else if (animals[i] instanceof Fish) {
				f++;
				Fish fish = (Fish) animals[i];	// 类型转换
				fish.swimming();
			}
		}
		System.out.printf("一共有：%s只猫，%s只狗，%s条鱼", c, d, f);
	}
}

class Animal {

}

class Cat extends Animal {

	public void eat() {
		System.out.println("猫吃鱼");
	}

}

class Dog extends Animal {
	public void play() {
		System.out.println("狗儿在玩");
	}
}

class Fish extends Animal {
	public void swimming() {
		System.out.println("鱼儿游泳");
	}
}
