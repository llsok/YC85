package com.yc.java.d1223;

/**
 * 导入其他包下的类
 */
// import com.yc.java.d1220.Person;

/**
 * 学生类
 * 
 * 继承关键字  extends
 * 
 * Implicit super constructor Person() 
 * is undefined for default constructor. 
 * Must define an explicit constructor
 * 父类没有无参数的构造函数
 * 
 */
public class Student extends Person{
	
	/**
	 * 展示学生的信息
	 */
	public void show(){
		// The field Person.name is not visible
		// name 属性不可见
		System.out.print("姓名："+name);
		System.out.print("，年龄："+age);
		System.out.println("，性别："+gender);
	}

}
