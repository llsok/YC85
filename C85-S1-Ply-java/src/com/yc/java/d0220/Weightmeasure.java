package com.yc.java.d0220;
/**
 * 体重测量工具
 * @author Administrator
 *
 */
public class Weightmeasure implements IMeasurer{

	public double measure(Object obj) {
		if(obj instanceof Person) {
			Person person=(Person)obj;
			return person.getWeight();
		}else {
		return -1;
		}
	}
	
}
