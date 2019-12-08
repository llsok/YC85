package com.yc.java.d1208;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {

		// 多维数组，可以只定义第一维的长度

		// int[] arr1 = new int[5];  //==>  {0,0,0,0,0}

		// 二维数组未指定第二维的长度，那么第一维数组的元素值 是  null
		int[][] arr = new int[5][]; //==> arr[0] 类型？ 数组 int[]

		// 增强 for 循环
		/*int[] i  = arr[0];
		 i  = arr[1];
		 i  = arr[2];
		 i  = arr[3];
		 i  = arr[4];*/

		for (int[] i : arr) {
			System.out.print(i + ",");
		}
		System.out.println("\n\n");

		arr[0] = new int[] { 1, 2, 3, 4, 5 };
		arr[1] = new int[] { 6, 7, 8 };
		arr[2] = new int[] { 9, 10, 11, 12 };
		arr[3] = new int[] { 13, 14, 15, 16, 17, 18, 19, 10 };

		/**
		 * 用户输入 二维数组的下标值，输出二维数组的元素值
		 */
		Scanner s = new Scanner(System.in);
		while (true) {
			//arr[4] = ??? ==> null
			// 使用增强for循环 遍历二维数组
			for (int[] i : arr) {
				// i 是返回的 一维数组      NullPointerException 空指针异常
				if (i == null) {
					// 如果 i == null 那么就回到循环的开始处
					continue;
				}
				for (int j : i) {
					System.out.print(j + ",");
				}
				System.out.println();
			}

			System.out.print("请输入二维数组的第一维下标：");
			int i = s.nextInt();
			System.out.print("请输入二维数组的第二维下标：");
			int j = s.nextInt();

			System.out.println("数组的元素值：" + arr[i][j]);

		}

	}

}
