package com.yc.java.d0210;

import java.util.Random;

/**
 * 复习：
 * 内容： Java语法基础、OOP1内容：封装
 * 流程：
 * 1、知识点回顾
 * 2、练习题10+讲解
 * 3、编程练习
 * 
 * 
 * @author hy2005zyx
 *
 */
public class Demo {
	
	public static void main(String[] args) {

		/**
		 * 	1、定义一个长度为50的整型数数组
			2、随机赋值60~100，表示数学考试的成绩
			3、请计算求出成绩的前三名（允许并列排名）
			
			取随机数
			Random r = new Random();
			r.nextInt(最大值);
		 */

		int[] scores = new int[100];
		Random r = new Random();
		for (int i = 0; i < scores.length; i++) {
			scores[i] = 60 + r.nextInt(41); // 0~99   60 + 40随机数
		}

		for (int j = 0; j < scores.length - 1; j++) {
			for (int i = 0; i < scores.length - 1 - j; i++) {
				//判斷大小
				if (scores[i] < scores[i + 1]) {
					//交換值
					int tmp = scores[i];
					scores[i] = scores[i + 1];
					scores[i + 1] = tmp;
				}

			}
		}

		// 增强for循环
		for (int s : scores) {
			System.out.println(s);
		}

		
		System.out.println("前三名（含并列）");
		// 记录当前名词的索引（下标）
		int curIndex = 0;
		
		for (int i = 0; i < 3; i++) {
			int curScore = scores[ curIndex]; // 0  =>  100;
			// j 从当前的名次索引处开始循环
			for (int j = curIndex; j < scores.length; j++) {
				if(scores[j] == curScore) {
					System.out.println(scores[j]);
				} else {
					// 记录下一个名次的分数的起始索引（下标）
					curIndex = j;
					break;
				}
			}
		}

	}

}
