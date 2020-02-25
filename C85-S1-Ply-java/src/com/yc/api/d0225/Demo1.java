package com.yc.api.d0225;

public class Demo1 {

	public static void main(String[] args) {

		/**
		 * 如果处理的多个异常之间有继承关系，那么JDK要求父异常必须位于子异常下面
		 */
		try {
			int[] a = { 1, 2, 3, 4 };
			System.out.println(a[4]);
		} catch (ArrayIndexOutOfBoundsException e) {  // 子异常
			System.out.println("子异常 "+e.getMessage());
		} catch (IndexOutOfBoundsException e) {			// 父异常
			// 如果父异常出现自异常的 catch 语句前，会导致自异常 catch 失效
			/**
			 * Unreachable catch block for ArrayIndexOutOfBoundsException.
				It is already handled by the catch block for
				IndexOutOfBoundsException
				代码不可达
			 */
			System.out.println("父异常 "+e.getMessage());
		} finally {
			System.out.println("结束");
		}
		
		/**
		 * 捕获父异常可以附带捕获其子异常
		 */
		try {
			int[] a = { 1, 2, 3, 4 };
			System.out.println(a[4]);
		} catch (Exception e) {// 父异常
			System.out.println("父异常 "+e.getMessage());
		} finally {
			System.out.println("结束");
		}

	}

}
