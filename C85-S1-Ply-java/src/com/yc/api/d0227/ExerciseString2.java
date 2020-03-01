package com.yc.api.d0227;

import java.util.*;

public class ExerciseString2 {
	
	public static void main(String[] args) {
		
		ExerciseString2 es2 = new ExerciseString2();
		
		es2.getISP("18900001111");
		
	}
	
	/**
 		手机号码前三位代表运营商
      	中国电信	2G/3G号段：133，153， 180，181，189
				4G号段：173， 177
      	中国联通	2G/3G号段：130，131，132，155，156，185，186
				3G上网卡：145
				4G号段：176，185
      	中国移动	2G/3G号段：134，135，136，137，138，139，150，151，152，158，159，182，183，184
				3G上网卡：147
				4G号段：178，184
		请根据传入的电话号码, 返回对应的运营商的名称
		
		15300001111;
	 */
	public String getISP(String phoneNumber) {
		String[] p1 = {"133","153","180","181","189","173","177"};
		Arrays.sort(p1);
		
		String prefix = phoneNumber.substring(0,3);
		System.out.println(prefix);
		// 查找元素  index 是元素的索引 下标, 如果返回 -1 表示未找对
		int index = Arrays.binarySearch(p1, prefix);
		System.out.println(index);
		// 数组排序(升序), 所有参与排序的对象必须实现一个 Compareable 接口
		Arrays.sort(p1);
		// 打印数组
		System.out.println(p1);
		System.out.println(Arrays.toString(p1));
		
		return "中国电信 or 中国联通 or 中国移动";
	}
	
	/**
		身份证号码规则：
			前1、2位数字表示：所在省份的代码；
			第3、4位数字表示：所在城市的代码；
			第5、6位数字表示：所在区县的代码；
			第7-14位数字表示：出生年、月、日；
			第15、16位数字表示：所在地的派出所的代码；
			第17位数字表示性别：奇数表示男性，偶数表示女性；
			第18位数字是校检码
		任意给出一个身份证号码，在控制台输所有的出个人信息，
			日期格式：xxxx年xx月xx日
			性别：显示男，女
			其他代码：显示原值
	 */
	public void parseId(String id) {
		
	}
	
	/**
		研究网络上垃圾邮件的信息和词，请将经常在垃圾邮件中看到的30个词创建成一个列表。写一个方法，用户输入email信息，
		扫描这些词是否出现在这个邮件中，只要在信息中出现一次这些单词，就给这个词记一分，根据最后的得分，给这个邮件记一个等级，
		返回该邮件的等级
	 * @param email
	 */
	public int checkJunkMail(String email) {
		return 0;
	}
	
}
