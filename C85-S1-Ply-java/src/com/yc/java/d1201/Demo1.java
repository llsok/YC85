package com.yc.java.d1201;

public class Demo1 {
	
	// main  alt + /
	public static void main(String[] args) {
		
		/**
		 * 未婚  40000
		 * 
		 * 21450  15%
		 * （40000 - 21450） * 28%
		 * 
		 * 90000
		 * 21450 15%
		 * 51900 - 21450 28%
		 * 90000 - 51900 31%
		 * 
		 */
		
		boolean ishun = false;  // 已婚
		double money = 40000;  // 税基
		double tax = 0;
		
		// 定义字符串
		String hun = null;
		
		if ( ishun ){ // 判断是否已婚
			hun = "已婚";
			if ( money < 35800 ){
				tax = money * 0.15;
			} else if ( money < 86500 ){
				tax = 35800 * 0.15 + ( money - 35800) * 0.28;
			} else {
				tax = 35800 * 0.15 + ( 86500 - 35800) * 0.28
						+ ( money - 86500) * 0.31;
			}
		} else {	  // 否则就是未婚
			// 请完成未婚税金计算
			hun = "未婚";
			if ( money < 21450 ){
				tax = money * 0.15;
			} else if ( money < 51900 ){
				tax = 21450 * 0.15 + ( money - 21450) * 0.28;
			} else {
				tax = 21450 * 0.15 + ( 51900 - 21450) * 0.28
						+ ( money - 51900) * 0.31;
			}
		}
		
		System.out.println(hun + "人士，收入：" +
					money + "，计算税金是：" +tax);
		
	}

}
