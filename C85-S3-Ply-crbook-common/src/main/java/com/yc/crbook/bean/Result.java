package com.yc.crbook.bean;

public class Result implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code; // 0失败，  1成功
	private String msg;
	private Object data;
	
	/**
	 * 	JavaBean 规范 ：一定要定义无参数的构造函数
	 */
	public Result() { }
	
	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Result(int code, String msg, Object data) {
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
