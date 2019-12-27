package com.yc.java.d1226.q7;

public class ChinaPeople extends People{
	
	public ChinaPeople(){
		super.height = 180;
		super.weight = 130;
	}
	
	public void sayHello() {
		System.out.println("你好，我是中国人！");
	}
	
	public void chinaGongFu(){
		System.out.println("坐如钟，站如松，睡如弓");
	}
	
	

}
