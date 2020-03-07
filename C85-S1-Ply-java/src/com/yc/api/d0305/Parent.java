package com.yc.api.d0305;

public class Parent implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private int	age;
	
	public Parent(String name, String phone, int age) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Parent [name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}

}
