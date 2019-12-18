package com.yc.java.d1218;

/**
 * Student 的 测试类
 * @author Administrator
 *
 */

public class StudentTest {

	public static void main(String[] args) {
		
		// The constructor Student() is undefined
		// 该构造方法未定义
		Student s1 = new Student("林冲");
		s1.addQuiz(98);
		s1.addQuiz(95);
		s1.addQuiz(99);
		s1.addQuiz(97);
		
		System.out.println(s1.getName());
		
		System.out.println("的总成绩：" + s1.getTotalScore());
		System.out.println("平均成绩：" + s1.getAverageScore());
		
		
	}
}
