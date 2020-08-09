package com.yc.spring.bean;

import java.util.List;

public class Person {

	private String name;

	private String id;

	private int age;
	
	private List<String> killeds;
	
	private Person friend;
	
	/**
	 * 	静态的工厂方法
	 */
	public static Person PersonFactory() {
		Person p = new Person();
		p.setAge(40);
		return p;
	}
	
	/**
	 * 	实例的工厂方法
	 */
	public Person PersonFactory1() {
		Person p = new Person();
		p.setAge(20);
		return p;
	}
	
	public Person() {
		
	}
	
	public Person(int age, String name, String alisa) {
		super();
		System.out.println("==========1==========");
		this.name = name;
		this.age = age;
		this.alisa = alisa;
	}
	
	public Person(String name, int age, String alisa) {
		super();
		System.out.println("==========2==========");
		this.name = name;
		this.age = age;
		this.alisa = alisa;
	}
	
	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	public String getAlisa() {
		return alisa;
	}

	public void setAlisa(String alisa) {
		this.alisa = alisa;
	}



	// 身高
	private int Height;
	// 绰号
	private String alisa;
	
	public List<String> getKilleds() {
		return killeds;
	}

	public void setKilleds(List<String> killeds) {
		this.killeds = killeds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	
}
