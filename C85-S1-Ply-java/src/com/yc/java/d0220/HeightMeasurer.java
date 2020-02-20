package com.yc.java.d0220;

/**
 *  测量身高
 */
public class HeightMeasurer implements IMeasurer{

	@Override
	public double measure(Object obj) {
		if(obj instanceof Person) {
			Person person = (Person)obj;
			return person.getHeight();
		} else {
			return -1;
		}
	}

}
