package com.yc.api.d0225;

/**
 * 课后作业：
 * 1、请按照方法上面的注释要求完成下面类中的方法代码，包括方法体和声明抛出异常
 * 2、编写 main 方法测试所有方法是否正确
 */
public class ExceptionHomework {
	
	/**
	 * 返回2个数字中的最大值，如果出现2个数字大小一样，
	 * 请抛出异常一个名为 MaxException 的异常，异常信息提示“数值大小一致：X”，X为数值
	 * @param numbers	参数数组
	 * @return
	 */
	public int max(int a, int b){
		return -1;
	}
	
	/**
	 * 返回数组中的最大值，如果出现最大值（相同值）有多个情况，
	 * 请抛出异常一个名为 MaxException 的异常，异常信息提示“最大值重复：X”，X为最大值
	 * @param numbers	参数数组
	 * @return
	 */
	public int max(int[] numbers){
		return -1;
	}
	
	/**
	 * 请在控制台上，输出字符数组中的最大字符（char的值最大），如果出现最大值（相同值）有多个情况，
	 * 请抛出异常一个名为 MaxException 的异常，异常信息提示“最大值重复：X”，X为最大值
	 * @param numbers	参数数组
	 * @return
	 */
	public void max(char[] chars){
	}

	/**
	 * 根据出入的高度数值，在控制台输出一个金字塔，如果数值是负数，
	 * 请抛出异常一个名为 PyramidException 的异常，异常信息提示“高度值错误：X”，X为高度值
	 * 例如：输入3，控制台输出
	 *     *
	 *    ***
	 *   *****
	 * @param height	高度值
	 */
	public void printPyramid(int height){
	}
	
	/**
	 * 请统计传入的数组总奇数的个数，如果数组中不包含奇数，
	 * 请抛出一个名为 OddException 的异常，异常信息自定
	 * @param numbers
	 */
	public int countOdd(int[] numbers) {
		return -1;
	}
}
