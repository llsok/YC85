package com.yc.java.d1218;

/**
 * 
 * 定义以下类：
	汽车（品牌、颜色、型号、马力、油量、百公里耗油、行驶、停车、年检）
	学生（姓名、年龄、性别、学号、专业、学习、锻炼、休息）
	手机（品牌、型号、颜色、cpu、内存、sdcard、开机、关机、打电话）
	宠物（类别、名字、性别、颜色、吃、跑、睡）
	商品（品牌、型号、颜色、数量、上架、下架、打折）
	图书（名称、ISBN、作者、出版社、阅读、借书、还书）
	食品（名称、类别、生产日期、保质期、成份、上架、下架、打折）

 * 人类
 */
public class Person {
	
	/**
	 * 自定义构造方法
	 */
	public Person(){
		
	}
	

	/**
	 * 属性、成员变量
	 * 
	 * 完整的定义属性的语法：
	 * 作用域  静态关键字  终结关键字  属性类型  属性名 [ = 赋值]
	 * 
	 * 将属性保护起来，不被外界直接访问，那么使用 作用域关键字
	 * 
	 * private 关键字 表示 私有作用域，只能在当前对象访问
	 * 
	 * public 表示共有：没有任何限制的访问的作用域
	 */
	private String name; // 人名
	private int age; // 年龄
	private String id; // 身份证号
	
	private boolean sex;	// 性别
	private String address;	//地址

	/**
	 * 行为：方法 or 函数
	 */
	public void eat() {
		System.out.println("吃饭");
	}

	public void sleep() {
		System.out.println("睡觉");
	}

	/**
	 * 用于设置名称的方法
	 * The assignment to variable name has no effect
	 * 这个变量的复制必须是两个不同的变量
	 * 
	 * this 表示当前对象
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() < 2 || name.length() > 10) {
			System.out.println("该名字不合法：" + name);
			// 退出当前方法
			return;
		}
		this.name = name;
	}

	public void setAge(int age) {
		if (age >= 0 && age <= 160) {
			this.age = age;
		} else {
			System.out.println("该年龄不合法：" + age);
		}
	}

	public void setId(String id) {
		// 判断身份证的长度必须是 18 ~ 19
		if (id.length() >= 18 && id.length() <= 19) {
			this.id = id;
		} else {
			System.out.println("该身份证号码不合法：" + id);
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return id;
	}
	

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address.length()>3 && address.length()<200){
			this.address = address;
		}
	}

	
	
	
	
}
