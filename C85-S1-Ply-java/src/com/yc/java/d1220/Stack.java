package com.yc.java.d1220;

public class Stack {

	// 存放数组的数组
	private int[] array;

	private int index; // 属性变量 int 的默认值就是 0

	/**
	 * 构造方法
	 * @param size 创建栈对象，指定的栈的大小
	 */
	public Stack(int size) {
		array = new int[size];
	}

	/**
	 * 压栈
	 * @param num 压入的元素
	 */
	public void push(int num) {
		if(index == array.length){
			System.out.println("栈已满！");
			// 直接退出方法
			return;
		}
		// 这里有数组越界的风险
		array[index] = num;
		index++;
	}

	/**
	 * 出栈
	 * @return 出栈的数字
	 */
	public int pop() {
		if(index == 0){
			System.out.println("栈已空！");
			// 直接退出方法
			return 0;
		}
		// 指针减一
		index --;
		// 保存弹出元素的值
		int ret = array[index];
		// 将该元素坐在位置的值清零
		array[index] = 0;
		// 返回结果
		return ret;
	}

}
