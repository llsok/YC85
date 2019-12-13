package com.yc.java.d1204;

// Eclipse 自动导入的类
import java.util.Scanner;

/**
 * 任意给一个年月，请输出该月的所有日期，按日历格式输出
 * 
 * 1、类与对象，使用 java api（应用程序接口）
 * 		Scanner 类，用于屏幕录入 
 * 2、定义函数 或 方法，帮助我们简化编程
 * 
 */
public class Calendar {

	public static void main(String[] args) {

		// 1、 从屏幕录入我显示的年月
		Scanner scanner = new Scanner(System.in); // 创建对象

		while (true) {
			// 快捷键 syso（alt + /）
			System.out.println("请输入年份：");
			int year = scanner.nextInt(); // 程序会停下来，等待用户的输入

			// 输入 0 则退出
			if (year == 0) {
				System.out.println("再见！");
				break;
			}
			
			System.out.println("请输入月份：");
			int month = scanner.nextInt();
			
			// 输入 0 则退出
			if (month == 0) {
				System.out.println("再见！");
				break;
			}
			
			// 2、 根据输入的年月，显示这个月每一天，不考虑1号星期几
			int days = getDays(year, month);

			// 3、 计算1号是星期几 1900.1.1 星期一
			// 统计天数 2019.3.1 ==> 1900.1.1 ~ 2019.2.28
			int allDays = 0;
			// 求过去的所有完整年份的天数
			for (int i = 1900; i < year; i++) {
				// i 表示的是当前的年份
				boolean isleap = isLeap(i);
				allDays += isleap ? 366 : 365;
			}
			// 求该年该月过去的天数
			for (int i = 1; i < month; i++) {
				// i 表示的是当前的月份
				// Duplicate local variable days 重复的定义变量 days
				allDays += getDays(year, i); // 将函数的返回值直接加到 allDays
			}
			// 上月最后一天是星期几
			int lastDayWeek = allDays % 7;

			System.out.println("====================="+year + "年" + month + "月=====================");
			// 输出星期数
			System.out.println("日\t一\t二\t三\t四\t五\t六");

			// 输出1号前的空格，周日在前
			for (int i = 0; i < (lastDayWeek + 1) % 7; i++) {
				System.out.print("\t");
			}

			// 4、根据1号星期数，修正日历的输出结果
			for (int i = 1; i <= days; i++) {
				// 计算星期数，注意这是周日在前的算法
				int week = (lastDayWeek + i + 1) % 7;
				// 逢周六日，给日期加上小括号
				if (week == 1 || week == 0) {
					System.out.print("(" + i + ")\t");
				} else {
					System.out.print(i + "\t");
				}
				// 如果 除 7 余 0 那么就换行
				if (week == 0) {
					System.out.println();
				}
			}
			System.out.println();

		}
		/**
		 * 作业： 
		 * 1、如果用户输入 0 年 或 0月，就退出运行 	* 
		 * 2、请实现使周日显示在日历的第一列 		***
		 * 3、请将周六和周日的日期，两边加上括号 	**
		 */

	}

	// 函数的定义语法 作用域 静态关键字 返回值 函数名( 参数列表 ) { 函数体 }
	// 判断闰年的函数
	public static boolean isLeap(int year) {
		boolean isLeap = year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
		return isLeap;
	}

	/**
	 * 请定义计算指定年月的天数的函数
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return 该月天数
	 */
	public static int getDays(int year, int month) {
		// 判断闰年
		// && 与运算符 优先级 要高于 || 或运算符
		boolean isLeap = isLeap(year);
		// 定义保存天数的变量 days
		int days;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 2:
			days = isLeap ? 29 : 28;
			break;
		default:
			days = 30;
		}
		return days;
	}

}
