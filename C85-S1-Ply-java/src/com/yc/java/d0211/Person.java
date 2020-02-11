package com.yc.java.d0211;

/**
 * 人类
 * @author hy2005zyx
 *
 */
public class Person {

	private String name;

	private char sex;

	private int age;

	public void show() {
		//char sex='男';
		System.out.println("姓名：" + this.name + "  性别：" + this.sex + "   年龄：" + age);
		// 使用 this 調用其他实例方法
		//this.hello();
	}

	public void hello() {
		System.out.println("你好 " + name);
	}

	/**
	 * 结婚：
	 * 配偶：partner
	 * 规则：
	 * 	1、同性不婚
	 * 	2、合法年龄：男：22岁，女：20岁
	 * 	3、不能重婚
	 */
	private Person partner;

	/**
	 * 结婚的方法
	 * @param parter
	 */
	public void marry(Person partner) {
		this.show();
		partner.show();
		if (this.sex == partner.sex) {
			System.out.println("=========同性不婚========");
			return;
		}
		/**
		 * 年龄判断作为练习
		 */
		if (this.sex == '男' && this.age < 22) {
			System.out.println("=========我的年龄不够========");
			return;
		}
		/*if(this.sex == '男' && this.age < 22) {
			System.out.println("=========我的年龄不够========");
			return;
		}if(this.sex == '男' && this.age < 22) {
			System.out.println("=========我的年龄不够========");
			return;
		}if(this.sex == '男' && this.age < 22) {
			System.out.println("=========我的年龄不够========");
			return;
		}*/

		if (this.partner != null) {
			System.out.println("=========我已婚========");
			return;
		}
		if (partner.partner != null) {
			System.out.println("=========对方已婚========");
			return;
		}
		/**
		 * 结婚仪式
		 */
		// 将传入的对象 赋值给 当前对象的配偶变量 
		this.partner = partner;
		partner.partner = this;
		System.out.println("========祝愿新人白头偕老=========");
	}

	/**
	 * 	如果想知道某个类创建过多少个对象
	 * 
	 *  static 表示该属性或方法 是静态的，静态的属性不属于某一个对象，
	 *  属于整个类的，所有的对象共享同一个静态属性
	 */

	static int count; //  int 实例变量的初始值 是 0

	/**
	 * 告警：This method has a constructor name
	 * 这个普通方法使用了 构造方法的 名字
	 */
	public Person(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		System.out.println("构造方法执行");
		// 计数器加一
		count++;
	}

	/**
	 * 静态方法 
	 * Cannot make a static reference to the non-static field name
	 * 不能在静态方法中引用 非静态的属性（成员变量）
	 */
	public static void showCount() {
		System.out.println("创建了" + count + "个对象");
	}
	
	/**
	 * 	静态成员变量
	 * 	在成员变量前加static关键字，可以将其声明为静态成员变量；
		如果类中成员变量被定义为静态，那么不论有多少个对象，静态成员变量只有一份内存拷贝，即所有对象共享该成员变量；
		静态成员变量的作用域只在类内部，但其生命周期却贯穿整个程序。
	 * 
	 * 	静态成员变量的注意事项
	 * 	和程序同生命周期；
		在没有实例化对象时，可以通过类名访问静态成员变量；
		也可以通过对象访问静态成员变量，但不论使用的是哪个对象，访问到的都是同一个变量；
		静态成员变量在声明时最好初始化，如果不进行初始化，系统会默认初始化为0。

	 * 	静态成员方法
	 * 	在成员方法前加static关键字，可以将其声明为静态成员方法；
		静态成员方法只能对类的静态成员变量进行操作；
		静态成员方法没有this引用；
		在没有实例化对象时，可以通过类名访问静态成员方法。

	 *	静态方法的用途：
	 *		使用静态方法定义工具类
	 * 
	 */
	
	

}
