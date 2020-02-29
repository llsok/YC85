package com.yc.api.d0229;

import java.util.*;

public class RandomDemo {
	
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextInt(100));
		// 随机成功浮点数 是 0 ~ 1 的值  , 如果需要整数位, 要另外生成
		System.out.println(r.nextDouble());
		
		// 随机种子: 伪随机,生成的随机数是有可能重复
		
		// 通过构造方法传入种子值, 种子值相同的随机对象,将会参数相同的随机值序列
		Random r1 = new Random(100);
		Random r2 = new Random(100);
		
		System.out.println(r1.nextInt() + "=====" + r2.nextInt());
		System.out.println(r1.nextInt() + "=====" + r2.nextInt());
		System.out.println(r1.nextInt() + "=====" + r2.nextInt());
		System.out.println(r1.nextInt() + "=====" + r2.nextInt());
		System.out.println(r1.nextInt() + "=====" + r2.nextInt());
	}
	
	
	/**
	 * 	作业:
	 * 	请随机生成人物的  姓 + 名 , 
	 *  	姓:	赵,钱,孙,李...
	 *  	名:	建国,翠花...
	 */

}
