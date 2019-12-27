package com.yc.java.d1226.q1;

public class Rect extends Shape{
	
	private double a;
	private double b;
	
	public Rect() {
	}
	
	public Rect(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public void setWidth(double a){
		this.a = a;
	}
	
	public void setHeight(double b){
		this.b = b;
	}

	@Override
	public void getArea() {
		System.out.println("面积是：" + a * b);
	}

	
	
}
