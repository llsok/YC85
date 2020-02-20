package com.yc.java.d0220;

/**
 * 	容器类
 */
public class Container {

	// 存放对象的数组
	private Object[] objects = new Object[100];

	// 存放对象在第几个元素上，元素位置的下标值
	private int index;

	// 测量工具对象
	private IMeasurer measurer;

	private double min;
	private double max;
	
	public void addObject(Object obj) {
		// 请将对象存放到 对象数组中
		if (index == 100) {
			System.out.println("容器已满！");
			return;
		}
		if (obj == null) {
			System.out.println("被测试对象不能为空！");
			return;
		}
		objects[index] = obj;
		// 下标值+1
		index++;
	}

	/**
	 * 	设置测量工具
	 * @param m
	 */
	public void setMeasurer(IMeasurer m) {
		this.measurer = m;
	}

	/**
	 * 实现对象数组的测量，得出结论
	 */
	public void measure() {
		// 重置最大值和最小值
		min = -1;
		max = -1;
		// 增强for循环
		for (Object obj : objects) {
			// 如果被测试对象为空，则测试结束
			if (obj == null) {
				break;
			}
			double value = measurer.measure(obj);
			if (min == -1 || min > value) {
				min = value;
			}
			if (max == -1 || max < value) {
				max = value;
			}
		}
	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
	}

}
