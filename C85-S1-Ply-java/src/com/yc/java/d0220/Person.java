package com.yc.java.d0220;

public class Person {

	// 请定义姓名、身高和体重属性

	private String name;

	private double height;

	private double weight;
	
	private double income;//收入
	private double expenses;//支出
	private double foodexpenses;
	
	public Person(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	/**
	 * 属性方法：设值方法setXXX，取值方法 getXXX
	 * 为什么一定要属性方法？
	 */

	public void setName(String name) {
		if(name ==null) {
			System.out.println("请输入用户名！");
			return;
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	public double getFoodexpenses() {
		return foodexpenses;
	}

	public void setFoodexpenses(double foodexpenses) {
		this.foodexpenses = foodexpenses;
	}


}
