package com.yc.java.d0220;

/**
 *
 *	测量工具（Measurer）
 *		对某类对象的属性值进行测定，选出其中最大和最小的对象
 *		测试的属性值与测试工具有关
 *		使用一个测试对象完成对被测试对象的检测
 *
 *	实现功能：
 *		添加被测试对象：	addObject（Object obj）
 *		开始测量：		measure()
 *		获取最大的元素	getMax()
 *		获取最小的元素	getMin()
 *
 *		设置测量工具的方法： setMeasurer(Measurer m);
 *		对被测试对象的检测： ？？？？？？？
 *
 *	类的定义：
 *		1、Container  	存放被测试对象的容器
 *		2、Person		测试的对象：人类
 *		3、Measure		测试工具
 */

public class Demo {
	
	
	
	public static void main(String[] args) {
		// 创建容器
		Container container = new Container();
		// 创建测量身高的测量工具
		HeightMeasurer hm = new HeightMeasurer();
		// 设置测量工具
		container.setMeasurer(hm);
		
		container.addObject(new Person("武松",1.88,90));
		container.addObject(new Person("鲁达",1.92,110));
		container.addObject(new Person("宋江",1.68,75));
		container.addObject(new Person("燕青",1.78,70));
		container.addObject(new Person("王英",1.40,55));
		
		container.measure();
		
		double max = container.getMax();
		double min = container.getMin();
		System.out.println("最高的身高是：" + max);
		System.out.println("最矮的身高是：" + min);
		
		
		// 目的：如果要测体重、BMI
		BmiMeasurer bm = new BmiMeasurer();
		container.setMeasurer(bm);
		container.measure();
		max = container.getMax();
		min = container.getMin();
		System.out.println("最胖的BMI是：" + max);
		System.out.println("最瘦的BMI是：" + min);
		
	}
	
	/**
	 * 作业：
	 * 1、实现体重的测量
	 * 2、请输出最大值和最小值的人是谁？
	 * 3、请参考实现 恩格尔系数的测量（可以新增属性）
	 */
	

}
