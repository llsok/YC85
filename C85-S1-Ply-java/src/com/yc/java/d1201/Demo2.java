package com.yc.java.d1201;

public class Demo2 {
	
	public static void main(String[] args) {
		
		// 跑圈 1200米
		for( int i=1; i<=10; i++ ){
			// + 作为字符串连接符
			System.out.println("第" + i + "圈");
		}
		
		double money = 10000;  // 10000元
		double rate = 0.03;     // 年利率
		
		// 请问多少年之后 本金达到      20000；
		int year = 0;   // 年数
		
		double orgMoney = money;  // 保存本金
		/*while ( money < 20000 ){
			money += money * rate;
			year ++;
		}*/
		// do while 循环要注意 第一次循环是没有判断的
		do {
			money += money * rate;
			year ++;
		} while ( money < 20000 );
		
		
		System.out.println("本金：" + orgMoney + "，当前金额：" + money
				+ "，一共花了" + year + "年");
		
		// 本金：10000.0，当前金额：20327.941064604023，一共花了24年

	}

}
