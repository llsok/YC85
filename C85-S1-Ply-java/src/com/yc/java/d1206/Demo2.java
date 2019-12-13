package com.yc.java.d1206;

import java.util.Random;

public class Demo2 {

	/**
	 * 小结：
	 * 	数组定义：
	 * 		1  int[] arr = new int[10]   
	 * 		2  int[] arr = new int[]{1,2,3}
	 *  	3  int[] arr = {1,2,3}
	 *  数组属性：length 长度
	 *  数组访问： 下标访问 0 表示第一元素，  最后一个元素的下标  length - 1
	 *  		数组名[ 下标 ]
	 *
	 * 数组的复制
	 * 	1、引用复制
	 * 	2、克隆复制
	 * 	3、arraycopy复制(高级复制，元素复制) System
	 * 
	 *  Array   Index  Out  Of  Bounds Exception
	 *  数组越界 0~51      52 or -1 
	 * 
	 */

	public static void main(String[] args) {
		/**
		 * 模拟手工切牌
		 */
		int[] poke = new int[52];
		for (int i = 1; i <= poke.length; i++) {
			System.out.print(castDisplay(i) + ",");
			poke[i - 1] = i;
		}

		System.out.println();

		// 定义随机对象
		Random rand = new Random();

		/**
		 * 实现10次切牌
		 */
		for (int i = 0; i < 10; i++) {
			// 产生切牌点   0 ~ 51
			int size = rand.nextInt(52);
			// System.out.println("切牌点：" + size);
			// 创建临时保存切牌点上面的牌的数组
			int[] poke1 = new int[size];
			// 保存切出的牌
			System.arraycopy(poke, 0, poke1, 0, size);
			// 将下面的牌复制到上面
			System.arraycopy(poke, size, poke, 0, poke.length - size);
			// 将临时保存的牌，复制回poke
			System.arraycopy(poke1, 0, poke, poke.length - size, size);
		}

		// 打印切牌后的结果
		for (int i = 0; i < poke.length; i++) {
			System.out.print(castDisplay(poke[i]) + ",");
		}
		
		/**
		 * 发牌，将52牌分给4个数组
		 */
		int[] p1 = new int[13];
		int[] p2 = new int[13];
		int[] p3 = new int[13];
		int[] p4 = new int[13];
		System.arraycopy(poke, 0, p1, 0, 13);
		System.arraycopy(poke, 13, p2, 0, 13);
		System.arraycopy(poke, 26, p3, 0, 13);
		System.arraycopy(poke, 39, p4, 0, 13);
		
		System.out.println();
		for (int i = 0; i < p1.length; i++) {
			System.out.print(castDisplay(p1[i]) + ",");
		}
		System.out.println();
		for (int i = 0; i < p2.length; i++) {
			System.out.print(castDisplay(p2[i]) + ",");
		}
		System.out.println();
		for (int i = 0; i < p3.length; i++) {
			System.out.print(castDisplay(p3[i]) + ",");
		}
		System.out.println();
		for (int i = 0; i < p4.length; i++) {
			System.out.print(castDisplay(p4[i]) + ",");
		}

		/**
		 * 作业：
		 * 1、将扑克牌显示对应的花色：
		 * 		1~13   黑桃 A ~ K
		 *		14~26 红桃 A ~ K
		 * 		27~39 梅花 A ~ K
		 * 		40~52 方块 A ~ K
		 * 2、发牌，将52牌分给4个数组
		 */

	}

	public static String castDisplay(int poke) {
		String ret = null;
		switch (poke / 13) {
		case 0:
			ret = "黑桃";
			break;
		case 1:
			ret = "红桃";
			break;
		case 2:
			ret = "梅花";
			break;
		case 3:
		case 4:
			ret = "方块";
			break;
		}
		int i = poke % 13;
		switch (i) {
		case 1:
			ret += "A";
			break;
		case 11:
			ret += "J";
			break;
		case 12:
			ret += "Q";
			break;
		case 0:
			ret += "K";
			break;
		default:
			ret += i;
		}
		return ret;
	}

	/**
	 * 引用复制
	 */
	public static void copy1() {

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = arr1; // 引用复制

		arr1[2] = 100;

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

	}

	/**
	 * 克隆复制    ctrl + shift + f 关闭输入法
	 */
	public static void copy2() {
		int[] arr1 = { 1, 2, 3, 4, 5 };

		int[] arr2 = arr1.clone(); // 克隆复制

		arr1[2] = 100;

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}

	public static void copy3() {
		int[] arr1 = { 1, 2, 3, 4, 5 };

		int[] arr2 = new int[10];

		/**
		 *  数组复制方法
		 *  参数1：src 	 原数组
		 *  参数2：srcPos	 从原数组的第几个元素开始复制，如果是第一个那么就是 0
		 *  参数3：dest	 目标数组
		 *  参数4：destPos 复制到目标数组的第几个元素位置
		 *  参数5：length  复制的元素个数
		 *  
		 */
		// System.arraycopy(src, srcPos, dest, destPos, length);
		System.arraycopy(arr1, 0, arr2, 5, arr1.length);

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ",");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + ",");
		}
	}

}

class Demo3 {

}
