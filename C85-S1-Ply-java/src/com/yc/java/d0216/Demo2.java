package com.yc.java.d0216;

/**
 * 抽象类
 * 	抽象方法：是没有方法体的方法，在参数列表后面直接用 ; 结束方法的定义
 * 
 * 1、抽象类是 用 abstract 修饰的类
 * 2、有抽象方法的类一定是抽象类
 * 3、抽象类不一定有抽象方法
 * 4、抽象类不能直接创建
 * 5、抽象类希望子类继承抽象类（类的模版），子类必须实现抽象法，否则子类也必须为抽象类
 * 6、构造方法和静态方法不可以修饰为abstract
 *
 *The type Demo2 must be an abstract class to define abstract methods
 * 当一个类中定义了一个抽象方法，那么该一定也是抽象类
 * 
 */
public abstract class Demo2 {

	/**
	 * 方法定义的必要元素：
	 * 1、返回值
	 * 2、方法名
	 * 3、参数列表
	 * 4、方法体
	 */
	// This method requires a body instead of a semicolon
	abstract void test();
	
	/**
	 * 设计过程：不涉及代码编写，只收类或接口的定义
	 * 
	 * 素描
	 * 
	 * Cannot instantiate the type Demo2
	 * 无法实例化（创建）一个抽象类对象
	 */
	public void test1() {
		Person p = new Teacher();
		p.work();
		
		p = new Programer();
		p.work();
		
		// p = new Worker();
	}

}


abstract class Person {
	String name;
	/**
	 * 工作，抽象方法
	 */
	abstract void work();
	
	abstract void play();
}


class Teacher extends Person {
	void work() {
		System.out.println("老师教书");
	}

	@Override
	void play() {
		
	}
}

abstract class Worker extends Person {
}

class Programer extends Person {
	void work() {
		System.out.println("程序员写代码");
	}

	@Override
	void play() {
		
	}
}



