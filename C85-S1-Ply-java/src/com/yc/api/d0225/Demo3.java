package com.yc.api.d0225;

/**
 * 	以返回值返回错误信息的方式，有局限性
 * 	
 *  	解决方案：
 *  	抛出自定义异常
 * 
 */
public class Demo3 {

	/**
	 * 登录的方法, 假设正确的用户名是：yc，  密码是：123
	 * @param name 用户名
	 * @param pwd  密码
	 * @return	登录是否成功
	 * 
	 * throws 用于声明  方法可能抛出的异常类型
	 * throw 用于抛出异常对象
	 */
	public boolean login(String name, String pwd) throws MyException {
		if (name == null) {
			// 用户名为空
			// 创建异常对象
			MyException e = new MyException("用户名为空");
			// 抛出异常
			// Unhandled exception type MyException
			// 未处理的异常,我们的处理方式是：不处理！！！
			// 抛出异常是为了让外部程序知道这里错了
			throw e; // int i = 1/0;

		}
		if (pwd == null) {
			// 密码为空
			throw new MyException("密码为空");
		}
		if ("yc" == name && "123" == pwd) {
			return true;
		} else {
			// 用户名或密码错误
		}

		return false;
	}

	public static void main(String[] args) {

		Demo3 d = new Demo3();
		boolean bool;

		try {
			bool = d.login("yc", "123");
			System.out.println(bool);
		} catch (MyException e) {
			e.printStackTrace();
		}

		try {
			bool = d.login(null, "123");
			System.out.println(bool);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			bool = d.login("demo", null);
			System.out.println(bool);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
