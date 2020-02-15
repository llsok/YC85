package com.yc.java.d0215;

/**
 * 父类
 * 
 * 
 * 在类的继承体系结构中，如果子类中出现了与父类中有同原型(方法的签名)的方法，
 * 	那么认为子类中的方法覆盖了父类中的方法（也称为方法重写）；
	同原型：同名、同参、同返回值、访问修饰符不能小于父类
	public
	protect
	默认
	private
	
	重写：子类、同名、同参、同返回值
	重载：同类、同名、不同参数
	
	父类指向子类对象
 */
public class Parent {
	
	String name = "高俅";
	
	String like;
	
	/**
	 * 技能
	 */
	
	public void showName() {
		System.out.println( this.name);
	}
	
	public void show技能() {
		
	}
	
	public static void main(String[] args) {
		
		Child c = new Child();
		c.showName();
		
		/**
		 * 父类指向子类对象  ==> 引用转型
		 * 多态性：统一对象呈现出不同的形态（状态）
		 */
		Parent p = new Child();
		p.showName();
		
		/**
		 * Type mismatch: cannot convert from Parent to Child
		 * 类型不匹配：子类对象不能指向父类对象
		 * 
		 */
		// Child c1 = new Parent();
		
		/**
		 * 引用转型有什么限制
		 * 1、 引用转型，指向的对象还子类对象
		 * 2、尽管父类指向的是子类对象，但是你看不到子类 “扩展” 的成员
		 * 
		 * 对象成员（成员变量+成员方法）在引用转型中的访问规则（注意：一定要有重写）
		 * 1、成员方法
		 * 		既然父类的引用可以指向子类的实例，如果父类和子类中存在方法重写的情况，那么通过父类的引用将会调用到哪个类中的方法呢？
		 * 		当执行被重写的方法时：new 的那个类，就执行哪个类的方法  ==》 方法执行看（=号）右边
		 * 2、成员属性
		 * 		当访问被重写的属性是：你声明是哪个类，就访问哪个类的属性 ==> 属性访问看（=号）左边
		 * 
		 */
		//p.name;//p.like;//c.name;//c.like;//c.edu;
		System.out.println("==================================");
		
		Child c1 = new Child();
		Parent p1 = c1;
		
		System.out.println(  c1 == p1 ) ;  // true ，因为它们统一个对象
		
		p1.name="陶宗旺";
		p1.like="种地";
		c1.edu = "初中";
		
		System.out.println(c1.edu);  // 初中
		System.out.println(c1.name); // 高衙内
		System.out.println(c1.like); // 种地
		
		System.out.println("--------------");
		
		System.out.println(p1.name); // 陶宗旺
		System.out.println(p1.like); // 种地
		
		System.out.println("-------方法测试1-------");
		p1.showName();
		System.out.println("-------方法测试2-------");
		c1.showName();

		System.out.println("-------属性测试1-------");
		System.out.println( p1.name );
		System.out.println( c1.name );
		
	}

}

class Child extends Parent{
	
	String name = "高衙内";	// 重写的属性
	
	String edu;  // 学历 		// 扩展的属性
	
	/**
	 * 装备
	 */
	public void showName() {
		super.showName();
		System.out.println( this.name);
	}
	
}
