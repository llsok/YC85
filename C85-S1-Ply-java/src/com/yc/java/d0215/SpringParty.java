package com.yc.java.d0215;

/**
 * 春晚
 * 
 * 练习题：
 * 1、请加入魔术和杂技
 * 2、扩展子类的方法或属性，让每一个节目都有不同的内容
 * 
 * 代码重构
 * 
 * 多态性：
 * 	同名属性和方法
 * 	方法：重写（子类、同原型【同名、同参、通返回值、兼容的修饰符】）  、  重载（同类、同名、不同参）
 *  父类指向子类对象（引用转型）
 *  	属性的访问看左边
 *  	方法的调动看右边
 * 
 * 抽象类、接口、实现。。。
 * 
 * 作业：刷题、资源库中编程题
 */
public class SpringParty {
	// 界面单
	private Program[] programs = new Program[100];
	// 最后一个节目的编号
	private int index = 0;

	/**
	 * 开始表演
	 */
	public void start() {

		for (Program p : programs) {
			if (p != null) {
				p.show();
			} else {
				System.out.println("难忘今宵。。。");
				break;
			}
		}

	}

	/**
	* 添加节目
	* 
	* 方法重载（多态：静态多态）
	*/
	public void addProgram(Program p) {
		programs[index] = p;
		index++;
	}

	public static void main(String[] args) {
		SpringParty sp = new SpringParty();
		sp.addProgram(new Singe("黄河大合唱","黄河在咆哮。。。"));
		sp.addProgram(new Dance("千手观音","一千只手。。。"));
		sp.addProgram(new Singe("两只老虎","两只老虎..."));
		sp.addProgram(new Dance("踢踏舞","踏踏踏踏。。。"));
		sp.start();
	}

}

/**
* 节目类
* @author hy2005zyx
*
*/
class Program {
	String name;
	// 内容的属性
	String content;
	
	public void show() {
		System.out.print(name + ":");
		System.out.println(content);
	}
}

/**
* 唱歌
*/
class Singe extends Program {
	Singe(String name, String content) {
		this.name = name;
		this.content = content;
	}
}

class Dance extends Program {
	Dance(String name, String content) {
		this.name = name;
		this.content = content;
	}
	
	public void show() {
		super.show();
		System.out.println("...........................");
	}
	
}
