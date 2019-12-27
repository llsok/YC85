package com.yc.java.d1226.周军的游戏;

import java.util.Scanner;

public class 召唤师 extends 法师{
	public void choose() {
		Scanner s=new Scanner(System.in);
		 if(liliang>=18 && zhili>=50 && minjie>=18 && naili>=18) {
			System.out.println("再确认一遍：1 是，2否！");
			int a=s.nextInt();
			if(a==1) {
				System.out.println("转职成功");
				System.out.println("召唤师的专属技能：召唤哥布林！");
			}else {
				System.out.println("转职成功");
				System.out.println("召唤师的专属技能：召唤哥布林！");
			}
		}
		}
}
