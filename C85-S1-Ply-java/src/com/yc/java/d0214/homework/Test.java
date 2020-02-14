package com.yc.java.d0214.homework;

/**
 * 编写一个程序，用于创建一个名为Employee的父类和两个名为Manager和Director的子类，
 * Employee类中包含三个属性和一个方法，属性为name,basic和address,方法为show用于显示这些属性的值。
 * Manager类有一个称为department的附加属性。Director类有一个称为transportAllowance的附加属性。
 * 创建包含main方法的EmployeeTest类，在main方法创建Manager和Director类的对象,并调用show方法显示其详细信息。
	要求:
	所有类的属性通过构造方法初始化。
	name是名字、basic是基本底薪、address是地址、 transportAllowance是津贴

 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		Manager e2 = new Manager("武松", 1000f, "清河县", "销售部");
		
		e2.show();
		
	}

}
