package com.yc.java.d1226.周军的游戏;

import java.util.Scanner;

public class 战士 extends 职业{
   public void choose(Person p) {
	   Scanner s=new Scanner(System.in);
		if(liliang<16 ||zhili<10  ||minjie<10  ||naili<10) {
			System.out.println(p.name+"先生你的力量不够，不能转职为战士");
		}
		else if(liliang>=16 && zhili>=10 && minjie>=10 && naili>=10) {
			System.out.println("再确认一遍：1 是，2否！");
			int a=s.nextInt();
			if(a==1) {
				System.out.println("转职成功");
				System.out.println("战士的普通攻击是A你！");
			}else {
				System.out.println("转职成功");
				System.out.println("战士的普通攻击是A你！");
			}
		}
   }
   public void up() {
	   System.out.println("第一次转职为战士！");
   }
   
	  
   
}
