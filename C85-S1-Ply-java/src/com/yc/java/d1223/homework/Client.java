package com.yc.java.d1223.homework;

/**
 * 客户
 */
public class Client {
	
	private String name;
	
	/**
	 * 其他属性省略
	 */

	/**
	 * order 下订单(定飞机票)
	 * @param f  航班对象
	 */
	public void order(Flight f){
		// 通过航班获取飞机对象
		Plane plane = f.getPlane();
		// 将当前乘客添加到 飞机中
		plane.add(this);
		
	}

}
