package com.yc.java.d1206;

import java.util.Random;

public class Demo1 {

	public static void main(String[] args) {

		// 定义数组  new 用于创建引用数据类型变量（对象、实例）
		// new 表示会在 堆 内存中创建一块存储区域
		// Java 数组定义，必须必须在创建的时候，指定数组的长度（元素的个数）
		int[] arr = new int[10]; // int 数组 元素的默认值 是 0 boolean false
		int[] arr1 = new int[] { 10, 20, 30 };
		int[] arr2 = { 10, 20, 30, 50, 60 };

		// 数组的属性 和 访问方式(读写操作)
		int size = arr.length; // length（唯一属性） 代表着当前数组的长度（元素个数）
		System.out.println(arr.length);
		System.out.println(arr1.length);
		System.out.println(arr2.length);

		// 给数组元素赋值  [下标值  索引  编号  序号]
		arr[0] = 10;
		arr[1] = 20;
		arr[9] = 100;

		System.out.println("=======遍历数组=======");
		// 遍历数组  for
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// 请反序打印该数组   10个元素的数组   0 ~ 9
		System.out.println("=======反向遍历数组=======");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		
		
		System.out.println("=======数组元素随机赋值=======");
		// 查找最大值 ，随机生成数字   Random 随机类
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);  // 生成 0 ~ 99 的整数值
		}
		
		System.out.println("=======遍历数组=======");
		
		int max = -1;
		int min = 100;
		int sum = 0;  //统计数组元素之和，sum的初值为0
		// 查找最大值
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if( arr[i] > max ){
				max = arr[i];
			}
			if( arr[i] < min ){
				min = arr[i];
			}
			sum += arr[i];  // 求和
		}
		System.out.println("最大值是：" + max);
		System.out.println("最小值是：" + min);
		System.out.println("总和是：" + sum);
		// 请求出最小值
		
		/**
		 *  ctrl + s 保存
		 *  ctrl + z 回退
		 *  ctrl + y 恢复
		 */

	}

}
