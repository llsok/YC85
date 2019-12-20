package com.yc.java.d1220;

public class PersonTest {
	
	public static void main(String[] args) {
		Person p1 = new Person("武松",25,"男",null);
		Person p2 = new Person("宋江",40,"男",null);
		Person p3 = new Person("阎婆惜",22,"女",p2);
		p2.setPartner(p3);
		Person p4 = new Person("扈三娘",20,"女",null);
		Person p5 = new Person("林黛玉",23,"女",null);
		
		
		p1.marry(p2);
		p1.marry(p3);
		p1.marry(p4);
		p1.marry(p5);
		
		p2.marry(p2);
		p2.marry(p1);
		p2.marry(p3);
		p2.marry(p4);
		
		p4.marry(p1);
		p4.marry(p2);
		p4.marry(p3);
		p4.marry(p5);
		
	}

}
