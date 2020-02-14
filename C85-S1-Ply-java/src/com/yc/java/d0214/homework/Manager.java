package com.yc.java.d0214.homework;

public class Manager extends Employee{
	
	private String department;
	
	public Manager(String name, float basic, String address, String department) {
		// 调用父类的构造方法
		super(name,basic,address);
		// 初始化本类的属性
		this.department = department;
	}
	
	
	public void show() {
		/**
		 * The field Employee.name is not visible
		 * 该属性不可见
		 */
		// System.out.printf("姓名：%s   底薪：%s    地址：%s\n", name, basic, address);
		// 调用父类的 show()
		super.show();
		
		System.out.println("部门：" + department);
	}

}
