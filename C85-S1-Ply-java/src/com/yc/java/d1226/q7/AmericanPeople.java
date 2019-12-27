package com.yc.java.d1226.q7;

public class AmericanPeople extends People {

	public AmericanPeople() {
		super.height = 175;
		super.weight = 150;
	}

	public void sayHello() {
		System.out.println("你好，我是美国人！");
	}

	public void americanBoxing() {
		System.out.println("直拳，上勾拳！");
	}

}
