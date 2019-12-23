package com.yc.java.d1223;

public class MathTest {

	public static void main(String[] args) {

		Math math = new Math();

		int a = 5;
		int b = 3;
		int r = math.add(a, b);
		System.out.println(  r  );
		
		double d1 = 10;
		double d2 = 20;
	
		// The method add(int, int) in the type Math is not 
		// applicable for the arguments (double, double)
		
		double r2 = math.add(d1, d2);
		
		System.out.println(  r2  );

	}

}
