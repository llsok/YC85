package com.yc.java.d1218;

/**
 * 
 *实现一个Student类。学生应有姓名和总分。提供一个适当的构造方法以及
 *getName(), addQuiz(int score), getTotalScore()和
 *getAverageScore()方法。为了计算后者，需要存储学生所参加的测验数.
 *
 */
public class Student {
	
	private String name;		// 姓名
	private double totalScore;	// 总分
	
	private int count;			// 记录测试的次数
	
	/**
	 * 通过构造函数给属性赋值
	 * @param name
	 */
	public Student(String name){
		this.name = name;
	}
	
	/**
	 * 添加一次测试的成绩
	 * @param score
	 */
	public void addQuiz(int score){
		count ++;
		totalScore += score;
	}
	
	/**
	 * 返回该学的总分数
	 * @return
	 */
	public double getTotalScore(){
		return totalScore;
	}
	
	/**
	 * 计算并返回平均成绩
	 * @return
	 */
	public double getAverageScore(){
		return totalScore / count;
	}

	public String getName() {
		return name;
	}

}
