package com.yc.api.d0225;

import java.util.Arrays;

/**
 * 课后作业：
 * 1、请按照方法上面的注释要求完成下面类中的方法代码，包括方法体和声明抛出异常
 * 2、编写 main 方法测试所有方法是否正确
 */
public class ExceptionHomework {

	public static void main(String[] args) {
		ExceptionHomework eh = new ExceptionHomework();

		try {
			System.out.println("最大值是: " + eh.max(5, 5));
		} catch (MaxException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("最大值是: " + eh.max(new int[] { 4, 63, 25, 63, 31, 12, 54 }));
		} catch (MaxException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("最大值是: " + eh.max(new char[] { 'z', 'A', '你', '你', '1', '%', ' ' }));
		} catch (MaxException e1) {
			e1.printStackTrace();
		}

		try {
			eh.printPyramid(10);
		} catch (PyramidException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("奇数个数有: " + eh.countOdd(new int[] { 432, 12, 4, 34, 124, 112 }));
		} catch (OddException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回2个数字中的最大值，如果出现2个数字大小一样，
	 * 请抛出异常一个名为 MaxException 的异常，异常信息提示“数值大小一致：X”，X为数值
	 * @param numbers	参数数组
	 * @return
	 * @throws MaxException 
	 */
	public int max(int a, int b) throws MaxException {
		System.out.println(a + "," + b);
		if (a == b) {
			throw new MaxException("数值大小一致：" + a);
		} else {
			return a > b ? a : b;
		}
	}

	/**
	 * 返回数组中的最大值，如果出现最大值（相同值）有多个情况，
	 * 请抛出异常一个名为 MaxException 的异常，异常信息提示“最大值重复：X”，X为最大值
	 * @param numbers	参数数组
	 * @return
	 * @throws MaxException 
	 */
	public int max(int[] numbers) throws MaxException {
		// 打印数组
		System.out.println(Arrays.toString(numbers));
		// 第一次for循环找出最大值
		int max = Integer.MIN_VALUE;
		for (int n : numbers) {
			if (n > max)
				max = n;
		}
		// 第一次for循环统计 max 出现的次数
		int count = 0;
		for (int n : numbers) {
			if (n == max)
				count++;
		}
		if (count > 1) {
			throw new MaxException("最大值重复：" + max);
		}
		return max;
	}

	/**
	 * 请在控制台上，输出字符数组中的最大字符（char的值最大），如果出现最大值（相同值）有多个情况，
	 * 请抛出异常一个名为 MaxException 的异常，异常信息提示“最大值重复：X”，X为最大值
	 * @param numbers	参数数组
	 * @return
	 * @throws MaxException 
	 */
	public char max(char[] chars) throws MaxException {
		// 打印数组
		System.out.println(Arrays.toString(chars));
		char max = Character.MIN_VALUE;
		for (char n : chars) {
			if (n > max)
				max = n;
		}
		// 第一次for循环统计 max 出现的次数
		int count = 0;
		for (char n : chars) {
			if (n == max)
				count++;
		}
		if (count > 1) {
			throw new MaxException("最大值重复：" + max);
		}
		return max;
	}

	/**
	 * 根据出入的高度数值，在控制台输出一个金字塔，如果数值是负数或0，
	 * 请抛出异常一个名为 PyramidException 的异常，异常信息提示“高度值错误：X”，X为高度值
	 * 例如：输入3，控制台输出
	 *     *
	 *    ***
	 *   *****
	 * @param height	高度值
	 * @throws PyramidException 
	 */
	public void printPyramid(int height) throws PyramidException {
		if (height <= 0) {
			throw new PyramidException("高度值错误：" + height);
		}
		for (int i = 0; i < height; i++) {
			// 打印每行前的空格
			for (int j = 0; j < height - i - 1; j++) {
				System.out.print(" ");
			}
			// 打印每行的 * 号
			for (int j = 0; j < (i + 1) * 2 - 1; j++) {
				System.out.print("*");
			}
			// 换行
			System.out.println();
		}
	}

	/**
	 * 请统计传入的数组总奇数的个数，如果数组中不包含奇数，
	 * 请抛出一个名为 OddException 的异常，异常信息自定
	 * @param numbers
	 * @throws OddException 
	 */
	public int countOdd(int[] numbers) throws OddException {
		// 打印数组
		System.out.println(Arrays.toString(numbers));
		int count = 0;
		for (int n : numbers) {
			// 余数是1就是奇数, 直接 加到 count 中, 节省一行代码, 哈哈
			count += n % 2;
		}
		if (count == 0) {
			throw new OddException("数组中不包含奇数");
		}
		return count;
	}
}
