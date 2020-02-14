package com.yc.java.d0214.homework;

public class Employee {
	
	private String name;
	
	private float basic;
	
	private String address;
	
	public Employee(String name, float basic, String address) {
		this.name = name;
		this.basic = basic;
		this.address = address;
	}
	
	public void show() {
		// printf 是格式化 打印   %s  %d 。。。 与C语言的格式化规则一致
		System.out.printf("姓名：%s   底薪：%s    地址：%s\n", name, basic, address);
	}

}
