package com.yc.java.d0223;

import java.util.Scanner;

/**
 * 如何处理异常？   de  bug  杀  虫子（错误）
 * 	当出现异常，那么异常出现后面的代码就不会再执行了
 * 	如果你不处理，那么异常会导致程序在此处终止
 * 
 * 	如何保证程序的强壮性（出错不退出）
 * 
 * 	try : 	检测、检查
 * 	catch：	捕获异常  解决异常
 *  finally	最终执行的代码块（不管是否有异常出现都执行）  
 *  
 *  1、try + catch 组合
 *  2、try + catch，catch...组合，catch 的异常不能重复
 *	3、try + catch，catch... + finally 组合
 */
public class Demo2 {

	public static void main(String[] args) {
		int number = 100;
		int[] a = { 1, 2, 3, 4, 5, 6, 0 };
		Scanner sc = new Scanner(System.in);
		System.out.println("开始");
		boolean bool = true;
		while (bool) {
			try {
				System.out.println("请输入数组下标：");
				int index = sc.nextInt();
				int value = number / a[index];
				System.out.println("结果值是：" + value);
				/**
				 * 请实现当用户输入 -1 时 退出循环            按下 ctrl + 鼠标点击   ==》 Java 的类
				 */
			} catch (ArithmeticException e) {
				System.out.println("数学计算错误：" + e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e) {
				// 捕获了异常，代码将会执行到这里
				System.out.println("数组索引错误：" + e.getMessage());
			} finally {
				System.out.println("本次循环结束");
			}

		}
		System.out.println("完成");
	}

}
