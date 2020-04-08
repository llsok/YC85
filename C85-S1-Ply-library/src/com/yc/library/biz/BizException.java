package com.yc.library.biz;

/**
 *	自定义业务异常
 * 1 序列化
 * 2 构造方法
 * @author 廖彦
 *
 */
public class BizException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -82953954820912237L;

	public BizException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BizException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BizException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
