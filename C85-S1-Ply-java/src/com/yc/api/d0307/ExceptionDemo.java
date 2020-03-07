package com.yc.api.d0307;

public class ExceptionDemo {

	public static void main(String[] args) {
		
		System.out.println(func());
		
		
		try {
			test(false);
		} catch (MyException1 e) {
			System.out.println("------------" + e);
		} /* catch(MyException2 e) {
			// 运行期异常可以捕获， 但不强制要求捕获
			System.out.println("==============="+e);
			}*/
	}

	public static void test(boolean bool) throws MyException1, MyException2 {
		if (bool) {
			// 自定义编译期异常
			throw new MyException1();
		} else {
			// 自定义运行期异常
			// 如果某异常继承RuntimeException，则该异常可以不被声明( throws )
			throw new MyException2();
		}

	}

	public static int func() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

}

/**
 * 编译期异常
 */
class MyException1 extends Exception {

}

/**
 * 运行期异常
 */
class MyException2 extends RuntimeException {

}

/**
 * 运行期异常
 */
class MyException3 extends RuntimeException {

}
