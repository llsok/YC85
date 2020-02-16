package com.yc.java.d0216.homework;

import java.util.Random;

/**
 * 公司类
 */
public class Company {

	/**
	 * 请编程完成主方法, 统计该公司员工:
	 * 1 分别统计出: 会 Java, Html, MySQL 的人数
	 * 2 分别统计出: 会一项技术, 两项技术, 三项技术的人数
	 * 3 请辞退年龄在 40 岁以上的只会一项技术的男程序员, 
	 * 		在辞退前后, 请打印所有员工信息, 以作验证
	 * 
	 * 提示: 使用 instanceof 判断是否实现了某接口
	 * 限制: 不能使用 类名 判断, 即: 代码中不能出现 Employer1 ~ Employer7
	 * 		辞退就是将数组的元素设置为空 null
	 * 		employers[19] = null;
	 */
	public static void main(String[] args) {

		Company company = new Company("华为", 100);

		// 作业代码: 打...打...打劫! 留下你的代码!!!

	}

	// 公司所有员工数组
	private Employer[] employers;

	private String name;

	/**
	 * 公司的构造方法
	 * @param name  公司名
	 * @param number 公司人数
	 */
	public Company(String name, int number) {
		this.name = name;
		employers = new Employer[number];
		for (int i = 0; i < number; i++) {
			// 网上随机招聘员工
			employers[i] = recruitByInternet();
		}
	}

	/**
	 * 随机网上招聘 ( recruit )
	 * @return
	 */
	public Employer recruitByInternet() {
		// 随机生成员工对象
		Random random = new Random();
		switch (random.nextInt(7)) {
		case 0:
			return new Employer1();
		case 1:
			return new Employer2();
		case 2:
			return new Employer3();
		case 3:
			return new Employer4();
		case 4:
			return new Employer5();
		case 5:
			return new Employer6();
		default:
			return new Employer7();
		}
	}

}

interface Java {
}

interface Html {
}

interface MySQL {
}

/**
 * 员工抽象类
 */
abstract class Employer {
	Random random = new Random();
	String name; // 名字想办法随机生成吧
	int age = random.nextInt(31) + 20; // 随机产生20 ~ 50 岁 的员工年龄
	int sex = random.nextInt(2); // 随机生成性别 0女性, 1男性
}

class Employer1 extends Employer implements Java {
}

class Employer2 extends Employer implements Html {
}

class Employer3 extends Employer implements MySQL {
}

class Employer4 extends Employer implements Java, Html {
}

class Employer5 extends Employer implements Html, MySQL {
}

class Employer6 extends Employer implements Java, MySQL {
}

class Employer7 extends Employer implements Java, Html, MySQL {
}
