package com.yc.api.d0301;

import java.util.*;

/**
 * List 集合
 * 有序集合（也称为序列 ）。
 */
public class ListDemo {

	public static void main(String[] args) {
		/**
		 * 所有的集合类都是 泛型 类  java 1.5 推出的新特性
		 * 泛型: 用于指定某个类只能处理的对象的类型
		 */
		// 创建list集合, 引用转型
		List<String> list = new ArrayList<>();

		list.add("武松");
		list.add("武松");
		list.add("武松");
		list.add("李逵");
		list.add("宋江");
		list.add("林冲");

		String ws = (String) list.get(0);
		System.out.println(ws);
		System.out.println(list.size());
		list.add(0, "李忠");
		System.out.println(list.get(0));

		/**
		 * 集合的遍历: 3种遍历方式
		 */
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "; ");
		}
		System.out.println();

		/**
		 * 增强 for 循环
		 */
		for (String person : list) {
			System.out.print(person + "; ");
		}
		System.out.println();
		
		/**
		 * 迭代器循环
		 */
		for( Iterator<String> it = list.iterator(); it.hasNext()  ; /*置空*/ ) {
			String person = it.next();
			System.out.print(person + "; ");
		}
		System.out.println();
		
		Vector a;
		
		// 获取迭代器对象
		Iterator<String> it = list.iterator();
		// 迭代: 就是讲对象中的元素一个一个取出来的过程
		// it.hasNext(); // 判断迭代器中是否有下一个元素
		// it.next();// 获取下一个元素
		// it.remove();// 删除当前元素
		
		for( /*置空*/ ; it.hasNext()  ; /*置空*/ ) {
			String person = it.next();
			System.out.print(person + "; ");
		}
		System.out.println();

		while (it.hasNext()) {
			String person = it.next();
			System.out.print(person + "; ");
		}
		System.out.println();
	}

}
