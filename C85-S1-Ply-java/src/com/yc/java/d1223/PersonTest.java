package com.yc.java.d1223;

public class PersonTest {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		p.name = "周通";
		p.age = 30;
		p.gender = "男";
		
		System.out.println(p.name);
		
		Student s = new Student();
		s.name = "李忠";
		s.age = 35;
		s.gender = "男";
		
		s.show();
		
		Teacher t = new Teacher();
		t.name = "张青";  // 子类的name，父类的name还是 null
		t.age = 32;
		t.gender = "男";
		
		t.display();
		
		p.eat();
		s.eat();
		t.eat();
		
		/**
		 * 请给学生添加学习的方法
		 * 给老师添加教学的方法
		 * 不管是学生还是老师，都有玩的方法
		 * 
		 * 老师和学生都有:生日的属性
		 * 学生有学号
		 * 老师有学历
		 * 
		 * 
		 */
		
		
		
	}

}
