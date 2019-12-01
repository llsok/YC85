package com.yc.java.d1201;

public class Demo3 {
	public static void main(String[] args) {
		/**
		 * 1、能被 4 整除 并且 不能被 100 整除
		 * 2、能被 400 整除
		 */
		// 闰年计算
		int year = 2016;
		int month = 2; // 月份
		boolean isLeap = false;
		// & |
		if (year % 4 == 0 & year % 100 != 0 | year % 400 == 0) {
			System.out.println(year + "是闰年");
			isLeap = true;
		} else {
			System.out.println(year + "不是闰年");
		}

		int days = 0;
		// if 判断的写法
		// 任意给以年份和月份，输出该月的天数
		if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
			days = 31;
		} else if (month == 4 | month == 6 | month == 9 | month == 11) {
			days = 30;
		} else if (isLeap) {
			days = 29;
		} else {
			days = 28;
		}

		// switch 判断的写法
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if (isLeap) {
				days = 29;
			} else {
				days = 28;
			}
			break;
		default:
			days = 31;
		}

		System.out.println(year + "年" + month + "月" + "有" + days + "天");

	}

}
