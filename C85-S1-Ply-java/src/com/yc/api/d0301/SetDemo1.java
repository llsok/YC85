package com.yc.api.d0301;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {

	public static void main(String[] args) {
		
		Set<Person> set = new HashSet<>();
		
		set.add( new Person("武松",30));
		set.add( new Person("李逵",35));
		set.add( new Person("宋江",40));
		set.add( new Person("杨志",35));
		set.add( new Person("武松",30));
		set.add( new Person("武松",30));
		
		/**
		 * HashSet 判断对象是否相同基于 2 个方法
		 * hashCode() 返回对象的哈希值
		 * 		哈希函数计算的一个hash值
		 * 
		 * equals()	  判断对象是否内容相同
		 * 
		 * 1, hashCode 不同, 那么这个两个对象移动不同 ,不需要equals
		 * 2, hashCode 相同, 那么两个个对象有可能内容一致
		 * 3, 进行equals 比较
		 * 
		 * Person 必须同时重写  equals 和 hashCode 方法
		 * 
		 */
		
		for(Person p : set) {
			System.out.println(p);
		}
	}
}

class Person {
	
	String name;
	Integer age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//@Override
	//public boolean equals(Object obj) {
		//  return (this == obj);  ==> 武松,30  false
	//	return super.equals(obj);
	//}
	
	
	
}