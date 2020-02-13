package com.yc.java.d0213.construt;

public class PersonTest {
	public static void main(String[] args) {
		/**
		 * 1、每个类，系统都会默认提供一个无参数的构造方法
		 * 2、如果自定义有参数的构造方法，那么无参数的构造方法就会失效
		 * 
		 * 3、每个构造方法都必须先执行   父类的构造方法
		 * 
		 * 
		 * 	父类中的构造方法不能被子类继承，即便它是public的；
			父类的构造方法负责初始化属于它的成员变量，而子类的构造方法则只需考虑属于自己的成员变量，不必去关注父类的情况。
			
			当实例化子类的对象时，必须先执行父类的构造方法，然后再执行子类的构造方法；
			如果父类还有更上级的父类，就会先调用最高父类的构造方法，再逐个依次地将所有继承关系的父类构造方法全部执行；
			如果父类的构造方法执行失败，那么子类的对象也将无法实例化。
		 * 
		 */

		/*Person p = new Person("周通", 23);
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println("==================================");*/
		
		Student s = new Student("李忠", 40, "123456");
		System.out.println(s.name);
		System.out.println(s.age);
		System.out.println(s.sn);
		
		
		/**
		 * 
			作业一：
			 设计一个班级学生管理系统,要求如下:
			1.班级共有三十名学生，首先请在系统中初始化他们的姓名和年龄.
			2. 提供查找所有的学生信息的方法
			3. 提供根据姓名查找学生的方法，并将查出来的学生信息显示出来,  使用 == 比较名字是否相同
			4. 提供根据姓名查找学生并修改学生的年龄的方法.
			类结构设计参照如下:
			
			作业二：
			默写：访问控制权限列表
			检查：excel、word 表格，截图发送群中
			
			作业三：
			章节刷题
			
		 */
		
		Classes classes = new Classes();
		
		String a = "张三";
		String b = "张三";
		System.out.println(a == b);
		
		classes.query();
		
		classes.find("宋江");
		
		classes.edit("宋江");
		
	}

}
