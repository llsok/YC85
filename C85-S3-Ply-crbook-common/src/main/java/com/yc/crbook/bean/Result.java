package com.yc.crbook.bean;

public class Result<T> implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code; // 0失败，  1成功
	private String msg;
	private T data;
	
	/**
	 * 	JavaBean 规范 ：一定要定义无参数的构造函数
	 */
	public Result() { }
	
	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
