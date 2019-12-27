package com.yc.java.d1226.周军的游戏;

import java.util.Scanner;

public class 狂战士 extends 战士{
	public void choose() {
	Scanner s=new Scanner(System.in);
	 if(liliang>=25 && zhili>=18 && minjie>=18 && naili>=18) {
		System.out.println("再确认一遍：1 是，2否！");
		int a=s.nextInt();
		if(a==1) {
			System.out.println("转职成功");
			System.out.println("狂战士的专属技能：怒气爆发！");
		}else {
			System.out.println("转职成功");
			System.out.println("狂战士的专属技能：怒气爆发！");
		}
	}
	}
	}



