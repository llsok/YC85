package com.yc.java.d1208;

import java.util.Random;

public class Demo1 {

	public static void main(String[] args) {

		// 二维数组的定义

		int[] arr1 = new int[10]; // 元素个数 10
		int[][] arr2 = new int[10][20]; // 元素个数 10 * 10

		// 获取数组的长度
		int l1 = arr1.length; // ==> 10
		int l2 = arr2.length; // ==> 10

		// 获取元素
		int v1 = arr1[0]; //  ==> 返回的类型  int
		/**
		 * Type mismatch: cannot convert from int[] to int
		 * 类型     不匹配               无法           转换              从         int数组 到  int
		 */

		int[] v2 = arr2[0]; //  ==> 返回的类型  int[]
		l2 = v2.length; //  ==> 20

		System.out.println(l2);

		// 给二维数组分配随机数值
		Random r = new Random();
		for (int i = 0; i < arr2.length; i++) {
			int[] arr3 = arr2[i]; // 第一维数组元素  ==》 int[]
			for (int j = 0; j < arr3.length; j++) {
				// 40 ~ 100
				int num = 40 + r.nextInt(61); // 0 ~ 60
				/**
				 * 二维数组赋值
				 */
				arr2[i][j] = num;
				// 获取元素的值
				System.out.print(arr2[i][j] + ",");
			}
			// 换行
			System.out.println();
		}

		// 查找二维数组中的最大值
		int max = -1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				if(arr2[i][j] > max){
					max = arr2[i][j];
				}
			}
		}
		System.out.println("max = " + max);
	}

}
