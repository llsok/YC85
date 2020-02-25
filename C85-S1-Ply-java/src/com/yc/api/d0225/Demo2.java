package com.yc.api.d0225;

/**
 * 异常类的定义
 */
public class Demo2 {

	public static void main(String[] args) {

		/**
		 * 类的构成元素（5个）：属性、函数、构造方法、块、内部类
		 */
		try {
			new Demo2().a();
		} catch (Exception e) {
			// 属性（属性方法）
			System.out.println(e.getMessage()); // 异常对象的描述信息
			System.out.println(e.getCause()); // 当前异常原因异常
			// 方法
			e.printStackTrace(); // 打印方法调用栈信息
		}
	}
	public void a() {
		b();
	}

	public void b() {
		c();
	}

	public void c() {
		d();
	}

	public void d() {
		int i = 1/0;
	}

}
