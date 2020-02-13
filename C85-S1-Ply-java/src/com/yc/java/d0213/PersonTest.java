package com.yc.java.d0213;

public class PersonTest {
	
	public static void main(String[] args) {
		
		Student s = new Student();
		s.age = 18;
		s.name = "李逵";
		s.sn = "123456";
		
		Teacher t = new Teacher();
		t.name = "林冲";
		t.age = 40;
		t.workAge = 10;
		
		s.eat();
		
		t.eat();
		
		/**
		 * 继承的属性和方法 不能是 private
		 */
		
	}

}
