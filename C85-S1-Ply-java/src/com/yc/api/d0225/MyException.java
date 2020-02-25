package com.yc.api.d0225;

/**
 * 自定义异常，自己定义的类继承于  Exception（编译期异常） 或者 RuntimeException（运行期异常）
 */
public class MyException extends Exception {
	/**
	 * 自定义异常的实现:
	 * 1、生成序列化版本编号（不是必须）
	 * 2、重写父类所有的构造函数
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -6800934130623408060L;

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

}
