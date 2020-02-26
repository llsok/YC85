package com.yc.java.d0218;

/**
 * 子类出现以下错误：
 * Implicit super constructor Company() is undefined for default constructor.
 *  Must define an explicit constructor
 *  
 *  作业列表：
 *  1、所有的课堂案例
 *  2、Company + SubCompany
 *  3、连连看案例
 *  4、02月14日 Employer的作业
 *  5、春晚案例
 */
public class SubCompany extends Company { // 按下 ctrl + 鼠标点击 类名 ==》 鼠标变手

	SubCompany(String name, int number) {
		// 手动的执行父类的构造函数，因为没有无参构造函数
		super(name, number);
	}

	/**
	 * 查询所有员工
	 */
	public void query() {
		for (Employer e : employers) {
			e.show();
		}
	}

	/**
	 * 查询所有男员工
	 */
	/*public void addSalary1() {
		for (Employer e : employers) {
			if (condition(e)) {
				e.salary += 200;
				e.show();
			}
		}
	}*/

	/**
	 * 查询所有女员工，并且工资大于7000
	 */
	/*public void addSalary2() {
		for (Employer e : employers) {
			if (e.sex == 0 && e.salary > 7000) {
				// 加薪100
				e.salary += 100;
				e.show();
			}
		}
	}*/

	/**
	 * 	 加薪的公共方法
	 * @param money   加薪的数额
	 * @param checker 用于判断哪些员工可以被加薪
	 * 	接口也可以父类指向子类对象===》引用转型
	 * 	定义方法时，把父类类型作为参数类型；调用方法时，把父类或子类的对象作为参 数传入方法
	 */
	public void addSalary(int money, Checker checker) {
		for (Employer e : employers) {
			if (checker.condition(e)) {
				// 加薪
				e.salary += money;
				e.show();
			}
		}
	}

	/**
	 * 判断是否是  男员工
	 * @param e
	 * @return
	 */
	public boolean condition(Employer e) {
		return e.sex == 1;
	}

	/**
	 * 	
		运行时，根据实际创建的对象类型动态决定使用哪个方法
	 * @param args
	 */
	public static void main(String[] args) {
		SubCompany sc = new SubCompany("百度", 100);
		System.out.println("===============查询所有员工==================");
		sc.query();
		System.out.println("===============查询所有男员工==================");
		//sc.addSalary1();
		sc.addSalary(200, new ManChecker());
		System.out.println("===============所有女员工，并且工资大于7000==================");
		//sc.addSalary2();
		sc.addSalary(100, new WomanChecker());
	}

	/**
	 * 	内部类：男员工的检查器
	 */
	static class ManChecker implements Checker {
		public boolean condition(Employer e) {
			return e.sex == 1;
		}
	}
	/**
	 *所有女员工，并且工资大于7000 
	 */
	static class WomanChecker implements Checker {
		public boolean condition(Employer e) {
			return e.sex == 0 && e.salary > 7000;
		}
	}
	
	/**
	 *  判断男员工 + 只会一项技能
	 */
	static class ManChecker1 implements Checker {
		public boolean condition(Employer e) {
			// 判断技能数量
			int count = 0;
			if (e instanceof Java) {
				count++;
			}
			if (e instanceof Html) {
				count++;
			}
			if (e instanceof MySQL) {
				count++;
			}
			// 判断男员工 + 只会一项技能
			return e.sex == 1 && count == 1;
		}
	}
	
	/**
	 * 给只会一门技术的男员工 减薪 200
	 */

	/**
	 * 给所有会 Java 和 Html 的女员工加薪 500
	 */
}

/**
 * 检查器的接口，用于判断符合条件的员工
 */
interface Checker {
	/**
	 * 判断员工是否符合指定的条件
	 * @param e
	 * @return
	 */
	boolean condition(Employer e);
}
