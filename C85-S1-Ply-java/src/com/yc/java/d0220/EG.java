package com.yc.java.d0220;

public class EG implements IMeasurer{

	public double measure(Object obj) {
		if(obj instanceof Person) {
			Person p=(Person)obj;
			return (p.getFoodexpenses()/p.getExpenses());
		}
		return 0;
	}

}
