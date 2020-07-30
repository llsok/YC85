package com.yc.thread.d0730;

public class Cookie {

	private String name;
	private String value;
	private int maxAge = -1;

	public Cookie(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String toString() {
		String s = "Set-Cookie: %s=%s;";
		s = String.format(s, name, value);
		if(maxAge > -1) {
			s += "Max-Age=" + maxAge + ";";
		}
		s+="\n";
		System.out.println("s="+s);
		return s;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

}
