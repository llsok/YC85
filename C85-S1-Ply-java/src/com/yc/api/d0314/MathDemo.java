package com.yc.api.d0314;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathDemo {

	public static void main(String[] args) {

		// 去随机浮点数 0~1 的小数 ctrl + 鼠标点击
		// Math.random();

		List<String> list = new ArrayList<>();

		list.add("武松");
		list.add("李逵");
		list.add("宋江");
		list.add("燕青");
		list.add("吴用");
		list.add("孙二娘");

		// 手工转数组
		String[] sarr1 = new String[list.size()];
		for (int i = 0; i < sarr1.length; i++) {
			sarr1[i] = list.get(i);
		}

		Object[] oarr1 = list.toArray();

		// 带参数的是一个泛型方法
		// 完美方案
		String[] sarr2 = list.toArray(new String[list.size()]);

		// 偷懒方案
		String[] sarr3 = list.toArray(new String[0]);

		System.out.println(list);
		System.out.println(sarr1);
		System.out.println(Arrays.toString(sarr1));
		System.out.println(Arrays.toString(oarr1));
		System.out.println(Arrays.toString(sarr2));
		System.out.println(Arrays.toString(sarr3));

		"abc".toCharArray(); // 字符串转 字符数组

		// asList() // 数组转集合
		List<String> list1 = Arrays.asList(sarr3);
		;
		System.out.println("=================");
		System.out.println(list1);

		// System.arraycopy(src, srcPos, dest, destPos, length);

		String s1 = "";
		String s2 = null;

		System.out.println(s1.length());
		// System.out.println(s2.length());

		MathDemo md = new MathDemo();
		System.out.println(md.getVal("10"));
		System.out.println(md.getVal("-2"));
		System.out.println(md.getVal("x"));
		System.out.println(md.getVal(null));

	}

	public int getVal(String str) {
		int val = 0;
		try {
			val = Integer.parseInt(str);
			return val;
		} catch (NumberFormatException e) {
			return val;
		} finally {
			// finally 没有 return 那么 返回值不变
			// finally 有 return 那么 返回值会改变
			// return -1;
			val = -1;
		}
	}

}
