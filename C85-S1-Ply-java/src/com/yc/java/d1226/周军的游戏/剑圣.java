package com.yc.java.d1226.周军的游戏;

import java.util.Scanner;

public class 剑圣 extends 战士{
	public void choose() {
		Scanner s=new Scanner(System.in);
		 if(liliang>=50 && zhili>=24 && minjie>=24 && naili>=24) {
			System.out.println("再确认一遍：1 是，2否！");
			int a=s.nextInt();
			if(a==1) {
				System.out.println("转职成功");
				System.out.println("剑圣的专属技能：拔刀斩！");
			}else {
				System.out.println("转职成功");
				System.out.println("剑圣的专属技能：拔刀斩！");
			}
		}
	}}
