package com.yc.java.d1220;

/**
 * 人类
 * 
6，写一个类Person,包含以下属性：String name; int age; String gender;
 Person partner。为Person类写一个marry(Person  p)方法，
   代表当前对象和p结婚，如若可以结婚，则输出恭贺信息，否则输出不能结婚原因。
   要求在另外一个类中写一个主方法，来测试以上程序。
   （下列情况不能结婚：
   	1，同性； 
   	2，未达到结婚年龄，男<24，女<22；
   	3，某一方已婚）

 */
public class Person {

	private String name;
	private int age;
	// 性别
	private String gender;
	/**
	 *  配偶，也是一个人类对象, 
	 *  如果该对象为空（null）那么就是未婚
	 *  如果该对象不为空，那么就是已婚
	 *  任何一个对象属性，在没有赋值前，都是 null 值
	 */
	private Person partner;
	
	// 定义一个无参数的构造函数
	public Person(){}
	
	public Person(String name, int age, String gender, Person partner) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.partner = partner;
	}

	/**
	 * 结婚的函数，如果条件符合，p 对象最终将赋值给  partner
	 * @param p	表示结婚的对象
	 */
	public void marry(Person p) {
		/**
		 * 自己不能跟自己结婚   this != p
		 */
		
		// 同一类中可以访问另一个对象的私有属性
		if (this.gender == p.gender) {
			System.out.println("同性不婚！");
			return;
		}

		// equals 是判断字符串相同的函数
		if ("女".equals(this.gender) && this.age < 22 
				|| "男".equals(this.gender) && this.age < 24) {
			System.out.println("我还不到结婚年龄");
			return;
		}

		if ("女".equals(p.gender) && p.age < 22 
				|| "男".equals(p.gender) && p.age < 24) {
			System.out.println("对方还不到结婚年龄");
			return;
		}

		if (this.partner != null) {
			System.out.println("你来晚了！");
			return;
		}

		if (p.partner != null) {
			System.out.println("你结婚太早！");
			return;
		}
		
		this.partner = p;
		p.partner = this;
		
		System.out.println("祝福" + this.name + "和" + p.name + "白头偕老！");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Person getPartner() {
		return partner;
	}

	public void setPartner(Person partner) {
		this.partner = partner;
	}
	

}
